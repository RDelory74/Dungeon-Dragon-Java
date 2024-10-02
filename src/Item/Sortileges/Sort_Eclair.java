package Item.Sortileges;

import BoardGame.Case;


public class Sort_Eclair extends Sort implements Case {

    // constructor
    public Sort_Eclair() {

        setName("Sort Foudre");
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

