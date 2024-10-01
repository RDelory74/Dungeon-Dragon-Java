package Item;

import BoardGame.Case;

public class TheMassue extends Arme implements Case {

// constructor
    public TheMassue(String name) {

        setName(name);
        setAttack(12);
        setWeaponType("Massue");
        setValue(90);
        setWeight(4);
    }
    public TheMassue() {
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

