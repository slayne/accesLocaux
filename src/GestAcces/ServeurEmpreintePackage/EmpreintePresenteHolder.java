package GestAcces.ServeurEmpreintePackage;

/**
 * Holder class for : EmpreintePresente
 * 
 * @author OpenORB Compiler
 */
final public class EmpreintePresenteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EmpreintePresente value
     */
    public GestAcces.ServeurEmpreintePackage.EmpreintePresente value;

    /**
     * Default constructor
     */
    public EmpreintePresenteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EmpreintePresenteHolder(GestAcces.ServeurEmpreintePackage.EmpreintePresente initial)
    {
        value = initial;
    }

    /**
     * Read EmpreintePresente from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EmpreintePresenteHelper.read(istream);
    }

    /**
     * Write EmpreintePresente into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EmpreintePresenteHelper.write(ostream,value);
    }

    /**
     * Return the EmpreintePresente TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EmpreintePresenteHelper.type();
    }

}
