package BoardGame;


public  class Sorcier extends Ennemis implements Case {

    //Attributs


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

