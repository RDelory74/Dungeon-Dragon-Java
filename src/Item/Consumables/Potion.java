package Item.Consumables;
import BoardGame.Case;
import Donjon_Dragons.Player;
import Item.Consumable;
import Print.PrintAcs;

import java.util.Scanner;

public  class Potion extends Consumable implements Case {
// constructor
    public Potion(String name, int effect, String type) {
        setName(name);
        setEffect(effect);
        setType(type);
    }

    public Potion() {
    }
//method
@Override
public void interact (Player player, PrintAcs printThings){
    Scanner sc = new Scanner(System.in);
    System.out.println("C'est " + getName() + " veux-tu le stocker (tape 1) ?? Valeur de l'objet "+ getValue()+".");
    System.out.println("Poid de l'objet " + getWeight() + " Capacité du Sac restant:  "+ player.getInventoryCapacity()+".");
    System.out.println("C'est " + getName() + " veux-tu la consommer (tape 2) ?? Régénere "+ getEffect()+".");
    int playerChoice = sc.nextInt();
    if(playerChoice == 2 ){
        System.out.println("C'est " + getName() + " elle te régenère "+ getEffect()+".");
        player.setPv(player.getVie()+getEffect());
    } else if (playerChoice == 1 ){
        player.addItemToInventory(this,this.getWeight());
    }

}

    @Override
    public  void use (){

    }

    @Override
    public String toString() {
        return "\n" + "** Et à terre tu aperçois, cachée ...  " + getName() + "**" +
                "------------ " + getName() + "\n" +
                "|Defense     " + getEffect() + "\n" +
                "|Type:       " + getType() + "\n" +
                "------------------------\n";
    }
}

