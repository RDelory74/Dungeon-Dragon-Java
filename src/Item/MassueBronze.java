package Item;

import BoardGame.Case;

public class MassueBronze extends Arme implements Case {

// constructor
    public MassueBronze(String name) {

        setName(name);
        setAttack(6);
        setWeaponType("Massue");
        setValue(20);
        setWeight(6);
    }
    public MassueBronze() {
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

