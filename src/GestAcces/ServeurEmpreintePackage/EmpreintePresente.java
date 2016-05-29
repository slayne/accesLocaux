package GestAcces.ServeurEmpreintePackage;

/**
 * Exception definition : EmpreintePresente
 * 
 * @author OpenORB Compiler
 */
public final class EmpreintePresente extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public EmpreintePresente()
    {
        super(EmpreintePresenteHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public EmpreintePresente(String orb_reason)
    {
        super(EmpreintePresenteHelper.id() +" " +  orb_reason);
    }

}
