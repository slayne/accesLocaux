package GestAcces;

/**
 * Holder class for : ServeurEmpreinte
 * 
 * @author OpenORB Compiler
 */
final public class ServeurEmpreinteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ServeurEmpreinte value
     */
    public GestAcces.ServeurEmpreinte value;

    /**
     * Default constructor
     */
    public ServeurEmpreinteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ServeurEmpreinteHolder(GestAcces.ServeurEmpreinte initial)
    {
        value = initial;
    }

    /**
     * Read ServeurEmpreinte from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ServeurEmpreinteHelper.read(istream);
    }

    /**
     * Write ServeurEmpreinte into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ServeurEmpreinteHelper.write(ostream,value);
    }

    /**
     * Return the ServeurEmpreinte TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ServeurEmpreinteHelper.type();
    }

}
