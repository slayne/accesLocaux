package bdd.objetDao;

import GestAcces.Zone;
import bdd.DAO;
import bdd.objetsMetier.Acces;
import bdd.objetsMetier.acces.AccesPermanent;
import bdd.objetsMetier.acces.AccesTemporaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static bdd.connectionJDBC.ConnectionBDD.url_acces;

/**
 * Created by Miaeln on 11/06/2016.
 */
public class AccesDAO extends DAO<Acces> {

    ZoneDAO zoneDAO;

    public AccesDAO() {
        super(url_acces);
        this.zoneDAO = new ZoneDAO();
    }

    @Override
    public ArrayList<Acces> getInstances() {
        ArrayList<Acces> lesAcces = new ArrayList<Acces>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT idAcces FROM acces");
            while (result.next()) {
                Acces s = this.find(result.getInt(1));
                lesAcces.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesAcces;
    }

    public ArrayList<Acces> getInstances(short idC) {
        ArrayList<Acces> lesAcces = new ArrayList<Acces>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT idAcces FROM acces WHERE idcollaborateur = " + idC);
            while (result.next()) {
                Acces s = this.find(result.getInt(1));
                lesAcces.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesAcces;
    }

    @Override
    public Acces find(long id) {
        ZoneDAO zoneDAO = new ZoneDAO();
        Acces a = null;
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM acces WHERE idAcces = " + id
                    );
            if(result.first()) {
                if (result.getTimestamp("dateDebut") == null)
                {
                    a = new AccesPermanent(zoneDAO.find(result.getInt("idZone")),result.getShort("idCollaborateur"), result.getInt("heureDebut"), result.getInt("heureFin"));
                    a.setIdAcces(result.getInt("idAcces"));
                }
                else {
                    a = new AccesTemporaire(zoneDAO.find(result.getInt("idZone")),result.getShort("idCollaborateur"), result.getInt("heureDebut"), result.getInt("heureFin"),result.getTimestamp("dateDebut"), result.getTimestamp("dateFin"));
                    a.setIdAcces(result.getInt("idAcces"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public Acces create(Acces obj) {
        try {
            PreparedStatement prepare =
                    this.connect.prepareStatement(
                            "INSERT INTO acces(idCollaborateur, idZone, heureDebut, heureFin, dateDebut, dateFin) VALUES (?, ?, ?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
            prepare.setInt(1, obj.getIdCollaborateur());
            prepare.setInt(2, obj.getZone().idZone);
            if (obj instanceof AccesPermanent)
            {
                AccesPermanent obj2 = (AccesPermanent) obj;
                prepare.setInt(3, obj2.getHeureDebut());
                prepare.setInt(4, obj2.getHeureFin());
                if (obj instanceof AccesTemporaire)
                {
                    AccesTemporaire obj3 = (AccesTemporaire) obj;
                    prepare.setTimestamp(5,obj3.getDateDebut());
                    prepare.setTimestamp(6,obj3.getDateFin());
                }
                else
                {
                    prepare.setTimestamp(5,null);
                    prepare.setTimestamp(6,null);
                }

            }
            prepare.executeUpdate();

            // récupération des valeurs de l'insert
            ResultSet rs = prepare.getGeneratedKeys();
            rs.next();
            return find(rs.getInt("idAcces"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Acces update(Acces obj) { // inutile ici
        return null;
    }

    @Override
    public void delete(Acces obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "DELETE FROM acces WHERE idAcces = " + obj.getIdAcces()
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Acces find(long idC, long idZ) {
        ZoneDAO zoneDAO = new ZoneDAO();
        Acces a = null;
        try {
            ResultSet result = this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM acces WHERE idCollaborateur = " + idC + "AND idZone = "+ idZ + ";"
                    );
            if(result.first()) {
                if (result.getTimestamp("dateDebut") == null)
                {
                    a = new AccesPermanent(zoneDAO.find(result.getInt("idZone")),result.getShort("idCollaborateur"), result.getInt("heureDebut"), result.getInt("heureFin"));
                    a.setIdAcces(result.getInt("idAcces"));
                }
                else {
                    a = new AccesTemporaire(zoneDAO.find(result.getInt("idZone")),result.getShort("idCollaborateur"), result.getInt("heureDebut"), result.getInt("heureFin"),result.getTimestamp("dateDebut"), result.getTimestamp("dateFin"));
                    a.setIdAcces(result.getInt("idAcces"));
                }
            }
            else
            {
                a = null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
}
