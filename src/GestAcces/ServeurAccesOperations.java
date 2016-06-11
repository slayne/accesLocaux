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
    public void ajoutPerm(short id, short heureDebut, short heureFin, short idZone)
        throws GestAcces.ServeurAccesPackage.ZoneInexistante;

    /**
     * Operation ajoutTemp
     */
    public void ajoutTemp(short id, GestAcces.Jour jourDeb, GestAcces.Jour jourFin, short heureDebut, short heureFin, short idZone)
        throws GestAcces.ServeurAccesPackage.ZoneInexistante;

    /**
     * Operation supprimerAcces
     */
    public void supprimerAcces(short idCollaborateur, short idZone)
        throws GestAcces.ServeurAccesPackage.CollaborateurInexistant;

    /**
     * Operation verifierAcces
     */
    public boolean verifierAcces(short idCollaborateur, short idZone);

    /**
     * Operation getListeZone
     */
    public GestAcces.Zone[] getListeZone();

    /**
     * Operation getZonesPorte
     */
    public GestAcces.Zone[] getZonesPorte(short idPorte)
        throws GestAcces.ServeurAccesPackage.PorteInexistante;

}
