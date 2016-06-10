package bdd.objetsMetier.personnel.collabos;

import bdd.objetsMetier.acces.AccesPermanent;
import bdd.objetsMetier.personnel.Collaborateur;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by igloo on 27/05/2016.
 */
public class CollaborateurPermanent extends Collaborateur {
    private ArrayList<AccesPermanent> accesPermanents;


    public CollaborateurPermanent(String nom,String photo, Timestamp dateEntree, String empreinte) {
        super(nom,photo, dateEntree, empreinte);
        accesPermanents = new ArrayList<>();
    }
}
