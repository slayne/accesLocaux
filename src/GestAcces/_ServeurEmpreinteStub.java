package GestAcces;

/**
 * Interface definition : ServeurEmpreinte
 * 
 * @author OpenORB Compiler
 */
public class _ServeurEmpreinteStub extends org.omg.CORBA.portable.ObjectImpl
        implements ServeurEmpreinte
{
    static final String[] _ids_list =
    {
        "IDL:GestAcces/ServeurEmpreinte:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestAcces.ServeurEmpreinteOperations.class;

    /**
     * Operation enregistrerEmpreinte
     */
    public void enregistrerEmpreinte(short idCollaborateur, String empreinte)
        throws GestAcces.ServeurEmpreintePackage.EmpreintePresente
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregistrerEmpreinte",true);
                    _output.write_short(idCollaborateur);
                    _output.write_string(empreinte);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestAcces.ServeurEmpreintePackage.EmpreintePresenteHelper.id()))
                    {
                        throw GestAcces.ServeurEmpreintePackage.EmpreintePresenteHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregistrerEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurEmpreinteOperations _self = (GestAcces.ServeurEmpreinteOperations) _so.servant;
                try
                {
                    _self.enregistrerEmpreinte( idCollaborateur,  empreinte);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(short idCollaborateur, String nouvelleEmpreinte)
        throws GestAcces.ServeurEmpreintePackage.EmpreinteInexistante
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierEmpreinte",true);
                    _output.write_short(idCollaborateur);
                    _output.write_string(nouvelleEmpreinte);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestAcces.ServeurEmpreintePackage.EmpreinteInexistanteHelper.id()))
                    {
                        throw GestAcces.ServeurEmpreintePackage.EmpreinteInexistanteHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurEmpreinteOperations _self = (GestAcces.ServeurEmpreinteOperations) _so.servant;
                try
                {
                    _self.modifierEmpreinte( idCollaborateur,  nouvelleEmpreinte);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation supprimerEmpreinte
     */
    public void supprimerEmpreinte(short idCollaborateur)
        throws GestAcces.ServeurEmpreintePackage.EmpreinteInexistante
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerEmpreinte",true);
                    _output.write_short(idCollaborateur);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestAcces.ServeurEmpreintePackage.EmpreinteInexistanteHelper.id()))
                    {
                        throw GestAcces.ServeurEmpreintePackage.EmpreinteInexistanteHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurEmpreinteOperations _self = (GestAcces.ServeurEmpreinteOperations) _so.servant;
                try
                {
                    _self.supprimerEmpreinte( idCollaborateur);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation verifierEmpreinte
     */
    public void verifierEmpreinte(short idCollaborateur, String mdp)
        throws GestAcces.ServeurEmpreintePackage.EmpreinteInvalide
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierEmpreinte",true);
                    _output.write_short(idCollaborateur);
                    _output.write_string(mdp);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestAcces.ServeurEmpreintePackage.EmpreinteInvalideHelper.id()))
                    {
                        throw GestAcces.ServeurEmpreintePackage.EmpreinteInvalideHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurEmpreinteOperations _self = (GestAcces.ServeurEmpreinteOperations) _so.servant;
                try
                {
                    _self.verifierEmpreinte( idCollaborateur,  mdp);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getEmpreinte
     */
    public String getEmpreinte(short idCollaborateur)
        throws GestAcces.ServeurEmpreintePackage.EmpreinteInvalide
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getEmpreinte",true);
                    _output.write_short(idCollaborateur);
                    _input = this._invoke(_output);
                    String _arg_ret = _input.read_string();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestAcces.ServeurEmpreintePackage.EmpreinteInvalideHelper.id()))
                    {
                        throw GestAcces.ServeurEmpreintePackage.EmpreinteInvalideHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurEmpreinteOperations _self = (GestAcces.ServeurEmpreinteOperations) _so.servant;
                try
                {
                    return _self.getEmpreinte( idCollaborateur);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
