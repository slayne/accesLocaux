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
     * Operation enregisterCollaborateur
     */
    public void enregisterCollaborateur(String nom, String prenom, String p, GestAcces.Empreinte e)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("enregisterCollaborateur",true);
                    _output.write_string(nom);
                    _output.write_string(prenom);
                    GestAcces.PhotoHelper.write(_output,p);
                    GestAcces.EmpreinteHelper.write(_output,e);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("enregisterCollaborateur",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAnnuaireOperations _self = (GestAcces.ServeurAnnuaireOperations) _so.servant;
                try
                {
                    _self.enregisterCollaborateur( nom,  prenom,  p,  e);
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
    public void rechercherCollaborateur(String nom, String prenom)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("rechercherCollaborateur",true);
                    _output.write_string(nom);
                    _output.write_string(prenom);
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
                    _self.rechercherCollaborateur( nom,  prenom);
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
     * Operation supprimerCollaborateur
     */
    public void supprimerCollaborateur(short id)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurInnexistant
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
                    if (_exception_id.equals(GestAcces.ServeurAnnuairePackage.CollaborateurInnexistantHelper.id()))
                    {
                        throw GestAcces.ServeurAnnuairePackage.CollaborateurInnexistantHelper.read(_exception.getInputStream());
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

}
