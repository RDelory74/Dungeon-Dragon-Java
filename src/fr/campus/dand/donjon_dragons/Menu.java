package fr.campus.dand.donjon_dragons;

import fr.campus.dand.print.PrintAcs;
import fr.campus.dand.type.Warrior;
import fr.campus.dand.type.Wizard;
import fr.campus.dand.db.PlayerDAO;

import java.util.List;
import java.util.Scanner; //J'appel les fonctions utiles


public class Menu  {
    public void start() {
        //Attributs
        Scanner sc = new Scanner(System.in);
        PrintAcs printThings = new PrintAcs();
        /**
         * Instance scanner to catch the user inputs
         * Instance PrintAcs to set the visual for cthe creation heros
         */

        System.out.println("             ******** Welcome to Dungeons & Dragons! ********");
        System.out.println("              ******** Let's create a new player ********");


        // Appel aux méthodes
        Player character = creerPersonnage(sc,printThings);
        /**
         *
         * Methode to create the new Heros and fill it into the database, pass the scanner and the fr.campus.dand.print as arguments
         */
        textPrez(character);
        /**
         * Simple Method to display a short text introducing the new Player with his own name (as arguments)
         *
         */
        afficherMenuAccueil(sc,character);
        /**
         *
         * A simple While loop (which is always true) allowing the player to see his heros,
         * then to modify the Type, and finally jump into the adventure by launching the Game Classe
         * with the method StartGame. as usual we pass the character and the scanner as arguments to allow user to interact
         * and to be persistent throught the game.
         *
         *
         */


    }




    public void textPrez(Player character){
        if (character != null) {
            System.out.println("C'est alors que des entrailles de l'abysse jaillit notre nouveau héros: \n " + character.toString());
        } else {
            System.out.println("Aucun personnage n'a été créé.");
        }
        /**
         * Here's the short text introducing the player or inform if the creation method doesn't work.
         *
         */
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
                /**
                 *Getting out of the adventure
                 */
            } else if (choice == 1) {
                System.out.println("\n*** Info Héros ***");
                System.out.println(character.toString());
                /**
                 *
                 * Showing player infos
                 */
            } else if (choice == 2) {
             character = modifierInfoPerso(sc,character);
                /**
                 *
                 * Modify fr.campus.dand.type  of the player
                 */
            } else if (choice == 3) {
                Game game = new Game("IN_PROGRESS");  // Crée une instance de Game
                game.startGame(character);
                /**
                 * Instance new Game Class and apply method startGame method as arguments a String which indicate
                 * the statement of the Game allowing the loop in Game to work correctly
                 *
                 */
            } else {
                System.out.println("Invalid choice. Try again.");
                /**
                 *
                 * If the player's choice are not correctly insert
                 */
            }
        }
    }


public Player modifierInfoPerso(Scanner sc,Player character){
        //instance
        PlayerDAO playerDAO = new PlayerDAO();
     //   Player lastPlayer = playerDAO.getLastPlayer();
/**
 * Creating new instance of the connection with the database to get the already used player and to modify their fr.campus.dand.type
 */
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
        /**
         * Showing the list of the player in the database.
         */
    }
    System.out.print("Enter the character name to apply this change: "); // utilisation de scanner pour créer son perso
    String characterName = sc.nextLine();
    if (typeChoice == 1 ){
        character = new Warrior (characterName);
    } else if (typeChoice == 2) {
        character = new Wizard (characterName);
    } else {
        System.out.println("Invalid choice. Try again.");
        /**
         * Select the player by tiping the correct name of the list and creating a new instance for the new fr.campus.dand.type.
         * If the name is not correctly tipped inform the user with a short text.
         */
    }
    //return & fr.campus.dand.print
    playerDAO.updatePlayer(character);
    /**
     * Updating the database with the new selected fr.campus.dand.type as argument.
     */

    return character;
}


    public Player creerPersonnage(Scanner sc, PrintAcs printThings) {
        //Instances
        String characterType = "";
        Player character = null;
        PlayerDAO playerDAO = new PlayerDAO();
        /**
         * Creating 2 new variables:
         *
         * - one for the new player
         * - one for the choice fr.campus.dand.type allowing the creating loop to stop if the new character is done
         */
        // Mécanik
        while (!characterType.equals("Type.Warrior") && !characterType.equals("Type.Wizard")) {
            System.out.println("\n\nEnter your character Type: Choose Warrior or Wizard: ");
            System.out.println("1. Type.Warrior");
            System.out.println("2. Type.Wizard");
            int typeChoice = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter your character name: ");
            String characterName = sc.nextLine();
/**
 * Getting charcter fr.campus.dand.type and character name with the scanner method
 */
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
/**
 * Depending on the user choice the wizard fr.campus.dand.type or the warrior are created with a println to inform the user of the Id of
 * his new entry in the database, then we set the variable with the fr.campus.dand.type and we create a new player in the database
 * through the playerDAO class and the createPlayer method
 */
            } else {
                System.out.println("Choix invalide. Aucun personnage n'a été créé.");
                /**
                 * Inform the user that choice is not valid
                 */
            }
        }
        //return
        return character;  // Retourne le personnage créé
    }

}


