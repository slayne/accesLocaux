package GestAcces;

/** 
 * Helper class for : ServeurAcces
 *  
 * @author OpenORB Compiler
 */ 
public class ServeurAccesHelper
{
    /**
     * Insert ServeurAcces into an any
     * @param a an any
     * @param t ServeurAcces value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.ServeurAcces t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ServeurAcces from an any
     * @param a an any
     * @return the extracted ServeurAcces value
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
     * Return the ServeurAcces TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"ServeurAcces");
        }
        return _tc;
    }

    /**
     * Return the ServeurAcces IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/ServeurAcces:1.0";

    /**
     * Read ServeurAcces from a marshalled stream
     * @param istream the input stream
     * @return the readed ServeurAcces value
     */
    public static GestAcces.ServeurAcces read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestAcces.ServeurAcces)istream.read_Object(GestAcces._ServeurAccesStub.class);
    }

    /**
     * Write ServeurAcces into a marshalled stream
     * @param ostream the output stream
     * @param value ServeurAcces value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.ServeurAcces value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ServeurAcces
     * @param obj the CORBA Object
     * @return ServeurAcces Object
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
     * Unchecked Narrow CORBA::Object to ServeurAcces
     * @param obj the CORBA Object
     * @return ServeurAcces Object
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
