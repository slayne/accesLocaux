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

        if (opName.equals("afficherLogs")) {
                return _invoke_afficherLogs(_is, handler);
        } else if (opName.equals("afficherLogsFromDate")) {
                return _invoke_afficherLogsFromDate(_is, handler);
        } else if (opName.equals("afficherLogsfromDateToDate")) {
                return _invoke_afficherLogsfromDateToDate(_is, handler);
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

    private org.omg.CORBA.portable.OutputStream _invoke_afficherLogs(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        GestAcces.Log[] _arg_result = afficherLogs();

        _output = handler.createReply();
        GestAcces.lLogHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_afficherLogsFromDate(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        GestAcces.Date arg0_in = GestAcces.DateHelper.read(_is);

        GestAcces.Log[] _arg_result = afficherLogsFromDate(arg0_in);

        _output = handler.createReply();
        GestAcces.lLogHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_afficherLogsfromDateToDate(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        GestAcces.Date arg0_in = GestAcces.DateHelper.read(_is);
        GestAcces.Date arg1_in = GestAcces.DateHelper.read(_is);

        GestAcces.Log[] _arg_result = afficherLogsfromDateToDate(arg0_in, arg1_in);

        _output = handler.createReply();
        GestAcces.lLogHelper.write(_output,_arg_result);

        return _output;
    }

}
