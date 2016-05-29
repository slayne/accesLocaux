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
    public short enregisterCollaborateur(String nom, String prenom, String p)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant;

    /**
     * Operation rechercherCollaborateur
     */
    public short rechercherCollaborateur(String nom, String prenom);

    /**
     * Operation supprimerCollaborateur
     */
    public void supprimerCollaborateur(short id)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurInnexistant;

}
