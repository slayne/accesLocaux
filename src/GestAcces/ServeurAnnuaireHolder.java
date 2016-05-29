package GestAcces;

/**
 * Holder class for : ServeurAnnuaire
 * 
 * @author OpenORB Compiler
 */
final public class ServeurAnnuaireHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ServeurAnnuaire value
     */
    public GestAcces.ServeurAnnuaire value;

    /**
     * Default constructor
     */
    public ServeurAnnuaireHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ServeurAnnuaireHolder(GestAcces.ServeurAnnuaire initial)
    {
        value = initial;
    }

    /**
     * Read ServeurAnnuaire from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ServeurAnnuaireHelper.read(istream);
    }

    /**
     * Write ServeurAnnuaire into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ServeurAnnuaireHelper.write(ostream,value);
    }

    /**
     * Return the ServeurAnnuaire TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ServeurAnnuaireHelper.type();
    }

}
