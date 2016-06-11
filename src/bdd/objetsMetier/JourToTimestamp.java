package bdd.objetsMetier;

import GestAcces.Jour;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Miaeln on 11/06/2016.
 */
public class JourToTimestamp {
    public static Timestamp convert(Jour j)
    {
        Date d = new Date(j.annee, j.mois, j.jour);
        return new Timestamp(d.getTime());
    }
}
