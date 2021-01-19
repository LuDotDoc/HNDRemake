package Week08.Assessment;

import javax.swing.JFrame;
import java.awt.EventQueue;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class SokobanDriver {

    /**
     * The main method. This starts the game running.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Sokoban driver = new Sokoban();
            driver.setVisible(true);
        });
    }
}

                                                                           
