package fr.campus.dand.item.armures;

import fr.campus.dand.boardgame.Case;
import fr.campus.dand.engine.Player;
import fr.campus.dand.item.Defense;
import fr.campus.dand.print.PrintAcs;
import fr.campus.dand.type.Warrior;

import java.util.Scanner;

public class Bouclier extends Defense implements Case {


// constructor
    public Bouclier(String name, int defense, String type) {
        super();
        setName(name);
        setDefense(defense);
        setType(type);
        setWeight(2);
        setValue(10);
    }

    public Bouclier() {
        super();

    }
//method

@Override
public String toString() {
    return "\n"+ "** Et à terre tu aperçois " + getName() + "**"+"\n"+
            "------------ "+getName()+"\n"+
            "|Defense     "+getDefense()+"\n"+
            "|Type:       "+getType()+"\n"+
            "------------------------\n";
}

    @Override
    public void interact (Player character, PrintAcs printThings){
        Scanner sc = new Scanner(System.in);

        if(character instanceof Warrior) {
            System.out.println("* Tu es actuelement équipé de " + character.getDefense().getName() + ", souhaites-tu remplacer par " + getName() + " ? *");
            System.out.println("Actual Defense : "+character.getDefense().getDefense()+" New defense:"+ getDefense() +"." );
            System.out.println("* 1. Oui, je la veux !! *");
            System.out.println("* 2. Non, je garde "+character.getDefense().getName()+" et laisse " +getName()+ " ici !! *");
            System.out.println("* 3. Je vais tenter de mettre ça dans mon sac *");
            int playerChoice = sc.nextInt();
            if (playerChoice == 1) {
                character.setDefense(this);
                character.setPv(character.getVie() + getDefense());
            }else if (playerChoice == 3 ){
                character.addItemToInventory(this,this.getWeight());
            }
        }

        else {
            System.out.println("* Elle est si belle, mais même à deux mains tu ne peux la lever *");
            }
        }

    @Override
    public void use(){
        System.out.println("* C'est beau, ceci est une méthode use *");
    }


}

