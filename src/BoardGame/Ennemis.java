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
        System.out.println("Un ennemi apparaît : " + name + " attaque le joueur et lui inflige" +getAttack()+"points de dégats !");
        int newPv = player.getVie() - getAttack();
        player.setPv(newPv);
        System.out.println(player.getName() + " a maintenant " + player.getVie() + " points de vie.");
    }

    @Override
    public String toString() {
        return  "                                       \n" +
                "                                      /|\n" +
                "                                     |\\|\n" +
                "                                     |||\n" +
                "                                     |||\n" +
                "                                     |||\n" +
                "                                     |||\n" +
                "                                     |||\n" +
                "                                     |||\n" +
                "                                  ~-[{o}]-~\n" +
                "                                     |/|\n" +
                "              ___                    |/|\n" +
                "             ///~`     |\\\\_          `0'         =\\\\\\\\         . .\n" +
                "            ,  |='  ,))\\_| ~-_                    _)  \\      _/_/|\n" +
                "           / ,' ,;((((((    ~ \\                  `~~~\\-~-_ /~ (_/\\\n" +
                "         /' -~/~)))))))'\\_   _/'                      \\_  /'  D   |\n" +
                "        (       (((((( ~-/ ~-/                          ~-;  /    \\--_\n" +
                "         ~~--|   ))''    ')  `                            `~~\\_    \\   )\n" +
                "             :        (_  ~\\           ,                    /~~-     ./\n" +
                "              \\        \\_   )--__  /(_/)                   |    )    )|\n" +
                "    ___       |_     \\__/~-__    ~~   ,'      /,_;,   __--(   _/      |\n" +
                "  //~~\\`\\    /' ~~~----|     ~~~~~~~~'        \\-  ((~~    __-~        |\n" +
                "((()   `\\`\\_(_     _-~~-\\                      ``~~ ~~~~~~   \\_      /\n" +
                " )))     ~----'   /      \\                                   )       )\n" +
                "  (         ;`~--'        :                                _-    ,;;(\n" +
                "            |    `\\       |                             _-~    ,;;;;)\n" +
                "            |    /'`\\     ;                          _-~          _/\n" +
                "           /~   /    |    )                         /;;;''  ,;;:-~\n" +
                "          |    /     / | /                         |;;'   ,''\n" +
                "          /   /     |  \\\\|                         |   ,;(    -Rod Delory\n" +
                "        _/  /'       \\  \\_)                   .---__\\_    \\,--._______\n" +
                "       ( )|'         (~-_|                   (;;'  ;;;~~~/' `;;|  `;;;\\\n" +
                "        ) `\\_         |-_;;--__               ~~~----__/'    /'_______/\n" +
                "        `----'       (   `~--_ ~~~;;------------~~~~~ ;;;'_/'\n" +
                "                     `~~~~~~~~'~~~-----....___;;;____---~~";
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

