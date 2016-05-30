package bdd.objetDao;

import bdd.DAO;
import bdd.objetsMetier.Personnel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by yoan on 29/05/16.
 */
public class PersonnelDAO extends DAO<Personnel> {
    @Override
    public ArrayList<Personnel> getInstances() {
        ArrayList<Personnel> personnels = new ArrayList<Personnel>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM personnel");
            while (result.next()) {
                Personnel s = this.find(result.getInt(1));
                personnels.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personnels;
    }

    @Override
    public Personnel find(long id) {
        Personnel perso = null;
        try {
            ResultSet result = this .connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM personnel WHERE id = " + id
                    );
            if(result.first()) {
                perso = new Personnel(
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("adresse"),
                        result.getString("statut"),
                        result.getString("login"),
                        result.getString("mdp")
                );
                perso.setId(result.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return perso;
    }

    @Override
    public Personnel create(Personnel obj) {
        try {
            // insertion de l'objet
            PreparedStatement prepare =
                    this.connect.prepareStatement(
                            "INSERT INTO personnel (nom,prenom,adresse,statut,login,mdp) VALUES (?, ?, ?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
            prepare.setString(1, obj.getNom());
            prepare.setString(2, obj.getPrenom());
            prepare.setString(3,obj.getAdresse());
            prepare.setString(4,obj.getStatut());
            prepare.setString(5,obj.getLogin());
            prepare.setString(6,obj.getMdp());
            prepare.executeUpdate();
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
    public Personnel update(Personnel obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "UPDATE personnel SET nom = '" + obj.getNom() + "',"+
                            " prenom = '" + obj.getPrenom() + "'" + "',"+
                            " adresse = '" + obj.getAdresse() + "'" +
                            " statut = '" + obj.getAdresse() + "'" +
                            " login = '" + obj.getLogin() + "'" +
                            " mdp = '" + obj.getMdp() + "'" +
                            " WHERE id = " + obj.getId()
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return find(obj.getId());
    }

    @Override
    public void delete(Personnel obj) {

    }
}
