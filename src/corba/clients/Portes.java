package corba.clients;

import GestAcces.Zone;
import bdd.objetDao.PorteDAO;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yoan on 11/06/16.
 */
public class Portes {

    private static ArrayList<Integer> idPortes;
    private static ArrayList<ClientPorte> portes;
    private static boolean init;

    public static void main(String[] args) {
        initPortes();


    }

    public static HashMap<Integer,ClientPorte> getPortesInZone(Zone z) {
        if (!init) {
            initPortes();
        }

        HashMap<Integer,ClientPorte> portesInZone = new HashMap<>();

        for (ClientPorte p : portes) {
            System.out.println(p.getIdPorte() + " / " + z.idZone + " / " + p.hasZone(z));
            if (p.hasZone(z)) portesInZone.put(p.getIdPorte(),p);
        }

        return portesInZone;
    }

    private static void initPortes() {
        portes = new ArrayList<>();
        idPortes = (new PorteDAO()).getInstances();
        for (int i : idPortes) {
            portes.add(new ClientPorte(i));
        }

        init = true;
    }




}
