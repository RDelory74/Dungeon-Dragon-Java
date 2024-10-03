package fr.campus.dand.item.consumables;

import fr.campus.dand.boardgame.Case;


public  class Potion_Gd_Soin extends Potion implements Case {
// constructor
    public Potion_Gd_Soin() {
        super();
        setName("Potion de grand Soin");
        setEffect(10);
        setType("Potion");
        setValue(50);
        setWeight(1);
    }

//method


    @Override
    public  void use (){

    }

    @Override
    public String toString() {
        return "\n" + "** Et à terre tu aperçois, cachée ...  " + getName() + "**" +
                "------------ " + getName() + "\n" +
                "|Defense     " + getEffect() + "\n" +
                "|Type:       " + getType() + "\n" +
                "------------------------\n";
    }
}

