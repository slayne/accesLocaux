package GestAcces;

/**
 * Interface definition : ServeurAnnuaire
 * 
 * @author OpenORB Compiler
 */
public interface ServeurAnnuaireOperations
{
    /**
     * Operation demanderAcces
     */
    public boolean demanderAcces(String Photo, String mdp, short idZone)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurInexistant;

    /**
     * Operation enregisterCollaborateurPermanent
     */
    public void enregisterCollaborateurPermanent(String nom, String p, String empreinte, GestAcces.Date de)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant;

    /**
     * Operation enregisterCollaborateurTemporaire
     */
    public void enregisterCollaborateurTemporaire(String nom, String p, String empreinte, GestAcces.Date de, GestAcces.Date df)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurDejaExistant;

    /**
     * Operation rechercherCollaborateur
     */
    public GestAcces.CollaborateurCorba[] rechercherCollaborateur(String nom, String prenom);

    /**
     * Operation supprimerCollaborateur
     */
    public void supprimerCollaborateur(short id)
        throws GestAcces.ServeurAnnuairePackage.CollaborateurInexistant;

}
