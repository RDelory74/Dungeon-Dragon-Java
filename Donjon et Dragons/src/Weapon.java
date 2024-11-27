

public class Weapon {

    //instance field
    private String name;
    private int attack;
    private String weaponType;


// constructor
    public Weapon(String weaponType) {
        if(weaponType.equals("weapon")){
            this.name = "Epee";
            this.attack = 10;

        } else if (weaponType.equals("spell")){
            this.name = "Sort";
            this.attack = 8;
        }
    }

    public Weapon() {
    }
//method
    public void chling() {
        System.out.println("Chling!");
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

    public void setsetAttack(int attack) {
        this.attack = attack;
    }

    public String getWeaponType() {
        return weaponType;
    }
    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

}

