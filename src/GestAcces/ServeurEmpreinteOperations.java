package GestAcces;

/**
 * Interface definition : ServeurEmpreinte
 * 
 * @author OpenORB Compiler
 */
public interface ServeurEmpreinteOperations
{
    /**
     * Operation enregistrerEmpreinte
     */
    public short enregistrerEmpreinte(String e, short id)
        throws GestAcces.ServeurEmpreintePackage.EmpreintePresente;

    /**
     * Operation modifierEmpreinte
     */
    public short modifierEmpreinte(String ancienneEmpreinte, String nouvelleEmpreinte)
        throws GestAcces.ServeurEmpreintePackage.EmpreinteInexistante;

    /**
     * Operation supprimerEmpreinte
     */
    public short supprimerEmpreinte(short id);

    /**
     * Operation verifierEmpreinte
     */
    public short verifierEmpreinte(String id, String mdp);

}
