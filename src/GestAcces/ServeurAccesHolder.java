package GestAcces;

/**
 * Holder class for : ServeurAcces
 * 
 * @author OpenORB Compiler
 */
final public class ServeurAccesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ServeurAcces value
     */
    public GestAcces.ServeurAcces value;

    /**
     * Default constructor
     */
    public ServeurAccesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ServeurAccesHolder(GestAcces.ServeurAcces initial)
    {
        value = initial;
    }

    /**
     * Read ServeurAcces from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ServeurAccesHelper.read(istream);
    }

    /**
     * Write ServeurAcces into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ServeurAccesHelper.write(ostream,value);
    }

    /**
     * Return the ServeurAcces TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ServeurAccesHelper.type();
    }

}
