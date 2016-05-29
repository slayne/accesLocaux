package GestAcces;

/** 
 * Helper class for : Heure
 *  
 * @author OpenORB Compiler
 */ 
public class HeureHelper
{
    /**
     * Insert Heure into an any
     * @param a an any
     * @param t Heure value
     */
    public static void insert(org.omg.CORBA.Any a, short t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract Heure from an any
     * @param a an any
     * @return the extracted Heure value
     */
    public static short extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the Heure TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"Heure",orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_short));
        }
        return _tc;
    }

    /**
     * Return the Heure IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:GestAcces/Heure:1.0";

    /**
     * Read Heure from a marshalled stream
     * @param istream the input stream
     * @return the readed Heure value
     */
    public static short read(org.omg.CORBA.portable.InputStream istream)
    {
        short new_one;
        new_one = istream.read_short();

        return new_one;
    }

    /**
     * Write Heure into a marshalled stream
     * @param ostream the output stream
     * @param value Heure value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, short value)
    {
        ostream.write_short(value);
    }

}
