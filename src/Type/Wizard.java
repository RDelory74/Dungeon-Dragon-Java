package Type;
import Donjon_Dragons.Player;

public class Wizard extends Player {

    // constructor
public Wizard(String name) {
    setName(name);
    setPv(6);
    setStrength(2);
    setWeapon("Sort d'apprentis");
    setDefense("Philtre d'apprentis");
    setType("Wizard");
}

    public Wizard() {
    }


//method

    @Override
    public void levelUp() {
        if (getExp() > 10) {
            setLevel(getLevel()+1);
            setPv(getVie()+1);
            setStrength(getStrength()+1);
            System.out.println(getName() + " monte au niveau " + getLevel() + "!"+"\n"+
                    "-------------- "+getName()+"\n"+
                    "|Pv: (+1)      "+getVie()+"pv\n"+
                    "|Attaque: (+1) "+getStrength()+"Force\n"+
                    "------------------------------\n");
            setExp(0);
        } else {
            System.out.println("Xp du joeur: " + getExp() + "!");
        }
    }
}

