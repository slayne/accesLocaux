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

/**
 * Created by yoan on 05/06/16.
 */
public class ClientLog {
    public static GestAcces.ServeurLog myLog;

    public static void main(String args[]) {
        try {
            // Intialisation de l'orb
            ORB orb = ORB.init(args,null);

            // Saisie du nom de l'objet (si utilisation du service de nommage)
            // System.out.println("Quel objet Corba voulez-vous contacter ?");
            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //String idObj = in.readLine();
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

            // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
            // org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001b49444c3a436f6e766572746973736575722f4575726f3a312e30000000000001000000000000008a00010200000000103133302e3132302e3230392e31353500db7f000000000031afabcb0000000020dc306ed400000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002");
            // Casting de l'objet CORBA au type talk
            myLog = ServeurLogHelper.narrow(distantAcces);


            System.out.println("Serveur Log - que voulez vous faire ?");
            Log[] ls = myLog.afficherLogs();
            for (Log l : ls) {
                System.out.println("log : " + l.log + " / " + l.date.h + ":" + l.date.m);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    } // main
}
