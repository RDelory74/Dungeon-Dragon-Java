package fr.campus.dand.item.philtressoin;

import fr.campus.dand.boardgame.Case;
import fr.campus.dand.engine.Player;
import fr.campus.dand.print.PrintAcs;
import fr.campus.dand.type.Wizard;

import java.util.Scanner;

public class SortCuratif extends Philtre implements Case {
    public SortCuratif() {
        super();
        setName("Sort de Soin");
        setDefense(5);
        setType("Heal");
        setValue(8);
    }

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
            System.out.println("* Tu es actuelement équipé de " + character.getDefense().getName() + ", souhaites-tu remplacer par " + getName() + " ? *");
            System.out.println("Actual attack : "+character.getDefense().getDefense()+" New attack:"+ getDefense() +"." );
            System.out.println("* 1. Oui, je la veux !! *");
            System.out.println("* 2. Non, je garde "+character.getDefense().getName()+" et laisse " +getName()+ "ici !! *");
            System.out.println("* 3. Je vais tenter de mettre ça dans mon sac *");
            int playerChoice = sc.nextInt();
            if (playerChoice == 1) {
                character.setDefense(this);
                character.setPv(character.getVie() + getDefense());
            }else if (playerChoice == 3 ){
                character.getInventory().addItem(this);
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
