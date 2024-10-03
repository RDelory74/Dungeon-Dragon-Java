package fr.campus.dand.item.armes;

import fr.campus.dand.boardgame.Case;

public class EpeeTitane extends Arme implements Case {

// constructor
    public EpeeTitane() {
        super();
        setName("Epee de titane");
        setAttack(9);
        setWeaponType("Sword");
        setValue(40);
        setWeight(2);
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

