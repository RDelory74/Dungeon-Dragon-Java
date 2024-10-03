package fr.campus.dand.boardgame;


public  class Gobelin extends Ennemis implements Case {

    //Attributs

    /**
     * Create Gobelins ennemis with set values for name, attack and PV
     * @param name
     */
    //Constructor
    public Gobelin(String name) {
        setName(name);
        setPv(6);
        setAttack(1);
    }
    public Gobelin(){
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

