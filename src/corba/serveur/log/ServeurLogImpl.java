package corba.serveur.log;

import GestAcces.Date;
import GestAcces.Jour;
import GestAcces.Log;
import GestAcces.ServeurLogPOA;
import bdd.objetDao.LogDAO;
import utils.AccesUtils;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by yoan on 04/06/16.
 */
public class ServeurLogImpl extends ServeurLogPOA {
    private static LogDAO logDAO = new LogDAO();

    @Override
    public void envoyerLog(String log) {
        System.out.println("Création log :" + log);
        Log l = new Log(AccesUtils.timestampToCorbaDate(
                            new Timestamp(System.currentTimeMillis())), log);
        logDAO.create(l);
    }

    @Override
    public Log[] afficherLogs() {
        ArrayList<Log> logsList = logDAO.getInstances();
        Log[] logs = new Log[logsList.size()];
        logs = logsList.toArray(logs);

        for (Log l: logs) {
            System.out.println(l.log);
        }
        return null;
    }

    @Override
    public Log[] afficherLogsFromDate(Date date) {
        ArrayList<Log> logsList = logDAO.getInstancesFrom(date);
        Log[] logs = new Log[logsList.size()];
        logs = logsList.toArray(logs);

        return logs;
    }

    @Override
    public Log[] afficherLogsfromDateToDate(Date dated, Date datef) {
        ArrayList<Log> logsList = logDAO.getInstancesByDate(dated,datef);
        Log[] logs = new Log[logsList.size()];
        logs = logsList.toArray(logs);

        return logs;
    }
}
