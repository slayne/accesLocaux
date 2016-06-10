package corba.serveur.acces;

import GestAcces.Jour;
import GestAcces.Log;
import GestAcces.ServeurAccesPOA;
import GestAcces.ServeurAccesPackage.CollaborateurInexistant;
import GestAcces.ServeurAccesPackage.PorteInexistante;
import GestAcces.ServeurAccesPackage.ZoneInexistante;
import GestAcces.Zone;
import bdd.objetDao.ZoneDAO;

import javax.sound.sampled.Port;
import java.util.ArrayList;


public class ServeurAccesImpl extends ServeurAccesPOA {
    private static ZoneDAO zoneDAO = new ZoneDAO();

    @Override
    public short ajoutPerm(short id, short heureDebut, short heureFin, short idZone) throws ZoneInexistante {
        return 0;
    }

    @Override
    public short ajoutTemp(short id, Jour jourDeb, Jour jourFin, short heureDebut, short heureFin, short idZone) throws ZoneInexistante {
        return 0;
    }

    @Override
    public short demanderAcces(String Photo, String mdp) {
        return 0;
    }

    @Override
    public void supprimerAcces(short idCollaborateur, short idZone) throws CollaborateurInexistant {

    }

    @Override
    public short verifierAcces(short idCollaborateur, short idZone) {
        return 0;
    }

    @Override
    public Zone[] getListeZone() {
        return new Zone[0];
    }

    @Override
    public Zone[] getZonesPorte(short idPorte) throws PorteInexistante {
        ArrayList<Zone> zonesList = zoneDAO.getZonesByPorteId(idPorte);

        // vérification de l'id de la porte
        if (zonesList.isEmpty()) throw  new PorteInexistante();

        Zone[] zones = new Zone[zonesList.size()];
        zones = zonesList.toArray(zones);


        return zones;
    }
}