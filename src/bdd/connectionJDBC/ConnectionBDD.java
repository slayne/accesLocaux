package bdd.connectionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Stéfan on 08/11/2015.
 */
public class ConnectionBDD {
    public static String url_acces = "jdbc:postgresql://localhost:5432/acces";
    public static String url_empreinte = "jdbc:postgresql://localhost:5432/empreinte";
    public static String url_annuaire = "jdbc:postgresql://localhost:5432/annuaire";
    public static String url_log = "jdbc:postgresql://localhost:5432/log";

    private static String user = "postgres";

    private static String passwd = "dev";

    private static Connection connect;

    /**
     * Returns database respConnection instance (and creates it if it doesn't exist)
     * 	 * @return Database respConnection link
     */
    public static Connection getInstance(String url){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }
}
