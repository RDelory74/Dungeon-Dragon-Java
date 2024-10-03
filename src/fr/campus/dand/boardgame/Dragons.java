package fr.campus.dand.boardgame;


public  class Dragons extends Ennemis implements Case {

    //Attributs

    /**
     * Create Dragons ennemis with set values for name, attack and PV
     * @param name
     */
    //Constructor
    public Dragons(String name) {
        setName(name);
        setPv(15);
        setAttack(4);
    }
    public Dragons(){
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

