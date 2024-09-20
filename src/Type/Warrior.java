package Type;
import Donjon_Dragons.Player;

public class Warrior extends Player {


    // constructor
    public Warrior(String name) {
        setName(name);
        setPv(10);
        setStrength(10);
        setWeapon("épée");
        setDefense("un bouclier");
        setType("Warrior");

    }


    public Warrior() {

    }


//method


    @Override
    public void attack() {
        System.out.println(getName() + " attaque avec une " + getWeapon() + " !");
    }
}


