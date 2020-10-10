package Week02.Clock.Pontoon;

import java.util.Scanner;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Pontoon                          *
 *************************************************************************/

public class Player {

    Scanner kboard;

    /**
     * Create a new player.
     */
    public Player()  {
        this.kboard = new Scanner(System.in);
    }

    /**
     * Get the player's input.
     *
     * @return Player's input
     */
    public String getInput() {
        return this.kboard.next();
    }

}

                                                                           
