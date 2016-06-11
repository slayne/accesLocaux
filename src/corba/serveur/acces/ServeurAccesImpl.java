package corba.serveur.acces;

import GestAcces.Jour;
import GestAcces.Log;
import GestAcces.ServeurAccesPOA;
import GestAcces.ServeurAccesPackage.CollaborateurInexistant;
import GestAcces.ServeurAccesPackage.PorteInexistante;
import GestAcces.ServeurAccesPackage.ZoneInexistante;
import GestAcces.Zone;
import bdd.objetDao.AccesDAO;
import bdd.objetDao.ZoneDAO;
import bdd.objetsMetier.Acces;
import bdd.objetsMetier.JourToTimestamp;
import bdd.objetsMetier.acces.AccesPermanent;
import bdd.objetsMetier.acces.AccesTemporaire;

import javax.sound.sampled.Port;
import java.util.ArrayList;


public class ServeurAccesImpl extends ServeurAccesPOA {
    private static ZoneDAO zoneDAO = new ZoneDAO();
    private static AccesDAO accesDAO = new AccesDAO();

    @Override
    public short ajoutPerm(short id, short heureDebut, short heureFin, short idZone) throws ZoneInexistante {
        Zone z = zoneDAO.find(idZone);
        AccesPermanent ap = new AccesPermanent(z, id, heureDebut, heureFin);
        accesDAO.create(ap);
        return 0;
    }

    @Override
    public short ajoutTemp(short id, Jour jourDeb, Jour jourFin, short heureDebut, short heureFin, short idZone) throws ZoneInexistante {
        Zone z = zoneDAO.find(idZone);
        AccesTemporaire at = new AccesTemporaire(z, id, heureDebut, heureFin, JourToTimestamp.convert(jourDeb), JourToTimestamp.convert(jourFin));
        accesDAO.create(at);
        return 0;
    }

    @Override
    public void supprimerAcces(short idCollaborateur, short idZone) throws CollaborateurInexistant {
        Acces a = accesDAO.find(idCollaborateur, idZone);
        if (a == null)
        {
            throw new CollaborateurInexistant();
        }
        else
        {
            accesDAO.delete(a);
        }

    }

    @Override
    public short verifierAcces(short idCollaborateur, short idZone) {
        Acces a = accesDAO.find(idCollaborateur, idZone);
        if (a == null)
        {
            return -1; // à savoir les codes de retour ?
        }
        else
        {
            return 0;
        }
    }

    @Override
    public Zone[] getListeZone() {
        ArrayList<Zone> zonesList = zoneDAO.getInstances();

        Zone[] zones = new Zone[zonesList.size()];
        zones = zonesList.toArray(zones);
        return zones;
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