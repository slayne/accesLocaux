package bdd.objetDao;

import bdd.DAO;
import bdd.connectionJDBC.ConnectionBDD;
import bdd.objetsMetier.Empreinte;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by yoan on 06/06/16.
 */
public class EmpreinteDAO extends DAO<Empreinte> {

    public EmpreinteDAO() {
        super(ConnectionBDD.url_empreinte);
    }

    @Override
    public ArrayList<Empreinte> getInstances() {
        ArrayList<Empreinte> empreintes = new ArrayList<Empreinte>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM empreinte");
            while (result.next()) {
                Empreinte s = this.find(result.getInt(1));
                empreintes.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empreintes;
    }

    @Override
    /**
     * Warning : cherche en fonction de l'id du collabo qui possède cette empreinte
     */
    public Empreinte find(long id) {
        Empreinte log = null;
        try {
            ResultSet result = this .connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM empreinte WHERE idcollaborateur = " + id
                    );
            if(result.first()) {
                log = new Empreinte(result.getString("empreinte"), (short)result.getInt("idcollaborateur"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return log;
    }

    @Override
    public Empreinte create(Empreinte obj) {
        try {
            // insertion de l'objet
            PreparedStatement prepare =
                    this.connect.prepareStatement(
                            "INSERT INTO empreinte(empreinte,idcollaborateur) VALUES (?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
            prepare.setString(1, obj.empreinte);
            prepare.setInt(2, obj.idCollaborateur);

            prepare.executeUpdate();

            // récupération des valeurs de l'insert
            ResultSet rs = prepare.getGeneratedKeys();
            rs.next();
            return find(rs.getInt(2));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    /**
     * Attention : modifie uniquement une empreinte
     */
    public Empreinte update(Empreinte obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "UPDATE empreinte SET empreinte = '" + obj.empreinte + "' "+
                            " WHERE idCollaborateur = " + obj.idCollaborateur
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return find(obj.idCollaborateur);
    }

    @Override
    public void delete(Empreinte obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "DELETE FROM empreinte WHERE idCollaborateur = " + obj.idCollaborateur
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
