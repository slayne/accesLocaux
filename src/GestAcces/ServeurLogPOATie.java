package GestAcces;

/**
 * Interface definition : ServeurLog
 * 
 * @author OpenORB Compiler
 */
public class ServeurLogPOATie extends ServeurLogPOA
{

    //
    // Private reference to implementation object
    //
    private ServeurLogOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ServeurLogPOATie(ServeurLogOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ServeurLogPOATie(ServeurLogOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ServeurLogOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ServeurLogOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation envoyerLog
     */
    public void envoyerLog(String log)
    {
        _tie.envoyerLog( log);
    }

    /**
     * Operation afficherLogs
     */
    public GestAcces.Log[] afficherLogs()
    {
        return _tie.afficherLogs();
    }

    /**
     * Operation afficherLogsFromDate
     */
    public GestAcces.Log[] afficherLogsFromDate(GestAcces.Date date)
    {
        return _tie.afficherLogsFromDate( date);
    }

    /**
     * Operation afficherLogsfromDateToDate
     */
    public GestAcces.Log[] afficherLogsfromDateToDate(GestAcces.Date dated, GestAcces.Date datef)
    {
        return _tie.afficherLogsfromDateToDate( dated,  datef);
    }

}
