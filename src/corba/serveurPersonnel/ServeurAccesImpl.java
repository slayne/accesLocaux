package corba.serveurPersonnel;

import GestAcces.Jour;
import GestAcces.ServeurAccesPOA;
import GestAcces.ServeurAccesPackage.CollaborateurInexistant;
import GestAcces.ServeurAccesPackage.ZoneInexistante;
import GestAcces.Zone;


public class ServeurAccesImpl extends ServeurAccesPOA {

    public ServeurAccesImpl(){

    }

    @Override
    public short ajoutPerm(short id, short heureDebut, short heureFin, Zone z) throws ZoneInexistante {
        return 0;
    }

    @Override
    public short ajoutTemp(short id, Jour jourDeb, Jour jourFin, short heureDebut, short heureFin, Zone z) throws ZoneInexistante {
        return 0;
    }

    @Override
    public short demanderAcces(String id, String mdp) {
        return 0;
    }

    @Override
    public short supprimerAcces(short idCollaborateur, short idZone) throws CollaborateurInexistant {
        return 0;
    }

    @Override
    public short verifierAcces(short idCollaborateur, short idZone) {
        return 0;
    }

    @Override
    public Zone[] getListeZone() {
        return new Zone[0];
    }
}