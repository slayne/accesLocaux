package corba.clients;

import GestAcces.*;
import GestAcces.ServeurAccesPackage.ZoneInexistante;
import bdd.objetsMetier.personnel.Collaborateur;
import org.omg.CORBA.ORB;
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
    public static ORB orb;
    private static Scanner reader;  // Reading from System.in


    public static void main(String args[]) {
        try {
            // Intialisation de l'orb
             orb = ORB.init(args, null);
            connexionAcces();
            connexionAnnuaire();

            gererCollabos();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void connexionAcces() {
        try {
            String idObj = AccesUtils.ACCES_SERVER;
            // Recuperation du naming service
            NamingContext nameRoot =
                    NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            // Construction du nom a rechercher
            NameComponent[] nameToFind = new NameComponent[1];
            nameToFind[0] = new NameComponent(idObj, "");

            // Recherche aupres du naming service
            Object distantAcces = nameRoot.resolve(nameToFind);
            System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantAcces));

            // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
            // org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001b49444c3a436f6e766572746973736575722f4575726f3a312e30000000000001000000000000008a00010200000000103133302e3132302e3230392e31353500db7f000000000031afabcb0000000020dc306ed400000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002");
            // Casting de l'objet CORBA au type talk
            acces = ServeurAccesHelper.narrow(distantAcces);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void connexionAnnuaire() {
        try {
            String idObj = AccesUtils.ANNUAIRE_SERVER;
            // Recuperation du naming service
            NamingContext nameRoot =
                    NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            // Construction du nom a rechercher
            NameComponent[] nameToFind = new NameComponent[1];
            nameToFind[0] = new NameComponent(idObj, "");

            // Recherche aupres du naming service
            Object distantAcces = nameRoot.resolve(nameToFind);
            System.out.println(orb.object_to_string(distantAcces));

            // Utilisation directe de l'IOR (SAUF utilisation du service de nommage)
            // org.omg.CORBA.Object distantEuro = orb.string_to_object("IOR:000000000000001b49444c3a436f6e766572746973736575722f4575726f3a312e30000000000001000000000000008a00010200000000103133302e3132302e3230392e31353500db7f000000000031afabcb0000000020dc306ed400000001000000000000000100000008526f6f74504f410000000008000000010000000014000000000000020000000100000020000000000001000100000002050100010001002000010109000000010001010000000026000000020002");
            // Casting de l'objet CORBA au type talk
            annuaire = ServeurAnnuaireHelper.narrow(distantAcces);
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
                case 0: userInput = false;
                    break;
                case 1:
                    System.out.println("Collabos présents : ");
                    CollaborateurCorba[] collabos = annuaire.rechercherCollaborateurs();

                    for (CollaborateurCorba c : collabos) {
                        System.out.println("Collabo n° " + c.id + " - " + getType(c.isTemp) + " : " + c.nom);
                    }

                    System.out.println("Tapez l'ID d'un collabo : ");
                    int collabo = reader.nextInt(); // Scans the next token of the input as an int.
                    gererCollabo(collabo,collabos);
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
