package GestAcces;

/**
 * Holder class for : Jour
 * 
 * @author OpenORB Compiler
 */
final public class JourHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Jour value
     */
    public GestAcces.Jour value;

    /**
     * Default constructor
     */
    public JourHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public JourHolder(GestAcces.Jour initial)
    {
        value = initial;
    }

    /**
     * Read Jour from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = JourHelper.read(istream);
    }

    /**
     * Write Jour into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        JourHelper.write(ostream,value);
    }

    /**
     * Return the Jour TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return JourHelper.type();
    }

}
