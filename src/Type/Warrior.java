package Type;
import Donjon_Dragons.Player;

public class Warrior extends Player {


    // constructor
    public Warrior(String name) {
        setName(name);
        setPv(10);
        setStrength(10);
        setWeapon("Epée en bois");
        setDefense("Bouclier banal");
        setType("Warrior");

    }


    public Warrior() {

    }


//method


    @Override
    public void levelUp() {
        if (getExp() > 10) {
            setLevel(+1);
            setPv(+2);
            setStrength(+2);
            System.out.println(getName() + " monte au niveau" + getLevel() + "!");
            setExp(0);
        } else {
            System.out.println("Xp du joeur: " + getExp() + "!");
        }
    }
}


