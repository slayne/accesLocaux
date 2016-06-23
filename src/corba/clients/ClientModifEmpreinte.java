package corba.clients;

import GestAcces.*;
import GestAcces.ServeurAccesPackage.CollaborateurInexistant;
import GestAcces.ServeurAccesPackage.ZoneInexistante;
import GestAcces.ServeurEmpreintePackage.EmpreinteInexistante;
import bdd.objetsMetier.Acces;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import utils.AccesUtils;

import java.util.Scanner;

/**
 * Created by yoan on 11/06/16.
 */
public class ClientModifEmpreinte {
    private ServeurAnnuaire annuaire;
    private ServeurEmpreinte myEmpreinte;
    private ServeurLog log;
    private ORB orb;
    private Scanner reader;  // Reading from System.in
    private NamingContext nameRoot;


    public ClientModifEmpreinte() {
        try {
            // Intialisation de l'orb
            orb = ORB.init(new String[0], null);
            // Recuperation du naming service
            try {
                nameRoot =
                        NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            } catch (InvalidName invalidName) {
                invalidName.printStackTrace();
            }

            myEmpreinte = AccesUtils.connexionEmpreinte(orb, nameRoot);
            log = AccesUtils.connexionLog(orb, nameRoot);
            annuaire = AccesUtils.connexionAnnuaire(orb, nameRoot);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String modifierEmpreinte(String photo, String empreinte) {
        System.out.println("Modification des empreintes");

        int collaboId = 0;

        try {
            CollaborateurCorba co = annuaire.rechercherCollaborateur(photo, empreinte);
            if (co.isTemp) {
                System.out.println("Vous n'avez pas le droit de modifier votre empreinte");
                return null;
            }
            collaboId = co.id;
        } catch (GestAcces.ServeurAnnuairePackage.CollaborateurInexistant collaborateurInexistant) {
            System.out.println("Identifiants invalides !");
            return null;
        }
        String nouvelleEmpreinte = null;
        reader = new Scanner(System.in);  // Reading from System.in
        boolean userInput = true;
        while (userInput) {
            System.out.print(" -> que voulez vous faire ?");
            System.out.println("--- 0 : quitter");
            System.out.println("--- 1 : modifier mon empreinte");
            int n = reader.nextInt(); // Scans the next token of the input as an int.
            switch (n) {
                case 0:
                    userInput = false;
                    break;
                case 1:
                    System.out.println("Entre votre nouvelle empreinte :");
                    nouvelleEmpreinte = reader.next();
                    try {
                        myEmpreinte.modifierEmpreinte((short) collaboId, nouvelleEmpreinte);
                    } catch (EmpreinteInexistante empreinteInexistante) {
                        System.out.println("Empreinte du collaborateur inexistante");
                        return null;
                    }
                    System.out.println("Empreinte modifiée");
                    break;
                default:
                    break;
            }
        }

        return nouvelleEmpreinte;
    }
}
