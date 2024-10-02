package Item;

public abstract class Weapon extends Item {

    //Attributs


    private int attack;
    private String weaponType;


// constructor
    public Weapon(String name) {
        setName(name);
    }

    public Weapon() {
        super();
    }
//method

    public abstract void use ();


    public String toString() {
        return "Chling!";
    }


//getter setter


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

