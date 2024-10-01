import Donjon_Dragons.LoadPlayer;
import Print.PrintAcs;
import db.PlayerDAO;



public class Main {
    public static void main(String[] args) {
        //instance field
        PrintAcs printThings = new PrintAcs();
        LoadPlayer loadPlayer = new LoadPlayer();

        //test connection bdd
        PlayerDAO playerDAO = new PlayerDAO();
        playerDAO.testConnection();

        //affichage img Menu
        printThings.Print("Welcome");
        printThings.Print("WelcomePaint");

        //choix Menu
        loadPlayer.MainChoice();

    }
}