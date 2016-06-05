package GestAcces;

/**
 * Interface definition : ServeurAcces
 * 
 * @author OpenORB Compiler
 */
public interface ServeurAccesOperations
{
    /**
     * Operation ajoutPerm
     */
    public short ajoutPerm(short id, short heureDebut, short heureFin, GestAcces.Zone z)
        throws GestAcces.ServeurAccesPackage.ZoneInexistante;

    /**
     * Operation ajoutTemp
     */
    public short ajoutTemp(short id, GestAcces.Jour jourDeb, GestAcces.Jour jourFin, short heureDebut, short heureFin, GestAcces.Zone z)
        throws GestAcces.ServeurAccesPackage.ZoneInexistante;

    /**
     * Operation demanderAcces
     */
    public short demanderAcces(String id, String mdp);

    /**
     * Operation supprimerAcces
     */
    public void supprimerAcces(short idCollaborateur, short idZone)
        throws GestAcces.ServeurAccesPackage.CollaborateurInexistant;

    /**
     * Operation verifierAcces
     */
    public short verifierAcces(short idCollaborateur, short idZone);

    /**
     * Operation getListeZone
     */
    public GestAcces.Zone[] getListeZone();

}
