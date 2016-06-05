package GestAcces.ServeurAccesPackage;

/** 
 * Helper class for : CollaborateurDejaExistant
 *  
 * @author OpenORB Compiler
 */ 
public class CollaborateurDejaExistantHelper
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
     * Insert CollaborateurDejaExistant into an any
     * @param a an any
     * @param t CollaborateurDejaExistant value
     */
    public static void insert(org.omg.CORBA.Any a, GestAcces.ServeurAccesPackage.CollaborateurDejaExistant t)
    {
        a.insert_Streamable(new GestAcces.ServeurAccesPackage.CollaborateurDejaExistantHolder(t));
    }

    /**
     * Extract CollaborateurDejaExistant from an any
     * @param a an any
     * @return the extracted CollaborateurDejaExistant value
     */
    public static GestAcces.ServeurAccesPackage.CollaborateurDejaExistant extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof GestAcces.ServeurAccesPackage.CollaborateurDejaExistantHolder)
                    return ((GestAcces.ServeurAccesPackage.CollaborateurDejaExistantHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            GestAcces.ServeurAccesPackage.CollaborateurDejaExistantHolder h = new GestAcces.ServeurAccesPackage.CollaborateurDejaExistantHolder(read(a.create_input_stream()));
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
     * Return the CollaborateurDejaExistant TypeCode
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

                _tc = orb.create_exception_tc(id(),"CollaborateurDejaExistant",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the CollaborateurDejaExistant IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/ServeurAcces/CollaborateurDejaExistant:1.0";

    /**
     * Read CollaborateurDejaExistant from a marshalled stream
     * @param istream the input stream
     * @return the readed CollaborateurDejaExistant value
     */
    public static GestAcces.ServeurAccesPackage.CollaborateurDejaExistant read(org.omg.CORBA.portable.InputStream istream)
    {
        GestAcces.ServeurAccesPackage.CollaborateurDejaExistant new_one = new GestAcces.ServeurAccesPackage.CollaborateurDejaExistant();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();

        return new_one;
    }

    /**
     * Write CollaborateurDejaExistant into a marshalled stream
     * @param ostream the output stream
     * @param value CollaborateurDejaExistant value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, GestAcces.ServeurAccesPackage.CollaborateurDejaExistant value)
    {
        ostream.write_string(id());
    }

}
