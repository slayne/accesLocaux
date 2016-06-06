package GestAcces;

/**
 * Interface definition : ServeurAcces
 * 
 * @author OpenORB Compiler
 */
public class _ServeurAccesStub extends org.omg.CORBA.portable.ObjectImpl
        implements ServeurAcces
{
    static final String[] _ids_list =
    {
        "IDL:GestAcces/ServeurAcces:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestAcces.ServeurAccesOperations.class;

    /**
     * Operation ajoutPerm
     */
    public short ajoutPerm(short id, short heureDebut, short heureFin, GestAcces.Zone z)
        throws GestAcces.ServeurAccesPackage.ZoneInexistante
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajoutPerm",true);
                    _output.write_short(id);
                    GestAcces.HeureHelper.write(_output,heureDebut);
                    GestAcces.HeureHelper.write(_output,heureFin);
                    GestAcces.ZoneHelper.write(_output,z);
                    _input = this._invoke(_output);
                    short _arg_ret = _input.read_short();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestAcces.ServeurAccesPackage.ZoneInexistanteHelper.id()))
                    {
                        throw GestAcces.ServeurAccesPackage.ZoneInexistanteHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajoutPerm",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAccesOperations _self = (GestAcces.ServeurAccesOperations) _so.servant;
                try
                {
                    return _self.ajoutPerm( id,  heureDebut,  heureFin,  z);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation ajoutTemp
     */
    public short ajoutTemp(short id, GestAcces.Jour jourDeb, GestAcces.Jour jourFin, short heureDebut, short heureFin, GestAcces.Zone z)
        throws GestAcces.ServeurAccesPackage.ZoneInexistante
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajoutTemp",true);
                    _output.write_short(id);
                    GestAcces.JourHelper.write(_output,jourDeb);
                    GestAcces.JourHelper.write(_output,jourFin);
                    GestAcces.HeureHelper.write(_output,heureDebut);
                    GestAcces.HeureHelper.write(_output,heureFin);
                    GestAcces.ZoneHelper.write(_output,z);
                    _input = this._invoke(_output);
                    short _arg_ret = _input.read_short();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(GestAcces.ServeurAccesPackage.ZoneInexistanteHelper.id()))
                    {
                        throw GestAcces.ServeurAccesPackage.ZoneInexistanteHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajoutTemp",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAccesOperations _self = (GestAcces.ServeurAccesOperations) _so.servant;
                try
                {
                    return _self.ajoutTemp( id,  jourDeb,  jourFin,  heureDebut,  heureFin,  z);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation demanderAcces
     */
    public short demanderAcces(String Photo, String mdp)
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
                    _input = this._invoke(_output);
                    short _arg_ret = _input.read_short();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("demanderAcces",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAccesOperations _self = (GestAcces.ServeurAccesOperations) _so.servant;
                try
                {
                    return _self.demanderAcces( Photo,  mdp);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation supprimerAcces
     */
    public void supprimerAcces(short idCollaborateur, short idZone)
        throws GestAcces.ServeurAccesPackage.CollaborateurInexistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerAcces",true);
                    _output.write_short(idCollaborateur);
                    _output.write_short(idZone);
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
                    if (_exception_id.equals(GestAcces.ServeurAccesPackage.CollaborateurInexistantHelper.id()))
                    {
                        throw GestAcces.ServeurAccesPackage.CollaborateurInexistantHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerAcces",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAccesOperations _self = (GestAcces.ServeurAccesOperations) _so.servant;
                try
                {
                    _self.supprimerAcces( idCollaborateur,  idZone);
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
     * Operation verifierAcces
     */
    public short verifierAcces(short idCollaborateur, short idZone)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAcces",true);
                    _output.write_short(idCollaborateur);
                    _output.write_short(idZone);
                    _input = this._invoke(_output);
                    short _arg_ret = _input.read_short();
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierAcces",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAccesOperations _self = (GestAcces.ServeurAccesOperations) _so.servant;
                try
                {
                    return _self.verifierAcces( idCollaborateur,  idZone);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getListeZone
     */
    public GestAcces.Zone[] getListeZone()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getListeZone",true);
                    _input = this._invoke(_output);
                    GestAcces.Zone[] _arg_ret = GestAcces.lZoneHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getListeZone",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurAccesOperations _self = (GestAcces.ServeurAccesOperations) _so.servant;
                try
                {
                    return _self.getListeZone();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
