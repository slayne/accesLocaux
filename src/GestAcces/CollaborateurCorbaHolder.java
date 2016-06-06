package GestAcces;

/**
 * Holder class for : CollaborateurCorba
 * 
 * @author OpenORB Compiler
 */
final public class CollaborateurCorbaHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal CollaborateurCorba value
     */
    public GestAcces.CollaborateurCorba value;

    /**
     * Default constructor
     */
    public CollaborateurCorbaHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CollaborateurCorbaHolder(GestAcces.CollaborateurCorba initial)
    {
        value = initial;
    }

    /**
     * Read CollaborateurCorba from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CollaborateurCorbaHelper.read(istream);
    }

    /**
     * Write CollaborateurCorba into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CollaborateurCorbaHelper.write(ostream,value);
    }

    /**
     * Return the CollaborateurCorba TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CollaborateurCorbaHelper.type();
    }

}
