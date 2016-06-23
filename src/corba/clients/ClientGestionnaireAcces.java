package corba.clients;

import GestAcces.*;
import GestAcces.ServeurAccesPackage.CollaborateurInexistant;
import GestAcces.ServeurAccesPackage.ZoneInexistante;
import bdd.objetsMetier.personnel.Collaborateur;
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
public class ClientGestionnaireAcces {
    public static ServeurAcces acces;
    public static ServeurAnnuaire annuaire;
    public static ServeurLog log;
    public static ORB orb;
    private static Scanner reader;  // Reading from System.in
    private static NamingContext nameRoot;


    public static void main(String args[]) {
        try {
            // Intialisation de l'orb
            orb = ORB.init(args, null);
            try {
                nameRoot =
                        NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            } catch (InvalidName invalidName) {
                invalidName.printStackTrace();
            }

            acces = AccesUtils.connexionAcces(orb, nameRoot);
            log = AccesUtils.connexionLog(orb, nameRoot);
            annuaire = AccesUtils.connexionAnnuaire(orb, nameRoot);

            gererCollabos();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void gererCollabos() {
        System.out.println("Gestion des accès collabos");

        boolean userInput = true;
        while (userInput) {
            System.out.print(" -> que voulez vous faire ?");
            System.out.println("--- 0 : quitter");
            System.out.println("--- 1 : gérer un collabo");
            reader = new Scanner(System.in);  // Reading from System.in
            int n = reader.nextInt(); // Scans the next token of the input as an int.
            switch (n) {
                case 0:
                    userInput = false;
                    break;
                case 1:
                    System.out.println("Collabos présents : ");
                    CollaborateurCorba[] collabos = annuaire.rechercherCollaborateurs();

                    for (CollaborateurCorba c : collabos) {
                        System.out.println("Collabo n° " + c.id + " - " + getType(c.isTemp) + " : " + c.nom);
                    }

                    System.out.println("Tapez l'ID d'un collabo : ");
                    int collabo = reader.nextInt(); // Scans the next token of the input as an int.
                    gererCollabo(collabo, collabos);
                    break;
                default:
                    break;
            }
        }
    }

    private static void gererCollabo(int cId, CollaborateurCorba[] collabos) {
        CollaborateurCorba collabo = null;
        for (CollaborateurCorba c : collabos) {
            if (c.id == (short) cId) {
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
            default:
                break;
        }
    }

    private static void ajouterAcces(CollaborateurCorba collabo) {
        System.out.println("Zones disponibles : ");
        for (Zone z : acces.getListeZone()) {
            System.out.println(" - n°" + z.idZone + " : " + z.nomZone);
        }

        System.out.println("Ajout de l'accès " + getType(collabo.isTemp) + ":");

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
                        new Jour((short) aA, (short) mA, (short) jA),
                        new Jour((short) aE, (short) mE, (short) jE),
                        (short) hD,
                        (short) hF,
                        (short) idZ);
                log.envoyerLog("Serveur Accès : ajout accès temporaire vers zone" + idZ + " pour " + collabo.nom);
            } catch (ZoneInexistante zoneInexistante) {
                log.envoyerLog("Serveur Accès : ajout accès temporaire vers zone" + idZ + " pour " + collabo.nom + "échoué : zone inexistante");
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
                acces.ajoutPerm(collabo.id, (short) hD, (short) hF, (short) idZ);
                log.envoyerLog("Serveur Accès : ajout accès permanent vers zone" + idZ + " pour " + collabo.nom);
            } catch (ZoneInexistante zoneInexistante) {
                log.envoyerLog("Serveur Accès : ajout accès permanent vers zone" + idZ + " pour " + collabo.nom + "échoué : zone inexistante");
            }
        }
    }


    public static void supprimerAcces(CollaborateurCorba c) {
        System.out.println("Liste des accès : ");

        for (AccesCorba a : acces.getAccesCollaborateur(c.id)) {
            System.out.print(" - n°"+a.idAcces + " : " + " acces" + getType(a.isTemp) + " " + a.heureDebut + "h - " + a.heureFin + "h ");
            if (a.isTemp) {
                System.out.println(" > du " + AccesUtils.corbaDateToTimeStamp(a.dateDebut).toGMTString() + " au " + AccesUtils.corbaDateToTimeStamp(a.dateDebut).toGMTString());
            } else System.out.println("");
        }

        System.out.println("Quel accès voulez vous supprimer ? ");
        int id = reader.nextInt();
        try {
            acces.supprimerAccesCollaborateur((short)id);
            log.envoyerLog("Serveur accès : suppression accès n°" + id);
        } catch (CollaborateurInexistant collaborateurInexistant) {
            System.out.println("erreur suppression");
        };
    }

    private static String getType(boolean isTemp) {
        return (isTemp ? "temporaire" : "permanent");
    }

}
