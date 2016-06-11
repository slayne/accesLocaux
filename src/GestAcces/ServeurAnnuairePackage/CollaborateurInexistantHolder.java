package GestAcces.ServeurAnnuairePackage;

/**
 * Holder class for : CollaborateurInexistant
 * 
 * @author OpenORB Compiler
 */
final public class CollaborateurInexistantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal CollaborateurInexistant value
     */
    public GestAcces.ServeurAnnuairePackage.CollaborateurInexistant value;

    /**
     * Default constructor
     */
    public CollaborateurInexistantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CollaborateurInexistantHolder(GestAcces.ServeurAnnuairePackage.CollaborateurInexistant initial)
    {
        value = initial;
    }

    /**
     * Read CollaborateurInexistant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CollaborateurInexistantHelper.read(istream);
    }

    /**
     * Write CollaborateurInexistant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CollaborateurInexistantHelper.write(ostream,value);
    }

    /**
     * Return the CollaborateurInexistant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CollaborateurInexistantHelper.type();
    }

}
