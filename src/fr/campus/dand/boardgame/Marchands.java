package fr.campus.dand.boardgame;

import fr.campus.dand.engine.Player;
import fr.campus.dand.item.consumables.Potion;
import fr.campus.dand.print.PrintAcs;

import java.util.ArrayList;
import java.util.Scanner;


public  class Marchands implements Case {

    //Attributs

    private int gold;
    private int empathie;
    private ArrayList<Potion> items;

    /**
     * Create merchant class to trade with the player items
     * We use an ArrayList of potion items tha we manually fill (in the future a random method will do this automatically)
     *
     * FOR INFO this class is not implemented in the board yet because few settings have to be done to make it fully
     * functional, especially in the choice of the items stock, the price and a method allowing the player to sell items.
     *
     * The empathie variable would affect the price of the items.
     *
     * @param gold
     * @param empathie
     */

    //Constructor
    public Marchands(int gold, int empathie) {
        this.gold = gold;
        this.empathie = empathie;
        this.items = new ArrayList<>(4);
        items.add(new Potion("La Goudale",10,"Heal"));
        items.add(new Potion("La Genevoise",8,"Heal"));
        items.add(new Potion("La Vraie",12,"Heal"));
    }

    public Marchands() {
    }
    //methods


    @Override
    public String toString() {
        return "\n" +
                "------------ Marchands\n" +
                "|Or:         " + gold + "\n" +
                "|Empathie:    " + empathie + "\n" +
                "------------------------\n";
    }

    @Override
    public void interact(Player character, PrintAcs printThings) {
        Scanner sc = new Scanner(System.in);


        //Print section
/**
 * Short picture and text to introduce the merchant and let choice to the player to choose and fr.campus.dand.item to buy.
 */
        printThings.Print("merchand");


        System.out.println("****** Bienvenue !!! Que puis-je ? *******");
        /**
         * showMarchands method to show the ArrayList of items to the player
         */
        showMarchand();
        System.out.println("****** Que souhaites-tu acheter ??  *******");
        System.out.println("****** Ton choix: ");
        System.out.println("****** 4 Pour quitter le Marchand et continuer ********");

        /**
         * Depending on the choice of the player we use addItemToInventory under 2  conditions:
         *  - corresponding the choice of the player
         *  - the player have enought gold to pay
         *  If those 2 condtions are ok so we add the fr.campus.dand.item to the player inventory and we took off the value of the
         *  player gold.
         */
        int playerChoice = sc.nextInt();
        if (playerChoice==1 && character.getOr()>10 ){
            //character.addItemToInventory();
            //character.setOr() = character.getOr(-10);
        }else if (playerChoice ==2 && character.getOr()>10 ){
            //character.addItemToInventory();
            //character.setOr() = character.getOr(-10);
        } else if (playerChoice ==3 && character.getOr()>10 ){
            //character.addItemToInventory();
            //character.setOr() = character.getOr(-10);
        } else if (playerChoice ==4 ){
            /**
             * Choice to the player to quit the merchant
             */
            System.out.print("Au revoir");
        } else if (character.getOr() < 10) {
            /**
             * If the player doesn't have enought money
             */
            System.out.print("Reviens quand tu auras de l'argent");
        }

    }

    public void showMarchand (){
        for (int i = 0; i < items.size(); i ++){
            System.out.println(items.get(i+1).toString());
        }
    }


    //getter setter
    public int getGold() {
        return gold;
    }

    public int getEmpathie() {
        return empathie;
    }

    public ArrayList<Potion> getItems() {
        return items;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setEmpathie(int empathie) {
        this.empathie = empathie;
    }

    public void setItems(ArrayList<Potion> items) {
        this.items = items;
    }
}

