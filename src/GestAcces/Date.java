package GestAcces;

/**
 * Struct definition : Date
 * 
 * @author OpenORB Compiler
*/
public final class Date implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member j
     */
    public GestAcces.Jour j;

    /**
     * Struct member h
     */
    public short h;

    /**
     * Struct member m
     */
    public short m;

    /**
     * Default constructor
     */
    public Date()
    { }

    /**
     * Constructor with fields initialization
     * @param j j struct member
     * @param h h struct member
     * @param m m struct member
     */
    public Date(GestAcces.Jour j, short h, short m)
    {
        this.j = j;
        this.h = h;
        this.m = m;
    }

}
