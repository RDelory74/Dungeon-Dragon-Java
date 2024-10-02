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
            setLevel(getLevel()+1);
            setPv(getVie()+2);
            setStrength(getStrength()+2);
            System.out.println(getName() + " monte au niveau " + getLevel() + "!"+"\n"+
                    "-------------- "+getName()+"\n"+
                    "|Pv: (+2)      "+getVie()+"pv\n"+
                    "|Attaque: (+2) "+getStrength()+"Force\n"+
                    "------------------------------\n");
            setExp(0);
        } else {
            System.out.println("Xp du joueur: " + getExp() + "!");
        }
    }
}


