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
    public void ajoutPerm(short id, short heureDebut, short heureFin, short idAcces)
        throws GestAcces.ServeurAccesPackage.ZoneInexistante
    {
        _tie.ajoutPerm( id,  heureDebut,  heureFin,  idAcces);
    }

    /**
     * Operation ajoutTemp
     */
    public void ajoutTemp(short id, GestAcces.Jour jourDeb, GestAcces.Jour jourFin, short heureDebut, short heureFin, short idZone)
        throws GestAcces.ServeurAccesPackage.ZoneInexistante
    {
        _tie.ajoutTemp( id,  jourDeb,  jourFin,  heureDebut,  heureFin,  idZone);
    }

    /**
     * Operation supprimerUnAcces
     */
    public void supprimerUnAcces(short idCollaborateur, short idZone)
        throws GestAcces.ServeurAccesPackage.CollaborateurInexistant
    {
        _tie.supprimerUnAcces( idCollaborateur,  idZone);
    }

    /**
     * Operation verifierAcces
     */
    public boolean verifierAcces(short idCollaborateur, short idZone)
    {
        return _tie.verifierAcces( idCollaborateur,  idZone);
    }

    /**
     * Operation supprimerAccesCollaborateur
     */
    public void supprimerAccesCollaborateur(short idCollaborateur)
        throws GestAcces.ServeurAccesPackage.CollaborateurInexistant
    {
        _tie.supprimerAccesCollaborateur( idCollaborateur);
    }

    /**
     * Operation getListeZone
     */
    public GestAcces.Zone[] getListeZone()
    {
        return _tie.getListeZone();
    }

    /**
     * Operation getZonesPorte
     */
    public GestAcces.Zone[] getZonesPorte(short idPorte)
        throws GestAcces.ServeurAccesPackage.PorteInexistante
    {
        return _tie.getZonesPorte( idPorte);
    }

    /**
     * Operation getAccesCollaborateur
     */
    public GestAcces.AccesCorba[] getAccesCollaborateur(short idCollaborateur)
    {
        return _tie.getAccesCollaborateur( idCollaborateur);
    }

}
