package GestAcces;

/**
 * Struct definition : Empreinte
 * 
 * @author OpenORB Compiler
*/
public final class Empreinte implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member empreinte
     */
    public String empreinte;

    /**
     * Struct member idCollaborateur
     */
    public short idCollaborateur;

    /**
     * Default constructor
     */
    public Empreinte()
    { }

    /**
     * Constructor with fields initialization
     * @param empreinte empreinte struct member
     * @param idCollaborateur idCollaborateur struct member
     */
    public Empreinte(String empreinte, short idCollaborateur)
    {
        this.empreinte = empreinte;
        this.idCollaborateur = idCollaborateur;
    }

}
