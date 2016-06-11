package corba.serveur.empreinte;

import GestAcces.ServeurEmpreintePOA;
import GestAcces.ServeurEmpreintePackage.EmpreinteInexistante;
import GestAcces.ServeurEmpreintePackage.EmpreinteInvalide;
import GestAcces.ServeurEmpreintePackage.EmpreintePresente;
import bdd.objetDao.EmpreinteDAO;
import bdd.objetsMetier.Empreinte;

/**
 * Created by yoan on 04/06/16.
 */
public class ServeurEmpreinteImpl extends ServeurEmpreintePOA {
    private static EmpreinteDAO empreinteDAO = new EmpreinteDAO();

    @Override
    public void enregistrerEmpreinte(short idCollaborateur, String empreinte) throws EmpreintePresente {
        Empreinte empreinteCree = empreinteDAO.create(new Empreinte(empreinte,(int)idCollaborateur));
        if (empreinteCree == null) throw new EmpreintePresente();
    }

    @Override
    public void modifierEmpreinte(short idCollaborateur, String nouvelleEmpreinte) throws EmpreinteInexistante {
        Empreinte e = empreinteDAO.find(idCollaborateur);
        if (e == null) throw new EmpreinteInexistante();

        // modification de l'empreinte
        e.empreinte = nouvelleEmpreinte;
        empreinteDAO.update(e);
    }

    @Override
    public void supprimerEmpreinte(short idCollaborateur) throws EmpreinteInexistante{
        Empreinte e = empreinteDAO.find(idCollaborateur);
        if (e == null) throw new EmpreinteInexistante();

        empreinteDAO.delete(e);
    }

    @Override
    /**
     * Vérification de la validité de l'empreinte
     * Note : on passe le string de l'empreinte en paramètre, car l'objet empreinte n'est pas encore crée
     * DSE : Porte --> Serveur RH ---> Serveur Empreinte
     */
    public void verifierEmpreinte(short idCollaborateur, String mdp) throws EmpreinteInvalide{
        Empreinte e = empreinteDAO.find(idCollaborateur);
        System.out.println(e.empreinte);

        if (!e.empreinte.equals(mdp)) throw new EmpreinteInvalide();
    }

    @Override
    public String getEmpreinte(short idCollaborateur) throws EmpreinteInvalide {
        Empreinte e = empreinteDAO.find(idCollaborateur);
        return e.empreinte;
    }

}
