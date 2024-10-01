package Item;

import BoardGame.Case;

public class MassueTitane extends Arme implements Case {

// constructor
    public MassueTitane(String name) {

        setName(name);
        setAttack(10);
        setWeaponType("Massue");
        setValue(40);
        setWeight(5);
    }
    public MassueTitane() {
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

