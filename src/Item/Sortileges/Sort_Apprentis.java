package Item.Sortileges;

import BoardGame.Case;


public class Sort_Apprentis extends Sort implements Case {

    // constructor
    public Sort_Apprentis() {

        setName("Sort d'apprentis");
        setAttack(6);
        setWeaponType("Spell");
        setValue(8);
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

