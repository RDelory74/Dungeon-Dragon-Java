package Item;

import BoardGame.Case;

public class MassueGold extends Arme implements Case {

// constructor
    public MassueGold(String name) {

        setName(name);
        setAttack(8);
        setWeaponType("Massue");
        setValue(60);
        setWeight(6);
    }
    public MassueGold() {
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

