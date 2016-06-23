package corba.clients;

import GestAcces.Log;
import GestAcces.ServeurAccesHelper;
import GestAcces.ServeurLogHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import utils.AccesUtils;

import java.util.Scanner;

/**
 * Created by yoan on 05/06/16.
 */
public class ClientLog {
    public static GestAcces.ServeurLog myLog;

    public static void main(String args[]) {
        try {
            // Intialisation de l'orb
            ORB orb = ORB.init(args,null);

            String idObj = AccesUtils.LOG_SERVER;
            // Recuperation du naming service
            NamingContext nameRoot =
                    NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            // Construction du nom a rechercher
            NameComponent[] nameToFind = new NameComponent[1];
            nameToFind[0] = new NameComponent(idObj,"");


            // Recherche aupres du naming service
            Object distantAcces = nameRoot.resolve(nameToFind);
            System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantAcces));

            myLog = ServeurLogHelper.narrow(distantAcces);


            boolean userInput = true;
            while (userInput) {
                System.out.println("que voulez vous faire ?");
                System.out.println("--- 0 : quitter");
                System.out.println("--- 1 : lire tous les logs");
                System.out.println("--- 2 : lire les logs depuis une date");
                System.out.println("--- 3 : lire les logs depuis une date, jusqu'à une date");
                Scanner reader = new Scanner(System.in);  // Reading from System.in
                int n = reader.nextInt(); // Scans the next token of the input as an int.
                switch (n) {
                    case 0: userInput = false;
                        break;
                    case 1:
                        Log[] ls = myLog.afficherLogs();
                        for (Log l : ls) {
                            System.out.println("log : " + l.log + " / " + l.date.h + ":" + l.date.m);
                        }
                        break;
                    case 2:
                        System.out.println("Entrez une date sous le format yyyy-MM-dd puis hh:mm:ss :");
                        String datef = reader.next();
                        datef+= " " + reader.next();
                        Log[] ll = myLog.afficherLogsFromDate(AccesUtils.stringToCorbaDate(datef));
                        for (Log l : ll) {
                            System.out.println("log : " + l.log + " / " + l.date.h + ":" + l.date.m);
                        }
                        break;
                    case 3:
                        System.out.println("Date de début : Entrez une date sous le format yyyy-MM-dd hh:mm:ss :");
                        String datedeb = reader.next();
                        System.out.println("Date de fin : Entrez une date sous le format yyyy-MM-dd hh:mm:ss :");
                        String datefin = reader.next();
                        Log[] lls = myLog.afficherLogsfromDateToDate(AccesUtils.stringToCorbaDate(datedeb),AccesUtils.stringToCorbaDate(datefin));
                        for (Log l : lls) {
                            System.out.println("log : " + l.log + " / " + l.date.h + ":" + l.date.m);
                        }
                        break;
                    default: break;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    } // main
}
