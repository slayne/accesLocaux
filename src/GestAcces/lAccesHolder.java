package GestAcces;

/**
 * Holder class for : lAcces
 * 
 * @author OpenORB Compiler
 */
final public class lAccesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal lAcces value
     */
    public GestAcces.AccesCorba[] value;

    /**
     * Default constructor
     */
    public lAccesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public lAccesHolder(GestAcces.AccesCorba[] initial)
    {
        value = initial;
    }

    /**
     * Read lAcces from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = lAccesHelper.read(istream);
    }

    /**
     * Write lAcces into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        lAccesHelper.write(ostream,value);
    }

    /**
     * Return the lAcces TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return lAccesHelper.type();
    }

}
