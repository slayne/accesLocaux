package GestAcces;

/**
 * Interface definition : ServeurLog
 * 
 * @author OpenORB Compiler
 */
public class _ServeurLogStub extends org.omg.CORBA.portable.ObjectImpl
        implements ServeurLog
{
    static final String[] _ids_list =
    {
        "IDL:GestAcces/ServeurLog:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = GestAcces.ServeurLogOperations.class;

    /**
     * Operation envoyerLog
     */
    public void envoyerLog(String log)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("envoyerLog",false);
                    _output.write_string(log);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("envoyerLog",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurLogOperations _self = (GestAcces.ServeurLogOperations) _so.servant;
                try
                {
                    _self.envoyerLog( log);
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
     * Operation afficherLogs
     */
    public GestAcces.Log[] afficherLogs()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("afficherLogs",false);
                    _input = this._invoke(_output);
                    GestAcces.Log[] _arg_ret = GestAcces.lLogHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("afficherLogs",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurLogOperations _self = (GestAcces.ServeurLogOperations) _so.servant;
                try
                {
                    return _self.afficherLogs();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation afficherLogsFromDate
     */
    public GestAcces.Log[] afficherLogsFromDate(GestAcces.Date date)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("afficherLogsFromDate",false);
                    GestAcces.DateHelper.write(_output,date);
                    _input = this._invoke(_output);
                    GestAcces.Log[] _arg_ret = GestAcces.lLogHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("afficherLogsFromDate",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurLogOperations _self = (GestAcces.ServeurLogOperations) _so.servant;
                try
                {
                    return _self.afficherLogsFromDate( date);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation afficherLogsfromDateToDate
     */
    public GestAcces.Log[] afficherLogsfromDateToDate(GestAcces.Date dated, GestAcces.Date datef)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("afficherLogsfromDateToDate",false);
                    GestAcces.DateHelper.write(_output,dated);
                    GestAcces.DateHelper.write(_output,datef);
                    _input = this._invoke(_output);
                    GestAcces.Log[] _arg_ret = GestAcces.lLogHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("afficherLogsfromDateToDate",_opsClass);
                if (_so == null)
                   continue;
                GestAcces.ServeurLogOperations _self = (GestAcces.ServeurLogOperations) _so.servant;
                try
                {
                    return _self.afficherLogsfromDateToDate( dated,  datef);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}
