package Item.Armures;

import BoardGame.Case;

public class Adarga extends Bouclier implements Case {


// constructor
    public Adarga() {

        setName("Adarga");
        setDefense(8);
        setType("Bouclier");
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

