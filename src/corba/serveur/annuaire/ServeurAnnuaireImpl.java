package corba.serveur.annuaire;

import GestAcces.*;
import GestAcces.ServeurAccesPackage.ZoneInexistante;
import GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant;
import GestAcces.ServeurAnnuairePackage.CollaborateurInexistant;
import GestAcces.ServeurAnnuairePackage.CollaborateurInnexistant;
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
import utils.AccesUtils;

import java.sql.Timestamp;
import java.util.ArrayList;

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

        Collaborateur c;

        if(collabDAO.isTemp(Photo)){
            c =(CollaborateurTemporaire)collabDAO.find(Photo);

        }else{
            c = (CollaborateurPermanent) collabDAO.find(Photo);
        }

        // récupération de l'empreinte
        try {
            c.setEmpreinte(servEmpreinte.getEmpreinte((short)c.getIdbd()));
        } catch (EmpreinteInvalide empreinteInvalide) {
            System.out.println("Empreinte invalide");
        }


        if(c.getEmpreinte().equals(mdp)){
            res=serveurAcces.verifierAcces((short)c.getIdbd(),idZone);
        }



        return res;
    }

    @Override
    public void enregisterCollaborateurPermanent(String nom, String p, String empreinte, Date de) throws CollaborateurDejaExistant {
        CollaborateurPermanent c = new CollaborateurPermanent(nom,p,new Timestamp(System.currentTimeMillis()),empreinte);
        System.out.println(c.getEmpreinte());
        c=(CollaborateurPermanent) collabDAO.create(c);

        try {
            servEmpreinte.enregistrerEmpreinte((short)c.getIdbd(),empreinte);

            // création d'un accès à l'accueil par défaut
            try {
                serveurAcces.ajoutPerm((short)c.getIdbd(), (short)9, (short)17,(short)1);
            } catch (ZoneInexistante zoneInexistante) {
                System.out.println("Erreur création accès");
            }
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

            // création d'un accès à l'accueil par défaut
            try {
                serveurAcces.ajoutTemp((short)c.getIdbd(),
                        de.j,
                        df.j,
                        (short)9, (short)17,(short)1);
            } catch (ZoneInexistante zoneInexistante) {
                System.out.println("Erreur création accès");
            }

        } catch (EmpreintePresente empreintePresente) {
            throw new CollaborateurDejaExistant();
        }
    }

    @Override
    public CollaborateurCorba[] rechercherCollaborateurs() {

         ArrayList<Collaborateur> list =  collabDAO.getInstances();
        ArrayList<CollaborateurCorba> listcorba = new ArrayList<CollaborateurCorba>();
        for(Collaborateur c : list){
            listcorba.add(collabDAO.findCorba(c.getPhoto(),
                    //serveurAcces.getAccesCollaborateur((short) c.getIdbd()))
                    new AccesCorba[0])
            );
        }
        System.out.println("nonm : " + listcorba.get(0).nom);
        CollaborateurCorba[] res = new CollaborateurCorba[listcorba.size()];
        res= listcorba.toArray(res);

        System.out.println(res);
        return res;
    }

    @Override
    public void supprimerCollaborateur(short id) throws CollaborateurInexistant {
        Collaborateur c = collabDAO.find(id);
        if (c==null) throw new CollaborateurInexistant();

        try {
            servEmpreinte.supprimerEmpreinte(id);
            serveurAcces.supprimerAccesCollaborateur(id);
            //faire supprimer acces
        } catch (EmpreinteInexistante empreinteInexistante) {
            System.out.println("Empreinte déjà supprimée");
        } catch (GestAcces.ServeurAccesPackage.CollaborateurInexistant collaborateurInexistant) {
            collaborateurInexistant.printStackTrace();
        }
        collabDAO.delete(c);
    }

    @Override
    public CollaborateurCorba rechercherCollaborateur(String p, String empreinte) throws CollaborateurInexistant {
        AccesCorba[] as = new AccesCorba[0];
        CollaborateurCorba co = collabDAO.findCorba(p,as);
        return co;
    }

}
