package bdd.objetsMetier;

import GestAcces.Zone;

/**
 * Created by igloo on 28/05/2016.
 */
public class Acces  {
    private int idAcces;
    private Zone zone;
    private short idCollaborateur;

    public Acces(Zone z, short idC)
    {
        this.zone = z;
        this.idCollaborateur = idC;
    }

    public int getIdAcces() {
        return idAcces;
    }

    public void setIdAcces(int idAcces) {
        this.idAcces = idAcces;
    }

    public Zone getZone() {
        return zone;
    }

    public short getIdCollaborateur() {
        return idCollaborateur;
    }
}
