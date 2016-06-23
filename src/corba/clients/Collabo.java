package corba.clients;


import GestAcces.ServeurAnnuairePackage.CollaborateurInexistant;
import GestAcces.Zone;
import bdd.objetDao.CollaborateurDAO;
import bdd.objetDao.EmpreinteDAO;
import bdd.objetsMetier.Empreinte;
import bdd.objetsMetier.personnel.Collaborateur;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by yoan on 10/06/16.
 */
public class Collabo {
    private String photo,empreinte;
    private Zone zoneCourante;
    private HashMap<Integer,ClientPorte> portesZone;

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Choissisez un collabo :");
        CollaborateurDAO c = new CollaborateurDAO();
        EmpreinteDAO e = new EmpreinteDAO();
        for (Collaborateur collabo : c.getInstances()) {
            System.out.println("- n°" + collabo.getIdbd() + " : " + collabo.getNom());
        }
        int id = reader.nextInt();
        Collaborateur choosen = c.find(id);

        Empreinte emp = e.find(id);

        System.out.println("Collaborateur " + choosen.getNom() + " , photo " + choosen.getPhoto() + " / empreinte " + emp.empreinte + " arrivé à l'accueil");

        Collabo collabo = new Collabo(choosen.getPhoto(),emp.empreinte);
        collabo.naviguer();
    }

    public Collabo(String p, String e) {
        photo = p;
        empreinte = e;
        zoneCourante = new Zone((short)1,"Accueil");
    }

    /**
     * Simulation de passage de porte, demande d'accès
     * @param p
     * @param zoneARejoindre
     */
    private void passerPorte(ClientPorte p, Zone zoneARejoindre) {
        System.out.println("Porte " + p.getIdPorte() + " : demande d'accès à la zone" + zoneARejoindre.nomZone);
        boolean hasAcces = false;
        try {
            hasAcces = p.traverser(zoneARejoindre, photo, empreinte);
        } catch (CollaborateurInexistant e) {
            System.out.println("Photo et empreinte incorrectes");
        }

        if (hasAcces) {
            System.out.println("Accès autorisé : vous etes maintenant dans la zone" + zoneARejoindre.nomZone);
            zoneCourante = zoneARejoindre;
        } else {
            System.out.println("Accès interdit");
        }

        portesZone = Entreprise.getPortesInZone(zoneCourante);
        for (ClientPorte po : portesZone.values()) {
            System.out.println("Porte " + po.getIdPorte() + " : vers zone " + po.getZoneSuivante(zoneCourante).nomZone);
        }


    }

    public void fouillerZoneCourante() {
        portesZone = Entreprise.getPortesInZone(zoneCourante);

        for (ClientPorte p : portesZone.values()) {
            System.out.println("Porte " + p.getIdPorte() + " : vers zone " + p.getZoneSuivante(zoneCourante).nomZone);
        }
        if (zoneCourante.idZone ==1) {
            System.out.println("Un modidificateur d'empreinte est disponible près de la machine à café : tapez 99");
        }
    }

    public void naviguer() {
        fouillerZoneCourante();

        boolean input = true;
        while (input) {
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Quel élément voulez vous atteindre ? (0 pour quitter)");
            int n = reader.nextInt(); // Scans the next token of the input as an int.
            if (n==0) {
                input = false;
            } else {
                if ((n==99) && (zoneCourante.idZone ==1)) {
                    String nouvelleEmpreinte =  Entreprise.getModifEmpreinte().modifierEmpreinte(photo,empreinte);
                    empreinte = nouvelleEmpreinte;
                } else {
                    ClientPorte p = portesZone.get(n);
                    passerPorte(p, p.getZoneSuivante(zoneCourante));
                }
            }
        }
    }

}
