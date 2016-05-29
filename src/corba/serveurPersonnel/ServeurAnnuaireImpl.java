package corba.serveurPersonnel;

import GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant;
import GestAcces.ServeurAnnuairePackage.CollaborateurInnexistant;

/**
 * Created by Miaeln on 29/05/2016.
 */
public class ServeurAnnuaireImpl extends GestAcces.ServeurAnnuairePOA {

    public short enregisterCollaborateur(String nom, String prenom, String p) throws CollaborateurDejaExistant {
        return 0;
    }

    public short rechercherCollaborateur(String nom, String prenom) {
        return 0;
    }

    public void supprimerCollaborateur(short id) throws CollaborateurInnexistant {

    }
}
