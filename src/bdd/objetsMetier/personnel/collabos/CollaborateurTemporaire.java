package bdd.objetsMetier.personnel.collabos;

import bdd.objetsMetier.personnel.Collaborateur;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by igloo on 27/05/2016.
 */
public class CollaborateurTemporaire extends Collaborateur {
    private Timestamp dateSortiePrevue;


    public CollaborateurTemporaire(String nom,String photo, Timestamp dateEntree, String empreinte, Timestamp dateSortiePrevue) {
        super(nom,photo, dateEntree, empreinte);
        this.dateSortiePrevue=dateSortiePrevue;
    }

    public Timestamp getDateSortiePrevue() {
        return dateSortiePrevue;
    }
}
