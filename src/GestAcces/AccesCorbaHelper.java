package GestAcces;

/** 
 * Helper class for : AccesCorba
 *  
 * @author OpenORB Compiler
 */ 
public class AccesCorbaHelper
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
     * Insert AccesCorba into an any
     * @param a an any
     * @param t AccesCorba value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.AccesCorba t)
    {
        a.insert_Streamable(new GestAcces.AccesCorbaHolder(t));
    }

    /**
     * Extract AccesCorba from an any
     * @param a an any
     * @return the extracted AccesCorba value
     */
    public static GestAcces.AccesCorba extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestAcces.AccesCorbaHolder)
                    return ((GestAcces.AccesCorbaHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestAcces.AccesCorbaHolder h = new GestAcces.AccesCorbaHolder(read(a.create_input_stream()));
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
     * Return the AccesCorba TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[8];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "idAcces";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "zone";
                _members[1].type = GestAcces.ZoneHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "idCollaborateur";
                _members[2].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "dateDebut";
                _members[3].type = GestAcces.DateHelper.type();
                _members[4] = new org.omg.CORBA.StructMember();
                _members[4].name = "dateFin";
                _members[4].type = GestAcces.DateHelper.type();
                _members[5] = new org.omg.CORBA.StructMember();
                _members[5].name = "heureDebut";
                _members[5].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[6] = new org.omg.CORBA.StructMember();
                _members[6].name = "heureFin";
                _members[6].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short);
                _members[7] = new org.omg.CORBA.StructMember();
                _members[7].name = "isTemp";
                _members[7].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_boolean);
                _tc = orb.create_struct_tc(id(),"AccesCorba",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the AccesCorba IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/AccesCorba:1.0";

    /**
     * Read AccesCorba from a marshalled stream
     * @param istream the input stream
     * @return the readed AccesCorba value
     */
    public static GestAcces.AccesCorba read(org.omg.CORBA.portable.InputStream istream)
    {
        GestAcces.AccesCorba new_one = new GestAcces.AccesCorba();

        new_one.idAcces = istream.read_short();
        new_one.zone = GestAcces.ZoneHelper.read(istream);
        new_one.idCollaborateur = istream.read_short();
        new_one.dateDebut = GestAcces.DateHelper.read(istream);
        new_one.dateFin = GestAcces.DateHelper.read(istream);
        new_one.heureDebut = istream.read_short();
        new_one.heureFin = istream.read_short();
        new_one.isTemp = istream.read_boolean();

        return new_one;
    }

    /**
     * Write AccesCorba into a marshalled stream
     * @param ostream the output stream
     * @param value AccesCorba value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.AccesCorba value)
    {
        ostream.write_short(value.idAcces);
        GestAcces.ZoneHelper.write(ostream,value.zone);
        ostream.write_short(value.idCollaborateur);
        GestAcces.DateHelper.write(ostream,value.dateDebut);
        GestAcces.DateHelper.write(ostream,value.dateFin);
        ostream.write_short(value.heureDebut);
        ostream.write_short(value.heureFin);
        ostream.write_boolean(value.isTemp);
    }

}
