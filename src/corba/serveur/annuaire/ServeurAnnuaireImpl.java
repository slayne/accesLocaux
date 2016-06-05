package corba.serveur.annuaire;

import GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant;
import GestAcces.ServeurAnnuairePackage.CollaborateurInnexistant;

/**
 * Created by Miaeln on 29/05/2016.
 */
public class ServeurAnnuaireImpl extends GestAcces.ServeurAnnuairePOA {

    @Override
    public void enregisterCollaborateur(String nom, String prenom, String p) throws CollaborateurDejaExistant {

    }

    @Override
    public void rechercherCollaborateur(String nom, String prenom) {

    }

    @Override
    public void supprimerCollaborateur(short id) throws CollaborateurInnexistant {

    }
}
