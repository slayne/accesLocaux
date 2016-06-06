package bdd.objetsMetier;

/**
 * Created by yoan on 06/06/16.
 */
public class Empreinte {
    public int idCollaborateur;
    public String empreinte;

    public Empreinte(String empreinte,int id) {
        this.idCollaborateur = id;
        this.empreinte = empreinte;
    }
}
