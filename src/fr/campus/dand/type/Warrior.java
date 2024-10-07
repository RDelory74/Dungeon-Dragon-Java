package fr.campus.dand.type;
import fr.campus.dand.engine.Player;
import fr.campus.dand.item.armes.EpeeBronze;
import fr.campus.dand.item.armures.Rondelle;

public class Warrior extends Player {

    /**
     * The player's fr.campus.dand.type created with set pv and Strength depending on the fr.campus.dand.type
     * As same as for the weapon we create a new Item EpeeBronze depending on the fr.campus.dand.type and a Rondelle as defense
     * @param name
     */

    // constructor
    public Warrior(String name) {
        setName(name);
        setPv(10);
        setStrength(10);
        setWeapon(new EpeeBronze());
        setDefense(new Rondelle());
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


