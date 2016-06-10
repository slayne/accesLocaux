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
     * Default constructor
     */
    public Zone()
    { }

    /**
     * Constructor with fields initialization
     * @param idZone idZone struct member
     * @param nomZone nomZone struct member
     */
    public Zone(short idZone, String nomZone)
    {
        this.idZone = idZone;
        this.nomZone = nomZone;
    }

}
