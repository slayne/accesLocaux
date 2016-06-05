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
     * Operation afficherLogFromDate
     */
    public GestAcces.Log afficherLogFromDate(GestAcces.Date date);

    /**
     * Operation afficherLogfromDateToDate
     */
    public GestAcces.Log afficherLogfromDateToDate(GestAcces.Date dated, GestAcces.Date datef);

}
