package GestAcces.ServeurEmpreintePackage;

/**
 * Exception definition : EmpreinteInvalide
 * 
 * @author OpenORB Compiler
 */
public final class EmpreinteInvalide extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public EmpreinteInvalide()
    {
        super(EmpreinteInvalideHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public EmpreinteInvalide(String orb_reason)
    {
        super(EmpreinteInvalideHelper.id() +" " +  orb_reason);
    }

}
