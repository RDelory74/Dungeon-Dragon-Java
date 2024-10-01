package Item;

import BoardGame.Case;

public class EpeeBronze extends Arme implements Case {

// constructor
    public EpeeBronze(String name) {

        setName(name);
        setAttack(5);
        setWeaponType("Sword");
        setValue(20);
        setWeight(5);
    }
    public EpeeBronze() {
    }
//method

    @Override
    public String toString() {
        return  "\n"+"** Et à terre tu aperçois " + getName() + "**"+"\n"+
                "------------ "+getName()+"\n"+
                "|Attack:     "+getAttack()+"\n"+
                "|Type:       "+getWeaponType()+"\n"+
                "------------------------\n";
    }

}

