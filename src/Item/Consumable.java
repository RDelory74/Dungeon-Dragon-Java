package Item;

import BoardGame.Case;
import Donjon_Dragons.Player;
import Print.PrintAcs;


import java.util.Scanner;

public abstract class Consumable extends Item implements Case {

    //instance field

    private String name;
    private int effect;
    private String defenseType;


    // constructor
    public Consumable(String name) {
        this.name = name;
    }

    public Consumable() {
        super();
    }

    //method
    public abstract void use();

    public String toString() {
        return "A consommer";
    }

    @Override
    public void interact (Player player, PrintAcs printThings){
        Scanner sc = new Scanner(System.in);
        System.out.println("C'est " + getName() + " veux-tu le stocker (tape 1) ?? Valeur de l'objet "+ getValue()+".");
        System.out.println("Poid de l'objet " + getWeight() + " Capacité du Sac restant:  "+ player.getInventoryCapacity()+".");
        System.out.println("C'est " + getName() + " veux-tu l'utiliser' (tape 2) ?? Effet "+ getEffect()+".");
        int playerChoice = sc.nextInt();
        if(playerChoice == 2 ){
            System.out.println("C'est " + getName() + " elle a pour effet "+ getEffect()+".");
            player.setPv(player.getVie()+getEffect());
        } else if (playerChoice == 1 ){
            player.addItemToInventory(this,this.getWeight());
        }

    }



//getter setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public String getType() {
        return defenseType;
    }
    
    public void setType(String type) {
        this.defenseType = defenseType;
    }

}

