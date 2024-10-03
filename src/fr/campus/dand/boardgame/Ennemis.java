package fr.campus.dand.boardgame;
import fr.campus.dand.donjon_dragons.Player;
import fr.campus.dand.print.PrintAcs;
import fr.campus.dand.db.PlayerDAO;

import java.util.Random;
import java.util.Scanner;


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
    public String toString() {
        return  "\n"+
                "------------ "+name+"\n"+
                "|Pv:         "+pv+"\n"+
                "|Attaque:    "+attack+"\n"+
                "------------------------\n";
    }

    /**
     * Interact method to link the player with the combat loop
     * We set the player character and the fr.campus.dand.print to allow the display
     * @param character
     * @param printThings
     */
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
            /**
             * Change display fr.campus.dand.print in case of the arguments called
             */
        }
        //Première intéraction


/**
 * Set 2 variables, one for the life of the ennemis and one for the escapeResult to know if the player can escape a combat
 * Add short text to remind the player important specs before the combat start
 */
        int ennemiPv;
        int escapeResult = random.nextInt(7) + 1;



        System.out.println(character.getName() + " tu as " + character.getVie() + " points de vie.");

        System.out.println("****** Il t'a bien surpris, que souhaites-tu faire ? *******");


/**
 * Starting combat loop with a while condition running until (the ennemis life is over zero ou player life is over zero)
 *
 */
        //boucle de combat
        while ( getPv() > 0 || character.getVie()> 0) {
/**
 *  Short text to give the player choice to attack or to escape
 */
            System.out.println("* Appuis sur 1 pour faire une attaque avec " + character.getWeapon().getName() + " infligeant " + character.getStrength() + " de dégats !!! *");
            System.out.println("* Appuis sur 2 pour Pour tenter de fuir le combat  *");



            int playerChoice = sc.nextInt();

            // Condition pour le coup critique
            if (playerChoice == 1) {
                /**
                 * 1 variable here to define if the attack is critical or not (attackCritical)
                 * 1 variable to define the value of the attack (which is 50 percent up if the critical is ok)
                 */
                int attackCritical = random.nextInt(100) + 1;
                int criticalAttack = (int) Math.floor(character.getStrength() * 1.50);

                if (attackCritical >= 20) {
                    /**
                     * Here we set the ennemis life less criticalAttack value
                     */
                    printThings.Print("fight50");
                    System.out.println("* Tu portes un coup critique à l'énnemi lui infligeant " + criticalAttack + " points de dégats*");
                    ennemiPv = getPv() - criticalAttack;
                    setPv(ennemiPv);
                    if (ennemiPv <= 0) {
                        /**
                         * If the ennemi's life is under zero we break the loop
                         */
                        break;
                    } else {
                        /**
                         * If the ennemis is still alive he will kick back the player with an attack
                         */
                        System.out.println("* Vie de " + name + " restant: " + getPv() + "*");
                        printThings.Print("ennemiAttack");
                        System.out.println(name + " attaque le joueur et lui inflige " + getAttack() + " points de dégats !");
                        character.setPv(character.getVie()-getAttack());
                        System.out.println("* Vie du joueur =" +character.getVie()+" PV*");
                        if(character.getVie() <= 0){
                            /**
                             * If the player's life is under zero we break the loop
                             */
                            break;
                        }
                    }
                } else {

                    /**
                     * Same mechanic with a normal attack
                     */
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
            } else if (playerChoice == 2) {
                /**
                 * // Condition pour s'enfuir
                 * Condition if the player try to escape a random int is set into escapeResult variable and if the
                 * result is over 2, the player can escape the combat and we break the loop, the player goes to the
                 * next step of a round. If the escapeResult is under or equal to 2 so it's a funble and the player
                 * will escape but get a kick-back from the ennemis. Then combat loop is break
                 *
                 */


                System.out.println("* ... Ha il est chaud, il tente une embardé pour esquiver l'énnemi ...   *");
                System.out.println("\n\n*  ... embardée en cours ...   *");
                if (escapeResult > 2) {
                    break;
                } else {
                    System.out.println("* ... mal gérée, tu t'échappes mais tu prends une attaque d'opprotunitée, " + getName() + " t'infligeant " + getAttack() + " de dégats !!! *");
                    character.setPv(character.getVie()-getAttack());
                    break;
                }
            }
        }

        /**
         *  Getting out of the combat loop there's 3 situations :
         *  - ennemi's life is equal or under zero ANd player's life is over zero, so it's a victory and player get Exp,
         *      gold and the levelup method is call to check if the player can get a new level.
         *  - player's life is equal or under zero and the combat is loose, a short text inform the player he is dead,
         *      by instancing a new Player DAO we call the deletePlayer method ti erase the heros from the database and
         *      we stop the programm with the method System.exit(status0)
         *  - Last condition, we check if the escaperesult value is over 2 and we let the player out of the combat Loop
         *      without consequences.
         *
         */
        if (getPv() <= 0 && character.getVie() > 0){ // Joueur gagne et récupère ses récompenses.
            int xpGagne = getAttack()*4;
            int newXp = character.getExp() + xpGagne;
            int orGagne = random.nextInt(1,10);
            int newOr = character.getOr() + orGagne;
            printThings.Print("victoire");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("* ... VICTOIRE!!!! "+ getName() + " est mort, "+ character.getName() + " remporte ce combat et continue sa route *");
            System.out.println(character.getName() + " gagne " + xpGagne +"XP // Total XP = "+newXp + " *");
            character.setExp(newXp);
            System.out.println("De plus "+character.getName() + " ramasse " + orGagne +" pièces d'or *");
            character.setOr(newOr);
            character.levelUp();
            System.out.println("----------------------------------------------------------------------------");

        } else if (character.getVie() <=0){
            System.out.println("* Mais t'es mort !!!  *");
            printThings.Print("death");
            PlayerDAO playerDAO = new PlayerDAO();
            playerDAO.deletePlayer(character.getId().toString());
            System.exit(0);
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

