package corba.serveur.acces;

import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import utils.AccesUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServeurAccesMain {

    public static void main(String[] args) {
        try {
            System.out.println("CE GENRE DE SERVEUR D'ACCES MAMENE DU SALE");
            // Intialisation de l'ORB
            //************************
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

            // Gestion du POA
            //****************
            // Recuperation du POA t
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            // Creation du servant
            //*********************
            ServeurAccesImpl acces = new ServeurAccesImpl();

            // Activer le servant au sein du POA et recuperer son ID
            byte[] accesid = rootPOA.activate_object(acces);

            // Activer le POA manager
            rootPOA.the_POAManager().activate();


            // Enregistrement dans le service de nommage
            //*******************************************
            // Recuperation du naming service
            NamingContext nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            //NamingContext nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc://iiop:1.2@130.120.210.149:2001/NameService"));
            // Construction du nom a enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];

            nameToRegister[0] = new org.omg.CosNaming.NameComponent(AccesUtils.ACCES_SERVER,"");

            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(acces));
            System.out.println("==> Nom '"+ AccesUtils.ACCES_SERVER + "' est enregistre dans le service de noms.");

            String IORServant = orb.object_to_string(rootPOA.servant_to_reference(acces));
            System.out.println("L'objet possede la reference suivante :");
            System.out.println(IORServant);

            // Lancement de l'ORB et mise en attente de requete
            //**************************************************
            orb.run();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    } // main

} // class