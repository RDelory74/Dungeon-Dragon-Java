package Item.Armes;

import BoardGame.Case;

public class MassueTitane extends Arme implements Case {

// constructor
    public MassueTitane() {
        super();
        setName("Massue de titane");
        setAttack(10);
        setWeaponType("Massue");
        setValue(40);
        setWeight(5);
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

