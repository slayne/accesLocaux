package bdd.objetsMetier;

import bdd.objetsMetier.personnel.Collaborateur;

/**
 * Created by igloo on 27/05/2016.
 */
public class Identifiant {
    private int id;
    private int idCollabo;
    private String empreinte;

    public String getEmpreinte() {
        return empreinte;
    }

    public void setEmpreinte(String empreinte) {
        this.empreinte = empreinte;
    }

    public Identifiant(String empreinte) {

        this.empreinte = empreinte;
    }

    public void setId(int id) {
        this.id = id;
    }
}
