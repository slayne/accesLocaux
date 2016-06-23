package bdd.objetDao;

import GestAcces.Date;
import GestAcces.Log;
import bdd.DAO;
import bdd.connectionJDBC.ConnectionBDD;
import bdd.objetsMetier.Acces;
import utils.AccesUtils;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by yoan on 05/06/16.
 */
public class LogDAO extends DAO<Log> {

    public LogDAO() {
        super(ConnectionBDD.url_log);
    }

    @Override
    public ArrayList<Log> getInstances() {
        ArrayList<Log> logs = new ArrayList<Log>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM logs");
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
        System.out.println(AccesUtils.corbaDateToTimeStamp(from).toLocalDateTime());
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM logs WHERE date > " + AccesUtils.corbaDateToTimeStamp(from));
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
                    "SELECT * FROM logs WHERE date BETWEEN " + AccesUtils.corbaDateToTimeStamp(from)
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
                            "SELECT * FROM logs WHERE id = " + id
                    );
            if(result.first()) {
                log = new Log(AccesUtils.timestampToCorbaDate(result.getTimestamp("date")),result.getString("log"));
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
                            "INSERT INTO logs(log,date) VALUES (?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
            prepare.setString(1, obj.log);
            prepare.setTimestamp(2, AccesUtils.corbaDateToTimeStamp(obj.date));
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
    public Log update(Log obj) {
        return null;
    }

    @Override
    public void delete(Log obj) {

    }
}
