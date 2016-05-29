package objetsMetier.personnel.collabos;

import objetsMetier.acces.AccesPermanent;
import objetsMetier.Identifiant;
import objetsMetier.personnel.Collaborateur;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by igloo on 27/05/2016.
 */
public class CollaborateurPermanent extends Collaborateur {
    private ArrayList<AccesPermanent> accesPermanents;

    public CollaborateurPermanent(String nom, String prenom, String adresse, String statut, String login, String mdp, String photo, Date dateEntree, Identifiant identifiant) {
        super(nom, prenom, adresse, statut, login, mdp, photo, dateEntree, identifiant);
    }
}
