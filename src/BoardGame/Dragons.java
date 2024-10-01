package BoardGame;


public  class Dragons extends Ennemis implements Case {

    //Attributs


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

