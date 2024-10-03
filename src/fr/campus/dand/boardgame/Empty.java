package fr.campus.dand.boardgame;

import fr.campus.dand.donjon_dragons.Player;
import fr.campus.dand.print.PrintAcs;

public class Empty implements Case{
   // Attributs
    private int numero;

    /**
     * Create an empty Class to fill the boar and inform the player with a short text that nothing happen on this case.
     * @param numero
     */
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
