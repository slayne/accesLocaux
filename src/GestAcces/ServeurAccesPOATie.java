package GestAcces;

/**
 * Interface definition : ServeurAcces
 * 
 * @author OpenORB Compiler
 */
public class ServeurAccesPOATie extends ServeurAccesPOA
{

    //
    // Private reference to implementation object
    //
    private ServeurAccesOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ServeurAccesPOATie(ServeurAccesOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ServeurAccesPOATie(ServeurAccesOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ServeurAccesOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ServeurAccesOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation ajoutPerm
     */
    public short ajoutPerm(short id, short heureDebut, short heureFin, GestAcces.Zone z)
        throws GestAcces.ServeurAccesPackage.ZoneInexistante
    {
        return _tie.ajoutPerm( id,  heureDebut,  heureFin,  z);
    }

    /**
     * Operation ajoutTemp
     */
    public short ajoutTemp(short id, GestAcces.Jour jourDeb, GestAcces.Jour jourFin, short heureDebut, short heureFin, GestAcces.Zone z)
        throws GestAcces.ServeurAccesPackage.ZoneInexistante
    {
        return _tie.ajoutTemp( id,  jourDeb,  jourFin,  heureDebut,  heureFin,  z);
    }

    /**
     * Operation demanderAcces
     */
    public short demanderAcces(GestAcces.Empreinte mdp)
    {
        return _tie.demanderAcces( mdp);
    }

    /**
     * Operation supprimerAcces
     */
    public void supprimerAcces(short idCollaborateur, short idZone)
        throws GestAcces.ServeurAccesPackage.CollaborateurInexistant
    {
        _tie.supprimerAcces( idCollaborateur,  idZone);
    }

    /**
     * Operation verifierAcces
     */
    public short verifierAcces(short idCollaborateur, short idZone)
    {
        return _tie.verifierAcces( idCollaborateur,  idZone);
    }

    /**
     * Operation getListeZone
     */
    public GestAcces.Zone[] getListeZone()
    {
        return _tie.getListeZone();
    }

}
