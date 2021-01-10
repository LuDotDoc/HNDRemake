package Week08.Assessment;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class Maps {
    /**
     * Holds an array of arrays containing strings. This strings are text based representations of levels. Different characters are used to define different level elements
     * X = wall, * = crate, . = diamond, @ = warehouse keeper, spaces = spaces
     */
    private int current;
    private String[] levels = new String[] {
            "    XXXXXX\n" +
            "    XX   X\n" +
            "    XX*  X\n" +
            "  XXXX  *XX\n" +
            "  XX  * * X\n" +
            "XXXX X XX X   XXXXXX\n" +
            "XX   X XX XXXXX  ..X\n" +
            "XX *  *          ..X\n" +
            "XXXXXX XXX X@XX  ..X\n" +
            "    XX     XXXXXXXXX\n" +
            "    XXXXXXXX\n",

            "              \n" +
            "XXXXXXXXXXXX  \n" +
            "X..  X     XXX\n" +
            "X..  X *  *  X\n" +
            "X..  X*XXXX  X\n" +
            "X..    @ XX  X\n" +
            "X..  X X  * XX\n" +
            "XXXXXX XX* * X\n" +
            "  X *  * * * X\n" +
            "  X    X     X\n" +
            "  XXXXXXXXXXXX\n",

            "        XXXXXXXX \n" +
            "        X     @X \n" +
            "        X *X* XX \n" +
            "        X *  *X  \n" +
            "        XX* * X  \n" +
            "XXXXXXXXX * X XXX\n" +
            "X....  XX *  *  X\n" +
            "XX...    *  *   X\n" +
            "X....  XXXXXXXXXX\n" +
            "XXXXXXXX         \n" +
            "                   ",

            "              XXXXXXXX\n" +
            "              X  ....X\n" +
            "   XXXXXXXXXXXX  ....X\n" +
            "   X    X  * *   ....X\n" +
            "   X ***X*  * X  ....X\n" +
            "   X  *     * X  ....X\n" +
            "   X ** X* * *XXXXXXXX\n" +
            "XXXX  * X     X       \n" +
            "X   X XXXXXXXXX       \n" +
            "X    *  XX            \n" +
            "X **X** @X            \n" +
            "X   X   XX            \n" +
            "XXXXXXXXX             \n" +
            "                      ",

            "        XXXXX    \n" +
            "        X   XXXXX\n" +
            "        X X*XX  X\n" +
            "        X     * X\n" +
            "XXXXXXXXX XXX   X\n" +
            "X....  XX *  *XXX\n" +
            "X....    * ** XX \n" +
            "X....  XX*  * @X \n" +
            "XXXXXXXXX  *  XX \n" +
            "        X * *  X \n" +
            "        XXX XX X \n" +
            "          X    X \n" +
            "          XXXXXX \n" +
            "                 "
    };

    /**
     * Allows the program to store which map is currently being displayed.
     */
    public Maps() {
        this.current = 0;
    }


    /**
     * Retrives a map from the array of map strings.
     * @return returns the string to allow it to be decoded and displayed as a level
     */
    public String getCurrentLevelString() {
        return levels[this.current];
    }

    /**
     * Retrieves which map number is stored.
     * @return returns the number of the map stored.
     */
    public int getCurrentLevel() {
        return this.current;
    }

    /**
     * calculates how many different map strings are contained in the array.
     * @return returns the amount of map strings. Currently there are 5.
     */
    public int getLevelAmount() {
        return this.levels.length;
    }

    /**
     * changes the level counter by increasing the amount by 1 each time a level is either completed or skipped.
     */
    public void progressNextLevel() {
        this.current++;
        if (current > this.getLevelAmount()) {
            this.current = this.getLevelAmount() - 1;
        }
    }

    /**
     * Allows the program to calculate if there is more levels to complete or if the pool of levels is finished.
     * @return if there are more levels returns true otherwise returns false.
     */
    public boolean hasNextLevel() {
        return current + 1 <= this.getLevelAmount() - 1;
    }
}

                                                                           
