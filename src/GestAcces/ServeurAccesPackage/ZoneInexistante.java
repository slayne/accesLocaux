package GestAcces.ServeurAccesPackage;

/**
 * Exception definition : ZoneInexistante
 * 
 * @author OpenORB Compiler
 */
public final class ZoneInexistante extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public ZoneInexistante()
    {
        super(ZoneInexistanteHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public ZoneInexistante(String orb_reason)
    {
        super(ZoneInexistanteHelper.id() +" " +  orb_reason);
    }

}
