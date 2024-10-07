package fr.campus.dand.item.armes;

import fr.campus.dand.boardgame.Case;
import fr.campus.dand.engine.Player;
import fr.campus.dand.item.Weapon;
import fr.campus.dand.print.PrintAcs;
import fr.campus.dand.type.Wizard;

import java.util.Scanner;


public class Arme extends Weapon implements Case {

// constructor
    public Arme(String name,int attack, String type) {
        super();
        setName(name);
        setAttack(attack);
        setWeaponType(type);
    }
    public Arme() {
        super();
    }
//method

    @Override
    public String toString() {
        return  "-------------------------------------------------------"+
                "\n\n"+"** Et à terre tu aperçois " + getName() + "**"+"\n\n"+
                "------------ "+getName()+"\n"+
                "|Attack:     "+getAttack()+"\n"+
                "|Type:       "+getWeaponType()+"\n"+
                "--------------------------------------------------------\n";
    }
    @Override
    public void interact (Player character, PrintAcs printThings){
        Scanner sc = new Scanner(System.in);

        if(character instanceof Wizard){
            System.out.println("* Elle est si belle, mais même à deux mains tu ne peux la lever *");
        } else {
            System.out.println("* Tu es actuelement équipé de "+ character.getWeapon().getName()+", souhaites-tu remplacer par "+ getName() + " ? *");
            System.out.println("Actual attack : "+character.getWeapon().getAttack()+" New attack:"+ getAttack() +"." );
            System.out.println("* 1. Oui, je la veux !! *");
            System.out.println("* 2. Non, je garde mon arme "+character.getWeapon().getName()+" et laisse " +getName()+ "ici !! *");
            System.out.println("* 3. Je vais tenter de mettre ça dans mon sac *");
            int playerChoice = sc.nextInt();
            if(playerChoice == 1 ){
                character.setWeapon(this);
                character.setStrength(character.getStrength()+getAttack());
            } else if (playerChoice == 3 ){
                character.addItemToInventory(this,this.getWeight());
            }
        }
    }
    @Override
    public void use (){
        System.out.println("Tu utilises l'arme " + getName() + " pour attaquer ! Tu infliges"+ getAttack()+".");
    }


}

