package Donjon_Dragons;
import java.util.*;
import java.util.UUID;


public abstract class Player {
    //instance field
    private UUID id;
    private String name;
    private int pv;
    private int strength;
    private String weapon;
    private String defense;
    private String type;
    private int exp;
    private int gold;
    private int level;
    private Inventory inventory;
    private int inventoryCapacity;


    // constructor

    public Player(String name) {
        this.id = UUID.randomUUID();
        Scanner scan = new Scanner(System.in);
        this.name = scan.nextLine();
        setOr(0);
        setExp(0);
        setLevel(1);
        this.inventory = new Inventory();
        this.inventoryCapacity = 0;

    }

    public Player() {
        this.id = UUID.randomUUID();
        this.inventory = new Inventory();
        this.inventoryCapacity = 0;
    }


    //method
    public abstract void levelUp();

    public String toString() {
        return "Nom:  " + this.name +
                " || Points de vie:   " + this.pv +
                " || Force:  " + this.strength +
                " || Arme: " + this.weapon +
                " || Défense: " + this.defense +
                " || Type: " + this.type +
                " || Level: " + this.level +
                " || Or: " + this.gold;
    }

    //getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVie() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public String getType() {
        return type;
    }

    public void setType(String defense) {
        this.type = defense;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int Exp) {
        this.exp = Exp;
    }

    public int getOr() {
        return gold;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setOr(int gold) {
        this.gold = gold;
    }

    public UUID getId() {
        return id;
    }

    // Méthode d'interaction avec mon inventaire
    public boolean canCarry(int weight) {
        return (inventoryCapacity + weight) <= strength;

    }

    public void addItemToInventory(String item, int weight) {
        if (canCarry(weight)) {
            inventory.addItem(item);
            inventoryCapacity += weight;
            System.out.println(item + " a été ajouté à l'inventaire.");
        } else {
            System.out.println("Vous ne pouvez pas porter cet objet, il est trop lourd.");
        }
    }

    public void removeItemFromInventory(String item, int weight) {
        inventory.removeItem(item);
        inventoryCapacity -= weight;
    }

    public void equipItem(String item) {
        inventory.equipItem(item);
    }

    public void displayInventory() {
        inventory.displayInventory();
    }

    public Inventory getInventory() {
        if (inventory == null || inventory.isEmpty()) {
            System.out.print(" Il n'y a rien ici  !!!");
        }
            return inventory;
    }
}

