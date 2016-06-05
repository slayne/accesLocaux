package corba.serveur.log;

import GestAcces.Date;
import GestAcces.Log;
import GestAcces.ServeurLogPOA;
import bdd.objetDao.LogDAO;

/**
 * Created by yoan on 04/06/16.
 */
public class ServeurLogImpl extends ServeurLogPOA {
    private static LogDAO logDAO = new LogDAO();

    @Override
    public void envoyerLog(String log) {
        Log l = new Log();
        logDAO.create(l);
    }

    @Override
    public Log[] afficherLogs() {
        return (Log[])logDAO.getInstances().toArray();
    }

    @Override
    public Log afficherLogFromDate(Date date) {
        return null;
    }

    @Override
    public Log afficherLogfromDateToDate(Date dated, Date datef) {
        return null;
    }
}
