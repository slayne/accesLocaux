package bdd.objetsMetier.personnel.collabos;

import bdd.objetsMetier.personnel.Collaborateur;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by igloo on 27/05/2016.
 */
public class CollaborateurTemporaire extends Collaborateur {
    private Date dateSortiePrevue;


    public CollaborateurTemporaire(String photo, Timestamp dateEntree, String empreinte) {
        super(photo, dateEntree, empreinte);
    }
}
