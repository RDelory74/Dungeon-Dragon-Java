package BoardGame;

import Donjon_Dragons.Player;
import Print.PrintAcs;

public class Empty implements Case{
   // Attributs
    private int numero;

    //Constructor
    public  Empty(int numero) {
        this.numero = numero;
    }
    public Empty(){
    }


    @Override
    public String toString() {
        return  "Tout a l'air tranquille ici " ;
    }

    @Override
    public void interact (Player player, PrintAcs printThings) {
    }



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
