package Item;

import BoardGame.Case;
import Donjon_Dragons.Player;



public class Arme extends Weapon implements Case {

// constructor
    public Arme(String name,int attack, String type) {

        setName(name);
        setAttack(attack);
        setWeaponType(type);
    }
    public Arme() {
    }
//method
    @Override
    public void interact (Player player){
        System.out.println("Et à terre tu aperçois *" + getName() + "*");
    }
    @Override
    public  void use (){
        System.out.println("Tu utilises l'arme " + getName() + " pour attaquer ! Tu infliges"+ getAttack()+".");
    }
    @Override
    public String toString() {
        return "Chling!";
    }


}

