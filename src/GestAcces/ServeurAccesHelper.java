package GestAcces;

/** 
 * Helper class for : ServeurAcceso
 *  
 * @author OpenORB Compiler
 */ 
public class ServeurAccesHelper
{
    /**
     * Insert ServeurAcceso into an any
     * @param a an any
     * @param t ServeurAcceso value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.ServeurAcces t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ServeurAcceso from an any
     * @param a an any
     * @return the extracted ServeurAcceso value
     */
    public static GestAcces.ServeurAcces extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestAcces.ServeurAccesHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the ServeurAcceso TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"ServeurAcceso");
        }
        return _tc;
    }

    /**
     * Return the ServeurAcceso IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/ServeurAcceso:1.0";

    /**
     * Read ServeurAcceso from a marshalled stream
     * @param istream the input stream
     * @return the readed ServeurAcceso value
     */
    public static GestAcces.ServeurAcces read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestAcces.ServeurAcces)istream.read_Object(GestAcces._ServeurAccesStub.class);
    }

    /**
     * Write ServeurAcceso into a marshalled stream
     * @param ostream the output stream
     * @param value ServeurAcceso value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.ServeurAcces value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ServeurAcceso
     * @param obj the CORBA Object
     * @return ServeurAcceso Object
     */
    public static ServeurAcces narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServeurAcces)
            return (ServeurAcces)obj;

        if (obj._is_a(id()))
        {
            _ServeurAccesStub stub = new _ServeurAccesStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ServeurAcceso
     * @param obj the CORBA Object
     * @return ServeurAcceso Object
     */
    public static ServeurAcces unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServeurAcces)
            return (ServeurAcces)obj;

        _ServeurAccesStub stub = new _ServeurAccesStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
