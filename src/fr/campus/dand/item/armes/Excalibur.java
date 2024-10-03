package fr.campus.dand.item.armes;

import fr.campus.dand.boardgame.Case;

public class Excalibur extends Arme implements Case {

// constructor
    public Excalibur() {
        super();
        setName("Excalibur");
        setAttack(10);
        setWeaponType("Sword");
        setValue(100);
        setWeight(3);
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

