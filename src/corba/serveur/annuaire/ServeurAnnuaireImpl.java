package corba.serveur.annuaire;

import GestAcces.CollaborateurCorba;
import GestAcces.Date;
import GestAcces.ServeurAcces;
import GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant;
import GestAcces.ServeurAnnuairePackage.CollaborateurInexistant;
import GestAcces.ServeurAnnuairePackage.CollaborateurInnexistant;
import GestAcces.ServeurEmpreinte;
import GestAcces.ServeurEmpreintePackage.EmpreinteInexistante;
import GestAcces.ServeurEmpreintePackage.EmpreinteInvalide;
import GestAcces.ServeurEmpreintePackage.EmpreintePresente;
import bdd.objetDao.CollaborateurDAO;
import bdd.objetDao.EmpreinteDAO;
import bdd.objetsMetier.Empreinte;
import bdd.objetsMetier.personnel.Collaborateur;
import bdd.objetsMetier.personnel.collabos.CollaborateurPermanent;
import bdd.objetsMetier.personnel.collabos.CollaborateurTemporaire;
import corba.clients.Collabo;
import corba.serveur.empreinte.ServeurEmpreinteImpl;

import java.sql.Timestamp;

import static utils.AccesUtils.corbaDateToTimeStamp;

/**
 * Created by Miaeln on 29/05/2016.
 */
public class ServeurAnnuaireImpl extends GestAcces.ServeurAnnuairePOA {

    private static CollaborateurDAO collabDAO= new CollaborateurDAO();
    public static ServeurEmpreinte servEmpreinte;
    public static ServeurAcces serveurAcces;

    public static void setServEmpreinte( ServeurEmpreinte s){
        servEmpreinte = s ;
    }

    public static void setAcces (ServeurAcces s){
        serveurAcces=s;
    }

    @Override
    public boolean demanderAcces(String Photo, String mdp, short idZone) throws CollaborateurInexistant {

        boolean res= false;

        if(collabDAO.isTemp(Photo)){
            CollaborateurTemporaire c =(CollaborateurTemporaire)collabDAO.find(Photo);

            if(c.getEmpreinte().equals(mdp)){
                res=serveurAcces.verifierAcces((short)c.getIdbd(),idZone);
            }

        }else{
            CollaborateurPermanent c = (CollaborateurPermanent) collabDAO.find(Photo);

            if(c.getEmpreinte().equals(mdp)){
                res=serveurAcces.verifierAcces((short)c.getIdbd(),idZone);
            }
        }

        return res;
    }

    @Override
    public void enregisterCollaborateurPermanent(String nom, String p, String empreinte, Date de) throws CollaborateurDejaExistant {
        CollaborateurPermanent c = new CollaborateurPermanent(nom,p,new Timestamp(System.currentTimeMillis()),empreinte);
        c=(CollaborateurPermanent) collabDAO.create(c);

        try {
            servEmpreinte.enregistrerEmpreinte((short)c.getIdbd(),empreinte);
        } catch (EmpreintePresente empreintePresente) {
           throw new CollaborateurDejaExistant();
        }
    }

    @Override
    public void enregisterCollaborateurTemporaire(String nom, String p, String empreinte, Date de, Date df) throws CollaborateurDejaExistant {
        CollaborateurTemporaire c = new CollaborateurTemporaire(nom,p,new Timestamp(System.currentTimeMillis()),empreinte,corbaDateToTimeStamp(df));
        c= (CollaborateurTemporaire) collabDAO.create(c);

        try {
            servEmpreinte.enregistrerEmpreinte((short)c.getIdbd(),empreinte);
        } catch (EmpreintePresente empreintePresente) {
            throw new CollaborateurDejaExistant();
        }
    }

    @Override
    public CollaborateurCorba[] rechercherCollaborateurs() {
        return new CollaborateurCorba[0];
    }

    public CollaborateurPermanent getPermanent(int id) throws EmpreinteInvalide {
        CollaborateurPermanent c = (CollaborateurPermanent)collabDAO.find(id);
        c.setEmpreinte(servEmpreinte.getEmpreinte((short) id));


        return c;
    }

    public CollaborateurTemporaire getTemporaire(int id) throws EmpreinteInvalide {
        CollaborateurTemporaire c = (CollaborateurTemporaire)collabDAO.find(id);
        c.setEmpreinte(servEmpreinte.getEmpreinte((short)id));

        return c;
    }

    public CollaborateurPermanent updatePermanent(CollaborateurPermanent co) throws EmpreinteInvalide, EmpreinteInexistante {
        CollaborateurPermanent c = (CollaborateurPermanent) collabDAO.update(co);
        servEmpreinte.modifierEmpreinte((short) c.getIdbd(), co.getEmpreinte());
        c.setEmpreinte(servEmpreinte.getEmpreinte((short) c.getIdbd()));

        return c;
    }

    public CollaborateurTemporaire updateTeporaire(CollaborateurTemporaire co) throws EmpreinteInvalide, EmpreinteInexistante, CollaborateurInexistant {

        CollaborateurTemporaire c = (CollaborateurTemporaire) collabDAO.update(co);
        servEmpreinte.modifierEmpreinte((short) c.getIdbd(), co.getEmpreinte());
        c.setEmpreinte(servEmpreinte.getEmpreinte((short) c.getIdbd()));

        return c;
    }

    @Override
    public void supprimerCollaborateur(short id) throws CollaborateurInexistant {
        collabDAO.delete(collabDAO.find(id));
        try {
            servEmpreinte.supprimerEmpreinte(id);
            serveurAcces.supprimerAcces(id);
            //faire supprimer acces
        } catch (EmpreinteInexistante empreinteInexistante) {
            throw  new CollaborateurInexistant();
        }
    }
}
