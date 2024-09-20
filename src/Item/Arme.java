package Item;

public  class Arme extends Weapon {

// constructor
    public Arme(String name,int attack, String type) {

        setName(name);
        setAttack(attack);
        setWeaponType(type);
    }
    public Arme() {
    }
//method
    @Override
    public  void use (){
    }
    @Override
    public String toString() {
        return "Chling!";
    }


}

