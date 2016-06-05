package GestAcces;

/**
 * Interface definition : ServeurAnnuaire
 * 
 * @author OpenORB Compiler
 */
public interface ServeurAnnuaireOperations
{
    /**
     * Operation enregisterCollaborateur
     */
    public void enregisterCollaborateur(String nom, String prenom, String p)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant;

    /**
     * Operation rechercherCollaborateur
     */
    public void rechercherCollaborateur(String nom, String prenom);

    /**
     * Operation supprimerCollaborateur
     */
    public void supprimerCollaborateur(short id)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurInnexistant;

}
