package corba.clients;

import GestAcces.*;
import GestAcces.ServeurAccesPackage.PorteInexistante;
import GestAcces.ServeurAnnuairePackage.CollaborateurInexistant;
import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import utils.AccesUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yoan on 10/06/16.
 */
public class ClientPorte {

    private ArrayList<Zone> zones;
    private int idPorte;
    private ORB orb;

    public static GestAcces.ServeurAcces serveurAcces;
    public static GestAcces.ServeurAnnuaire serveurAnnuaire;


    public ClientPorte(int idPorte) {
        this.idPorte = idPorte;

        connexionServeurAcces();
        connexionServeurRH();
        recuperationZones();
    }

    private void connexionServeurAcces() {
        try {
            // Intialisation de l'orb
            orb = ORB.init(new String[0], null);

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

            // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
            // org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001b49444c3a436f6e766572746973736575722f4575726f3a312e30000000000001000000000000008a00010200000000103133302e3132302e3230392e31353500db7f000000000031afabcb0000000020dc306ed400000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002");
            // Casting de l'objet CORBA au type talk
            serveurAcces = ServeurAccesHelper.narrow(distantAcces);
            System.out.println("Porte " + idPorte + " connectée au serveur d'accès");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connexionServeurRH() {
        try {
            // Saisie du nom de l'objet (si utilisation du service de nommage)
            // System.out.println("Quel objet Corba voulez-vous contacter ?");
            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //String idObj = in.readLine();
            String idObj = AccesUtils.ANNUAIRE_SERVER;
            // Recuperation du naming service
            NamingContext nameRoot =
                    NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            // Construction du nom a rechercher
            NameComponent[] nameToFind = new NameComponent[1];
            nameToFind[0] = new NameComponent(idObj, "");


            // Recherche aupres du naming service
            Object distantAnnuaire = nameRoot.resolve(nameToFind);

            // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
            // org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001b49444c3a436f6e766572746973736575722f4575726f3a312e30000000000001000000000000008a00010200000000103133302e3132302e3230392e31353500db7f000000000031afabcb0000000020dc306ed400000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002");
            // Casting de l'objet CORBA au type talk
            serveurAnnuaire = ServeurAnnuaireHelper.narrow(distantAnnuaire);
            System.out.println("Porte " + idPorte + " connectée au serveur d'annuaire");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void recuperationZones() {
        Zone[] ls = new Zone[0];
        try {
            ls = serveurAcces.getZonesPorte((short) idPorte);
            zones = new ArrayList<Zone>(Arrays.asList(ls));
        } catch (PorteInexistante porteInexistante) {
            porteInexistante.printStackTrace();
            System.out.println("La porte demandée est inexistante");
        }
    }

    public Zone getZoneSuivante(Zone zonePrec) {
        for (Zone z : zones) {
            if ((z.nomZone!=zonePrec.nomZone) && (z.idZone!=zonePrec.idZone)) return z;
        }

        return null;
    }

    public boolean traverser(Zone z, String photo, String empreinte) throws CollaborateurInexistant {
        boolean hasAcces = false;

        // demande de l'accès
        try {
            hasAcces = serveurAnnuaire.demanderAcces( photo, empreinte, z.idZone);
        } catch (CollaborateurInexistant e) {
            throw new CollaborateurInexistant();
        }

        return hasAcces;
    }

    public int getIdPorte() {
        return idPorte;
    }

    public boolean hasZone(Zone z) {
        for (Zone zo : zones) {
            if (zo.idZone==z.idZone) return true;
        }

        return false;
    }
}
