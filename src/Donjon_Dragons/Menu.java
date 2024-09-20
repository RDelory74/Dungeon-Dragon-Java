package Donjon_Dragons;

import Type.Warrior;
import Type.Wizard;

import java.util.Scanner; //J'appel les fonctions utiles


public class Menu  {
    public void start() {
        Scanner sc = new Scanner(System.in);
        String characterType = "";
        Player character= null;


        System.out.println("Welcome to Dungeons & Dragons!");

        System.out.println("Let's create a new player");

        while (!characterType.equals("Type.Warrior") && !characterType.equals("Type.Wizard")) { // boucle qui dit que tant que Type.Warrior
            System.out.println("Enter your character Type Choose Type.Warrior or Type.Wizard: ");
            System.out.println("1. Type.Warrior");
            System.out.println("2. Type.Wizard");
            int typeChoice = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter your character name: "); // utilisation de scanner pour créer son perso
            String characterName = sc.nextLine();
            if (typeChoice == 1) {
                character = new Warrior(characterName);
                characterType = "Type.Warrior";
            } else if (typeChoice == 2) {
                character = new Wizard(characterName);
                characterType = "Type.Wizard";
            } else {
                System.out.println("Aucun personnage n'a été créé.");
            }
        }
        System.out.println(characterType);
        if (character != null) {
            System.out.println("C'est alors que des entrailles de l'abysse jaillit notre nouveau héros: \n " + character.toString());
        } else {
            System.out.println("Aucun personnage n'a été créé.");
        }
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
            } else if (choice == 3) {
                Game game = new Game(64);  // Crée une instance de Game
                game.startGame(character);

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
    }


