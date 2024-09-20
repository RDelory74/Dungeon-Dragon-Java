import java.util.Scanner;
import java.util.Random;

public class Game {

    //instance field
    private int currentCase, maxCase;

    // class
    public Game (int maxCase){
        this.maxCase = maxCase;
        this.currentCase = 1;
    }
    // method
    public void startGame (){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        // implémenter in (if) player already came's here
        System.out.println("\n\n********** Welcome in the Dragon's Cave !!! **********");
        System.out.println("              ___====-_  _-====___\n" +
                "         _--^^^#####//      \\\\#####^^^--_\n" +
                "      _-^##########// (    ) \\\\##########^-_\n" +
                "     -############//  |\\^^/|  \\\\############-\n" +
                "   _/############//   (@::@)   \\\\############\\_\n" +
                "  /#############((     \\\\//     ))#############\\\n" +
                " -###############\\\\    (oo)    //###############-\n" +
                "-#################\\\\  / \" \" \\  //#################-\n" +
                "-###################\\\\/  (    ) \\//##################-\n" +
                "_#/|##########/\\######(   '  )######/\\##########|\\#_\n" +
                " |/ |#/\\#/\\#/\\/  \\#\\##\\    )\\##/  \\/\\/\\/#/\\#/\\| \\");
        System.out.println("\n\nTu te tiens à l'entrée d'une grotte sombre, l'air froid te glaçant la peau.\nDes grondements lointains résonnent, annonçant la présence d'un terrible dragon en son cœur.");

        while( currentCase<=maxCase){
            System.out.println("\n\n********** Tu es sur la case n°"+ currentCase +"!!! **********\n");
            System.out.println("\nQue fais-tu ?? :");
            System.out.println("* Appuis sur 1 pour lancer un dé !!! *");
            System.out.println("* Appuis sur 0 pour retourner au Menu !!! *");
            System.out.print("Que faits-tu ? ");
            int playerChoice = sc.nextInt();
            if(playerChoice == 0 ){
                break;
            } else if (playerChoice==1){
                System.out.print("Entre le type de dé que tu souhaites lancer: (4, 6, 8, 10, 12, 20): \n\n");
                int diceType = sc.nextInt();
                int diceRoll = random.nextInt(diceType) + 1;
                currentCase += diceRoll;
                System.out.println("*** "+ Character.getName() + " a fait un " + diceRoll + " avec un dé " + diceType + ". ***\n\n");
            }

        }
        System.out.println("\n\n********** Bravo tu es arrivé au bout de la Dragon's Cave !!! **********");
    }
    public static void main (String[] args){
        new Game(64).startGame();
    }
}
