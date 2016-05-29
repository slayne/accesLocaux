package GestAcces;

/** 
 * Helper class for : ServeurEmpreinte
 *  
 * @author OpenORB Compiler
 */ 
public class ServeurEmpreinteHelper
{
    /**
     * Insert ServeurEmpreinte into an any
     * @param a an any
     * @param t ServeurEmpreinte value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.ServeurEmpreinte t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ServeurEmpreinte from an any
     * @param a an any
     * @return the extracted ServeurEmpreinte value
     */
    public static GestAcces.ServeurEmpreinte extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return GestAcces.ServeurEmpreinteHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the ServeurEmpreinte TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"ServeurEmpreinte");
        }
        return _tc;
    }

    /**
     * Return the ServeurEmpreinte IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/ServeurEmpreinte:1.0";

    /**
     * Read ServeurEmpreinte from a marshalled stream
     * @param istream the input stream
     * @return the readed ServeurEmpreinte value
     */
    public static GestAcces.ServeurEmpreinte read(org.omg.CORBA.portable.InputStream istream)
    {
        return(GestAcces.ServeurEmpreinte)istream.read_Object(GestAcces._ServeurEmpreinteStub.class);
    }

    /**
     * Write ServeurEmpreinte into a marshalled stream
     * @param ostream the output stream
     * @param value ServeurEmpreinte value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.ServeurEmpreinte value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ServeurEmpreinte
     * @param obj the CORBA Object
     * @return ServeurEmpreinte Object
     */
    public static ServeurEmpreinte narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServeurEmpreinte)
            return (ServeurEmpreinte)obj;

        if (obj._is_a(id()))
        {
            _ServeurEmpreinteStub stub = new _ServeurEmpreinteStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ServeurEmpreinte
     * @param obj the CORBA Object
     * @return ServeurEmpreinte Object
     */
    public static ServeurEmpreinte unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServeurEmpreinte)
            return (ServeurEmpreinte)obj;

        _ServeurEmpreinteStub stub = new _ServeurEmpreinteStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}
