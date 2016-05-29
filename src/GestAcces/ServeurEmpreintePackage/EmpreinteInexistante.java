package GestAcces.ServeurEmpreintePackage;

/**
 * Exception definition : EmpreinteInexistante
 * 
 * @author OpenORB Compiler
 */
public final class EmpreinteInexistante extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public EmpreinteInexistante()
    {
        super(EmpreinteInexistanteHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public EmpreinteInexistante(String orb_reason)
    {
        super(EmpreinteInexistanteHelper.id() +" " +  orb_reason);
    }

}
