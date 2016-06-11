package corba.clients;

import GestAcces.*;
import GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant;
import GestAcces.ServeurAnnuairePackage.CollaborateurInexistant;
import org.omg.CORBA.ORB;
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
public class ClientRH {
    public static ServeurAnnuaire annuaire;
    public static ORB orb;
    private static Scanner reader;  // Reading from System.in


    public static void main(String args[]) {
        try {
            // Intialisation de l'orb
            orb = ORB.init(args, null);
            connexionAnnuaire();

            gererCollabos();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void gererCollabos() {
        System.out.print("Gestion des comptes collabos");

        boolean userInput = true;
        while (userInput) {
            System.out.println(" -> que voulez vous faire ?");
            System.out.println("--- 0 : quitter");
            System.out.println("--- 1 : ajouter un collabo");
            System.out.println("--- 2 : supprimer un collabo");
            reader = new Scanner(System.in);  // Reading from System.in
            int n = reader.nextInt(); // Scans the next token of the input as an int.
            switch (n) {
                case 0: userInput = false;
                    break;
                case 1:
                    ajouterCollabo();
                    break;
                case 2:
                    System.out.println("Collabos présents : ");
                    CollaborateurCorba[] collabos = annuaire.rechercherCollaborateurs();

                    for (CollaborateurCorba c : collabos) {
                        System.out.println(" - n° " + c.id + " - " + getType(c.isTemp) + " : " + c.nom);
                    }

                    System.out.println("Tapez l'ID d'un collabo : ");
                    int collabo = reader.nextInt(); // Scans the next token of the input as an int.
                    supprimerCollabo(collabo,collabos);
                    break;

                default: break;
            }
        }
    }

    private static void ajouterCollabo() {
        System.out.println("Entrez : ");
        System.out.println("- le nom : ");
        String nom = reader.next();
        System.out.println("- la photo ");
        String photo = reader.next();
        System.out.println("- l'empreinte ");
        String empreinte = reader.next();
        System.out.println("- le type : 1=temporaire, 0=permanent ");
        boolean isTemp = (reader.nextInt() == 1);


        if (isTemp) {
            System.out.println("- l'année d'expiration : ");
            int aE = reader.nextInt();
            System.out.println("- le mois d'expiration : ");
            int mE = reader.nextInt();
            System.out.println("- le jour d'expiration : ");
            int jE = reader.nextInt();
            System.out.println("- l'heure d'expiration : ");
            int hE = reader.nextInt();
            System.out.println("- la minute d'expiration : ");
            int minE = reader.nextInt();

            try {
                annuaire.enregisterCollaborateurTemporaire(nom,photo,empreinte,
                        AccesUtils.timestampToCorbaDate(new Timestamp(System.currentTimeMillis())),
                        new Date(new Jour((short)aE,(short)mE,(short)jE), (short) hE, (short) minE)
                        );
            } catch (CollaborateurDejaExistant collaborateurDejaExistant) {
                System.out.println("Collaborateur déjà existant");
            }
        } else {
            try {
                annuaire.enregisterCollaborateurPermanent(nom,photo,empreinte,AccesUtils.timestampToCorbaDate(new Timestamp(System.currentTimeMillis())));
            } catch (CollaborateurDejaExistant collaborateurDejaExistant) {
                System.out.println("Collaborateur déjà existant");
            }
        }
        System.out.println("collaborateur " + nom + " ajouté");

    }

    private static void supprimerCollabo(int cId, CollaborateurCorba[] collabos) {
        for (CollaborateurCorba c : collabos) {
            if (c.id == (short)cId) {
                try {
                    annuaire.supprimerCollaborateur(c.id);
                } catch (CollaborateurInexistant collaborateurInexistant) {
                    System.out.println("Erreur - Collabo inexistant");
                }
                return;
            }
        }

        System.out.println("Une erreur s'est passée, veuillez réessayer");

    }

    private static String getType(boolean isTemp) {
        return (isTemp ? "temporaire" : "permanent");
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

            annuaire = ServeurAnnuaireHelper.narrow(distantAcces);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
