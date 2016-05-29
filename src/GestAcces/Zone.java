package GestAcces;

/**
 * Struct definition : Zone
 * 
 * @author OpenORB Compiler
*/
public final class Zone implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idZone
     */
    public short idZone;

    /**
     * Struct member nomZone
     */
    public String nomZone;

    /**
     * Struct member tailleZone
     */
    public String tailleZone;

    /**
     * Struct member typeZone
     */
    public String typeZone;

    /**
     * Default constructor
     */
    public Zone()
    { }

    /**
     * Constructor with fields initialization
     * @param idZone idZone struct member
     * @param nomZone nomZone struct member
     * @param tailleZone tailleZone struct member
     * @param typeZone typeZone struct member
     */
    public Zone(short idZone, String nomZone, String tailleZone, String typeZone)
    {
        this.idZone = idZone;
        this.nomZone = nomZone;
        this.tailleZone = tailleZone;
        this.typeZone = typeZone;
    }

}
