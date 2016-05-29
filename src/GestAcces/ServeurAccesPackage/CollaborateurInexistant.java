package GestAcces.ServeurAccesPackage;

/**
 * Exception definition : CollaborateurInexistant
 * 
 * @author OpenORB Compiler
 */
public final class CollaborateurInexistant extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public CollaborateurInexistant()
    {
        super(CollaborateurInexistantHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public CollaborateurInexistant(String orb_reason)
    {
        super(CollaborateurInexistantHelper.id() +" " +  orb_reason);
    }

}
