package bdd.objetDao;

import GestAcces.Date;
import GestAcces.Log;
import bdd.DAO;
import bdd.objetsMetier.Acces;
import utils.AccesUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by yoan on 05/06/16.
 */
public class LogDAO extends DAO<Log> {

    @Override
    public ArrayList<Log> getInstances() {
        ArrayList<Log> logs = new ArrayList<Log>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM log");
            while (result.next()) {
                Log s = this.find(result.getInt(1));
                logs.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }

    public ArrayList<Log> getInstancesFrom(Date from) {
        ArrayList<Log> logs = new ArrayList<Log>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM log WHERE date > " + AccesUtils.corbaDateToTimeStamp(from));
            while (result.next()) {
                Log s = this.find(result.getInt(1));
                logs.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }


    public ArrayList<Log> getInstancesByDate(Date from, Date to) {
        ArrayList<Log> logs = new ArrayList<Log>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM log WHERE date BETWEEN " + AccesUtils.corbaDateToTimeStamp(from)
                            + " AND " + AccesUtils.corbaDateToTimeStamp(to));
            while (result.next()) {
                Log s = this.find(result.getInt(1));
                logs.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return logs;
    }


    @Override
    public Log find(long id) {
        Log log = null;
        try {
            ResultSet result = this .connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM log WHERE id = " + id
                    );
            if(result.first()) {
                log = new Log(AccesUtils.timestampToCorbaDate(result.getTimestamp("date")),result.getString("log"));
                log.id = (result.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return log;
    }

    @Override
    public Log create(Log obj) {
        try {
            // insertion de l'objet
            PreparedStatement prepare =
                    this.connect.prepareStatement(
                            "INSERT INTO log(log,date) VALUES (?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
            prepare.setString(1, obj.log);
            prepare.setTimestamp(2, AccesUtils.corbaDateToTimeStamp(obj.date));
            // récupération des valeurs de l'insert
            ResultSet rs = prepare.getGeneratedKeys();
            rs.next();
            return find(rs.getInt(1));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Log update(Log obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "UPDATE log SET log = '" + obj.log + "',"+
                            " date = '" + AccesUtils.corbaDateToTimeStamp(obj.date)+ "'" +
                            " WHERE id = " + obj.id
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return find(obj.id);
    }

    @Override
    public void delete(Log obj) {

    }
}
