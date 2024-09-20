import java.util.Scanner;
import java.util.Random;

public class Game {

    private int currentCase, maxCase;

    public Game (int maxCase){
        this.maxCase = maxCase;
        this.currentCase = 1;
    }

    public void startGame (){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("********** Welcome in the Dragon's Cave !!! **********");

        while( currentCase<=maxCase){
            System.out.println("********** Your on the case n°"+ currentCase +"!!! **********");
            System.out.println("********** Please press 1 to roll the dices !!! **********");
            System.out.println("********** Please press 0 to get back to the Menu !!! **********");
            System.out.print("Enter your choice: ");
            int playerChoice = sc.nextInt();
            if(playerChoice == 0 ){
                break;
            } else if (playerChoice==1){
                System.out.print("Enter the type of dice to roll (4, 6, 8, 10, 12, 20): ");
                int diceType = sc.nextInt();
                int diceRoll = random.nextInt(diceType) + 1;
                System.out.println(Character.getName() + " rolled a " + diceRoll + " with a " + diceType + ".");
            }

        }

    }
}
