package fr.campus.dand.item.sortileges;

import fr.campus.dand.boardgame.Case;


public class Sort_Eau extends Sort implements Case {

    // constructor
    public Sort_Eau() {
        super();
        setName("Sort Spalsh");
        setAttack(9);
        setWeaponType("Spell");
        setValue(6);
    }

//method

    @Override
    public String toString() {
        return  "\n"+"** Et à terre, flamboyant, tu aperçois " + getName() + "**"+"\n"+
                "------------ "+getName()+"\n"+
                "|Attack:     "+getAttack()+"\n"+
                "|Type:       "+getWeaponType()+"\n"+
                "------------------------\n";
    }

    @Override
    public  void use (){
        System.out.println("Tu utilises l'arme " + getName() + " pour attaquer ! Tu infliges"+ getAttack()+".");
    }


}

