package Item.Sortileges;

import BoardGame.Case;
import Donjon_Dragons.Player;
import Item.Weapon;
import Print.PrintAcs;
import Type.Wizard;

import java.util.Scanner;


public class Sort extends Weapon implements Case {

    // constructor
    public Sort(String name,int attack, String type) {

        setName(name);
        setAttack(attack);
        setWeaponType(type);
        setWeight(1);
    }
    public Sort() {
        setWeight(1);
    }
//method

    @Override
    public String toString() {
        return  "\n"+"** Et à terre, flamboyant, tu aperçois " + getName() + "**"+"\n"+
                "------------ "+getName()+"\n"+
                "|Attack:     "+getAttack()+"\n"+
                "|Type:       "+getWeaponType()+"\n"+
                "------------------------\n";
    }
    @Override
    public void interact (Player character, PrintAcs printThings) {
        Scanner sc = new Scanner(System.in);

        if (character instanceof Wizard) {
            System.out.println("* Tu es actuelement équipé de " + character.getWeapon().getName() + ", souhaites-tu remplacer par" + getName() + " ? *");
            System.out.println("Actual attack : " + character.getWeapon().getAttack() + " New attack:" + getAttack() + ".");
            System.out.println("* 1. Oui, je le veux !! *");
            System.out.println("* 2. Non, je garde mon sort " + character.getWeapon().getName() + " *");
            System.out.println("* 3. Je vais tenter de mettre ce truc dans mon sac *");
            int playerChoice = sc.nextInt();
            if (playerChoice == 1) {
                character.setWeapon(this);
                character.setStrength(character.getStrength() + getAttack());
            } else if (playerChoice == 3) {
                character.addItemToInventory(this,this.getWeight());

            }
        }
    }
    @Override
    public  void use (){
        System.out.println("Tu utilises l'arme " + getName() + " pour attaquer ! Tu infliges"+ getAttack()+".");
    }


}

