package objetsMetier;

import objetsMetier.personnel.Collaborateur;

/**
 * Created by igloo on 27/05/2016.
 */
public class Identifiant {
    private int id;
    private String empreinte;
    private Collaborateur collaborateur;

    public String getEmpreinte() {
        return empreinte;
    }

    public void setEmpreinte(String empreinte) {
        this.empreinte = empreinte;
    }

    public Collaborateur getCollaborateur() {
        return collaborateur;
    }

    public void setCollaborateur(Collaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public Identifiant(String empreinte) {

        this.empreinte = empreinte;
    }
}
