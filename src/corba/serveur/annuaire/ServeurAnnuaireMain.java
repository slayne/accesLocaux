package corba.serveur.annuaire;

import GestAcces.ServeurEmpreinte;
import GestAcces.ServeurEmpreinteHelper;
import org.omg.CORBA.*;
import org.omg.CORBA.Object;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import utils.AccesUtils;

/**
 * Created by david on 10/06/2016.
 */
public class ServeurAnnuaireMain {

    private static NamingContext nameRoot;
    private static ORB orb;

    public static void main(String[] args) {
        try {
            System.out.println("CE GENRE DE SERVEUR D'Annuaire MAMENE DU SALE");
            // Intialisation de l'ORB
            //************************
            orb = org.omg.CORBA.ORB.init(args, null);

            // Gestion du POA
            //****************
            // Recuperation du POA t
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            // Creation du servant
            //*********************
            ServeurAnnuaireImpl annuaire = new ServeurAnnuaireImpl();

            // Activer le servant au sein du POA et recuperer son ID
            byte[] accesid = rootPOA.activate_object(annuaire);

            // Activer le POA manager
            rootPOA.the_POAManager().activate();


            // Enregistrement dans le service de nommage
            //*******************************************
            // Recuperation du naming service
            nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            //NamingContext nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc://iiop:1.2@130.120.210.149:2001/NameService"));
            // Construction du nom a enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];

            nameToRegister[0] = new org.omg.CosNaming.NameComponent(AccesUtils.ANNUAIRE_SERVER, "");

            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(annuaire));
            System.out.println("==> Nom '" + AccesUtils.ANNUAIRE_SERVER + "' est enregistre dans le service de noms.");

            String IORServant = orb.object_to_string(rootPOA.servant_to_reference(annuaire));
            System.out.println("L'objet possede la reference suivante :");
            System.out.println(IORServant);



            // Construction du nom a rechercher + transfert de la souche myEmpreinte au serveur Annuaire
            NameComponent[] nameToFind = new NameComponent[1];
            nameToFind[0] = new NameComponent(AccesUtils.ANNUAIRE_SERVER,"");
            // Recherche aupres du naming service
            org.omg.CORBA.Object distantAcces = nameRoot.resolve(nameToFind);
            System.out.println("Objet '" + AccesUtils.ANNUAIRE_SERVER + "' trouve aupres du service de noms. IOR de l'objet :");
            System.out.println(orb.object_to_string(distantAcces));

            //recup du serveur empreinte
            AccesUtils.connexionEmpreinte(orb,nameRoot);



            // Lancement de l'ORB et mise en attente de requete
            //**************************************************
            orb.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}// main


