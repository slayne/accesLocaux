package bdd.objetsMetier.acces;

import GestAcces.Zone;
import bdd.objetsMetier.Acces;

/**
 * Created by igloo on 28/05/2016.
 */
public class AccesPermanent extends Acces {
    private int heureDebut;
    private int heureFin;

    public AccesPermanent(Zone z, short idC, int hDebut, int hFin)
    {
        super(z, idC);
        this.heureDebut = hDebut;
        this.heureFin = hFin;
    }


    public int getHeureDebut() {
        return heureDebut;
    }

    public int getHeureFin() {
        return heureFin;
    }
}
