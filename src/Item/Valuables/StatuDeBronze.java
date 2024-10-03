package Item.Valuables;

import BoardGame.Case;
import Item.Valuable;



public  class StatuDeBronze extends Valuable implements Case {
// constructor
    public StatuDeBronze() {
        super();
        setName("Statuette de Bronze");
        setValue(500);
        setWeight(15);
    }

//method

    @Override
    public  void use (){

    }

    @Override
    public String toString() {
        return "\n" + "** Et à terre tu aperçois, cachée ...  " + getName() + "**" +
                "------------ " + getName() + "\n" +
                "|Valeur:     " + getValue() + "\n" +
                "|Type:       " + getType() + "\n" +
                "------------------------\n";
    }
}

