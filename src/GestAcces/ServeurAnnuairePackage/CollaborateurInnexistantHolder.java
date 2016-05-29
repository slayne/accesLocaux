package GestAcces.ServeurAnnuairePackage;

/**
 * Holder class for : CollaborateurInnexistant
 * 
 * @author OpenORB Compiler
 */
final public class CollaborateurInnexistantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal CollaborateurInnexistant value
     */
    public GestAcces.ServeurAnnuairePackage.CollaborateurInnexistant value;

    /**
     * Default constructor
     */
    public CollaborateurInnexistantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CollaborateurInnexistantHolder(GestAcces.ServeurAnnuairePackage.CollaborateurInnexistant initial)
    {
        value = initial;
    }

    /**
     * Read CollaborateurInnexistant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CollaborateurInnexistantHelper.read(istream);
    }

    /**
     * Write CollaborateurInnexistant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CollaborateurInnexistantHelper.write(ostream,value);
    }

    /**
     * Return the CollaborateurInnexistant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CollaborateurInnexistantHelper.type();
    }

}
