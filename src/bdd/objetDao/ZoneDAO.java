package bdd.objetDao;

import GestAcces.Log;
import GestAcces.Zone;
import bdd.DAO;
import utils.AccesUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        ArrayList<Zone> zones = new ArrayList<Zone>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT zone.id FROM zone");
            while (result.next()) {
                Zone s = this.find(result.getInt(1));
                zones.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zones;
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
                    "SELECT zone.id FROM zone,porte where (zone.id=porte.idzone or zone.id=porte.idzone2) and porte.id=" + porteId);
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
            Zone z = null;
            try {
                ResultSet result = this.connect
                        .createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE
                        ).executeQuery(
                                "SELECT * FROM zone WHERE id = " + id
                        );
                if(result.first()) {
                    z= new Zone((short)result.getInt("id"),result.getString("nom"));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return z;

        }

    @Override
    public Zone create(Zone obj) {

        try {
        PreparedStatement prepare =
                this.connect.prepareStatement(
                        "INSERT INTO zone(id,nom) VALUES (?, ?)",
                        Statement.RETURN_GENERATED_KEYS
                );
        prepare.setInt(1, obj.idZone);
        prepare.setString(2, obj.nomZone);
        prepare.executeUpdate();

        // récupération des valeurs de l'insert
        ResultSet rs = prepare.getGeneratedKeys();
        rs.next();
        return find(rs.getInt("id"));
    }
    catch (SQLException e) {
        e.printStackTrace();
    }

    return null;
    }

    @Override
    public Zone update(Zone obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "UPDATE zone SET nom = '" + obj.nomZone + "' "+
                            " WHERE id = " + obj.idZone
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return find(obj.idZone);

    }

    @Override
    public void delete(Zone obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "DELETE FROM zone WHERE id = " + obj.idZone
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

