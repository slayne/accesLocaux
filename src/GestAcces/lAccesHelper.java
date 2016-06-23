package GestAcces;

/** 
 * Helper class for : lAcces
 *  
 * @author OpenORB Compiler
 */ 
public class lAccesHelper
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
     * Insert lAcces into an any
     * @param a an any
     * @param t lAcces value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.AccesCorba[] t)
    {
        a.insert_Streamable(new GestAcces.lAccesHolder(t));
    }

    /**
     * Extract lAcces from an any
     * @param a an any
     * @return the extracted lAcces value
     */
    public static GestAcces.AccesCorba[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestAcces.lAccesHolder)
                    return ((GestAcces.lAccesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestAcces.lAccesHolder h = new GestAcces.lAccesHolder(read(a.create_input_stream()));
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
     * Return the lAcces TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"lAcces",orb.create_sequence_tc(0,GestAcces.AccesCorbaHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the lAcces IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/lAcces:1.0";

    /**
     * Read lAcces from a marshalled stream
     * @param istream the input stream
     * @return the readed lAcces value
     */
    public static GestAcces.AccesCorba[] read(org.omg.CORBA.portable.InputStream istream)
    {
        GestAcces.AccesCorba[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new GestAcces.AccesCorba[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = GestAcces.AccesCorbaHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write lAcces into a marshalled stream
     * @param ostream the output stream
     * @param value lAcces value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.AccesCorba[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            GestAcces.AccesCorbaHelper.write(ostream,value[i7]);

        }
    }

}
