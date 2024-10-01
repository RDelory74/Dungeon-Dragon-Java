package BoardGame;

import Donjon_Dragons.Player;
import Print.PrintAcs;

import java.util.Random;
import java.util.Scanner;


public  class Marchands implements Case {

    //Attributs
    private String name;
    private int pv;
    private int attack;


    //Constructor
    public Marchands(String name, int pv, int attack) {
        this.name = name;
        this.pv = pv;
        this.attack = attack;
    }
    public Marchands(){
    }
    //methods


    @Override
    public String toString() {
        return  "\n"+
                "------------ "+name+"\n"+
                "|Pv:         "+pv+"\n"+
                "|Attaque:    "+attack+"\n"+
                "------------------------\n";
    }

    @Override
    public void interact (Player character,PrintAcs printThings){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        //Print section
        switch (name) {
            case "Dragon" -> printThings.Print("dragon");
            case "Gobelin" -> printThings.Print("gobelin");
            case "Sorcier" -> printThings.Print("sorcier");
            default -> printThings.Print("fight");
        }
        //Première intéraction



        int ennemiPv = getPv();
        int escapeResult = random.nextInt(7) + 1;



        System.out.println(character.getName() + " tu as " + character.getVie() + " points de vie.");

        System.out.println("****** Il t'a bien surpris, que souhaites-tu faire ? *******");


        //boucle de combat
        while ( getPv() > 0 || character.getVie()> 0) {

            System.out.println("* Appuis sur 1 pour faire une attaque avec " + character.getWeapon() + " infligeant " + character.getStrength() + " de dégats !!! *");
            System.out.println("* Appuis sur 2 pour Pour tenter de fuir le combat  *");
            System.out.println("*Dans la boucle character.getVie(); =" +character.getVie()+" PV*");


            int playerChoice = sc.nextInt();

            // Condition pour le coup critique
            if (playerChoice == 1) {
                int attackCritical = random.nextInt(100) + 1;
                printThings.Print("fight50");
                int criticalAttack = (int) Math.floor(character.getStrength() * 1.50);
                if (attackCritical >= 20) {
                    System.out.println("* Tu portes un coup critique à l'énnemi lui infligeant " + criticalAttack + " points de dégats*");
                    ennemiPv = getPv() - criticalAttack;
                    setPv(ennemiPv);
                    if (ennemiPv <= 0) {
                        break;
                    } else {
                        System.out.println("* Vie de " + name + " restant: " + getPv() + "*");
                        printThings.Print("ennemiAttack");
                        System.out.println(name + " attaque le joueur et lui inflige " + getAttack() + " points de dégats !");
                        character.setPv(character.getVie()-getAttack());
                        System.out.println("* Vie du joueur =" +character.getVie()+" PV*");
                        if(character.getVie() <= 0){
                            break;
                        }
                    }
                } else {
                    System.out.println("* Tu portes un coup normal à l'énnemi lui infligeant " + character.getStrength() + " points de dégats*");
                    ennemiPv = getPv() - character.getStrength();
                    setPv(ennemiPv);
                    if (ennemiPv <= 0) {
                        break;
                    } else {
                        character.setPv(character.getVie()-getAttack());
                        System.out.println("* Vie de " + name + " restant: " + getPv() + "*");
                        System.out.println(name + " attaque le joueur et lui inflige " + getAttack() + " points de dégats !");
                        printThings.Print("ennemiAttack");
                        System.out.println("* Vie du joueur =" +character.getVie()+" PV*");
                        if(character.getVie() <= 0){
                            break;
                        }
                    }
                }
            } else if (playerChoice == 2) { // Condition pour s'enfuir

                System.out.println("* ... Ha il est chaud, il tente une embardé pour esquiver l'énnemi ...   *");
                System.out.println("\n\n*  ... embardée en cours ...   *");
                if (escapeResult > 2) {
                    break;
                } else {
                    System.out.println("* ... mal gérée, tu t'échappes mais tu prends une attaque d'opprotunitée, " + getName() + " t'infligeant " + getAttack() + " de dégats !!! *");
                    character.setPv(character.getVie()-getAttack());
                }
            }
        }
        if (getPv() <= 0 && character.getVie() > 0){ // Joueur gagne et récupère ses récompenses.
            int xpGagne = getAttack()*4;
            int newXp = character.getExp() + xpGagne;
            int orGagne = random.nextInt(1,10);
            int newOr = character.getOr() + orGagne;
            printThings.Print("victoire");
            System.out.println("* ... VICTOIRE!!!! "+ getName() + " est mort, "+ character.getName() + " remporte ce combat et continue sa route *");
            System.out.println(character.getName() + " gagne " + xpGagne +"XP // Total XP = "+newXp + " *");
            character.setExp(newXp);
            System.out.println("De plus "+character.getName() + " ramasse " + orGagne +" pièces d'or *");
            character.setOr(newOr);
            character.levelUp();

        } else if (character.getVie() <=0){
            System.out.println("* Mais t'es mort !!!  *");
            printThings.Print("death");

        } else if (escapeResult > 2){
            System.out.println("* ... est c'est beau tu t'échappes !!!   *");

        }
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

