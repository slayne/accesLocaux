package GestAcces;

/**
 * Holder class for : lZone
 * 
 * @author OpenORB Compiler
 */
final public class lZoneHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal lZone value
     */
    public GestAcces.Zone[] value;

    /**
     * Default constructor
     */
    public lZoneHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public lZoneHolder(GestAcces.Zone[] initial)
    {
        value = initial;
    }

    /**
     * Read lZone from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = lZoneHelper.read(istream);
    }

    /**
     * Write lZone into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        lZoneHelper.write(ostream,value);
    }

    /**
     * Return the lZone TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return lZoneHelper.type();
    }

}
