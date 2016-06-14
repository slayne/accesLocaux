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
import java.util.Date;


public class ServeurAccesImpl extends ServeurAccesPOA {
    private static ZoneDAO zoneDAO = new ZoneDAO();
    private static AccesDAO accesDAO = new AccesDAO();

    @Override
    public void ajoutPerm(short id, short heureDebut, short heureFin, short idZone) throws ZoneInexistante {
        Zone z = zoneDAO.find(idZone);
        if (z == null)
        {
            throw new ZoneInexistante();
        }
        else {
            AccesPermanent ap = new AccesPermanent(z, id, heureDebut, heureFin);
            accesDAO.create(ap);
        }
    }

    @Override
    public void ajoutTemp(short id, Jour jourDeb, Jour jourFin, short heureDebut, short heureFin, short idZone) throws ZoneInexistante {
        Zone z = zoneDAO.find(idZone);
        if (z == null) {
            throw new ZoneInexistante();
        }
        else
        {
            AccesTemporaire at = new AccesTemporaire(z, id, heureDebut, heureFin, AccesUtils.corbaJourToTimestamp(jourDeb), AccesUtils.corbaJourToTimestamp(jourFin));
            accesDAO.create(at);
        }
    }

    @Override
    public void supprimerUnAcces(short idCollaborateur, short idZone) throws CollaborateurInexistant {
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

    public void supprimerAccesCollaborateur(short idCollaborateur) throws CollaborateurInexistant {
        ArrayList<Acces> aList = accesDAO.getInstances(idCollaborateur);
        if (aList.isEmpty())
        {
            throw new CollaborateurInexistant();
        }
        else
        {
            for (Acces a: aList) {
                accesDAO.create(a);
            }
        }
    }

    @Override
    public boolean verifierAcces(short idCollaborateur, short idZone) {
        Acces a = accesDAO.find(idCollaborateur, idZone);
        if (a == null)
        {
            return false;
        }
        else
        {
            if (a instanceof AccesTemporaire)
            {
                AccesTemporaire aPer = (AccesTemporaire)  a;
                Date d = new Date();
                if (aPer.getHeureDebut() < d.getHours() && aPer.getHeureFin() > d.getHours() && aPer.getDateFin().getDate() > d.getDate()  )
                {
                     return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                AccesPermanent aPer = (AccesPermanent)  a;
                Date d = new Date();
                if (aPer.getHeureDebut() < d.getHours() && aPer.getHeureFin() > d.getHours())
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }

    public AccesCorba[] getAccesCollaborateur(short idCollaborateur)
    {
        ArrayList<Acces> accesList = accesDAO.getInstances(idCollaborateur);
        AccesCorba[] acces = new AccesCorba[accesList.size()];
        int i=0;
        for (Acces a : accesList) {
            if (a instanceof AccesTemporaire)
            {
                acces[i] = new AccesCorba(a.getIdAcces(), a.getZone(), a.getIdCollaborateur(), AccesUtils.timestampToCorbaDate(((AccesTemporaire) a).getDateDebut()), AccesUtils.timestampToCorbaDate(((AccesTemporaire) a).getDateFin()), (short) ((AccesTemporaire) a).getHeureDebut(), (short) ((AccesTemporaire) a).getHeureFin(), true);
            }
            else
            {
                acces[i] = new AccesCorba(a.getIdAcces(), a.getZone(), a.getIdCollaborateur(), null,null, (short) ((AccesPermanent) a).getHeureDebut(), (short) ((AccesPermanent) a).getHeureFin(), false);
            }
            i++;
        }

        return acces;
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