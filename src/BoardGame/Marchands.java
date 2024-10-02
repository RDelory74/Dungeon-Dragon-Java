package BoardGame;

import Donjon_Dragons.Player;
import Item.Consumables.Potion;
import Print.PrintAcs;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public  class Marchands implements Case {

    //Attributs

    private int gold;
    private int empathie;
    private ArrayList<Potion> items;


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
        Random random = new Random();


        //Print section

        printThings.Print("merchand");


        int escapeResult = random.nextInt(7) + 1;

        System.out.println("****** Bienvenue !!! Que puis-je ? *******");
        showMarchand();
        System.out.println("****** Que souhaites-tu acheter ??  *******");
        System.out.println("****** Ton choix: ");
        int playerChoice = sc.nextInt();
        if (playerChoice==1 && character.getOr()>10 ){
            //character.addItemToInventory();
        }else if (playerChoice ==2 && character.getOr()>10 ){

        } else if (playerChoice ==3 && character.getOr()>10 ){

        } else if (playerChoice ==4 ){
            System.out.print("Au revoir");
        } else {
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

