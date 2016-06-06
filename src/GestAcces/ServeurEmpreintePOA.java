package GestAcces;

/**
 * Interface definition : ServeurEmpreinte
 * 
 * @author OpenORB Compiler
 */
public abstract class ServeurEmpreintePOA extends org.omg.PortableServer.Servant
        implements ServeurEmpreinteOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ServeurEmpreinte _this()
    {
        return ServeurEmpreinteHelper.narrow(_this_object());
    }

    public ServeurEmpreinte _this(org.omg.CORBA.ORB orb)
    {
        return ServeurEmpreinteHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:GestAcces/ServeurEmpreinte:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("enregistrerEmpreinte")) {
                return _invoke_enregistrerEmpreinte(_is, handler);
        } else if (opName.equals("modifierEmpreinte")) {
                return _invoke_modifierEmpreinte(_is, handler);
        } else if (opName.equals("supprimerEmpreinte")) {
                return _invoke_supprimerEmpreinte(_is, handler);
        } else if (opName.equals("verifierEmpreinte")) {
                return _invoke_verifierEmpreinte(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_enregistrerEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        GestAcces.Empreinte arg0_in = GestAcces.EmpreinteHelper.read(_is);

        try
        {
            enregistrerEmpreinte(arg0_in);

            _output = handler.createReply();

        }
        catch (GestAcces.ServeurEmpreintePackage.EmpreintePresente _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurEmpreintePackage.EmpreintePresenteHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        String arg1_in = _is.read_string();

        try
        {
            modifierEmpreinte(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (GestAcces.ServeurEmpreintePackage.EmpreinteInexistante _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurEmpreintePackage.EmpreinteInexistanteHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();

        try
        {
            supprimerEmpreinte(arg0_in);

            _output = handler.createReply();

        }
        catch (GestAcces.ServeurEmpreintePackage.EmpreinteInexistante _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurEmpreintePackage.EmpreinteInexistanteHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        short arg0_in = _is.read_short();
        String arg1_in = _is.read_string();

        try
        {
            verifierEmpreinte(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (GestAcces.ServeurEmpreintePackage.EmpreinteInvalide _exception)
        {
            _output = handler.createExceptionReply();
            GestAcces.ServeurEmpreintePackage.EmpreinteInvalideHelper.write(_output,_exception);
        }
        return _output;
    }

}
