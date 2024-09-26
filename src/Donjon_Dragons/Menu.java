package Donjon_Dragons;

import Print.PrintAcs;
import Type.Warrior;
import Type.Wizard;

import java.util.Scanner; //J'appel les fonctions utiles


public class Menu  {
    public void start() {
        //Attributs
        Scanner sc = new Scanner(System.in);
        String characterType = "";
        Player character= null;
        PrintAcs printThings = new PrintAcs();
        //Création du perso pour le faire ne méthode il faut bien que je déclare ma méthode avec le type de retour désiré à savoir un Player
        System.out.println("             ******** Welcome to Dungeons & Dragons! ********");
        System.out.println("              ******** Let's create a new player ********");
        while (!characterType.equals("Type.Warrior") && !characterType.equals("Type.Wizard")) { // boucle qui dit que tant que Type.Warrior
            System.out.println("\n\nEnter your character Type: Choose Warrior or Wizard: ");
            System.out.println("1. Type.Warrior");
            System.out.println("2. Type.Wizard");
            int typeChoice = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter your character name: "); // utilisation de scanner pour créer son perso
            String characterName = sc.nextLine();
            if (typeChoice == 1) {
                character = new Warrior(characterName);
                characterType = "Type.Warrior";
                printThings.Print("warrior");

            } else if (typeChoice == 2) {
                character = new Wizard(characterName);
                characterType = "Type.Wizard";
                printThings.Print("wizard");
            } else {
                System.out.println("Aucun personnage n'a été créé.");
            }
        }
    // appel aux méthodes
        textPrez(character);
        afficherMenuAccueil(sc,character);
    }


    public void textPrez(Player character){
        if (character != null) {
            System.out.println("C'est alors que des entrailles de l'abysse jaillit notre nouveau héros: \n " + character.toString());
        } else {
            System.out.println("Aucun personnage n'a été créé.");
        }
    }

    public void afficherMenuAccueil(Scanner sc,Player character){
        while (true) { // Remplacement possible par un tant que choice !=3
            System.out.println("\n**** Donjon_Dragons.Menu ****:");
            System.out.println("*1. Voir Info Héros*");
            System.out.println("*2. Modifier infos Héros*");
            System.out.println("*3. Entrez dans l'aventure*");
            System.out.println("*0. Exit*");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.println("\n*** Info Héros ***");
                System.out.println(character.toString());
            } else if (choice == 2) {

                System.out.println("Enter your character Type Choose Type.Warrior or Type.Wizard: ");
                System.out.println("1. Type.Warrior");
                System.out.println("2. Type.Wizard");
             modifierInfoPerso(sc,character);
            } else if (choice == 3) {
                Game game = new Game(64);  // Crée une instance de Game
                game.startGame(character);

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
public void modifierInfoPerso(Scanner sc,Player character){
    int typeChoice = sc.nextInt();
    sc.nextLine();
    System.out.print("Enter your character name: "); // utilisation de scanner pour créer son perso
    String characterName = sc.nextLine();
    if (typeChoice == 1 ){
        character = new Warrior (characterName);
    } else if (typeChoice == 2) {
        character = new Wizard (characterName);
    } else {
        System.out.println("Invalid choice. Try again.");
    }
}

    }


