package fr.campus.dand;

import fr.campus.dand.engine.LoadPlayer;
import fr.campus.dand.print.PrintAcs;
import fr.campus.dand.db.PlayerDAO;



public class Main {
    public static void main(String[] args) {
        //instance field
        PrintAcs printThings = new PrintAcs();
        LoadPlayer loadPlayer = new LoadPlayer();

/**
 * Creates a Print instance for the first screen
 * Creates an instance of LoadPlayer allowing the player to start new party or to load one
 */
        //test connection bdd
        PlayerDAO playerDAO = new PlayerDAO();
        playerDAO.testConnection();
/**
 * Creating instance of the connection with database of the player.
 * And make a quick test of the connection
 */


        //affichage img Menu
        printThings.Print("Welcome");
        printThings.Print("WelcomePaint");

        /**
         *
         * Creating 2 prints with string name to reference to the correct fr.campus.dand.print in PrintAcs Class
          */
        //choix Menu
        loadPlayer.MainChoice();
/**
 * Launch Menu with methode MainChoice();
 *
 */
    }
}
