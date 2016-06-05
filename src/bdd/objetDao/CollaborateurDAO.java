package bdd.objetDao;

import bdd.DAO;
import bdd.objetsMetier.Identifiant;
import bdd.objetsMetier.Personnel;
import bdd.objetsMetier.personnel.Collaborateur;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by yoan on 29/05/16.
 */
public class CollaborateurDAO extends DAO<Collaborateur> {
    @Override
    public ArrayList<Collaborateur> getInstances() {
        ArrayList<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM personnel");
            while (result.next()) {
                Collaborateur s = this.find(result.getInt(1));
                collaborateurs.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborateurs;
    }

    @Override
    public Collaborateur find(long id) {
        Collaborateur collaborateur = null;
        try {
            ResultSet result = this .connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM personnel,collabo,identifiant,collabo_has_identifiant chi WHERE personnel.id = " + id
                                    + " AND collabo.idPerso = personnel.id "+
                                      " AND collabo.id=chi.idCollabo AND identifiant.id=chi.idIdentifiant"
                    );
            if(result.first()) {
                Identifiant identifiant = new Identifiant(
                        result.getString("empreinte")
                );
                collaborateur = new Collaborateur(
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getString("adresse"),
                        result.getString("statut"),
                        result.getString("login"),
                        result.getString("mdp"),
                        result.getString("photo"),
                        result.getTimestamp("dateEntree"),
                        identifiant
                );
                collaborateur.setId(result.getInt("idCollabo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborateur;
    }

    @Override
    public Collaborateur create(Collaborateur obj) {
        try {
            // insertion du personnel
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
            int idPerso = rs.getInt(1);


            // insertion du collabo
            PreparedStatement prepareCollabo =
                    this.connect.prepareStatement(
                            "INSERT INTO collabo (idPerso,photo,dateEntree) VALUES (?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
            // id personnel
            prepareCollabo.setInt(1, idPerso);
            prepareCollabo.setString(2, obj.getPhoto());
            prepareCollabo.setTimestamp(3,obj.getDateEntree());
            prepareCollabo.executeUpdate();
            // récupération des valeurs de l'insert
            rs = prepareCollabo.getGeneratedKeys();
            rs.next();
            int idCollabo = rs.getInt(1);


            // insertion de l'identifiant
            Identifiant identifiant = obj.getIdentifiant();
            PreparedStatement prepareIdentifiant =
                    this.connect.prepareStatement(
                            "INSERT INTO identifiant (empreinte) VALUES (?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
            prepareIdentifiant.setString(1, identifiant.getEmpreinte());
            prepareIdentifiant.executeUpdate();
            // récupération des valeurs de l'insert
            rs = prepareIdentifiant.getGeneratedKeys();
            rs.next();
            int idIdentifiant = rs.getInt(1);

            // liaison identifiant -- collabo
            PreparedStatement prepareLiaison =
                    this.connect.prepareStatement(
                            "INSERT INTO collabo_has_identifiant (idCollabo,idIdentifiant) VALUES (?,?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
            prepareLiaison.setInt(1, idCollabo);
            prepareLiaison.setInt(2, idIdentifiant);
            prepareLiaison.executeUpdate();
            // récupération des valeurs de l'insert
            rs = prepareLiaison.getGeneratedKeys();
            rs.next();

            return find(idCollabo);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Collaborateur update(Collaborateur obj) {
        return null;
    }

    @Override
    public void delete(Collaborateur obj) {

    }
}
