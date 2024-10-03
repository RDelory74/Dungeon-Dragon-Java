package fr.campus.dand.donjon_dragons;


import fr.campus.dand.boardgame.Case;

import java.util.ArrayList;

/**
 * Creating Class to create boardGame but never used it as I did'nt have time enought to finish it.
 * This Class create an Array of 64 cases interfaces and instance a Class dispatchMesElements wihch call a method (disposeMesElements) to fill the array and then shuffle it
 */
public class Plateau {

    //Attributs
    private ArrayList<Case> plateau;
    private int lenght;


    //Constructor

    public Plateau(int lenght) {
        this.lenght = lenght;
        this.plateau = new ArrayList<>(lenght);
        DispatchMesElements dispatchMesElements= new DispatchMesElements();
        dispatchMesElements.disposeMesElements(plateau);
    }


    // methodes

    //getter setter
    public void setPlateau(ArrayList<Case> plateau) {
        this.plateau = plateau;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }



    public ArrayList<Case> getPlateau() {
        return plateau;
    }

    public int getLenght() {
        return lenght;
    }


}
