package Item;

import BoardGame.Case;
import Donjon_Dragons.Player;
import Print.PrintAcs;

public  class Potion extends Defense implements Case {
// constructor
    public Potion(String name, int defense, String type) {

        setName(name);
        setDefense(defense);
        setType(type);
    }

    public Potion() {
    }
//method
@Override
public void interact (Player player, PrintAcs printThings){
    System.out.println("C'est " + getName() + " elle te régenère "+ getDefense()+".");
    player.setPv(player.getVie()+getDefense());
}

    @Override
    public  void use (){

    }

    @Override
    public String toString() {
        return "\n" + "** Et à terre tu aperçois, cachée ...  " + getName() + "**" +
                "------------ " + getName() + "\n" +
                "|Defense     " + getDefense() + "\n" +
                "|Type:       " + getType() + "\n" +
                "------------------------\n";
    }
}

