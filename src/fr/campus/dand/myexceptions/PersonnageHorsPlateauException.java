package fr.campus.dand.myexceptions;

/**
 * My created exception to indicate the player is over the board lenght,
 * We can find it back in the loop Game
 */
public class PersonnageHorsPlateauException extends Exception {
    public PersonnageHorsPlateauException (String message){
        super (message);
    }
}
