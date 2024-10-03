package fr.campus.dand.item.armures;

import fr.campus.dand.boardgame.Case;

public class Broquel extends Bouclier implements Case {


// constructor
    public Broquel() {
        super();
        setName("Broquel");
        setDefense(10);
        setType("Bouclier");
        setWeight(2);
        setValue(100);

    }


//method

@Override
public String toString() {
    return "\n"+ "** Et à terre tu aperçois " + getName() + "**"+"\n"+
            "------------ "+getName()+"\n"+
            "|Defense     "+getDefense()+"\n"+
            "|Type:       "+getType()+"\n"+
            "------------------------\n";
}


    @Override
    public void use(){
        System.out.println("* C'est beau, ceci est une méthode use *");
    }


}

