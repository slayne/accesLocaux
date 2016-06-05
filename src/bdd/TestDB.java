package bdd;

import bdd.objetDao.CollaborateurDAO;
import bdd.objetsMetier.Identifiant;
import bdd.objetsMetier.personnel.Collaborateur;

import java.sql.Timestamp;


/**
 * Created by Stéfan on 09/11/2015.
 */
public class TestDB {
    public static void main(String[] args)  {
        Collaborateur test = new Collaborateur("Jean","Reno","11 rue de rome","statut","jreno","mdp", "photo",new Timestamp(System.currentTimeMillis()),new Identifiant("empreinte1"));
        CollaborateurDAO dao = new CollaborateurDAO();
        dao.create(test);
    }
}
