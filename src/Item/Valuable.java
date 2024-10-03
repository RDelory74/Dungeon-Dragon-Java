package Item;

import BoardGame.Case;
import Donjon_Dragons.Player;
import Print.PrintAcs;

import java.util.Scanner;

public abstract class Valuable extends Item implements Case {

    //instance field

    private String name;
    private int value;
    private String consumableType;


// constructor
    public Valuable(String name) {
 this.name = name;
}

    public Valuable() {
        super();
    }

//method
@Override
public void interact (Player player, PrintAcs printThings){
    Scanner sc = new Scanner(System.in);
    System.out.println("C'est " + getName() + " veux-tu le stocker (tape 1) ?? Valeur de l'objet "+ getValue()+".");
    System.out.println("Poid de l'objet " + getWeight() + " Capacité du Sac restant:  "+ player.getInventoryCapacity()+".");
    System.out.println("Pour continuer ta route (Tape entrée");
    int playerChoice = sc.nextInt();
    if(playerChoice == 1 ){
        System.out.println("C'est " + getName() + " Elle rentre dans le sac.");
        player.addItemToInventory(this,this.getWeight());
    }
}
    public abstract void use ();
    public String toString() {
        return "A vendre";
    }


//getter setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    public String getType() {
        return consumableType;
    }
    
    public void setType(String type) {
        this.consumableType = consumableType;
    }

}

