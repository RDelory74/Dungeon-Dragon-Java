package Item.Armes;

import BoardGame.Case;

public class TheMassue extends Arme implements Case {

// constructor
    public TheMassue() {
        super();
        setName("The Massue");
        setAttack(12);
        setWeaponType("Massue");
        setValue(90);
        setWeight(4);
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

