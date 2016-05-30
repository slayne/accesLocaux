package bdd.objetsMetier;

import bdd.objetsMetier.zonePortes.ZonesPorteList;

/**
 * Created by igloo on 28/05/2016.
 */
public class Porte {
    private int idPorte;
    private String nomPorte;
    private ZonesPorteList<Zone> zones;

    public Porte(String nomPorte, ZonesPorteList<Zone> zones) {
        this.nomPorte = nomPorte;
        this.zones = zones;
    }

    public ZonesPorteList<Zone> getZones() {
        return zones;
    }

    public void setZones(ZonesPorteList<Zone> zones) {
        this.zones = zones;
    }

    public String getNomPorte() {
        return nomPorte;
    }

    public void setNomPorte(String nomPorte) {
        this.nomPorte = nomPorte;
    }
}
