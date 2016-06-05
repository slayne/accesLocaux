package GestAcces;

/**
 * Struct definition : Log
 * 
 * @author OpenORB Compiler
*/
public final class Log implements org.omg.CORBA.portable.IDLEntity
{
    public int id;
    /**
     * Struct member date
     */
    public GestAcces.Date date;

    /**
     * Struct member log
     */
    public String log;

    /**
     * Default constructor
     */
    public Log()
    { }

    /**
     * Constructor with fields initialization
     * @param date date struct member
     * @param log log struct member
     */
    public Log(GestAcces.Date date, String log)
    {
        this.date = date;
        this.log = log;
    }

}
