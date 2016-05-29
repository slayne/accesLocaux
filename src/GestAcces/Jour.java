package GestAcces;

/**
 * Struct definition : Jour
 * 
 * @author OpenORB Compiler
*/
public final class Jour implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member annee
     */
    public short annee;

    /**
     * Struct member mois
     */
    public short mois;

    /**
     * Struct member jour
     */
    public short jour;

    /**
     * Default constructor
     */
    public Jour()
    { }

    /**
     * Constructor with fields initialization
     * @param annee annee struct member
     * @param mois mois struct member
     * @param jour jour struct member
     */
    public Jour(short annee, short mois, short jour)
    {
        this.annee = annee;
        this.mois = mois;
        this.jour = jour;
    }

}
