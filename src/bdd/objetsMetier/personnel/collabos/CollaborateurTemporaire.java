package bdd.objetsMetier.personnel.collabos;

import bdd.objetsMetier.Identifiant;
import bdd.objetsMetier.personnel.Collaborateur;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by igloo on 27/05/2016.
 */
public class CollaborateurTemporaire extends Collaborateur {
    private Date dateSortiePrevue;

    public CollaborateurTemporaire(String nom, String prenom, String adresse, String statut, String login, String mdp, String photo, Timestamp dateEntree, Identifiant identifiant, Date dateSortiePrevue) {
        super(nom, prenom, adresse, statut, login, mdp, photo, dateEntree, identifiant);
        this.dateSortiePrevue = dateSortiePrevue;
    }

    public Date getDateSortiePrevue() {

        return dateSortiePrevue;
    }

    public void setDateSortiePrevue(Date dateSortiePrevue) {
        this.dateSortiePrevue = dateSortiePrevue;
    }
}
