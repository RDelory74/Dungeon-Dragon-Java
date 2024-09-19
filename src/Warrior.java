public class Warrior {
//instance field
    private String name;
    private int pv;
    private int strength;
    private String weapon;
    private String defense;

// constructor
    public Warrior(String name, int pv, int strength, String weapon, String defense) {
        this.name = name;
        this.pv = pv;
        this.strength = strength;
        this.weapon = weapon;
        this.defense = defense;
    }

    public Warrior() {
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
}

