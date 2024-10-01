package Donjon_Dragons;


import BoardGame.Case;

import Donjon_Dragons.DispatchMesElements;
import java.util.ArrayList;


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
