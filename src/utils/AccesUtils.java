package utils;

import GestAcces.Date;
import GestAcces.Jour;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by yoan on 05/06/16.
 */
public class AccesUtils {
    public static final String LOG_SERVER = "Serveur de log tu le sais mamene on est la";
    public static final String ACCES_SERVER = "Serveur d'acces SI JE NMABUSE";
    public static final String ANNUAIRE_SERVER = "Le serveur d'annuaire pour toutes ces douces beurettes";
    public static final String EMPREINTE_SERVER = "Ce genre de serveur d'empreinte mamene";


    public static Timestamp corbaDateToTimeStamp(GestAcces.Date d) {
        Timestamp timestamp = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(""+d.j.annee + "-" + d.j.mois + "-" + d.j.jour + " " + d.h + ":" + d.m + ":" + "00");
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return timestamp;
    }

    public static GestAcces.Date timestampToCorbaDate(Timestamp t) {
        GestAcces.Date d = new Date(new Jour((short)t.getYear(),(short)t.getMonth(),(short)t.getDay()),
                (short)t.getHours(),(short)t.getMinutes());

        return d;
    }
}
