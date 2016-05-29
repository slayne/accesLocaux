package GestAcces.ServeurAnnuairePackage;

/**
 * Exception definition : CollaborateurInnexistant
 * 
 * @author OpenORB Compiler
 */
public final class CollaborateurInnexistant extends org.omg.CORBA.UserException
{
    /**
     * Default constructor
     */
    public CollaborateurInnexistant()
    {
        super(CollaborateurInnexistantHelper.id());
    }

    /**
     * Full constructor with fields initialization
     */
    public CollaborateurInnexistant(String orb_reason)
    {
        super(CollaborateurInnexistantHelper.id() +" " +  orb_reason);
    }

}
