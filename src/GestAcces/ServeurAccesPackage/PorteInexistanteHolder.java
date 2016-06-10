package GestAcces.ServeurAccesPackage;

/**
 * Holder class for : PorteInexistante
 * 
 * @author OpenORB Compiler
 */
final public class PorteInexistanteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal PorteInexistante value
     */
    public GestAcces.ServeurAccesPackage.PorteInexistante value;

    /**
     * Default constructor
     */
    public PorteInexistanteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public PorteInexistanteHolder(GestAcces.ServeurAccesPackage.PorteInexistante initial)
    {
        value = initial;
    }

    /**
     * Read PorteInexistante from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = PorteInexistanteHelper.read(istream);
    }

    /**
     * Write PorteInexistante into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        PorteInexistanteHelper.write(ostream,value);
    }

    /**
     * Return the PorteInexistante TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return PorteInexistanteHelper.type();
    }

}
