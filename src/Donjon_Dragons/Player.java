package Donjon_Dragons;
import java.util.*;

public abstract class Player {
//instance field
    private String name;
    private int pv;
    private int strength;
    private String weapon;
    private String defense;
    private String type;

    // constructor

    public Player(String name) {
        Scanner scan = new Scanner (System.in);
        this.name = scan.nextLine();
    }

    public Player() {
    }


//method
public abstract void attack();

    public String toString() {
        return  "Nom:  " + this.name +
                "// Points de vie:   " + this.pv +
                "// Force:  " + this.strength +
                "// Arme: " + this.weapon +
                "// Défense:   " + this.defense+
                "// Type: " + this.type;
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
}

