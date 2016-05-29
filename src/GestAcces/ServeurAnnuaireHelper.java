package GestAcces;

/** 
 * Helper class for : ServeurAnnuaire
 *  
 * @author OpenORB Compiler
 */ 
public class ServeurAnnuaireHelper
{
    /**
     * Insert ServeurAnnuaire into an any
     * @param a an any
     * @param t ServeurAnnuaire value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.ServeurAnnuaire t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ServeurAnnuaire from an any
     * @param a an any
     * @return the extracted ServeurAnnuaire value
     */
    public static GestAcces.ServeurAnnuaire extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestAcces.ServeurAnnuaireHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the ServeurAnnuaire TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"ServeurAnnuaire");
        }
        return _tc;
    }

    /**
     * Return the ServeurAnnuaire IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/ServeurAnnuaire:1.0";

    /**
     * Read ServeurAnnuaire from a marshalled stream
     * @param istream the input stream
     * @return the readed ServeurAnnuaire value
     */
    public static GestAcces.ServeurAnnuaire read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestAcces.ServeurAnnuaire)istream.read_Object(GestAcces._ServeurAnnuaireStub.class);
    }

    /**
     * Write ServeurAnnuaire into a marshalled stream
     * @param ostream the output stream
     * @param value ServeurAnnuaire value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.ServeurAnnuaire value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ServeurAnnuaire
     * @param obj the CORBA Object
     * @return ServeurAnnuaire Object
     */
    public static ServeurAnnuaire narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServeurAnnuaire)
            return (ServeurAnnuaire)obj;

        if (obj._is_a(id()))
        {
            _ServeurAnnuaireStub stub = new _ServeurAnnuaireStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ServeurAnnuaire
     * @param obj the CORBA Object
     * @return ServeurAnnuaire Object
     */
    public static ServeurAnnuaire unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServeurAnnuaire)
            return (ServeurAnnuaire)obj;

        _ServeurAnnuaireStub stub = new _ServeurAnnuaireStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
