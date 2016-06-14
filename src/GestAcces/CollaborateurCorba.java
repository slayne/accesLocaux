package GestAcces;

/**
 * Struct definition : CollaborateurCorba
 * 
 * @author OpenORB Compiler
*/
public final class CollaborateurCorba implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member id
     */
    public short id;

    /**
     * Struct member nom
     */
    public String nom;

    /**
     * Struct member photo
     */
    public String photo;

    /**
     * Struct member dateEntree
     */
    public GestAcces.Date dateEntree;

    /**
     * Struct member empreinte
     */
    public String empreinte;

    /**
     * Struct member isTemp
     */
    public boolean isTemp;

    /**
     * Struct member dateFin
     */
    public GestAcces.Date dateFin;

    /**
     * Struct member acces
     */
    public GestAcces.AccesCorba[] acces;

    /**
     * Default constructor
     */
    public CollaborateurCorba()
    { }

    /**
     * Constructor with fields initialization
     * @param id id struct member
     * @param nom nom struct member
     * @param photo photo struct member
     * @param dateEntree dateEntree struct member
     * @param empreinte empreinte struct member
     * @param isTemp isTemp struct member
     * @param dateFin dateFin struct member
     * @param acces acces struct member
     */
    public CollaborateurCorba(short id, String nom, String photo, GestAcces.Date dateEntree, String empreinte, boolean isTemp, GestAcces.Date dateFin, GestAcces.AccesCorba[] acces)
    {
        this.id = id;
        this.nom = nom;
        this.photo = photo;
        this.dateEntree = dateEntree;
        this.empreinte = empreinte;
        this.isTemp = isTemp;
        this.dateFin = dateFin;
        this.acces = acces;
    }

}
