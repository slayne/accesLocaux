package GestAcces;

/**
 * Interface definition : ServeurAcces
 * 
 * @author OpenORB Compiler
 */
public abstract class ServeurAccesPOA extends org.omg.PortableServer.Servant
        implements ServeurAccesOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ServeurAcces _this()
    {
        return ServeurAccesHelper.narrow(_this_object());
    }

    public ServeurAcces _this(org.omg.CORBA.ORB orb)
    {
        return ServeurAccesHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:GestAcces/ServeurAcces:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("ajoutPerm")) {
                return _invoke_ajoutPerm(_is, handler);
        } else if (opName.equals("ajoutTemp")) {
                return _invoke_ajoutTemp(_is, handler);
        } else if (opName.equals("demanderAcces")) {
                return _invoke_demanderAcces(_is, handler);
        } else if (opName.equals("getListeZone")) {
                return _invoke_getListeZone(_is, handler);
        } else if (opName.equals("getZonesPorte")) {
                return _invoke_getZonesPorte(_is, handler);
        } else if (opName.equals("supprimerAcces")) {
                return _invoke_supprimerAcces(_is, handler);
        } else if (opName.equals("verifierAcces")) {
                return _invoke_verifierAcces(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_ajoutPerm(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        short arg1_in = GestAcces.HeureHelper.read(_is);
        short arg2_in = GestAcces.HeureHelper.read(_is);
        short arg3_in = _is.read_short();

        try
        {
            short _arg_result = ajoutPerm(arg0_in, arg1_in, arg2_in, arg3_in);

            _output = handler.createReply();
            _output.write_short(_arg_result);

        }
        catch (GestAcces.ServeurAccesPackage.ZoneInexistante _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurAccesPackage.ZoneInexistanteHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_ajoutTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        GestAcces.Jour arg1_in = GestAcces.JourHelper.read(_is);
        GestAcces.Jour arg2_in = GestAcces.JourHelper.read(_is);
        short arg3_in = GestAcces.HeureHelper.read(_is);
        short arg4_in = GestAcces.HeureHelper.read(_is);
        short arg5_in = _is.read_short();

        try
        {
            short _arg_result = ajoutTemp(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in, arg5_in);

            _output = handler.createReply();
            _output.write_short(_arg_result);

        }
        catch (GestAcces.ServeurAccesPackage.ZoneInexistante _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurAccesPackage.ZoneInexistanteHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_demanderAcces(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();

        short _arg_result = demanderAcces(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_short(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerAcces(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        short arg1_in = _is.read_short();

        try
        {
            supprimerAcces(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (GestAcces.ServeurAccesPackage.CollaborateurInexistant _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurAccesPackage.CollaborateurInexistantHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierAcces(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        short arg1_in = _is.read_short();

        short _arg_result = verifierAcces(arg0_in, arg1_in);

        _output = handler.createReply();
        _output.write_short(_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getListeZone(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        GestAcces.Zone[] _arg_result = getListeZone();

        _output = handler.createReply();
        GestAcces.lZoneHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getZonesPorte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        try
        {
            GestAcces.Zone[] _arg_result = getZonesPorte(arg0_in);

            _output = handler.createReply();
            GestAcces.lZoneHelper.write(_output,_arg_result);

        }
        catch (GestAcces.ServeurAccesPackage.PorteInexistante _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurAccesPackage.PorteInexistanteHelper.write(_output,_exception);
        }
        return _output;
    }

}
