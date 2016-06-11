package bdd.objetDao;

import GestAcces.Zone;
import bdd.DAO;
import bdd.connectionJDBC.ConnectionBDD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by yoan on 11/06/16.
 */
public class PorteDAO extends DAO<Integer> {


    public PorteDAO() {
        super(ConnectionBDD.url_acces);
    }

    @Override
    public ArrayList<Integer> getInstances() {
        ArrayList<Integer> portes = new ArrayList<Integer>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT id FROM porte");
            while (result.next()) {
                Integer s = result.getInt(1);
                portes.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return portes;
    }

    @Override
    public Integer find(long id) {
        return null;
    }

    @Override
    public Integer create(Integer obj) {
        return null;
    }

    @Override
    public Integer update(Integer obj) {
        return null;
    }

    @Override
    public void delete(Integer obj) {

    }
}
