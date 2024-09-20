package Item;

public abstract class Weapon {

    //Attributs
    private String name;
    private int attack;
    private String weaponType;


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

}

