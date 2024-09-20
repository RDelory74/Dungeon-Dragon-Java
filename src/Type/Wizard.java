package Type;
import Donjon_Dragons.Player;

public class Wizard extends Player {

    // constructor
public Wizard(String name) {
    setName(name);
    setPv(6);
    setStrength(15);
    setWeapon("Item.Sort");
    setDefense("Potion");
    setType("Wizard");
}

    public Wizard() {
    }


//method

    @Override
    public void attack() {
        System.out.println(getName() + " lance un" +getWeapon() + "sort !");
    }
}

