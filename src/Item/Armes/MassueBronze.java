package Item.Armes;

import BoardGame.Case;

public class MassueBronze extends Arme implements Case {

// constructor
    public MassueBronze() {
        setName("Massue en Bronze");
        setAttack(6);
        setWeaponType("Massue");
        setValue(20);
        setWeight(6);
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

