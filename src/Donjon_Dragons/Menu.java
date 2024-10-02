package Donjon_Dragons;

import Print.PrintAcs;
import Type.Warrior;
import Type.Wizard;
import db.PlayerDAO;

import java.util.List;
import java.util.Scanner; //J'appel les fonctions utiles


public class Menu  {
    public void start() {
        //Attributs
        Scanner sc = new Scanner(System.in);
        PrintAcs printThings = new PrintAcs();


        System.out.println("             ******** Welcome to Dungeons & Dragons! ********");
        System.out.println("              ******** Let's create a new player ********");

        // Appel aux méthodes
        Player character = creerPersonnage(sc,printThings);
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
             character = modifierInfoPerso(sc,character);
            } else if (choice == 3) {
                Game game = new Game("IN_PROGRESS");  // Crée une instance de Game
                game.startGame(character);
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }


public Player modifierInfoPerso(Scanner sc,Player character){
        //instance
        PlayerDAO playerDAO = new PlayerDAO();
     //   Player lastPlayer = playerDAO.getLastPlayer();

        //Interact et travail
    System.out.println("Enter your character new Type Choose Warrior or Wizard: ");
    System.out.println("1. Type.Warrior");
    System.out.println("2. Type.Wizard");
    int typeChoice = sc.nextInt();
    sc.nextLine();
    System.out.println("Liste des Joueurs: \n");
    List<Player> players = playerDAO.getAllPlayers();
    for (Player player : players) {
        System.out.println(player);
    }
    System.out.print("Enter the character name to apply this change: "); // utilisation de scanner pour créer son perso
    String characterName = sc.nextLine();
    if (typeChoice == 1 ){
        character = new Warrior (characterName);
    } else if (typeChoice == 2) {
        character = new Wizard (characterName);
    } else {
        System.out.println("Invalid choice. Try again.");
    }
    //return & print
    playerDAO.updatePlayer(character);

    return character;
}


    public Player creerPersonnage(Scanner sc, PrintAcs printThings) {
        //Instances
        String characterType = "";
        Player character = null;
        PlayerDAO playerDAO = new PlayerDAO();
        // Mécanik
        while (!characterType.equals("Type.Warrior") && !characterType.equals("Type.Wizard")) {
            System.out.println("\n\nEnter your character Type: Choose Warrior or Wizard: ");
            System.out.println("1. Type.Warrior");
            System.out.println("2. Type.Wizard");
            int typeChoice = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter your character name: ");
            String characterName = sc.nextLine();

            if (typeChoice == 1) {
                character = new Warrior(characterName);
                System.out.println("Creating player with ID: " + character.getId());
                characterType = "Type.Warrior";
                playerDAO.createPlayer(character);
                printThings.Print("warrior");

            } else if (typeChoice == 2) {
                character = new Wizard(characterName);
                System.out.println("Creating player with ID: " + character.getId());
                characterType = "Type.Wizard";
                playerDAO.createPlayer(character);
                printThings.Print("wizard");

            } else {
                System.out.println("Choix invalide. Aucun personnage n'a été créé.");
            }
        }
        //return
        return character;  // Retourne le personnage créé
    }

}


