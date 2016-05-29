package GestAcces;

/**
 * Interface definition : ServeurLog
 * 
 * @author OpenORB Compiler
 */
public abstract class ServeurLogPOA extends org.omg.PortableServer.Servant
        implements ServeurLogOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ServeurLog _this()
    {
        return ServeurLogHelper.narrow(_this_object());
    }

    public ServeurLog _this(org.omg.CORBA.ORB orb)
    {
        return ServeurLogHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:GestAcces/ServeurLog:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("afficherLog")) {
                return _invoke_afficherLog(_is, handler);
        } else if (opName.equals("afficherLogd")) {
                return _invoke_afficherLogd(_is, handler);
        } else if (opName.equals("afficherLogdf")) {
                return _invoke_afficherLogdf(_is, handler);
        } else if (opName.equals("envoyerLog")) {
                return _invoke_envoyerLog(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_envoyerLog(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();

        envoyerLog(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_afficherLog(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        afficherLog();

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_afficherLogd(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        afficherLogd(arg0_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_afficherLogdf(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        short arg1_in = _is.read_short();

        afficherLogdf(arg0_in, arg1_in);

        _output = handler.createReply();

        return _output;
    }

}
