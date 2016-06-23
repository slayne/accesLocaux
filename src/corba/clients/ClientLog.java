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
                Scanner reader = new Scanner(System.in);  // Reading from System.in
                int n = reader.nextInt(); // Scans the next token of the input as an int.
                switch (n) {
                    case 0: userInput = false;
                        break;
                    case 1:
                        Log[] ls = myLog.afficherLogs();
                        for (Log l : ls) {
                            System.out.println("log : " + l.log + " / " + l.date.j.annee + "-" + l.date.j.mois+ l.date.j.jour + " > " + l.date.h + ":" + l.date.m);
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
