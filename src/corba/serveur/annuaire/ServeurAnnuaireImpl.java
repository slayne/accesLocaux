package corba.serveur.annuaire;

import GestAcces.CollaborateurCorba;
import GestAcces.Date;
import GestAcces.Empreinte;
import GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant;
import GestAcces.ServeurAnnuairePackage.CollaborateurInnexistant;
import bdd.objetsMetier.personnel.Collaborateur;

/**
 * Created by Miaeln on 29/05/2016.
 */
public class ServeurAnnuaireImpl extends GestAcces.ServeurAnnuairePOA {

    @Override
    public void enregisterCollaborateur(String nom, String prenom, String p, Empreinte e) throws CollaborateurDejaExistant {
        //CollaborateurCorba c= new CollaborateurCorba(nom,prenom,"","","","","",new Date((short)16,(short)06,(short)06),new Empreinte("",1));
        Collaborateur c = new Collaborateur(nom,prenom,p);

    }

    @Override
    public void rechercherCollaborateur(String nom, String prenom) {

    }

    @Override
    public void supprimerCollaborateur(short id) throws CollaborateurInnexistant {

    }
}
