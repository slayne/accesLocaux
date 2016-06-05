package corba.serveur.empreinte;

import GestAcces.ServeurEmpreintePOA;
import GestAcces.ServeurEmpreintePackage.EmpreinteInexistante;
import GestAcces.ServeurEmpreintePackage.EmpreintePresente;

/**
 * Created by yoan on 04/06/16.
 */
public class ServeurEmpreinteImpl extends ServeurEmpreintePOA {
    @Override
    public void enregistrerEmpreinte(String e, short id) throws EmpreintePresente {

    }

    @Override
    public void modifierEmpreinte(String ancienneEmpreinte, String nouvelleEmpreinte) throws EmpreinteInexistante {

    }

    @Override
    public void supprimerEmpreinte(short id) {

    }

    @Override
    public void verifierEmpreinte(String id, String mdp) {

    }
}
