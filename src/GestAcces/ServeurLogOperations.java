package GestAcces;

/**
 * Interface definition : ServeurLog
 * 
 * @author OpenORB Compiler
 */
public interface ServeurLogOperations
{
    /**
     * Operation envoyerLog
     */
    public void envoyerLog(String log);

    /**
     * Operation afficherLogs
     */
    public GestAcces.Log[] afficherLogs();

    /**
     * Operation afficherLogsFromDate
     */
    public GestAcces.Log[] afficherLogsFromDate(GestAcces.Date date);

    /**
     * Operation afficherLogsfromDateToDate
     */
    public GestAcces.Log[] afficherLogsfromDateToDate(GestAcces.Date dated, GestAcces.Date datef);

}
