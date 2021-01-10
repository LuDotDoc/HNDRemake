package Week08.Assessment;

import Week08.TestingCode.Sokoban;

import javax.swing.JFrame;
import java.awt.EventQueue;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class SokobanDriver extends JFrame {
    /**
     * constructor class that runs the init function by default.
     */
    public SokobanDriver() {
        this.init();
    }

    /**
     * Initializes the window to show the game on giving it default options such as title and what to do when the user presses the close button.
     */
    private void init() {
        this.setTitle("Sokoban!");
        Level level = new Level(this);
        this.add(level);
        this.resize(level);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    /**
     * Resizes the window depending on the given map the level is using.
     * @param level uses the level dimensions to resize the window.
     */
    public void resize(Level level) {
        this.setSize(level.getLevelWidth() + Config.OFFSET + (Config.OFFSET / 2), level.getLevelHeight() + (Config.OFFSET * 2));
    }

    /**
     * The main method. This starts the game running.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SokobanDriver driver = new SokobanDriver();
            driver.setVisible(true);
        });
    }
}

                                                                           
