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
    public void enregistrerEmpreinte(String e, short id)
        throws GestAcces.ServeurEmpreintePackage.EmpreintePresente;

    /**
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(String ancienneEmpreinte, String nouvelleEmpreinte)
        throws GestAcces.ServeurEmpreintePackage.EmpreinteInexistante;

    /**
     * Operation supprimerEmpreinte
     */
    public void supprimerEmpreinte(short id);

    /**
     * Operation verifierEmpreinte
     */
    public void verifierEmpreinte(String id, String mdp);

}
