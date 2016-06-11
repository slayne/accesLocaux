package GestAcces;

/**
 * Holder class for : lCollabo
 * 
 * @author OpenORB Compiler
 */
final public class lCollaboHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal lCollabo value
     */
    public GestAcces.CollaborateurCorba[] value;

    /**
     * Default constructor
     */
    public lCollaboHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public lCollaboHolder(GestAcces.CollaborateurCorba[] initial)
    {
        value = initial;
    }

    /**
     * Read lCollabo from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = lCollaboHelper.read(istream);
    }

    /**
     * Write lCollabo into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        lCollaboHelper.write(ostream,value);
    }

    /**
     * Return the lCollabo TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return lCollaboHelper.type();
    }

}
