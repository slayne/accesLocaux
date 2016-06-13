package corba.serveur.acces;

import GestAcces.Jour;
import GestAcces.ServeurAccesPOA;
import GestAcces.ServeurAccesPackage.CollaborateurInexistant;
import GestAcces.ServeurAccesPackage.PorteInexistante;
import GestAcces.ServeurAccesPackage.ZoneInexistante;
import GestAcces.Zone;
import bdd.objetDao.AccesDAO;
import bdd.objetDao.ZoneDAO;
import bdd.objetsMetier.Acces;
import utils.AccesUtils;
import bdd.objetsMetier.acces.AccesPermanent;
import bdd.objetsMetier.acces.AccesTemporaire;

import java.util.ArrayList;


public class ServeurAccesImpl extends ServeurAccesPOA {
    private static ZoneDAO zoneDAO = new ZoneDAO();
    private static AccesDAO accesDAO = new AccesDAO();

    @Override
    public void ajoutPerm(short id, short heureDebut, short heureFin, short idZone) throws ZoneInexistante {
        Zone z = zoneDAO.find(idZone);
        AccesPermanent ap = new AccesPermanent(z, id, heureDebut, heureFin);
        accesDAO.create(ap);
    }

    @Override
    public void ajoutTemp(short id, Jour jourDeb, Jour jourFin, short heureDebut, short heureFin, short idZone) throws ZoneInexistante {
        Zone z = zoneDAO.find(idZone);
        AccesTemporaire at = new AccesTemporaire(z, id, heureDebut, heureFin, AccesUtils.corbaJourToTimestamp(jourDeb), AccesUtils.corbaJourToTimestamp(jourFin));
        accesDAO.create(at);
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
    public boolean verifierAcces(short idCollaborateur, short idZone) {
        Acces a = accesDAO.find(idCollaborateur, idZone);
        if (a == null)
        {
            return false; // à savoir les codes de retour ?
        }
        else
        {
            return true;
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