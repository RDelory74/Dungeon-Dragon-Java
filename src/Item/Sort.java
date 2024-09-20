package Item;

public  class Sort extends Weapon {


// constructor
    public Sort(String name, int attack, String type) {
        setName(name);
        setAttack(attack);
        setWeaponType(type);
    }

    public Sort() {
    }
//method
    @Override
    public  void use (){

    }

    @Override
    public String toString() {
        return "Bzouing!";
    }


}

