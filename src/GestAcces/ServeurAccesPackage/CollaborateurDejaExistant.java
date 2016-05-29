package GestAcces.ServeurAccesPackage;

/**
 * Exception definition : CollaborateurDejaExistant
 * 
 * @author OpenORB Compiler
 */
public final class CollaborateurDejaExistant extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public CollaborateurDejaExistant()
    {
        super(CollaborateurDejaExistantHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public CollaborateurDejaExistant(String orb_reason)
    {
        super(CollaborateurDejaExistantHelper.id() +" " +  orb_reason);
    }

}
