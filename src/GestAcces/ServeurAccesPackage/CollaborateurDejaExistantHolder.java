package GestAcces.ServeurAccesPackage;

/**
 * Holder class for : CollaborateurDejaExistant
 * 
 * @author OpenORB Compiler
 */
final public class CollaborateurDejaExistantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal CollaborateurDejaExistant value
     */
    public GestAcces.ServeurAccesPackage.CollaborateurDejaExistant value;

    /**
     * Default constructor
     */
    public CollaborateurDejaExistantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CollaborateurDejaExistantHolder(GestAcces.ServeurAccesPackage.CollaborateurDejaExistant initial)
    {
        value = initial;
    }

    /**
     * Read CollaborateurDejaExistant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CollaborateurDejaExistantHelper.read(istream);
    }

    /**
     * Write CollaborateurDejaExistant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CollaborateurDejaExistantHelper.write(ostream,value);
    }

    /**
     * Return the CollaborateurDejaExistant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CollaborateurDejaExistantHelper.type();
    }

}
