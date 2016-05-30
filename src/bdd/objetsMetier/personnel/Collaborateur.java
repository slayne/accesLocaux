package bdd.objetsMetier.personnel;

import bdd.objetsMetier.Identifiant;
import bdd.objetsMetier.Personnel;
import bdd.objetsMetier.acces.AccesTemporaire;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by igloo on 27/05/2016.
 */
public class Collaborateur extends Personnel {
    private String photo;
    private Timestamp dateEntree;
    private Identifiant identifiant;
    private ArrayList<AccesTemporaire> accesTemporaires;

    /**
     * création d'un collaborateur
     * /!\ crée sans accès au début
     * @param nom
     * @param prenom
     * @param adresse
     * @param statut
     * @param login
     * @param mdp
     * @param photo
     * @param dateEntree
     * @param identifiant
     */
    public Collaborateur(String nom, String prenom, String adresse, String statut, String login, String mdp, String photo, Timestamp dateEntree, Identifiant identifiant) {
        super(nom, prenom, adresse, statut, login, mdp);
        this.photo = photo;
        this.dateEntree = dateEntree;
        this.identifiant = identifiant;
        this.accesTemporaires = new ArrayList<>();
    }

    public Timestamp getDateEntree() {
        return dateEntree;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Identifiant getIdentifiant() {
        return identifiant;
    }
}

