package GestAcces;

/**
 * Struct definition : CollaborateurCorba
 * 
 * @author OpenORB Compiler
*/
public final class CollaborateurCorba implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member nom
     */
    public String nom;

    /**
     * Struct member prenom
     */
    public String prenom;

    /**
     * Struct member adresse
     */
    public String adresse;

    /**
     * Struct member statut
     */
    public String statut;

    /**
     * Struct member login
     */
    public String login;

    /**
     * Struct member mdp
     */
    public String mdp;

    /**
     * Struct member photo
     */
    public String photo;

    /**
     * Struct member dateEntree
     */
    public GestAcces.Date dateEntree;

    /**
     * Struct member e
     */
    public GestAcces.Empreinte e;

    /**
     * Default constructor
     */
    public CollaborateurCorba()
    { }

    /**
     * Constructor with fields initialization
     * @param nom nom struct member
     * @param prenom prenom struct member
     * @param adresse adresse struct member
     * @param statut statut struct member
     * @param login login struct member
     * @param mdp mdp struct member
     * @param photo photo struct member
     * @param dateEntree dateEntree struct member
     * @param e e struct member
     */
    public CollaborateurCorba(String nom, String prenom, String adresse, String statut, String login, String mdp, String photo, GestAcces.Date dateEntree, GestAcces.Empreinte e)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.statut = statut;
        this.login = login;
        this.mdp = mdp;
        this.photo = photo;
        this.dateEntree = dateEntree;
        this.e = e;
    }

}
