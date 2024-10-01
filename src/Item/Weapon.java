package Item;

public abstract class Weapon {

    //Attributs
    private String name;
    private int attack;
    private String weaponType;
    private int weight;
    private int value;

// constructor
    public Weapon(String name) {
        this.name = name;
    }

    public Weapon() {
    }
//method

    public abstract void use ();


    public String toString() {
        return "Chling!";
    }


//getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getWeaponType() {
        return weaponType;
    }
    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}

