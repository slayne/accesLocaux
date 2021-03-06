package bdd.objetDao;

import GestAcces.*;
import GestAcces.Date;
import bdd.DAO;
import bdd.connectionJDBC.ConnectionBDD;
import bdd.objetsMetier.personnel.Collaborateur;
import bdd.objetsMetier.personnel.collabos.CollaborateurPermanent;
import bdd.objetsMetier.personnel.collabos.CollaborateurTemporaire;
import utils.AccesUtils;

import java.sql.*;
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
                                                                result.getTimestamp("datef"));
                }else{
                    collaborateur = new CollaborateurPermanent(result.getString("nom"),
                            result.getString("photo"),
                            result.getTimestamp("dateentree"),
                            null);
                }


                collaborateur.setIdbd(result.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborateur;
    }

    public CollaborateurCorba findCorba(String p, AccesCorba[] a) {
        CollaborateurCorba collaborateur = null;
        try {
            ResultSet result = this .connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "select * from collaborateur where collaborateur.photo='"+p+"';"
                    );
            if(result.first()) {

                    //gestion date fin
                    Date df=new Date(new Jour((short)0,(short)0,(short)0),(short)0,(short)0);
                    if( result.getBoolean("istemp")){
                         df= AccesUtils.timestampToCorbaDate(result.getTimestamp("datef"));
                    }

                    collaborateur = new CollaborateurCorba(result.getShort(1),result.getString("nom"),
                            result.getString("photo"),
                            AccesUtils.timestampToCorbaDate(result.getTimestamp("dateentree")),
                            "null",
                            result.getBoolean("istemp"),
                            df,
                            a);
                            //new AccesCorba[]{new AccesCorba((short)1,new Zone((short)1,"re"),(short)0,AccesUtils.timestampToCorbaDate(new Timestamp(System.currentTimeMillis())),AccesUtils.timestampToCorbaDate(new Timestamp(System.currentTimeMillis())),(short)1,(short)2,false)});


                //collaborateur.setId(result.getInt("idCollabo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborateur;
    }

    public CollaborateurCorba findAllCorba(String p, AccesCorba[] a) {
        CollaborateurCorba collaborateur = null;
        try {
            ResultSet result = this .connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "select * from collaborateur where collaborateur.photo='"+p+"';"
                    );
            if(result.first()) {

                //gestion date fin
                Date df=new Date(new Jour((short)0,(short)0,(short)0),(short)0,(short)0);
                if( result.getBoolean("istemp")){
                    df= AccesUtils.timestampToCorbaDate(result.getTimestamp("datef"));
                }

                collaborateur = new CollaborateurCorba(result.getShort(1),result.getString("nom"),
                        result.getString("photo"),
                        AccesUtils.timestampToCorbaDate(result.getTimestamp("dateentree")),
                        "null",
                        result.getBoolean("istemp"),
                        df,
                        a);
                //new AccesCorba[]{new AccesCorba((short)1,new Zone((short)1,"re"),(short)0,AccesUtils.timestampToCorbaDate(new Timestamp(System.currentTimeMillis())),AccesUtils.timestampToCorbaDate(new Timestamp(System.currentTimeMillis())),(short)1,(short)2,false)});
                System.out.println("ss");


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
                            "select * from collaborateur where photo='"+photo+"';"
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
                            result.getTimestamp("datef"));
                }else{
                    collaborateur = new CollaborateurPermanent(result.getString("nom"),
                            result.getString("photo"),
                            result.getTimestamp("dateentree"),
                            null);
                }


                collaborateur.setIdbd(result.getInt("id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return collaborateur;
    }
    public boolean isTemp(String photo) {
        Boolean res=false;
        System.out.println("temp?");

        try {
            ResultSet result = this .connect
                    .createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    ).executeQuery(
                            "SELECT * FROM collaborateur WHERE photo=\'"+photo+"\';"
                    );
            if(result.first()) {
                System.out.println("ttest");
                res = result.getBoolean("istemp");
            }

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
                    Collaborateur co = find(idColl);
                    co.setIdbd(idColl);

            return co;
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
