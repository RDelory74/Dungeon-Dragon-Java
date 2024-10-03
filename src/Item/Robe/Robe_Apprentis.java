package Item.Robe;

import BoardGame.Case;
import Donjon_Dragons.Player;
import Item.PhiltresSoin.Philtre;
import Print.PrintAcs;
import Type.Wizard;

import java.util.Scanner;

public class Robe_Apprentis extends Philtre implements Case {

        // constructor
        public Robe_Apprentis() {
            super();
            setName("Tunique d'apprentis");
            setDefense(8);
            setType("Robe de Mage");
        }


//method

        @Override
        public String toString() {
            return "\n"+ "** Et à terre tu aperçois, flamboyant le prachemin " + getName() + "**"+
                    "------------ "+getName()+"\n"+
                    "|Defense     "+getDefense()+"\n"+
                    "|Type:       "+getType()+"\n"+
                    "------------------------\n";
        }


        @Override
        public void use(){
            System.out.println("* C'est beau, ceci est une méthode use *");
        }


    }



