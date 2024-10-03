package Item.Armes;

import BoardGame.Case;

public class EpeeBronze extends Arme implements Case {
//id, name,attack, type, value, weight
// constructor
    public EpeeBronze() {
        super();
        setName("Epee de Bronze");
        setAttack(5);
        setWeaponType("Sword");
        setValue(20);
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

