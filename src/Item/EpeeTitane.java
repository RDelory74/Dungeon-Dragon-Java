package Item;

import BoardGame.Case;

public class EpeeTitane extends Arme implements Case {

// constructor
    public EpeeTitane(String name) {

        setName(name);
        setAttack(9);
        setWeaponType("Sword");
        setValue(40);
        setWeight(2);
    }
    public EpeeTitane() {
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

