package corba.clients;


import GestAcces.ServeurAnnuairePackage.CollaborateurInexistant;
import GestAcces.Zone;
import bdd.objetDao.PorteDAO;

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

        Collabo collabo = new Collabo("Photo","empreinte");
        collabo.naviguer();
    }

    public Collabo(String p, String e) {
        photo = p;
        empreinte = e;
        zoneCourante = new Zone((short)2,"Z2");
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
    }

    public void fouillerZoneCourante() {
        portesZone = Portes.getPortesInZone(zoneCourante);

        for (ClientPorte p : portesZone.values()) {
            System.out.println("Porte " + p.getIdPorte() + " : vers zone " + p.getZoneSuivante(zoneCourante).nomZone);
        }
    }

    public void naviguer() {
        fouillerZoneCourante();

        boolean input = true;
        while (input) {
            Scanner reader = new Scanner(System.in);  // Reading from System.in
            System.out.println("Quelle porte voulez vous franchir ? (0 pour quitter)");
            int n = reader.nextInt(); // Scans the next token of the input as an int.
            if (n==0) {
                input = false;
            } else {
                ClientPorte p = portesZone.get(n);

                passerPorte(p, p.getZoneSuivante(zoneCourante));

            }
        }
    }

}
