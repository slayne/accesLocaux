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
    public CollaborateurDAO() {
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
                            "select * from collaborateur where collaborateur.id="+id+";"
                    );
            if(result.first()) {
               /* Identifiant identifiant = new Identifiant(
                        result.getString("empreinte")
                );*/

                if(result.getBoolean("istemp") == true){
                    collaborateur = new CollaborateurTemporaire(result.getString("nom"),
                                                                result.getString("photo"),
                                                                result.getTimestamp("dateentree"),
                                                                null,
                                                                result.getTimestamp("datefin"));
                }else{
                    collaborateur = new CollaborateurPermanent(result.getString("nom"),
                            result.getString("photo"),
                            result.getTimestamp("dateentree"),
                            null);
                }


                //collaborateur.setId(result.getInt("idCollabo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborateur;
    }

    public Collaborateur find(String photo) {
        Collaborateur collaborateur = null;
        try {
            ResultSet result = this .connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "select * from collaborateur where collaborateur.photo="+photo+";"
                    );
            if(result.first()) {
               /* Identifiant identifiant = new Identifiant(
                        result.getString("empreinte")
                );*/

                if(result.getBoolean("istemp") == true){
                    collaborateur = new CollaborateurTemporaire(result.getString("nom"),
                            result.getString("photo"),
                            result.getTimestamp("dateentree"),
                            null,
                            result.getTimestamp("datefin"));
                }else{
                    collaborateur = new CollaborateurPermanent(result.getString("nom"),
                            result.getString("photo"),
                            result.getTimestamp("dateentree"),
                            null);
                }


                //collaborateur.setId(result.getInt("idCollabo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborateur;
    }
    public boolean isTemp(String photo) {
        Boolean res=false;
        try {
            ResultSet result = this .connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "select istemp from collaborateur where collaborateur.photo="+photo+";"
                    );
            res= result.getBoolean("istemp");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
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


        try {

            if(obj instanceof CollaborateurTemporaire){
                this.connect
                        .createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE
                        ).executeUpdate(
                        "UPDATE collaborateur SET nom ='"+obj.getNom()+"' ," +
                                "photo='"+obj.getPhoto()+"'," +
                                "dateentree='"+obj.getDateEntree()+"'," +
                                "datef = '" + ((CollaborateurTemporaire)obj).getDateSortiePrevue() + "' "+
                                " WHERE id = " + obj.getIdbd()
                );
            }else{
                this.connect
                        .createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE
                        ).executeUpdate(
                        "UPDATE collaborateur SET nom ='"+obj.getNom()+"' ," +
                                "photo='"+obj.getPhoto()+"'," +
                                "dateentree='"+obj.getDateEntree()+
                                " WHERE id = " + obj.getIdbd()
                );
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return find(obj.getIdbd());

    }

    @Override
    public void delete(Collaborateur obj) {
        try {
            this.connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    "DELETE FROM collaborateur WHERE id = " + obj.getIdbd()
            );
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
