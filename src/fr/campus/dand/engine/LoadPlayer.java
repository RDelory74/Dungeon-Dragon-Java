package fr.campus.dand.engine;

import fr.campus.dand.db.PlayerDAO;
import java.util.List;
import java.util.Scanner;

public class LoadPlayer {
    public void MainChoice() {
        PlayerDAO playerDAO = new PlayerDAO();
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        /**
         * New instance for connection to interact with database
         * New instance to use Scanner
         * New instance to drive the player to the creation Menu choice n°1
         */
        System.out.println("\n\n                        ** 1. Nouvelle partie **");
        System.out.println("                          ** 2. Charger héros **");
        System.out.println("Player Choice: ");

        int playerChoice = sc.nextInt();
        sc.nextLine();

        if (playerChoice == 1) {
            menu.start();
        } else {
            System.out.println("Liste des Personnages existants   ");
            List<Player> players = playerDAO.getAllPlayers();
            for (Player player : players) {
                System.out.println(player);
                /**
                 * Method from playerDAO to getAllPlayers set in the database and display them
                 */
            }
            System.out.println("\nQuel personnage souhaitez-vous charger ?   ");
            String characterName = sc.nextLine();
            Player character = playerDAO.getPlayerByName(characterName);
            /**
             * Here the user can choose a player from the database by tipping his name
             */
            if (character != null) {
                System.out.println("Chargement player with ID: " + character.getId());
                System.out.println("Le joueur suivant a été chargé : " + character);
                Game game = new Game("IN_PROGRESS");
                game.startGame(character);
                /**
                 * Here we fr.campus.dand.print the ID of the loaded heros and display his spec
                 * Then create a new instance of Game and aplly StartGame method with the character as arguments
                 */
            } else {
                /**
                 * return short text to inform the player the name he tipped does not exist in list
                 */
                System.out.println("Le joueur n'existe pas.");
            }
        }
    }
}
