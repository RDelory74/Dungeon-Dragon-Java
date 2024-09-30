package Item;

import BoardGame.Case;
import Donjon_Dragons.Player;
import Print.PrintAcs;
import Type.Warrior;
import Type.Wizard;

import java.util.Scanner;

public class Philtre extends Defense implements Case {


    // constructor
    public Philtre(String name, int defense, String type) {

        setName(name);
        setDefense(defense);
        setType(type);
    }

    public Philtre() {
    }
//method

    @Override
    public String toString() {
        return "\n"+ "** Et à terre tu aperçois, flamboyant le prachemin " + getName() + "**"+
                "------------ "+getName()+"\n"+
                "|Defense     "+getDefense()+"\n"+
                "|Type:       "+getType()+"\n"+
                "------------------------\n";
    }

    @Override
    public void interact (Player character, PrintAcs printThings){
        Scanner sc = new Scanner(System.in);

        if(character instanceof Wizard) {
            System.out.println("* Tu es actuelement équipé de " + character.getDefense() + ", souhaites-tu remplacer par " + getName() + " ? *");
            System.out.println("* 1. Oui, je la veux !! *");
            System.out.println("* 2. Non, je garde mon " + character.getDefense() + " *");
            int playerChoice = sc.nextInt();
            if (playerChoice == 1) {
                character.setDefense(getName());
                character.setPv(character.getVie() + getDefense());
            }
        }

        else {
            System.out.println("* C'est pour le café ??  *");
        }
    }

    @Override
    public void use(){
        System.out.println("* C'est beau, ceci est une méthode use *");
    }


}

