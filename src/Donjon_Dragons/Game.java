package Donjon_Dragons;
import BoardGame.Case;
import BoardGame.Empty;
import BoardGame.Ennemis;
import Item.Arme;
import Item.Bouclier;
import Item.Potion;
import Print.PrintAcs;
import myExceptions.PersonnageHorsPlateauException;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Game {


    //Attributs
    private int currentCase;
    private  String gameState;
    private ArrayList<Case> plateau;
    private int maxCase;



    // constructor

    public Game (String gameState){
        this.gameState = gameState;
        this.currentCase = 1;
        this.plateau = new ArrayList<>(64);

        disposeMesElements();


    }
    // method
    public void startGame (Player character){
        PrintAcs printThings = new PrintAcs();
        Menu menu = new Menu();
        String gameState ="IN_PROGRESS";

        textPrezCave(character,printThings);

        do {
            jouer_un_tour(character, printThings);
        } while(gameState.equals("IN_PROGRESS"));

        if(gameState.equals("FINISHED")) {
            System.out.println("\n\n********** Veux-tu recommencer une partie  ??? **********");
            printThings.Print("victory");
            menu.start();
        }
    }

    public void jouer_un_tour(Player character,PrintAcs printThings){
        Scanner sc = new Scanner(System.in);





        while(gameState.equals("IN_PROGRESS")&& character.getVie()>=0){

            System.out.println("\n\n********** "+character.getName() + " es sur la case n°"+ currentCase +"!!! **********\n");
            System.out.println("\nQue fais-tu "+ character.getName() + "?? :");
            System.out.println("* Appuis sur 1 pour lancer un dé !!! *");
            System.out.println("* Appuis sur 0 pour quitter la partie et retourner au Menu !!! *");
            System.out.println("* Appuis sur 3 pour Pour voir tes infos  *");

            System.out.print("Que faits-tu ? ");
            int playerChoice = sc.nextInt();
            if(playerChoice == 0 ){
                break;
            } else if (playerChoice==1) {
                try {
                    //System.out.print("Entre le type de dé que tu souhaites lancer: (4, 6, 8, 10, 12, 20): \n\n");
                    //int diceType = sc.nextInt();
                    //int diceRoll = random.nextInt(diceType) + 1;
                    int diceRollPipped =  1;
                    currentCase += diceRollPipped;
                    //System.out.println("*** Tu as fait un " + diceRoll + " avec un dé " + diceType + ". ***\n\n");
                    if (currentCase > plateau.size()) {
                        throw new PersonnageHorsPlateauException("********** Bravo tu as terminé ce Donjon !!! **********" );
                    } else if (currentCase <= plateau.size()) {
                        // Récupérer la case actuelle du plateau
                        Case currentPlateauCase = plateau.get(currentCase - 1);  // -1 car les indices commencent à 0
                        System.out.println("Tu arrives sur une nouvelle case : " + currentPlateauCase);
                        // Interaction avec la case
                        currentPlateauCase.interact(character,printThings);
                    }
                } catch(PersonnageHorsPlateauException e) {
                    System.out.println(e.getMessage());
                    printThings.Print("victory");
                    gameState = "FINISHED";
                    break;
                }
            } else if (playerChoice == 3){
                System.out.println(character);
            }
        }

    }

    public void textPrezCave(Player character, PrintAcs printThings){
        System.out.println("\n\n********** Welcome in the Dragon's Cave !!! "+ character.getName() +" **********");
        printThings.Print("dragonCave");
        System.out.println("\n\nTu te tiens à l'entrée d'une grotte sombre, l'air froid te glaçant la peau.\n" +
                "Des grondements lointains résonnent, annonçant la présence d'un terrible dragon en son cœur.");
    }

    public void disposeMesElements(){
        Random random = new Random();

        int ennemisElements = 10;
        int weaponsElements = 10;
        int potionElements = 10;
        int defenseElements = 10;
        int emptyElements = plateau.size() - (ennemisElements+weaponsElements+potionElements+defenseElements);

        for (int i = 0; i < ennemisElements; i ++){
            plateau.add(new Ennemis("Ennemis " +(i +1), random.nextInt(10)+5, random.nextInt(5)+1));
        }
        for (int i = 0; i < weaponsElements; i ++){
            plateau.add(new Arme("Arme " +(i +1), random.nextInt(10)+5, "Element d'attaque"));
        }
        for (int i = 0; i < potionElements; i ++){
            plateau.add(new Potion("Potion " +(i +1), random.nextInt(1)+5, "Ca fait grand bien"));
        }
        for (int i = 0; i < defenseElements; i ++){
            plateau.add(new Bouclier("Bouclier " +(i +1), random.nextInt(10)+5, "Element de defense"));
        } for (int i = 0; i < emptyElements; i ++){
            plateau.add(new Empty(i +1));
        }
        System.out.println(plateau);
        java.util.Collections.shuffle(plateau);
        System.out.println(plateau);
    }
}
