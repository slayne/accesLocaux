package GestAcces;

/** 
 * Helper class for : lZone
 *  
 * @author OpenORB Compiler
 */ 
public class lZoneHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert lZone into an any
     * @param a an any
     * @param t lZone value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.Zone[] t)
    {
        a.insert_Streamable(new GestAcces.lZoneHolder(t));
    }

    /**
     * Extract lZone from an any
     * @param a an any
     * @return the extracted lZone value
     */
    public static GestAcces.Zone[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestAcces.lZoneHolder)
                    return ((GestAcces.lZoneHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestAcces.lZoneHolder h = new GestAcces.lZoneHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the lZone TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"lZone",orb.create_sequence_tc(0,GestAcces.ZoneHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the lZone IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/lZone:1.0";

    /**
     * Read lZone from a marshalled stream
     * @param istream the input stream
     * @return the readed lZone value
     */
    public static GestAcces.Zone[] read(org.omg.CORBA.portable.InputStream istream)
    {
        GestAcces.Zone[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new GestAcces.Zone[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = GestAcces.ZoneHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write lZone into a marshalled stream
     * @param ostream the output stream
     * @param value lZone value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.Zone[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            GestAcces.ZoneHelper.write(ostream,value[i7]);

        }
    }

}
