package bdd.objetsMetier.personnel;

import bdd.objetsMetier.Personnel;
import bdd.objetsMetier.acces.AccesTemporaire;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by igloo on 27/05/2016.
 */
public abstract class Collaborateur {
    private String photo;
    private Timestamp dateEntree;
    private String empreinte;
    private ArrayList<AccesTemporaire> accesTemporaires;

    public Collaborateur(String photo, Timestamp dateEntree, String empreinte) {
        this.photo = photo;
        this.dateEntree = dateEntree;
        accesTemporaires = new ArrayList<>();
        this.empreinte = empreinte;
    }
}

