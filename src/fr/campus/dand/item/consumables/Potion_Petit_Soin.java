package fr.campus.dand.item.consumables;

import fr.campus.dand.boardgame.Case;

public  class Potion_Petit_Soin extends Potion implements Case {
// constructor
    public Potion_Petit_Soin() {
        super();
        setName("Potion de petit Soin");
        setEffect(5);
        setType("Potion");
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

