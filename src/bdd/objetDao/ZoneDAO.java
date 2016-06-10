package bdd.objetDao;

import GestAcces.Zone;
import bdd.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static bdd.connectionJDBC.ConnectionBDD.url_acces;

/**
 * Created by yoan on 10/06/16.
 */
public class ZoneDAO extends DAO<Zone> {

    public ZoneDAO() {
        super(url_acces);
    }

    @Override
    public ArrayList<Zone> getInstances() {
        return null;
    }

    /**
     * retourne les zones d'une porte
     */
    public ArrayList<Zone> getZonesByPorteId(int porteId) {
        ArrayList<Zone> zonesPorte = new ArrayList<Zone>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM zone,porte where zone.id = porte.idZone and porte.id=" + porteId);
            while (result.next()) {
                Zone s = this.find(result.getInt(1));
                zonesPorte.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zonesPorte;

    }

    @Override
    public Zone find(long id) {
        return null;
    }

    @Override
    public Zone create(Zone obj) {
        return null;
    }

    @Override
    public Zone update(Zone obj) {
        return null;
    }

    @Override
    public void delete(Zone obj) {

    }
}
