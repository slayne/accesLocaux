package GestAcces;

/**
 * Interface definition : ServeurAnnuaire
 * 
 * @author OpenORB Compiler
 */
public class _ServeurAnnuaireStub extends org.omg.CORBA.portable.ObjectImpl
        implements ServeurAnnuaire
{
    static final String[] _ids_list =
    {
        "IDL:GestAcces/ServeurAnnuaire:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestAcces.ServeurAnnuaireOperations.class;

    /**
     * Operation demanderAcces
     */
    public boolean demanderAcces(String Photo, String mdp, short idZone)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurInexistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("demanderAcces",true);
                    _output.write_string(Photo);
                    _output.write_string(mdp);
                    _output.write_short(idZone);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestAcces.ServeurAnnuairePackage.CollaborateurInexistantHelper.id()))
                    {
                        throw GestAcces.ServeurAnnuairePackage.CollaborateurInexistantHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demanderAcces",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAnnuaireOperations _self = (GestAcces.ServeurAnnuaireOperations) _so.servant;
                try
                {
                    return _self.demanderAcces( Photo,  mdp,  idZone);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation enregisterCollaborateurPermanent
     */
    public void enregisterCollaborateurPermanent(String nom, String p, String empreinte, GestAcces.Date de)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregisterCollaborateurPermanent",true);
                    _output.write_string(nom);
                    GestAcces.PhotoHelper.write(_output,p);
                    _output.write_string(empreinte);
                    GestAcces.DateHelper.write(_output,de);
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
                    if (_exception_id.equals(GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistantHelper.id()))
                    {
                        throw GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistantHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregisterCollaborateurPermanent",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAnnuaireOperations _self = (GestAcces.ServeurAnnuaireOperations) _so.servant;
                try
                {
                    _self.enregisterCollaborateurPermanent( nom,  p,  empreinte,  de);
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
     * Operation enregisterCollaborateurTemporaire
     */
    public void enregisterCollaborateurTemporaire(String nom, String p, String empreinte, GestAcces.Date de, GestAcces.Date df)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregisterCollaborateurTemporaire",true);
                    _output.write_string(nom);
                    GestAcces.PhotoHelper.write(_output,p);
                    _output.write_string(empreinte);
                    GestAcces.DateHelper.write(_output,de);
                    GestAcces.DateHelper.write(_output,df);
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
                    if (_exception_id.equals(GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistantHelper.id()))
                    {
                        throw GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistantHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregisterCollaborateurTemporaire",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAnnuaireOperations _self = (GestAcces.ServeurAnnuaireOperations) _so.servant;
                try
                {
                    _self.enregisterCollaborateurTemporaire( nom,  p,  empreinte,  de,  df);
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
     * Operation rechercherCollaborateurs
     */
    public GestAcces.CollaborateurCorba[] rechercherCollaborateurs()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("rechercherCollaborateurs",true);
                    _input = this._invoke(_output);
                    GestAcces.CollaborateurCorba[] _arg_ret = GestAcces.lCollaboHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("rechercherCollaborateurs",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAnnuaireOperations _self = (GestAcces.ServeurAnnuaireOperations) _so.servant;
                try
                {
                    return _self.rechercherCollaborateurs();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation supprimerCollaborateur
     */
    public void supprimerCollaborateur(short id)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurInexistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerCollaborateur",true);
                    _output.write_short(id);
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
                    if (_exception_id.equals(GestAcces.ServeurAnnuairePackage.CollaborateurInexistantHelper.id()))
                    {
                        throw GestAcces.ServeurAnnuairePackage.CollaborateurInexistantHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerCollaborateur",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAnnuaireOperations _self = (GestAcces.ServeurAnnuaireOperations) _so.servant;
                try
                {
                    _self.supprimerCollaborateur( id);
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
     * Operation rechercherCollaborateur
     */
    public GestAcces.CollaborateurCorba rechercherCollaborateur(String p, String empreinte)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurInexistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("rechercherCollaborateur",true);
                    GestAcces.PhotoHelper.write(_output,p);
                    _output.write_string(empreinte);
                    _input = this._invoke(_output);
                    GestAcces.CollaborateurCorba _arg_ret = GestAcces.CollaborateurCorbaHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestAcces.ServeurAnnuairePackage.CollaborateurInexistantHelper.id()))
                    {
                        throw GestAcces.ServeurAnnuairePackage.CollaborateurInexistantHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("rechercherCollaborateur",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAnnuaireOperations _self = (GestAcces.ServeurAnnuaireOperations) _so.servant;
                try
                {
                    return _self.rechercherCollaborateur( p,  empreinte);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
