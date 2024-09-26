import Donjon_Dragons.Menu;
import Print.PrintAcs;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        PrintAcs printThings = new PrintAcs();

        printThings.Print("Welcome");
        printThings.Print("WelcomePaint");

        menu.start();
    }
}