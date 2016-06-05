package GestAcces;

/**
 * Interface definition : ServeurEmpreinte
 * 
 * @author OpenORB Compiler
 */
public class ServeurEmpreintePOATie extends ServeurEmpreintePOA
{

    //
    // Private reference to implementation object
    //
    private ServeurEmpreinteOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ServeurEmpreintePOATie(ServeurEmpreinteOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ServeurEmpreintePOATie(ServeurEmpreinteOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ServeurEmpreinteOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ServeurEmpreinteOperations delegate_)
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
     * Operation enregistrerEmpreinte
     */
    public void enregistrerEmpreinte(String e, short id)
        throws GestAcces.ServeurEmpreintePackage.EmpreintePresente
    {
        _tie.enregistrerEmpreinte( e,  id);
    }

    /**
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(String ancienneEmpreinte, String nouvelleEmpreinte)
        throws GestAcces.ServeurEmpreintePackage.EmpreinteInexistante
    {
        _tie.modifierEmpreinte( ancienneEmpreinte,  nouvelleEmpreinte);
    }

    /**
     * Operation supprimerEmpreinte
     */
    public void supprimerEmpreinte(short id)
    {
        _tie.supprimerEmpreinte( id);
    }

    /**
     * Operation verifierEmpreinte
     */
    public void verifierEmpreinte(String id, String mdp)
    {
        _tie.verifierEmpreinte( id,  mdp);
    }

}