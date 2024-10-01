package Item;

import BoardGame.Case;

public class EpeeGold extends Arme implements Case {

// constructor
    public EpeeGold(String name) {

        setName(name);
        setAttack(7);
        setWeaponType("Sword");
        setValue(50);
        setWeight(4);
    }
    public EpeeGold() {
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

