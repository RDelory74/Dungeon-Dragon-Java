package Donjon_Dragons;

import BoardGame.*;
import Item.Arme;
import Item.Bouclier;
import Item.Potion;



import java.util.ArrayList;
import java.util.Random;

public class DispatchMesElements {


    public void disposeMesElements(ArrayList<Case> plateau){
        Random random = new Random();

        int dragonsElements = 4;
        int sorciersElements = 10;
        int gobelinsElements = 10;
        int weaponsElements = 10;
        int potionElements = 10;
        int defenseElements = 10;
        int emptyElements = plateau.size() - (gobelinsElements+sorciersElements+dragonsElements+weaponsElements+potionElements+defenseElements);

        for (int i = 0; i < dragonsElements; i ++){
            plateau.add(new Dragons("Dragon"));
        }  for (int i = 0; i < gobelinsElements; i ++){
            plateau.add(new Gobelin("Sorcier"));
        }  for (int i = 0; i < gobelinsElements; i ++){
            plateau.add(new Gobelin("Gobelin"));
        }
        for (int i = 0; i < weaponsElements; i ++){
            plateau.add(new Arme("Arme " +(i +1), random.nextInt(10)+5, "Element d'attaque"));
        }
        for (int i = 0; i < potionElements; i ++){
            plateau.add(new Potion("Potion " +(i +1), random.nextInt(1)+5, "Ca fait grand bien"));
        }
        for (int i = 0; i < defenseElements; i ++){
            plateau.add(new Bouclier("Bouclier " +(i +1), random.nextInt(10)+5, "Element de defense"));
        } for (int i = 0; i < emptyElements; i ++){
            plateau.add(new Empty(i +1));
        }

        java.util.Collections.shuffle(plateau);
         System.out.println(plateau);
    }
}
