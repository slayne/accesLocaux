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
     * Operation afficherLog
     */
    public void afficherLog();

    /**
     * Operation afficherLogd
     */
    public void afficherLogd(short date);

    /**
     * Operation afficherLogdf
     */
    public void afficherLogdf(short dated, short datef);

}
