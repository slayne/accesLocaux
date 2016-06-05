package GestAcces;

/** 
 * Helper class for : Date
 *  
 * @author OpenORB Compiler
 */ 
public class DateHelper
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
     * Insert Date into an any
     * @param a an any
     * @param t Date value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.Date t)
    {
        a.insert_Streamable(new GestAcces.DateHolder(t));
    }

    /**
     * Extract Date from an any
     * @param a an any
     * @return the extracted Date value
     */
    public static GestAcces.Date extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestAcces.DateHolder)
                    return ((GestAcces.DateHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestAcces.DateHolder h = new GestAcces.DateHolder(read(a.create_input_stream()));
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
     * Return the Date TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[3];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "j";
                _members[0].type = GestAcces.JourHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "h";
                _members[1].type = GestAcces.HeureHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "m";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _tc = orb.create_struct_tc(id(),"Date",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Date IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/Date:1.0";

    /**
     * Read Date from a marshalled stream
     * @param istream the input stream
     * @return the readed Date value
     */
    public static GestAcces.Date read(org.omg.CORBA.portable.InputStream istream)
    {
        GestAcces.Date new_one = new GestAcces.Date();

        new_one.j = GestAcces.JourHelper.read(istream);
        new_one.h = GestAcces.HeureHelper.read(istream);
        new_one.m = istream.read_short();

        return new_one;
    }

    /**
     * Write Date into a marshalled stream
     * @param ostream the output stream
     * @param value Date value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.Date value)
    {
        GestAcces.JourHelper.write(ostream,value.j);
        GestAcces.HeureHelper.write(ostream,value.h);
        ostream.write_short(value.m);
    }

}
