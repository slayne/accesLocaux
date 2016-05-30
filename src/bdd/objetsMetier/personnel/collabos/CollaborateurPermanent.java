package bdd.objetsMetier.personnel.collabos;

import bdd.objetsMetier.acces.AccesPermanent;
import bdd.objetsMetier.Identifiant;
import bdd.objetsMetier.personnel.Collaborateur;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by igloo on 27/05/2016.
 */
public class CollaborateurPermanent extends Collaborateur {
    private ArrayList<AccesPermanent> accesPermanents;

    public CollaborateurPermanent(String nom, String prenom, String adresse, String statut, String login, String mdp, String photo, Timestamp dateEntree, Identifiant identifiant) {
        super(nom, prenom, adresse, statut, login, mdp, photo, dateEntree, identifiant);
    }
}
