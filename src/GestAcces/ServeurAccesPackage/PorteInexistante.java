package GestAcces.ServeurAccesPackage;

/**
 * Exception definition : PorteInexistante
 * 
 * @author OpenORB Compiler
 */
public final class PorteInexistante extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public PorteInexistante()
    {
        super(PorteInexistanteHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public PorteInexistante(String orb_reason)
    {
        super(PorteInexistanteHelper.id() +" " +  orb_reason);
    }

}
