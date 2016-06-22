package bdd.objetsMetier.personnel;

import bdd.objetsMetier.Personnel;
import bdd.objetsMetier.acces.AccesTemporaire;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by igloo on 27/05/2016.
 */
public class Collaborateur {
    private String nom;
    private String photo;
    private Timestamp dateEntree;
    private String empreinte;
    private ArrayList<AccesTemporaire> accesTemporaires;
    private int idbd;

    public Collaborateur(String nom,String photo, Timestamp dateEntree, String empreinte) {
        this.nom=nom;
        this.photo = photo;
        this.dateEntree = dateEntree;
        accesTemporaires = new ArrayList<>();
        this.empreinte = empreinte;
    }

    public String getNom() {
        return nom;
    }

    public String getPhoto() {
        return photo;
    }

    public Timestamp getDateEntree() {
        return dateEntree;
    }

    public String getEmpreinte() {
        return empreinte;
    }

    public void setIdbd(int idbd) {
        this.idbd = idbd;
    }

    public void setEmpreinte(String e) {
        this.empreinte = e;
    }

    public int getIdbd() {
        return idbd;
    }
}

