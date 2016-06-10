package bdd.objetDao;

import bdd.DAO;
import bdd.connectionJDBC.ConnectionBDD;
import bdd.objetsMetier.personnel.Collaborateur;
import bdd.objetsMetier.personnel.collabos.CollaborateurPermanent;
import bdd.objetsMetier.personnel.collabos.CollaborateurTemporaire;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by yoan on 29/05/16.
 */

public class CollaborateurDAO extends DAO<Collaborateur> {
    public CollaborateurDAO(String url) {
        super(ConnectionBDD.url_annuaire);
    }

    @Override
    public ArrayList<Collaborateur> getInstances() {
        ArrayList<Collaborateur> collaborateurs = new ArrayList<Collaborateur>();
        try {

            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE).executeQuery(
                    "SELECT * FROM collaborateur");
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
                            "select * from collaborateur,empreinte where collaborateur.idcollabo=empreinte.idcollaborateur" +
                                    "and collaborateur.idcollabo="+id+";"
                    );
            if(result.first()) {
               /* Identifiant identifiant = new Identifiant(
                        result.getString("empreinte")
                );*/

                if(result.getBoolean("istemp") == true){
                    collaborateur = new CollaborateurTemporaire(result.getString("nom"),
                                                                result.getString("photo"),
                                                                result.getTimestamp("dateentree"),
                                                                result.getString("empreinte"),
                                                                result.getTimestamp("datefin"));
                }else{
                    collaborateur = new CollaborateurPermanent(result.getString("nom"),
                            result.getString("photo"),
                            result.getTimestamp("dateentree"),
                            result.getString("empreinte"));
                }


                //collaborateur.setId(result.getInt("idCollabo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborateur;
    }

    @Override
    public Collaborateur create(Collaborateur obj) {
        try {
            // insertion du collabo
            PreparedStatement prepare =
                    this.connect.prepareStatement(
                            "INSERT INTO collaborateur (nom,photo,dateentree,istemp,datef) VALUES (?, ?, ?, ?,?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
                    prepare.setString(1, obj.getNom());
                    prepare.setString(2, obj.getPhoto());
                    prepare.setTimestamp(3, obj.getDateEntree());
                    if(obj instanceof CollaborateurTemporaire){
                        prepare.setBoolean(4,true);
                        prepare.setTimestamp(5, ((CollaborateurTemporaire) obj).getDateSortiePrevue());

                    }else{
                        prepare.setBoolean(4,false);
                        prepare.setTimestamp(5,null);
                    }

                    prepare.executeUpdate();
                    // récupération des valeurs de l'insert
                    ResultSet rs = prepare.getGeneratedKeys();
                    rs.next();
                    int idColl = rs.getInt(1);
                    obj.setIdbd(idColl);

            return find(idColl);
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
