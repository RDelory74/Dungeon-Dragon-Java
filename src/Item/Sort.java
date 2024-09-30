package Item;

import BoardGame.Case;
import Donjon_Dragons.Player;
import Print.PrintAcs;
import Type.Wizard;

import java.util.Scanner;


public class Sort extends Weapon implements Case {

    // constructor
    public Sort(String name,int attack, String type) {

        setName(name);
        setAttack(attack);
        setWeaponType(type);
    }
    public Sort() {
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
    public void interact (Player character, PrintAcs printThings){
        Scanner sc = new Scanner(System.in);

        if(character instanceof Wizard){
            System.out.println("* Tu es actuelement équipé de "+ character.getWeapon()+", souhaites-tu remplacer par"+ getName() + " ? *");
            System.out.println("* 1. Oui, je le veux !! *");
            System.out.println("* 2. Non, je garde mon arme "+character.getWeapon()+" *");
            int playerChoice = sc.nextInt();
            if(playerChoice == 1 ){
                character.setWeapon(getName());
                character.setStrength(character.getStrength()+getAttack());
            }
        } else {
            System.out.println("* C'est bô ... mais qu'est ce que c'est ??  *");
        }
    }
    @Override
    public  void use (){
        System.out.println("Tu utilises l'arme " + getName() + " pour attaquer ! Tu infliges"+ getAttack()+".");
    }


}

