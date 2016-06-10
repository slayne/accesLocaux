package corba.serveur.annuaire;

import GestAcces.CollaborateurCorba;
import GestAcces.Date;
import GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant;
import GestAcces.ServeurAnnuairePackage.CollaborateurInnexistant;
import GestAcces.ServeurEmpreinte;
import GestAcces.ServeurEmpreintePackage.EmpreintePresente;
import bdd.objetDao.CollaborateurDAO;
import bdd.objetDao.EmpreinteDAO;
import bdd.objetsMetier.Empreinte;
import bdd.objetsMetier.personnel.Collaborateur;
import bdd.objetsMetier.personnel.collabos.CollaborateurPermanent;
import bdd.objetsMetier.personnel.collabos.CollaborateurTemporaire;
import corba.serveur.empreinte.ServeurEmpreinteImpl;

import java.sql.Timestamp;

import static utils.AccesUtils.corbaDateToTimeStamp;

/**
 * Created by Miaeln on 29/05/2016.
 */
public class ServeurAnnuaireImpl extends GestAcces.ServeurAnnuairePOA {

    private static CollaborateurDAO collabDAO;
    public ServeurEmpreinte servEmpreinte;

    public void setEmpreinte(ServeurEmpreinte s){
        servEmpreinte=s;
    }

    @Override
    public void enregisterCollaborateurPermanent(String nom, String p, String empreinte, Date de) throws CollaborateurDejaExistant {
        CollaborateurPermanent c = new CollaborateurPermanent(nom,p,new Timestamp(System.currentTimeMillis()),empreinte);
        c=(CollaborateurPermanent) collabDAO.create(c);

        try {
            servEmpreinte.enregistrerEmpreinte((short)c.getIdbd(),empreinte);
        } catch (EmpreintePresente empreintePresente) {
            empreintePresente.printStackTrace();
        }


    }

    @Override
    public void enregisterCollaborateurTemporaire(String nom, String p, String empreinte, Date de, Date df) throws CollaborateurDejaExistant {
        CollaborateurTemporaire c = new CollaborateurTemporaire(nom,p,new Timestamp(System.currentTimeMillis()),empreinte,corbaDateToTimeStamp(df));
        c= (CollaborateurTemporaire) collabDAO.create(c);

        try {
            servEmpreinte.enregistrerEmpreinte((short)c.getIdbd(),empreinte);
        } catch (EmpreintePresente empreintePresente) {
            empreintePresente.printStackTrace();
        }
    }

    @Override
    public void rechercherCollaborateur(String nom, String prenom) {

    }

    @Override
    public void supprimerCollaborateur(short id) throws CollaborateurInnexistant {

    }
}
