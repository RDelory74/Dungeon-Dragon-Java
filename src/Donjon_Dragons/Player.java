package Donjon_Dragons;
import Item.Weapon;
import Item.Defense;
import Item.Item;

import java.util.*;
import java.util.UUID;


public abstract class Player {
    //instance field
    private UUID id;
    private String name;
    private int pv;
    private int strength;
    private Weapon weapon;
    private Defense defense;
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
                " || Arme: " + this.weapon.getName() + "("+this.weapon.getAttack()+")"+
                " || Défense: " + this.defense.getName() +"("+this.defense.getDefense()+")"+
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
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

    public int getInventoryCapacity() {
        return inventoryCapacity;
    }

    public void setInventoryCapacity(int inventoryCapacity) {
        this.inventoryCapacity = inventoryCapacity;
    }

    // Méthode d'interaction avec mon inventaire
    public boolean canCarry(int weight) {
        return (inventoryCapacity + weight) <= strength;

    }

    public void addItemToInventory(Item item, int weight) {
        if (canCarry(weight)) {
            inventory.addItem(item);
            inventoryCapacity += weight;
        } else {
            System.out.println("Vous ne pouvez pas porter cet objet, il est trop lourd.");
        }
    }

    public void removeItemFromInventory(Item item, int weight) {
        inventory.removeItem(item);
        inventoryCapacity -= weight;
    }

    public void equipItem(Item item) {
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

