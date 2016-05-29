package GestAcces.ServeurEmpreintePackage;

/**
 * Holder class for : EmpreinteInexistante
 * 
 * @author OpenORB Compiler
 */
final public class EmpreinteInexistanteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EmpreinteInexistante value
     */
    public GestAcces.ServeurEmpreintePackage.EmpreinteInexistante value;

    /**
     * Default constructor
     */
    public EmpreinteInexistanteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EmpreinteInexistanteHolder(GestAcces.ServeurEmpreintePackage.EmpreinteInexistante initial)
    {
        value = initial;
    }

    /**
     * Read EmpreinteInexistante from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EmpreinteInexistanteHelper.read(istream);
    }

    /**
     * Write EmpreinteInexistante into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EmpreinteInexistanteHelper.write(ostream,value);
    }

    /**
     * Return the EmpreinteInexistante TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EmpreinteInexistanteHelper.type();
    }

}
