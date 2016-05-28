package objetsMetier.personnel;

import objetsMetier.Identifiant;
import objetsMetier.Personnel;
import objetsMetier.acces.AccesTemporaire;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by igloo on 27/05/2016.
 */
public class Collaborateur extends Personnel {
    private String photo;
    private Date dateEntree;
    private Identifiant identifiant;
    private ArrayList<AccesTemporaire> accesTemporaires;

    public Collaborateur(String nom, String prenom, String adresse, String statut, String login, String mdp, String photo, Date dateEntree, Identifiant identifiant) {
        super(nom, prenom, adresse, statut, login, mdp);
        this.photo = photo;
        this.dateEntree = dateEntree;
        this.identifiant = identifiant;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

