import java.util.*;

public class Character {
//instance field
    private String name;
    private int pv;
    private int strength;
    private String weapon;
    private String defense;
    private String type;

    // constructor
public Character(String name, String type) {
    this.name = name;
    if(type.equals("Warrior")){
        this.pv = 10;
        this.strength = 10;
        this.weapon = "weapon";
        this.defense = "shields";
    } else if (type.equals("Wizard")) {
        this.pv = 6;
        this.strength = 15;
        this.weapon = "spell";
        this.defense = "potion";
    } else {
        System.out.println("Not the right type character");
    }
}


    public Character(String name) {
        this.name = name;
    }

    public Character() {
        Scanner scan = new Scanner (System.in);
        String name = scan.nextLine();
    }


//method
    public void sayYEAAHH() {
        System.out.println("yeah!");
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
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

