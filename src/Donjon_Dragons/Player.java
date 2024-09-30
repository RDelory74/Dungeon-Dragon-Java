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
    private int exp;
    private int or;
    private int level;


    // constructor

    public Player(String name) {
        Scanner scan = new Scanner (System.in);
        this.name = scan.nextLine();
        setOr(0);
        setExp(0);
        setLevel(1);
    }

    public Player() {
    }


//method
public abstract void levelUp();

    public String toString() {
        return  "Nom:  " + this.name +
                "// Points de vie:   " + this.pv +
                "// Force:  " + this.strength +
                "// Arme: " + this.weapon +
                "// Défense:   " + this.defense+
                "// Type: " + this.type +
                "// Experience: " + this.exp + "xp" +
                "// Or: " + this.or;
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
        return or;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }

    public void setOr(int or) {
        this.or = or;
    }
}

