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
    public void enregistrerEmpreinte(short idCollaborateur, String empreinte)
        throws GestAcces.ServeurEmpreintePackage.EmpreintePresente;

    /**
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(short idCollaborateur, String nouvelleEmpreinte)
        throws GestAcces.ServeurEmpreintePackage.EmpreinteInexistante;

    /**
     * Operation supprimerEmpreinte
     */
    public void supprimerEmpreinte(short idCollaborateur)
        throws GestAcces.ServeurEmpreintePackage.EmpreinteInexistante;

    /**
     * Operation verifierEmpreinte
     */
    public void verifierEmpreinte(short idCollaborateur, String mdp)
        throws GestAcces.ServeurEmpreintePackage.EmpreinteInvalide;

}
