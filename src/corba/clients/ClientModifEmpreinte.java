package corba.clients;

import GestAcces.*;
import GestAcces.ServeurAccesPackage.CollaborateurInexistant;
import GestAcces.ServeurAccesPackage.ZoneInexistante;
import GestAcces.ServeurEmpreintePackage.EmpreinteInexistante;
import bdd.objetsMetier.Acces;
import com.sun.deploy.util.SessionState;
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

            AccesUtils.connexionEmpreinte(orb,nameRoot);
            AccesUtils.connexionLog(orb,nameRoot);
            AccesUtils.connexionAnnuaire(orb,nameRoot);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifierEmpreinte(String photo, String empreinte) {
        System.out.println("Modification des empreintes");

        int collaboId = 0;

        try {
            collaboId = annuaire.rechercherCollaborateur(photo, empreinte);
        } catch (CollaborateurInexistant e) {
            System.out.println("Identifiants invalides !");
            return;
        }
        reader = new Scanner(System.in);  // Reading from System.in
        boolean userInput = true;
        while (userInput) {
            System.out.print(" -> que voulez vous faire ?");
            System.out.println("--- 0 : quitter");
            System.out.println("--- 1 : modifier mon empreinte");
            int n = reader.nextInt(); // Scans the next token of the input as an int.
            switch (n) {
                case 0: userInput = false;
                    break;
                case 1:
                    System.out.println("Entre votre nouvelle empreinte :");
                    String nouvelleEmpreinte =  reader.next();
                    try {
                        myEmpreinte.modifierEmpreinte((short)collaboId, nouvelleEmpreinte);
                    } catch (EmpreinteInexistante empreinteInexistante) {
                        System.out.println("Empreinte du collaborateur inexistante");
                        return;
                    }
                    System.out.println("Empreinte modifiée");
                    break;
                default: break;
            }
        }
    }

    private static void gererCollabo(int cId, CollaborateurCorba[] collabos) {
        CollaborateurCorba collabo = null;
        for (CollaborateurCorba c : collabos) {
            if (c.id == (short)cId) {
                collabo = c;
                break;
            }
        }

        System.out.println("Collabo " + collabo.nom + " - " + getType(collabo.isTemp));
        System.out.println("que voulez vous faire ?");
        System.out.println("--- 0 : quitter");
        System.out.println("--- 1 : supprimer un accès");
        System.out.println("--- 2 : ajouter un accès");

        int n = reader.nextInt(); // Scans the next token of the input as an int.
        switch (n) {
            case 0:
                break;
            case 1:
                supprimerAcces(collabo);
                break;
            case 2:
                ajouterAcces(collabo);
                break;
            default: break;
        }
    }

    private static void ajouterAcces(CollaborateurCorba collabo) {
        System.out.println("Zones disponibles : ");
        for (Zone z : acces.getListeZone()) {
            System.out.println(" - n°" + z.idZone + " : " + z.nomZone);
        }

        System.out.println("Ajout de l'accès " + getType(collabo.isTemp) +":");

        if (collabo.isTemp) {
            System.out.println("Entrez : ");
            System.out.println("- l'id zone : ");
            int idZ = reader.nextInt();
            System.out.println("- l'heure de début : ");
            int hD = reader.nextInt();
            System.out.println("- l'heure de fin : ");
            int hF = reader.nextInt();
            System.out.println("- l'année d'expiration : ");
            int aE = reader.nextInt();
            System.out.println("- le mois d'expiration : ");
            int mE = reader.nextInt();
            System.out.println("- le jour d'expiration : ");
            int jE = reader.nextInt();
            System.out.println("- l'année d'activation : ");
            int aA = reader.nextInt();
            System.out.println("- le mois d'activation : ");
            int mA = reader.nextInt();
            System.out.println("- le jour d'activation : ");
            int jA = reader.nextInt();


            try {
                acces.ajoutTemp(collabo.id,
                        new Jour((short)aA,(short)mA,(short)jA),
                        new Jour((short)aE,(short)mE,(short)jE),
                        (short) hD,
                        (short) hF,
                        (short) idZ);
            } catch (ZoneInexistante zoneInexistante) {
                System.out.println("Erreur : zone inexistante");
            }

        } else {
            // ajout accès collabo permanent
            System.out.println("Entrez : ");
            System.out.println("- l'id zone : ");
            int idZ = reader.nextInt();
            System.out.println("- l'heure de début : ");
            int hD = reader.nextInt();
            System.out.println("- l'heure de fin : ");
            int hF = reader.nextInt();

            try {
                acces.ajoutPerm(collabo.id,(short)hD,(short)hF,(short)idZ);
            } catch (ZoneInexistante zoneInexistante) {
                System.out.println("Erreur : zone inexistante");
            }
        }
    }


    public static void supprimerAcces(CollaborateurCorba c) {

    }

    private static String getType(boolean isTemp) {
        return (isTemp ? "temporaire" : "permanent");
    }

}
