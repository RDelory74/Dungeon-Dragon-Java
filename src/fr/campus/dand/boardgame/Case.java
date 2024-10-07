package fr.campus.dand.boardgame;

import fr.campus.dand.engine.Player;
import fr.campus.dand.print.PrintAcs;

/**
 * Create an interface to fill the board of the game with an interact method requesting character and printACs arguments
 */

public interface Case {
   void interact (Player charcater, PrintAcs printThings);
}
