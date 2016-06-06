package GestAcces.ServeurEmpreintePackage;

/**
 * Holder class for : EmpreinteInvalide
 * 
 * @author OpenORB Compiler
 */
final public class EmpreinteInvalideHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EmpreinteInvalide value
     */
    public GestAcces.ServeurEmpreintePackage.EmpreinteInvalide value;

    /**
     * Default constructor
     */
    public EmpreinteInvalideHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EmpreinteInvalideHolder(GestAcces.ServeurEmpreintePackage.EmpreinteInvalide initial)
    {
        value = initial;
    }

    /**
     * Read EmpreinteInvalide from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EmpreinteInvalideHelper.read(istream);
    }

    /**
     * Write EmpreinteInvalide into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EmpreinteInvalideHelper.write(ostream,value);
    }

    /**
     * Return the EmpreinteInvalide TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EmpreinteInvalideHelper.type();
    }

}
