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
     * Operation enregisterCollaborateur
     */
    public short enregisterCollaborateur(String nom, String prenom, String p)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant
    {
        return _tie.enregisterCollaborateur( nom,  prenom,  p);
    }

    /**
     * Operation rechercherCollaborateur
     */
    public short rechercherCollaborateur(String nom, String prenom)
    {
        return _tie.rechercherCollaborateur( nom,  prenom);
    }

    /**
     * Operation supprimerCollaborateur
     */
    public void supprimerCollaborateur(short id)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurInnexistant
    {
        _tie.supprimerCollaborateur( id);
    }

}
