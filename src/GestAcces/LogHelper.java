package GestAcces;

/** 
 * Helper class for : Log
 *  
 * @author OpenORB Compiler
 */ 
public class LogHelper
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
     * Insert Log into an any
     * @param a an any
     * @param t Log value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.Log t)
    {
        a.insert_Streamable(new GestAcces.LogHolder(t));
    }

    /**
     * Extract Log from an any
     * @param a an any
     * @return the extracted Log value
     */
    public static GestAcces.Log extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestAcces.LogHolder)
                    return ((GestAcces.LogHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestAcces.LogHolder h = new GestAcces.LogHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the Log TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "date";
                _members[0].type = GestAcces.DateHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "log";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_struct_tc(id(),"Log",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Log IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/Log:1.0";

    /**
     * Read Log from a marshalled stream
     * @param istream the input stream
     * @return the readed Log value
     */
    public static GestAcces.Log read(org.omg.CORBA.portable.InputStream istream)
    {
        GestAcces.Log new_one = new GestAcces.Log();

        new_one.date = GestAcces.DateHelper.read(istream);
        new_one.log = istream.read_string();

        return new_one;
    }

    /**
     * Write Log into a marshalled stream
     * @param ostream the output stream
     * @param value Log value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.Log value)
    {
        GestAcces.DateHelper.write(ostream,value.date);
        ostream.write_string(value.log);
    }

}
