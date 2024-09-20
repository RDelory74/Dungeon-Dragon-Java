import java.util.Scanner;
import java.awt.event.KeyEvent;
import java.util.Random;



public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Dungeons & Dragons!");
        System.out.println("Let's create a new player");


        System.out.print("Enter your character name: ");
        String characterName = sc.nextLine();
        System.out.print("Enter your character Type Choose Warrior or Wizard: ");
        String characterType = sc.nextLine();

        if( characterType.equals("Warrior")||characterType.equals("Wizard")) {
            Character character = new Character(characterName, characterType);

        System.out.println("C'est alors que des entrailles de l'abysse jailli notre nouveau héros: \n " + character.toString());


        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Voir Info Héros");
            System.out.println("2. Modifier infos Héros");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                System.out.println("Info Héros");
                System.out.println("Name :" + character.getName() +
                        "\n" + "PV :" + character.getVie() +
                        "\n" + "Force :" + character.getStrength() +
                        "\n" + "Arme :" + character.getWeapon() +
                        "\n" + "Defense :" + character.getDefense() +
                        "\n" + "Type :" + character.getType() +
                        "\n");
            } else if (choice == 2) {
                System.out.println("\nModifier Héros:");
                System.out.println("1. Modifier Nom");
                System.out.println("2. Modifier Type");
                System.out.println("0. Back");
                System.out.print("Enter your choice: ");
                int custChoice = sc.nextInt();
                if (custChoice == 0) {
                    System.out.println("Retour au menu");
                } else if (custChoice == 1) {
                    System.out.println("Nouveau nom du Héros:");
                    sc.nextLine();
                    character.setName(sc.nextLine());
                    System.out.println("Le nouveau nom du héros a bien été remplacé par: "+character.getName());
                } else if (custChoice == 2) {
                    System.out.println("Nouveau type de Héros (Wizard ou Warrior): ");
                    sc.nextLine();
                    character.setType(sc.nextLine());
                    System.out.println("Le nouveau type du héros a bien été remplacé par: "+character.getType());
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        }else {
            System.out.println("Invalid choice. Try again.");
        }

    }

}
