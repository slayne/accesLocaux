package GestAcces;

/**
 * Interface definition : ServeurAnnuaire
 * 
 * @author OpenORB Compiler
 */
public class ServeurAnnuairePOATie extends ServeurAnnuairePOA
{

    //
    // Private reference to implementation object
    //
    private ServeurAnnuaireOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ServeurAnnuairePOATie(ServeurAnnuaireOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ServeurAnnuairePOATie(ServeurAnnuaireOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ServeurAnnuaireOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ServeurAnnuaireOperations delegate_)
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
     * Operation demanderAcces
     */
    public boolean demanderAcces(String Photo, String mdp, short idZone)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurInexistant
    {
        return _tie.demanderAcces( Photo,  mdp,  idZone);
    }

    /**
     * Operation enregisterCollaborateurPermanent
     */
    public void enregisterCollaborateurPermanent(String nom, String p, String empreinte, GestAcces.Date de)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant
    {
        _tie.enregisterCollaborateurPermanent( nom,  p,  empreinte,  de);
    }

    /**
     * Operation enregisterCollaborateurTemporaire
     */
    public void enregisterCollaborateurTemporaire(String nom, String p, String empreinte, GestAcces.Date de, GestAcces.Date df)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant
    {
        _tie.enregisterCollaborateurTemporaire( nom,  p,  empreinte,  de,  df);
    }

    /**
     * Operation rechercherCollaborateur
     */
    public GestAcces.CollaborateurCorba[] rechercherCollaborateur(String nom, String prenom)
    {
        return _tie.rechercherCollaborateur( nom,  prenom);
    }

    /**
     * Operation supprimerCollaborateur
     */
    public void supprimerCollaborateur(short id)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurInexistant
    {
        _tie.supprimerCollaborateur( id);
    }

}
