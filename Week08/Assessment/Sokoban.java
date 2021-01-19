package Week08.Assessment;

import javax.swing.*;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class Sokoban extends JFrame {
    /**
     * Initializes the window to show the game on giving it default options such as title and what to do when the user presses the close button.
     */
    public Sokoban() {
        this.setTitle("Sokoban!");
        Game game = new Game();
        this.add(game);
        this.resize(game);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    /**
     * Resize the window depending on the given map the level is using.
     * @param game uses the level dimensions to resize the window.
     */
    public void resize(Game game) {
        this.setSize(game.getLevel().getLevelWidth() + Config.OFFSET + (Config.OFFSET / 2), game.getLevel().getLevelHeight() + (Config.OFFSET * 3));
    }
}

                                                                           
