package Donjon_Dragons;

import BoardGame.Case;
import BoardGame.Dragons;
import BoardGame.Empty;
import BoardGame.Gobelin;
import Item.Armes.*;
import Item.Armures.Adarga;
import Item.Armures.Bouclier;
import Item.Armures.Broquel;
import Item.Armures.Rondelle;
import Item.Consumables.Potion_Gd_Soin;
import Item.Consumables.Potion_Petit_Soin;
import Item.PhiltresSoin.SortCuratif;
import Item.Robe.Robe_Apprentis;
import Item.Sortileges.Sort_Apprentis;
import Item.Sortileges.Sort_Eau;
import Item.Sortileges.Sort_Eclair;
import Item.Sortileges.Sort_Feu;
import Print.PrintAcs;
import db.PlayerDAO;
import myExceptions.PersonnageHorsPlateauException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    //Attributs
    private int currentCase;
    private String gameState; //a remplacer par un enum
    private ArrayList<Case> plateau;

    // constructor
    public Game(String gameState) {
        this.gameState = gameState;
        this.currentCase = 1;
        this.plateau = new ArrayList<>(64);
        disposeMesElements();

    }

    // method
    public void startGame(Player character) {
        PrintAcs printThings = new PrintAcs();
        Menu menu = new Menu();
        String gameState = "IN_PROGRESS";

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

        while (gameState.equals("IN_PROGRESS") && character.getVie() >= 0) {

            System.out.println("\n\n********** " + character.getName() + " es sur la case n°" + currentCase + "!!! **********\n");
            System.out.println("\nQue fais-tu " + character.getName() + "?? :");
            System.out.println("*  1 Lancer un Dé !!! *");
            System.out.println("*  2 Quitter le jeu *");
            System.out.println("*  3 Infos Heros  *");
            System.out.println("*  4 Sauvegarder le Heros  *");
            System.out.println("*  5 Ouvrir l'inventaire  *");

            System.out.print("Que faits-tu ? ");
            int playerChoice = sc.nextInt();
            if (playerChoice == 2) {
                LoadPlayer loadPlayer = new LoadPlayer();
                loadPlayer.MainChoice();
            } else if (playerChoice == 1) {
                try {
                    //System.out.print("Entre le type de dé que tu souhaites lancer: (4, 6, 8, 10, 12, 20): \n\n");
                    //int diceType = sc.nextInt();
                    //int diceRoll = random.nextInt(diceType) + 1;
                    int diceRollPipped = 1;
                    currentCase += diceRollPipped;
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
                System.out.println(character);
            } else if (playerChoice == 4) {
                PlayerDAO playerDAO = new PlayerDAO();
                System.out.println("Updating player with ID: " + character.getId());
                playerDAO.updatePlayer(character);
            } else if (playerChoice == 5) {
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
            java.util.Collections.shuffle(plateau);
            // System.out.println(plateau);
        }
    }
