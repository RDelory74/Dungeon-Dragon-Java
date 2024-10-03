package Donjon_Dragons;

import db.PlayerDAO;
import java.util.List;
import java.util.Scanner;

public class LoadPlayer {
    public void MainChoice() {
        PlayerDAO playerDAO = new PlayerDAO();
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();


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
            }
            System.out.println("\nQuel personnage souhaitez-vous charger ?   ");
            String characterName = sc.nextLine();
            Player character = playerDAO.getPlayerByName(characterName);
            if (character != null) {
                System.out.println("Chargement player with ID: " + character.getId());
                System.out.println("Le joueur suivant a été chargé : " + character);
                Game game = new Game("IN_PROGRESS");
                game.startGame(character);
            } else {
                System.out.println("Le joueur n'existe pas.");
            }
        }
    }
}
