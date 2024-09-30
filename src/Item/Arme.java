package Item;

import BoardGame.Case;
import Donjon_Dragons.Player;
import Print.PrintAcs;
import Type.Wizard;

import java.util.Scanner;


public class Arme extends Weapon implements Case {

// constructor
    public Arme(String name,int attack, String type) {

        setName(name);
        setAttack(attack);
        setWeaponType(type);
    }
    public Arme() {
    }
//method

    @Override
    public String toString() {
        return  "\n"+"** Et à terre tu aperçois " + getName() + "**"+"\n"+
                "------------ "+getName()+"\n"+
                "|Attack:     "+getAttack()+"\n"+
                "|Type:       "+getWeaponType()+"\n"+
                "------------------------\n";
    }
    @Override
    public void interact (Player character, PrintAcs printThings){
        Scanner sc = new Scanner(System.in);

        if(character instanceof Wizard){
            System.out.println("* Elle est si belle, mais même à deux mains tu ne peux la lever *");
        } else {
            System.out.println("* Tu es actuelement équipé de "+ character.getWeapon()+", souhaites-tu remplacer par"+ getName() + " ? *");
            System.out.println("* 1. Oui, je la veux !! *");
            System.out.println("* 2. Non, je garde mon arme "+character.getWeapon()+" *");
            int playerChoice = sc.nextInt();
            if(playerChoice == 1 ){
                character.setWeapon(getName());
                character.setStrength(character.getStrength()+getAttack());
            }
        }
    }
    @Override
    public  void use (){
        System.out.println("Tu utilises l'arme " + getName() + " pour attaquer ! Tu infliges"+ getAttack()+".");
    }


}

