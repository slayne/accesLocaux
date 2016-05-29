package GestAcces;

/** 
 * Helper class for : Jour
 *  
 * @author OpenORB Compiler
 */ 
public class JourHelper
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
     * Insert Jour into an any
     * @param a an any
     * @param t Jour value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.Jour t)
    {
        a.insert_Streamable(new GestAcces.JourHolder(t));
    }

    /**
     * Extract Jour from an any
     * @param a an any
     * @return the extracted Jour value
     */
    public static GestAcces.Jour extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestAcces.JourHolder)
                    return ((GestAcces.JourHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestAcces.JourHolder h = new GestAcces.JourHolder(read(a.create_input_stream()));
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
     * Return the Jour TypeCode
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
                _members[0].name = "annee";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "mois";
                _members[1].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "jour";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _tc = orb.create_struct_tc(id(),"Jour",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Jour IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/Jour:1.0";

    /**
     * Read Jour from a marshalled stream
     * @param istream the input stream
     * @return the readed Jour value
     */
    public static GestAcces.Jour read(org.omg.CORBA.portable.InputStream istream)
    {
        GestAcces.Jour new_one = new GestAcces.Jour();

        new_one.annee = istream.read_short();
        new_one.mois = istream.read_short();
        new_one.jour = istream.read_short();

        return new_one;
    }

    /**
     * Write Jour into a marshalled stream
     * @param ostream the output stream
     * @param value Jour value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.Jour value)
    {
        ostream.write_short(value.annee);
        ostream.write_short(value.mois);
        ostream.write_short(value.jour);
    }

}
