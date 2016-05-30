package bdd.objetsMetier;

import java.util.Arrays;
import java.util.List;

/**
 * Created by igloo on 28/05/2016.
 */
public class Zone {
    private int id;
    private String nom,taille,type;
    private List<Porte> portes;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Zone(String nom, String taille, String type, Porte... portes) {
        this.nom = nom;
        this.taille = taille;
        this.type = type;
        this.portes = Arrays.asList(portes);
    }
}
