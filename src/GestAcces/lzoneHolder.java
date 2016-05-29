package GestAcces;

/**
 * Holder class for : lzone
 * 
 * @author OpenORB Compiler
 */
final public class lzoneHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal lzone value
     */
    public GestAcces.Zone[] value;

    /**
     * Default constructor
     */
    public lzoneHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public lzoneHolder(GestAcces.Zone[] initial)
    {
        value = initial;
    }

    /**
     * Read lzone from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = lzoneHelper.read(istream);
    }

    /**
     * Write lzone into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        lzoneHelper.write(ostream,value);
    }

    /**
     * Return the lzone TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return lzoneHelper.type();
    }

}
