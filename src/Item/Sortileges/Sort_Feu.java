package Item.Sortileges;

import BoardGame.Case;


public class Sort_Feu extends Sort implements Case {

    // constructor
    public Sort_Feu() {
        super();
        setName("Sort Flameche");
        setAttack(4);
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

