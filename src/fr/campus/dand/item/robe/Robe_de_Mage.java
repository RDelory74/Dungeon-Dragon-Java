package fr.campus.dand.item.robe;

import fr.campus.dand.boardgame.Case;
import fr.campus.dand.engine.Player;
import fr.campus.dand.item.philtressoin.Philtre;
import fr.campus.dand.print.PrintAcs;
import fr.campus.dand.type.Wizard;

import java.util.Scanner;

public class Robe_de_Mage extends Philtre implements Case {

        // constructor
        public Robe_de_Mage(String name, int defense) {
            super();
            setName(name);
            setDefense(defense);
            setType("Robe de Mage");
            setWeight(4);
        }

        public Robe_de_Mage() {
            super();
            setType("Robe de Mage");
            setWeight(4);
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
        public void interact (Player character, PrintAcs printThings){
            Scanner sc = new Scanner(System.in);

            if(character instanceof Wizard) {
                System.out.println("* Tu es actuelement équipé de " + character.getDefense().getName() + ", souhaites-tu remplacer par " + getName() + " ? *");
                System.out.println("Actual defense : "+character.getDefense().getDefense()+" New defense:"+ getDefense() +"." );
                System.out.println("* 1. Oui, je la veux !! *");
                System.out.println("* 2. Non, je garde "+character.getDefense().getName()+" et laisse " +getName()+ "ici !! *");
                System.out.println("* 3. Je vais tenter de mettre ça dans mon sac *");
                int playerChoice = sc.nextInt();
                if (playerChoice == 1) {
                    character.setDefense(this);
                    character.setPv(character.getVie() + getDefense());
                }else if (playerChoice == 3 ){
                    character.addItemToInventory(this,this.getWeight());
                }
            }

            else {
                System.out.println("* Heuuu, bha Heeee Hooo il y a du linge de partout ici !!  *");
            }
        }

        @Override
        public void use(){
            System.out.println("* C'est beau, ceci est une méthode use *");
        }


    }



