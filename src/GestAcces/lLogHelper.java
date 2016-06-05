package GestAcces;

/** 
 * Helper class for : lLog
 *  
 * @author OpenORB Compiler
 */ 
public class lLogHelper
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
     * Insert lLog into an any
     * @param a an any
     * @param t lLog value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.Log[] t)
    {
        a.insert_Streamable(new GestAcces.lLogHolder(t));
    }

    /**
     * Extract lLog from an any
     * @param a an any
     * @return the extracted lLog value
     */
    public static GestAcces.Log[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestAcces.lLogHolder)
                    return ((GestAcces.lLogHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestAcces.lLogHolder h = new GestAcces.lLogHolder(read(a.create_input_stream()));
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
     * Return the lLog TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"lLog",orb.create_sequence_tc(0,GestAcces.LogHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the lLog IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/lLog:1.0";

    /**
     * Read lLog from a marshalled stream
     * @param istream the input stream
     * @return the readed lLog value
     */
    public static GestAcces.Log[] read(org.omg.CORBA.portable.InputStream istream)
    {
        GestAcces.Log[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new GestAcces.Log[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = GestAcces.LogHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write lLog into a marshalled stream
     * @param ostream the output stream
     * @param value lLog value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.Log[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            GestAcces.LogHelper.write(ostream,value[i7]);

        }
    }

}
