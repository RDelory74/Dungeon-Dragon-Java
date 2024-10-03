package fr.campus.dand.boardgame;


public  class Sorcier extends Ennemis implements Case {

    //Attributs
    /**
     * Create Sorcier ennemis with set values for name, attack and PV
     * @param name
     */

    //Constructor
    public Sorcier(String name) {
        setName(name);
        setPv(9);
        setAttack(2);
    }
    public Sorcier(){
    }
    //methods


    @Override
    public String toString() {
        return  "\n"+
                "------------ "+getName()+"\n"+
                "|Pv:         "+getPv()+"\n"+
                "|Attaque:    "+getAttack()+"\n"+
                "------------------------\n";
    }

}

