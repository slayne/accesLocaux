package corba.serveur.annuaire;

import GestAcces.ServeurAnnuaire;
import GestAcces.ServeurAnnuaireHelper;
import GestAcces.ServeurEmpreinte;
import GestAcces.ServeurEmpreinteHelper;
import bdd.objetsMetier.Acces;
import corba.clients.Portes;
import corba.serveur.acces.ServeurAccesImpl;
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
            connexionEmpreinte(annuaire);



            // Lancement de l'ORB et mise en attente de requete
            //**************************************************
            orb.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void connexionEmpreinte(ServeurAnnuaireImpl annauire) {
        try {
            String idObj = AccesUtils.EMPREINTE_SERVER;
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
            ServeurEmpreinte myEmpreinte = ServeurEmpreinteHelper.narrow(distantAcces);
            annauire.setServEmpreinte(myEmpreinte);
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}// main


