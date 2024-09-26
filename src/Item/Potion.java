package Item;

import BoardGame.Case;
import Donjon_Dragons.Player;

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
public void interact (Player player){
    System.out.println("Tu vois un petit objet c'est " + getName() + " elle te régenère "+ getDefense()+".");

}

    @Override
    public  void use (){

    }

    @Override
    public String toString() {
        return "Fouwing!";
    }


}

