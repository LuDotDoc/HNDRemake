package Week08.Assessment;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                             Week08.Assessment                          *
 *************************************************************************/

class MovementController extends KeyAdapter {

    private Game game;

    public MovementController(Game game) {
        this.game = game;
    }

    /**
     * This function takes in keyboard events. Such as pressing up, down, left or right and assigns them functionality.
    */
    @Override
    public void keyPressed(KeyEvent e) {
        if (this.game.isCompleted()) {
            return;
        }

        int key = e.getKeyCode();
        switch (key) {

            case (KeyEvent.VK_LEFT):
            case (KeyEvent.VK_A):
                this.game.moveLeft();
                break;

            case KeyEvent.VK_RIGHT:
            case (KeyEvent.VK_D):
                this.game.moveRight();
                break;

            case KeyEvent.VK_UP:
            case (KeyEvent.VK_W):
                this.game.moveUp();
                break;

            case KeyEvent.VK_DOWN:
            case (KeyEvent.VK_S):
                this.game.moveDown();
                break;

            case KeyEvent.VK_R:
                this.game.moveResetMap();
                break;

            case KeyEvent.VK_N:
                this.game.skipLevelCheat();
                break;

            default:
                break;
        }

        this.game.repaint();
    }
}
