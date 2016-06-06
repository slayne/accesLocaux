package bdd;

import GestAcces.Log;
import bdd.objetDao.CollaborateurDAO;
import bdd.objetDao.LogDAO;
import bdd.objetsMetier.Identifiant;
import bdd.objetsMetier.personnel.Collaborateur;

import java.sql.Timestamp;
import java.util.ArrayList;


/**
 * Created by Stéfan on 09/11/2015.
 */
public class TestDB {
    public static void main(String[] args)  {
        LogDAO dao = new LogDAO();
        ArrayList<Log> logsList = dao.getInstances();
        Log[] logs = new Log[logsList.size()];
        System.out.println(logsList.toArray(logs).length + " /" + logsList.size());
        for (Log l: logs) {
            System.out.println(l.log);
        }
    }
}
