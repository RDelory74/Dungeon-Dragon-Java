package fr.campus.dand.type;
import fr.campus.dand.engine.Player;
import fr.campus.dand.item.philtressoin.SortCuratif;
import fr.campus.dand.item.sortileges.Sort_Apprentis;

public class Wizard extends Player {

    /**
     * The player's fr.campus.dand.type created with set pv and Strength depending on the fr.campus.dand.type
     * As same as for the weapon we create a new Item Sort_Apprentis depending on the fr.campus.dand.type and a SortCuratifs as defense
     * @param name
     */

    // constructor
public Wizard(String name) {
    setName(name);
    setPv(6);
    setStrength(2);
    setWeapon(new Sort_Apprentis());
    setDefense(new SortCuratif());
    setType("Wizard");
}

    public Wizard() {
    }


//method

    /**
     * The levelup method use one condition
     */
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

