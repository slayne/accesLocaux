package GestAcces;

/**
 * Holder class for : lLog
 * 
 * @author OpenORB Compiler
 */
final public class lLogHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal lLog value
     */
    public GestAcces.Log[] value;

    /**
     * Default constructor
     */
    public lLogHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public lLogHolder(GestAcces.Log[] initial)
    {
        value = initial;
    }

    /**
     * Read lLog from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = lLogHelper.read(istream);
    }

    /**
     * Write lLog into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        lLogHelper.write(ostream,value);
    }

    /**
     * Return the lLog TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return lLogHelper.type();
    }

}
