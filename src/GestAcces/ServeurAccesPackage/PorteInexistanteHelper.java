package GestAcces.ServeurAccesPackage;

/** 
 * Helper class for : PorteInexistante
 *  
 * @author OpenORB Compiler
 */ 
public class PorteInexistanteHelper
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
     * Insert PorteInexistante into an any
     * @param a an any
     * @param t PorteInexistante value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.ServeurAccesPackage.PorteInexistante t)
    {
        a.insert_Streamable(new GestAcces.ServeurAccesPackage.PorteInexistanteHolder(t));
    }

    /**
     * Extract PorteInexistante from an any
     * @param a an any
     * @return the extracted PorteInexistante value
     */
    public static GestAcces.ServeurAccesPackage.PorteInexistante extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestAcces.ServeurAccesPackage.PorteInexistanteHolder)
                    return ((GestAcces.ServeurAccesPackage.PorteInexistanteHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestAcces.ServeurAccesPackage.PorteInexistanteHolder h = new GestAcces.ServeurAccesPackage.PorteInexistanteHolder(read(a.create_input_stream()));
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
     * Return the PorteInexistante TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[0];

                _tc = orb.create_exception_tc(id(),"PorteInexistante",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the PorteInexistante IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/ServeurAcces/PorteInexistante:1.0";

    /**
     * Read PorteInexistante from a marshalled stream
     * @param istream the input stream
     * @return the readed PorteInexistante value
     */
    public static GestAcces.ServeurAccesPackage.PorteInexistante read(org.omg.CORBA.portable.InputStream istream)
    {
        GestAcces.ServeurAccesPackage.PorteInexistante new_one = new GestAcces.ServeurAccesPackage.PorteInexistante();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();

        return new_one;
    }

    /**
     * Write PorteInexistante into a marshalled stream
     * @param ostream the output stream
     * @param value PorteInexistante value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.ServeurAccesPackage.PorteInexistante value)
    {
        ostream.write_string(id());
    }

}
