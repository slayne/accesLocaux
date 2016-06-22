package corba.clients;

import GestAcces.*;
import GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant;
import GestAcces.ServeurAnnuairePackage.CollaborateurInexistant;
import bdd.objetDao.CollaborateurDAO;
import bdd.objetsMetier.Acces;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import utils.AccesUtils;

import java.sql.Timestamp;
import java.util.Scanner;

/**
 * Created by yoan on 11/06/16.
 */
public class TestAnnuaire {
    public static ServeurAnnuaire annuaire;
    public static ServeurLog log;
    public static ORB orb;
    private static NamingContext nameRoot;
    private static Scanner reader;  // Reading from System.in


    public static void main(String args[]) {
        try {
            // Intialisation de l'orb
            orb = ORB.init(args, null);
            // Recuperation du naming service
            try {
                nameRoot =
                        NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            } catch (InvalidName invalidName) {
                invalidName.printStackTrace();
            }
            CollaborateurDAO c= new CollaborateurDAO();
            annuaire = AccesUtils.connexionAnnuaire(orb,nameRoot);
            log = AccesUtils.connexionLog(orb, nameRoot);


            CollaborateurCorba co=annuaire.rechercherCollaborateur("un", "un");
            System.out.println(co.nom);


            CollaborateurCorba[] lc= annuaire.rechercherCollaborateurs();
            System.out.println(lc[0].nom);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
