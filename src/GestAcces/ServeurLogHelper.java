package GestAcces;

/** 
 * Helper class for : ServeurLog
 *  
 * @author OpenORB Compiler
 */ 
public class ServeurLogHelper
{
    /**
     * Insert ServeurLog into an any
     * @param a an any
     * @param t ServeurLog value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.ServeurLog t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ServeurLog from an any
     * @param a an any
     * @return the extracted ServeurLog value
     */
    public static GestAcces.ServeurLog extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestAcces.ServeurLogHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the ServeurLog TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"ServeurLog");
        }
        return _tc;
    }

    /**
     * Return the ServeurLog IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/ServeurLog:1.0";

    /**
     * Read ServeurLog from a marshalled stream
     * @param istream the input stream
     * @return the readed ServeurLog value
     */
    public static GestAcces.ServeurLog read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestAcces.ServeurLog)istream.read_Object(GestAcces._ServeurLogStub.class);
    }

    /**
     * Write ServeurLog into a marshalled stream
     * @param ostream the output stream
     * @param value ServeurLog value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.ServeurLog value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ServeurLog
     * @param obj the CORBA Object
     * @return ServeurLog Object
     */
    public static ServeurLog narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServeurLog)
            return (ServeurLog)obj;

        if (obj._is_a(id()))
        {
            _ServeurLogStub stub = new _ServeurLogStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ServeurLog
     * @param obj the CORBA Object
     * @return ServeurLog Object
     */
    public static ServeurLog unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServeurLog)
            return (ServeurLog)obj;

        _ServeurLogStub stub = new _ServeurLogStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
