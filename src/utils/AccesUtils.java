package utils;

import GestAcces.*;
import GestAcces.Date;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by yoan on 05/06/16.
 */
public class AccesUtils {
    public static final String LOG_SERVER = "Serveur de log tu le sais mamene on est la";
    public static final String ACCES_SERVER = "Serveur d'acces SI JE NMABUSE";
    public static final String ANNUAIRE_SERVER = "Le serveur d'annuaire pour toutes ces douces beurettes";
    public static final String EMPREINTE_SERVER = "Ce genre de serveur d'empreinte mamene";

    public static Timestamp corbaJourToTimestamp(Jour j) {
        System.out.println("Corba ! " + j.annee + " / " + j.mois + j.jour);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date d = null;
        try {
            d = sdf.parse(j.jour + "/" + j.mois +"/"+ j.annee);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Timestamp(d.getTime());
    }

    public static Timestamp corbaDateToTimeStamp(GestAcces.Date d) {
        Timestamp timestamp = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse("" + d.j.annee + "-" + d.j.mois + "-" + d.j.jour + " " + d.h + ":" + d.m + ":" + "00");
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return timestamp;
    }

    public static GestAcces.Date stringToCorbaDate(String date) {
        Timestamp timestamp = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(date);
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
            System.out.println(timestamp.toLocalDateTime());
            return timestampToCorbaDate(timestamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static GestAcces.Date timestampToCorbaDate(Timestamp t) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(t.getTime());
        GestAcces.Date d = new Date(new Jour((short) cal.get(Calendar.YEAR), (short) cal.get(Calendar.MONTH), (short) cal.get(Calendar.DAY_OF_MONTH)),
                (short) cal.get(Calendar.HOUR), (short) cal.get(Calendar.MINUTE));

        return d;
    }

    // méthodes de connexion corba
    public static ServeurLog connexionLog(ORB orb, NamingContext nameRoot) {
        try {
            String idObj = AccesUtils.LOG_SERVER;
            // Recuperation du naming service

            // Construction du nom a rechercher
            NameComponent[] nameToFind = new NameComponent[1];
            nameToFind[0] = new NameComponent(idObj, "");


            // Recherche aupres du naming service
            Object distantAcces = nameRoot.resolve(nameToFind);
            /*System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantAcces));*/

            // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
            // org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001b49444c3a436f6e766572746973736575722f4575726f3a312e30000000000001000000000000008a00010200000000103133302e3132302e3230392e31353500db7f000000000031afabcb0000000020dc306ed400000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002");
            // Casting de l'objet CORBA au type talk
            ServeurLog myLog = ServeurLogHelper.narrow(distantAcces);
            return myLog;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static ServeurAcces connexionAcces(ORB orb, NamingContext nameRoot) {
        try {
            String idObj = AccesUtils.ACCES_SERVER;

            // Construction du nom a rechercher
            NameComponent[] nameToFind = new NameComponent[1];
            nameToFind[0] = new NameComponent(idObj, "");

            // Recherche aupres du naming service
            Object distantAcces = nameRoot.resolve(nameToFind);
            /*System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantAcces));*/

            // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
            // org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001b49444c3a436f6e766572746973736575722f4575726f3a312e30000000000001000000000000008a00010200000000103133302e3132302e3230392e31353500db7f000000000031afabcb0000000020dc306ed400000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002");
            // Casting de l'objet CORBA au type talk
            return ServeurAccesHelper.narrow(distantAcces);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ServeurAnnuaire connexionAnnuaire(ORB orb, NamingContext nameRoot) {
        try {
            String idObj = AccesUtils.ANNUAIRE_SERVER;

            // Construction du nom a rechercher
            NameComponent[] nameToFind = new NameComponent[1];
            nameToFind[0] = new NameComponent(idObj, "");

            // Recherche aupres du naming service
            Object distantAcces = nameRoot.resolve(nameToFind);
            System.out.println(orb.object_to_string(distantAcces));

            // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
            // org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001b49444c3a436f6e766572746973736575722f4575726f3a312e30000000000001000000000000008a00010200000000103133302e3132302e3230392e31353500db7f000000000031afabcb0000000020dc306ed400000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002");
            // Casting de l'objet CORBA au type talk
            return ServeurAnnuaireHelper.narrow(distantAcces);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ServeurEmpreinte connexionEmpreinte(ORB orb, NamingContext nameRoot) {
        try {
            // Saisie du nom de l'objet (si utilisation du service de nommage)
            // System.out.println("Quel objet Corba voulez-vous contacter ?");
            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //String idObj = in.readLine();
            String idObj = AccesUtils.EMPREINTE_SERVER;

            // Construction du nom a rechercher
            NameComponent[] nameToFind = new NameComponent[1];
            nameToFind[0] = new NameComponent(idObj, "");


            // Recherche aupres du naming service
            Object distantAcces = nameRoot.resolve(nameToFind);
            /*System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantAcces));*/

            // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
            // org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001b49444c3a436f6e766572746973736575722f4575726f3a312e30000000000001000000000000008a00010200000000103133302e3132302e3230392e31353500db7f000000000031afabcb0000000020dc306ed400000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002");
            // Casting de l'objet CORBA au type talk
            return ServeurEmpreinteHelper.narrow(distantAcces);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
