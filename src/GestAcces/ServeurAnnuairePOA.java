package GestAcces;

/**
 * Interface definition : ServeurAnnuaire
 * 
 * @author OpenORB Compiler
 */
public abstract class ServeurAnnuairePOA extends org.omg.PortableServer.Servant
        implements ServeurAnnuaireOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ServeurAnnuaire _this()
    {
        return ServeurAnnuaireHelper.narrow(_this_object());
    }

    public ServeurAnnuaire _this(org.omg.CORBA.ORB orb)
    {
        return ServeurAnnuaireHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:GestAcces/ServeurAnnuaire:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("demanderAcces")) {
                return _invoke_demanderAcces(_is, handler);
        } else if (opName.equals("enregisterCollaborateurPermanent")) {
                return _invoke_enregisterCollaborateurPermanent(_is, handler);
        } else if (opName.equals("enregisterCollaborateurTemporaire")) {
                return _invoke_enregisterCollaborateurTemporaire(_is, handler);
        } else if (opName.equals("rechercherCollaborateur")) {
                return _invoke_rechercherCollaborateur(_is, handler);
        } else if (opName.equals("rechercherCollaborateurs")) {
                return _invoke_rechercherCollaborateurs(_is, handler);
        } else if (opName.equals("supprimerCollaborateur")) {
                return _invoke_supprimerCollaborateur(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_demanderAcces(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = _is.read_string();
        short arg2_in = _is.read_short();

        try
        {
            boolean _arg_result = demanderAcces(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (GestAcces.ServeurAnnuairePackage.CollaborateurInexistant _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurAnnuairePackage.CollaborateurInexistantHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregisterCollaborateurPermanent(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = GestAcces.PhotoHelper.read(_is);
        String arg2_in = _is.read_string();
        GestAcces.Date arg3_in = GestAcces.DateHelper.read(_is);

        try
        {
            enregisterCollaborateurPermanent(arg0_in, arg1_in, arg2_in, arg3_in);

            _output = handler.createReply();

        }
        catch (GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistantHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_enregisterCollaborateurTemporaire(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = _is.read_string();
        String arg1_in = GestAcces.PhotoHelper.read(_is);
        String arg2_in = _is.read_string();
        GestAcces.Date arg3_in = GestAcces.DateHelper.read(_is);
        GestAcces.Date arg4_in = GestAcces.DateHelper.read(_is);

        try
        {
            enregisterCollaborateurTemporaire(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in);

            _output = handler.createReply();

        }
        catch (GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistantHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_rechercherCollaborateurs(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        GestAcces.CollaborateurCorba[] _arg_result = rechercherCollaborateurs();

        _output = handler.createReply();
        GestAcces.lCollaboHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerCollaborateur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        try
        {
            supprimerCollaborateur(arg0_in);

            _output = handler.createReply();

        }
        catch (GestAcces.ServeurAnnuairePackage.CollaborateurInexistant _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurAnnuairePackage.CollaborateurInexistantHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_rechercherCollaborateur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = GestAcces.PhotoHelper.read(_is);
        String arg1_in = _is.read_string();

        try
        {
            GestAcces.CollaborateurCorba _arg_result = rechercherCollaborateur(arg0_in, arg1_in);

            _output = handler.createReply();
            GestAcces.CollaborateurCorbaHelper.write(_output,_arg_result);

        }
        catch (GestAcces.ServeurAnnuairePackage.CollaborateurInexistant _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurAnnuairePackage.CollaborateurInexistantHelper.write(_output,_exception);
        }
        return _output;
    }

}
