package GestAcces;

/**
 * Holder class for : ServeurLog
 * 
 * @author OpenORB Compiler
 */
final public class ServeurLogHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ServeurLog value
     */
    public GestAcces.ServeurLog value;

    /**
     * Default constructor
     */
    public ServeurLogHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ServeurLogHolder(GestAcces.ServeurLog initial)
    {
        value = initial;
    }

    /**
     * Read ServeurLog from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ServeurLogHelper.read(istream);
    }

    /**
     * Write ServeurLog into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ServeurLogHelper.write(ostream,value);
    }

    /**
     * Return the ServeurLog TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ServeurLogHelper.type();
    }

}
