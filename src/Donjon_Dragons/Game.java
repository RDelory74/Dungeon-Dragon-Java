package Donjon_Dragons;
import BoardGame.Case;
import BoardGame.Ennemis;
import Item.Arme;
import Item.Potion;
import Print.PrintAcs;
import myExceptions.PersonnageHorsPlateauException;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Game {


    //instance field
    private int currentCase;
    private  int maxCase;

    private ArrayList<Case> plateau;



    // constructor

    public Game (int maxCase){
        this.maxCase = maxCase;
        this.currentCase = 1;
        this.plateau = new ArrayList<>();


        plateau.add(new Ennemis("Voleur",10,5));
        plateau.add(new Ennemis("Voleur",10,5));
        plateau.add(new Arme("Escalibure",5,"sword"));
        plateau.add(new Potion("Potion standard",2,"healPotion"));

    }
    // method
    public void startGame (Player character){
        PrintAcs printThings = new PrintAcs();

        textPrezCave(character,printThings);

        jouer_un_tour(character,printThings);

        if(currentCase <= maxCase) {
            System.out.println("\n\n********** Bravo tu es arrivé au bout de la Dragon's Cave !!! **********");
            printThings.Print("victory");
        }
    }

    public void jouer_un_tour(Player character,PrintAcs printThings){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        Ennemis ennemis = new Ennemis();



        while( currentCase<=maxCase){

            System.out.println("\n\n********** "+character.getName() + " es sur la case n°"+ currentCase +"!!! **********\n");
            System.out.println("\nQue fais-tu "+ character.getName() + "?? :");

            System.out.println("* Appuis sur 1 pour lancer un dé !!! *");
            System.out.println("* Appuis sur 0 pour quitter la partie et retourner au Menu !!! *");
            System.out.print("Que faits-tu ? ");
            int playerChoice = sc.nextInt();
            if(playerChoice == 0 ){
                break;
            } else if (playerChoice==1) {
                try {
                    System.out.print("Entre le type de dé que tu souhaites lancer: (4, 6, 8, 10, 12, 20): \n\n");
                    int diceType = sc.nextInt();
                    //int diceRoll = random.nextInt(diceType) + 1;
                    int diceRollPipped =  1;
                    currentCase += diceRollPipped;
                    //System.out.println("*** Tu as fait un " + diceRoll + " avec un dé " + diceType + ". ***\n\n");
                    if (currentCase > maxCase) {
                        throw new PersonnageHorsPlateauException("********** Tu es allé trop loin gros !!! **********" );
                    }else if (currentCase <= plateau.size()) {
                        // Récupérer la case actuelle du plateau
                        Case currentPlateauCase = plateau.get(currentCase - 1);  // -1 car les indices commencent à 0
                        System.out.println("Tu arrives sur une nouvelle case : " + currentPlateauCase);
                        // Interaction avec la case
                        currentPlateauCase.interact(character);
                    }
                } catch(PersonnageHorsPlateauException e) {
                    System.out.println(e.getMessage());
                    printThings.Print("death");
                    break;
                }
            }
        }
    }
    public void textPrezCave(Player character, PrintAcs printThings){
        System.out.println("\n\n********** Welcome in the Dragon's Cave !!! "+ character.getName() +" **********");
        printThings.Print("dragonCave");
        System.out.println("\n\nTu te tiens à l'entrée d'une grotte sombre, l'air froid te glaçant la peau.\n" +
                "Des grondements lointains résonnent, annonçant la présence d'un terrible dragon en son cœur.");
    }
}
