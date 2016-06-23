package GestAcces;

/**
 * Holder class for : AccesCorba
 * 
 * @author OpenORB Compiler
 */
final public class AccesCorbaHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AccesCorba value
     */
    public GestAcces.AccesCorba value;

    /**
     * Default constructor
     */
    public AccesCorbaHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AccesCorbaHolder(GestAcces.AccesCorba initial)
    {
        value = initial;
    }

    /**
     * Read AccesCorba from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AccesCorbaHelper.read(istream);
    }

    /**
     * Write AccesCorba into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AccesCorbaHelper.write(ostream,value);
    }

    /**
     * Return the AccesCorba TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AccesCorbaHelper.type();
    }

}
