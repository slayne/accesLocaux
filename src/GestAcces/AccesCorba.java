package GestAcces;

/**
 * Struct definition : AccesCorba
 * 
 * @author OpenORB Compiler
*/
public final class AccesCorba implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idAcces
     */
    public short idAcces;

    /**
     * Struct member zone
     */
    public GestAcces.Zone zone;

    /**
     * Struct member idCollaborateur
     */
    public short idCollaborateur;

    /**
     * Struct member dateDebut
     */
    public GestAcces.Date dateDebut;

    /**
     * Struct member dateFin
     */
    public GestAcces.Date dateFin;

    /**
     * Struct member heureDebut
     */
    public short heureDebut;

    /**
     * Struct member heureFin
     */
    public short heureFin;

    /**
     * Struct member isTemp
     */
    public boolean isTemp;

    /**
     * Default constructor
     */
    public AccesCorba()
    { }

    /**
     * Constructor with fields initialization
     * @param idAcces idAcces struct member
     * @param zone zone struct member
     * @param idCollaborateur idCollaborateur struct member
     * @param dateDebut dateDebut struct member
     * @param dateFin dateFin struct member
     * @param heureDebut heureDebut struct member
     * @param heureFin heureFin struct member
     * @param isTemp isTemp struct member
     */
    public AccesCorba(short idAcces, GestAcces.Zone zone, short idCollaborateur, GestAcces.Date dateDebut, GestAcces.Date dateFin, short heureDebut, short heureFin, boolean isTemp)
    {
        this.idAcces = idAcces;
        this.zone = zone;
        this.idCollaborateur = idCollaborateur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.isTemp = isTemp;
    }

}
