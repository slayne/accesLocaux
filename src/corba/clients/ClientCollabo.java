package corba.clients;


import GestAcces.ServeurAccesHelper;
import GestAcces.ServeurAnnuairePackage.CollaborateurInexistant;
import GestAcces.Zone;
import bdd.objetDao.PorteDAO;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import utils.AccesUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by yoan on 10/06/16.
 */
public class ClientCollabo {

    private String photo,empreinte;
    private Zone zoneCourante;
    private HashMap<Integer,ClientPorte> portesZone;

    public static void main(String[] args) {

        System.out.println((new PorteDAO()).getInstances());

        ClientCollabo collabo = new ClientCollabo("Photo","empreinte");
        collabo.naviguer();
    }

    public ClientCollabo(String p, String e) {
        photo = p;
        empreinte = e;
        zoneCourante = new Zone((short)1,"Accueil");
    }

    /*
    private void connexionServeurAcces() {
        try {
            // Intialisation de l'orb
            ORB orb = ORB.init(new String[0], null);

            // Saisie du nom de l'objet (si utilisation du service de nommage)
            // System.out.println("Quel objet Corba voulez-vous contacter ?");
            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //String idObj = in.readLine();
            String idObj = AccesUtils.ACCES_SERVER;
            // Recuperation du naming service
            NamingContext nameRoot =
                    NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            // Construction du nom a rechercher
            NameComponent[] nameToFind = new NameComponent[1];
            nameToFind[0] = new NameComponent(idObj, "");


            // Recherche aupres du naming service
            Object distantAcces = nameRoot.resolve(nameToFind);
            System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantAcces));

            // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
            // org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001b49444c3a436f6e766572746973736575722f4575726f3a312e30000000000001000000000000008a00010200000000103133302e3132302e3230392e31353500db7f000000000031afabcb0000000020dc306ed400000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002");
            // Casting de l'objet CORBA au type talk
            serveurAcces = ServeurAccesHelper.narrow(distantAcces);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
    /**
     * Simulation de passage de porte, demande d'accès
     * @param p
     * @param zoneARejoindre
     */
    private void passerPorte(ClientPorte p, Zone zoneARejoindre) {
        System.out.println("Porte " + p.getIdPorte() + " : demande d'accès à la zone" + zoneARejoindre.nomZone);
        boolean hasAcces = false;
        try {
            hasAcces = p.traverser(zoneARejoindre, photo, empreinte);
        } catch (CollaborateurInexistant e) {
            System.out.println("Photo et empreinte incorrectes");
        }

        if (hasAcces) {
            System.out.println("Accès autorisé : vous etes maintenant dans la zone" + zoneARejoindre.nomZone);
            zoneCourante = zoneARejoindre;
        } else {
            System.out.println("Accès interdit");
        }
    }

    public void fouillerZoneCourante() {
        portesZone = Portes.getPortesInZone(zoneCourante);

        for (ClientPorte p : portesZone.values()) {
            System.out.println("Porte " + p.getIdPorte() + " : vers zone " + p.getZoneSuivante(zoneCourante).nomZone);
        }
    }

    public void naviguer() {
        fouillerZoneCourante();

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Quelle porte voulez vous franchir ?");
        int n = reader.nextInt(); // Scans the next token of the input as an int.

        ClientPorte p = portesZone.get(n);

        passerPorte(p, p.getZoneSuivante(zoneCourante));
    }

}
