package corba.clients;

import GestAcces.*;
import GestAcces.ServeurAccesPackage.PorteInexistante;
import GestAcces.ServeurAnnuairePackage.CollaborateurInexistant;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
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
    private NamingContext nameRoot;

    public static GestAcces.ServeurAcces serveurAcces;
    public static GestAcces.ServeurAnnuaire serveurAnnuaire;
    public static ServeurLog serveurLog;


    public ClientPorte(int idPorte) {
        this.idPorte = idPorte;

        // Intialisation de l'orb
        orb = ORB.init(new String[0], null);
        // Recuperation du naming service
        try {
            nameRoot =
                    NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
        } catch (InvalidName invalidName) {
            invalidName.printStackTrace();
        }

        serveurAcces = AccesUtils.connexionAcces(orb,nameRoot);
        serveurAnnuaire = AccesUtils.connexionAnnuaire(orb,nameRoot);
        serveurLog = AccesUtils.connexionLog(orb,nameRoot);


        recuperationZones();
    }

    private void recuperationZones() {
        Zone[] ls = new Zone[0];
        try {
            ls = serveurAcces.getZonesPorte((short) idPorte);
            zones = new ArrayList<Zone>(Arrays.asList(ls));
            serveurLog.envoyerLog("Porte " + idPorte + " : connectée");
        } catch (PorteInexistante porteInexistante) {
            porteInexistante.printStackTrace();
            System.out.println("La porte demandée est inexistante");
            serveurLog.envoyerLog("Porte " + idPorte + " : inexistante");

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
            serveurLog.envoyerLog("Porte " + idPorte + " : "
                    + (hasAcces ? "autorise" : "interdit") + " traversée de l'empreinte"
                    + empreinte + " et photo " + photo + " vers zone " + z.nomZone);
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
