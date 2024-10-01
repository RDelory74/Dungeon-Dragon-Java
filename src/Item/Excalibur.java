package Item;

import BoardGame.Case;

public class Excalibur extends Arme implements Case {

// constructor
    public Excalibur(String name) {

        setName(name);
        setAttack(10);
        setWeaponType("Sword");
        setValue(100);
        setWeight(3);
    }
    public Excalibur() {
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

