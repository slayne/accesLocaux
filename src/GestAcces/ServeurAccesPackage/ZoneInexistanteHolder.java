package GestAcces.ServeurAccesPackage;

/**
 * Holder class for : ZoneInexistante
 * 
 * @author OpenORB Compiler
 */
final public class ZoneInexistanteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ZoneInexistante value
     */
    public GestAcces.ServeurAccesPackage.ZoneInexistante value;

    /**
     * Default constructor
     */
    public ZoneInexistanteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ZoneInexistanteHolder(GestAcces.ServeurAccesPackage.ZoneInexistante initial)
    {
        value = initial;
    }

    /**
     * Read ZoneInexistante from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ZoneInexistanteHelper.read(istream);
    }

    /**
     * Write ZoneInexistante into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ZoneInexistanteHelper.write(ostream,value);
    }

    /**
     * Return the ZoneInexistante TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ZoneInexistanteHelper.type();
    }

}
