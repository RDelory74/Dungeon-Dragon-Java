package fr.campus.dand.engine;

import fr.campus.dand.boardgame.Case;
import fr.campus.dand.boardgame.Dragons;
import fr.campus.dand.boardgame.Empty;
import fr.campus.dand.boardgame.Gobelin;
import fr.campus.dand.item.armes.*;
import fr.campus.dand.item.armures.Adarga;
import fr.campus.dand.item.armures.Broquel;
import fr.campus.dand.item.armures.Rondelle;
import fr.campus.dand.item.consumables.Potion_Gd_Soin;
import fr.campus.dand.item.consumables.Potion_Petit_Soin;
import fr.campus.dand.item.philtressoin.SortCuratif;
import fr.campus.dand.item.robe.Robe_Apprentis;
import fr.campus.dand.item.sortileges.Sort_Apprentis;
import fr.campus.dand.item.sortileges.Sort_Eau;
import fr.campus.dand.item.sortileges.Sort_Eclair;
import fr.campus.dand.item.sortileges.Sort_Feu;
import fr.campus.dand.print.PrintAcs;
import fr.campus.dand.db.PlayerDAO;
import fr.campus.dand.myexceptions.PersonnageHorsPlateauException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    //Attributes
    private int currentCase;
    private String gameState; //a remplacer par un enum
    private ArrayList<Case> plateau;

    /**
     * Create an arrayList of Case interfaces which is named plateau
     * @param gameState
     */
    // constructor
    public Game(String gameState) {
        this.gameState = gameState;
        this.currentCase = 1;
        this.plateau = new ArrayList<>(64);
        disposeMesElements();
        /**
         * We construct the new board and we set the player position, the lenght of the array, and the statement of the
         * game at his creation. with the method disposeMesElements (which is not named correctly) we fill the ArrayList
         * with elements and shuffle it.
         */

    }

    // method
    public void startGame(Player character) {
        PrintAcs printThings = new PrintAcs();
        Menu menu = new Menu();
        String gameState = "IN_PROGRESS";
/**
 * A do while loop managing the player round (jouer_un_tour) until the Game is In_PROGRESS
 * If the Game statement is finished fr.campus.dand.print Victory display and drive back the player to the main.Menu Class
 */
        textPrezCave(character, printThings);

        do {
            jouer_un_tour(character, printThings);
        } while (gameState.equals("IN_PROGRESS"));

        if (gameState.equals("FINISHED")) {
            System.out.println("\n\n********** Veux-tu recommencer une partie  ??? **********");
            printThings.Print("victory");
            menu.start();
        }
    }

    public void jouer_un_tour(Player character, PrintAcs printThings) {
        Scanner sc = new Scanner(System.in);
/**
 * Here is the engine of a round in my Game
 * A While Loop running until the Game statement is IN_PROGRESS and the player life is over zero life.
 * Each iteration fr.campus.dand.print the CurrentCase of the player and ask him what does he want to do (Que fais-tu?)
 */
        while (gameState.equals("IN_PROGRESS") && character.getVie() >= 0) {

            System.out.println("\n\n********** " + character.getName() + " es sur la case n°" + currentCase + "!!! **********\n");
            System.out.println("\nQue fais-tu " + character.getName() + "?? :");
            System.out.println("*  1 Lancer un Dé !!! *");
            System.out.println("*  2 Quitter le jeu *");
            System.out.println("*  3 Infos Heros  *");
            System.out.println("*  4 Sauvegarder le Heros  *");
            System.out.println("*  5 Ouvrir l'inventaire  *");
/**
 * Short list of the allowed actions with number that we can require through the scanner.
 */
            System.out.print("Que faits-tu ? ");
            int playerChoice = sc.nextInt();
            if (playerChoice == 2) {
                /**
                 * Here we start a new Menu allowing the player to quit the Game and restart a new one with an old heros
                 * or with a new one with the MainChoice() method.
                 */
                LoadPlayer loadPlayer = new LoadPlayer();
                loadPlayer.MainChoice();
            } else if (playerChoice == 1) {
                /**
                 * Here is the dice mechanic as needed for the tests my dice is cheated allowing me to test every case of the Array
                 * But if we set back the variables it allows the player to choose the dice he wants to use, then it sets a random number
                 * bounded by the value of the dice he chose before, then we set the current Player position with this value ( currentCase += diceRoll;)
                 * Finally it's a threw Exception conditioning    if the player get over the Array lenght a catch fr.campus.dand.print the new exception sentence,
                 * an instanced fr.campus.dand.print select by his string arguments, a new statement foir the Game as Finished to cut the loop StartGame and a break to quit this one.
                 */
                try {
                    Random random = new Random();
                    System.out.print("Entre le fr.campus.dand.type de dé que tu souhaites lancer: (4, 6, 8, 10, 12, 20): \n\n");
                    int diceType = sc.nextInt();
                    int diceRoll = random.nextInt(diceType) + 1;
                    //int diceRollPipped = 1;
                    currentCase += diceRoll;
                    //System.out.println("*** Tu as fait un " + diceRoll + " avec un dé " + diceType + ". ***\n\n");
                    if (currentCase > plateau.size()) {
                        throw new PersonnageHorsPlateauException("********** Bravo tu as terminé ce Donjon !!! **********");
                    } else if (currentCase <= plateau.size()) {
                        // Récupérer la case actuelle du plateau
                        Case currentPlateauCase = plateau.get(currentCase - 1);  // -1 car les indices commencent à 0
                        System.out.println("Tu arrives sur une nouvelle case : " + currentPlateauCase);
                        // Interaction avec la case
                        currentPlateauCase.interact(character, printThings);
                    }
                } catch (PersonnageHorsPlateauException e) {
                    System.out.println(e.getMessage());
                    printThings.Print("victory");
                    gameState = "FINISHED";
                    break;
                }
            } else if (playerChoice == 3) {
                /**
                 * Here it allows the player to check his specs at any round
                 */
                System.out.println(character);
            } else if (playerChoice == 4) {
                /**
                 * Here we create a new instance of the connection with the database to allow player to save his heros.
                 * The class player DAO with the method updatePlayer with the character arguments( the player)
                 */
                PlayerDAO playerDAO = new PlayerDAO();
                System.out.println("Updating player with ID: " + character.getId());
                playerDAO.updatePlayer(character);
            } else if (playerChoice == 5) {
                /**
                 * Here a method of the character cLass allow the player to show the Inventory array
                 */
                character.getInventory().showInventory();
            }
        }

    }

    public void textPrezCave(Player character, PrintAcs printThings) {
        System.out.println("\n\n********** Welcome in the Dragon's Cave !!! " + character.getName() + " **********");
        printThings.Print("dragonCave");
        System.out.println("\n\nTu te tiens à l'entrée d'une grotte sombre, l'air froid te glaçant la peau.\n" +
                "Des grondements lointains résonnent, annonçant la présence d'un terrible dragon en son cœur.");
    }

    public void disposeMesElements() {
        Random random = new Random();
        /**
         * The method that fill the ArrayList Case interface (plateau) with elements Class
         * By creating variable we can decide of the number of ennemis, and objects.
         * Finally, a variable (emptyElements) will automatically calculate the number of Empty Cases
         */
        int dragonsElements = 4;
        int sorciersElements = 5;
        int gobelinsElements = 10;
        int epeeElements = 4;
        int massueElements = 4;
        int potionElements = 5;
        int defenseElements = 5;
        int sortilegElements = 6;
        int emptyElements = plateau.size() - (sortilegElements+massueElements + gobelinsElements + sorciersElements + dragonsElements + epeeElements + potionElements + defenseElements);

        for (int i = 0; i < dragonsElements; i++) {
            plateau.add(new Dragons("Dragon"));
        }
        for (int i = 0; i < sorciersElements; i++) {
            plateau.add(new Gobelin("Sorcier"));
        }
        for (int i = 0; i < gobelinsElements; i++) {
            plateau.add(new Gobelin("Gobelin"));
        }
        /**
         * For each fr.campus.dand.type of objects we let a random choice to the loop to add new elements with a switch
         */
        for (int i = 0; i < epeeElements; i++) {
            int epeeChoice = random.nextInt(epeeElements);
            switch (epeeChoice) {
                case 0:
                    plateau.add(new Excalibur());
                case 1:
                    plateau.add(new EpeeBronze());
                case 2:
                    plateau.add(new EpeeGold());
                case 3:
                    plateau.add(new EpeeTitane());
            }
        }
        for (int i = 0; i < massueElements; i++) {
            int epeeChoice = random.nextInt(massueElements);
            switch (epeeChoice) {
                case 0:
                    plateau.add(new TheMassue());
                case 1:
                    plateau.add(new MassueBronze());
                case 2:
                    plateau.add(new MassueGold());
                case 3:
                    plateau.add(new MassueTitane());
            }
        }
        for (int i = 0; i < potionElements; i++) {
            int dispacthChoice = random.nextInt(potionElements);
            switch (dispacthChoice) {
                case 0:
                    plateau.add(new Potion_Petit_Soin());
                case 1:
                    plateau.add(new Potion_Gd_Soin());
            }
        }
        for (int i = 0; i < defenseElements; i++) {
            int dispacthChoice = random.nextInt(defenseElements);
            switch (dispacthChoice) {
                case 0:
                    plateau.add(new Robe_Apprentis());
                case 1:
                    plateau.add(new Rondelle());
                case 2:
                    plateau.add(new Adarga());
                case 3:
                    plateau.add(new Broquel());
            }
        }
        for (int i = 0; i < sortilegElements; i++) {
            int dispacthChoice = random.nextInt(sortilegElements);
            switch (dispacthChoice) {
                case 0:
                    plateau.add(new Sort_Apprentis());
                case 1:
                    plateau.add(new Sort_Eau());
                case 2:
                    plateau.add(new Sort_Eclair());
                case 3:
                    plateau.add(new Sort_Feu());
                case 4:
                    plateau.add(new SortCuratif());
            }
        }
        for (int i = 0; i < emptyElements; i++) {
            plateau.add(new Empty());
        }

        /**
         * Finally we shuffle the Array with the Collections. shuffle method
         */
        java.util.Collections.shuffle(plateau);
            // System.out.println(plateau);
        }
    }
