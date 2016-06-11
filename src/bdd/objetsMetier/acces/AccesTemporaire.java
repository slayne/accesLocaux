package bdd.objetsMetier.acces;

import GestAcces.Zone;
import bdd.objetsMetier.Acces;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by igloo on 28/05/2016.
 */
public class AccesTemporaire extends AccesPermanent {
    private Timestamp dateDebut;
    private Timestamp dateFin;

    public AccesTemporaire(Zone z, short idC, int hDebut, int hFin, Timestamp dateD, Timestamp dateF)
    {
        super(z, idC, hDebut, hFin);
        this.dateDebut = dateD;
        this.dateFin = dateF;
    }

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }
}
