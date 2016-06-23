package corba.serveur;

import GestAcces.ServeurEmpreinte;
import GestAcces.ServeurLog;
import corba.serveur.acces.ServeurAccesMain;
import corba.serveur.annuaire.ServeurAnnuaireMain;
import corba.serveur.empreinte.ServeurEmpreinteMain;
import corba.serveur.log.ServeurLogMain;

/**
 * Created by yoan on 23/06/16.
 */
public class Lanceur {
    public static void main(String[] args) {
        ServeurLogMain.main(null);
        ServeurEmpreinteMain.main(null);
        ServeurAccesMain.main(null);
        ServeurAnnuaireMain.main(null);
    }
}
