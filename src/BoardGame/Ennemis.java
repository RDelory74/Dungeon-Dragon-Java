package BoardGame;
import Donjon_Dragons.Player;


public  class Ennemis implements Case {

    //Attributs
    private String name;
    private int pv;
    private int attack;
    //Constructor
    public  Ennemis(String name, int pv, int attack) {
        this.name = name;
        this.pv = pv;
        this.attack = attack;
    }
    public Ennemis(){
    }
    //methods



    @Override
    public void interact (Player player){
        System.out.println("Un ennemi apparaît : " + name + " attaque le joueur !");
    }
    @Override
    public String toString() {
        return "Pchiiiit!";
    }


    //getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

}

