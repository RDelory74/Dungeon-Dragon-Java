package fr.campus.dand.item.armures;

import fr.campus.dand.boardgame.Case;

public class Rondelle extends Bouclier implements Case {

//
// constructor
    public Rondelle() {
        super();
        setName("Rondelle");
        setDefense(5);
        setType("Bouclier");
        setWeight(2);
        setValue(10);
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

