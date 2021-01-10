package Week08.Assessment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class Level extends JPanel {
    private int levelWidth = 0;
    private int levelHeight = 0;

    private final int LEFT_COLLISION = 1;
    private final int RIGHT_COLLISION = 2;
    private final int TOP_COLLISION = 3;
    private final int BOTTOM_COLLISION = 4;

    private ArrayList<Wall> walls;
    private ArrayList<Crate> crates;
    private ArrayList<Diamond> diamonds;
    private WarehouseKeeper warehouseKeeper;
    private boolean isCompleted = false;
    private Maps maps;
    private SokobanDriver _parent;
    private Long movesCounter;

    public Level(SokobanDriver parent) {
        this._parent = parent;
        this.movesCounter = 0L;
        addKeyListener(new Level.TAdapter());
        this.setFocusable(true);
        this.maps = new Maps();
        this.init();
    }

    /**
     * This function allows the map to be generated based on the array of strings given in the Maps class. Each different character in the array is assigned a different object.
     * Capital Xs are placeholders for walls on the map, *s are crates, . are the places to put crates etc
     * This information is stored in array lists so that it can be used in the draw world function.
     */
    public void init() {
        walls = new ArrayList<>();
        crates = new ArrayList<>();
        diamonds = new ArrayList<>();
        int x = Config.OFFSET;
        int y = Config.OFFSET;

        String level = this.maps.getCurrentLevelString();

        for (int i = 0; i < level.length(); i++) {
            char item = level.charAt(i);

            switch (item) {
                case '\n':
                    y += Config.SPACE;
                    if (this.levelWidth < x) {
                        this.levelWidth = x;
                    }
                    x = Config.OFFSET;
                    break;

                case 'X':
                    this.walls.add(new Wall(x, y));
                    x += Config.SPACE;
                    break;

                case '*':
                    this.crates.add(new Crate(x, y));
                    x += Config.SPACE;
                    break;

                case '.':
                    this.diamonds.add(new Diamond(x, y));
                    x += Config.SPACE;
                    break;

                case '@':
                    this.warehouseKeeper = new WarehouseKeeper(x, y);
                    x += Config.SPACE;
                    break;

                case ' ':
                    x += Config.SPACE;
                    break;

                default:
                    break;
            }
        }

        this.levelHeight = y;
    }

    /**
     * Draws the map given the information passed from the array lists. Sets the default window background colour and size.
     * @param g default parameter for swing
     */
    public void drawWorld(Graphics g) {
        g.setColor(new Color(250, 221, 186));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        ArrayList<MapElement> world = new ArrayList<>();

        world.addAll(this.walls);
        world.addAll(this.diamonds);
        world.addAll(this.crates);
        world.add(this.warehouseKeeper);

        for (MapElement element : world) {
            g.drawImage(element.getImage(), element.getX(), element.getY(), this);
        }
        if (isCompleted) {
            g.setColor(new Color(0, 0, 0));
            g.drawString("Completed", 25, 20);
        } else {
            g.setColor(new Color(0,0,0));
            g.drawString("Level: " + (this.maps.getCurrentLevel() + 1) + "/" + this.maps.getLevelAmount(), 25, 20);
        }
        g.drawString("Moves: " + this.movesCounter, 25, 35);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.drawWorld(g);
        this._parent.resize(this);
    }

    public int getLevelWidth() {
        return levelWidth;
    }
    public int getLevelHeight() {
        return levelHeight;
    }

    /**
     * This function takes in keyboard events. Such as pressing up, down, left or right and assigns them functionality.
     */
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (isCompleted) {
                return;
            }
            int key = e.getKeyCode();
            switch (key) {

                case (KeyEvent.VK_LEFT):
                case (KeyEvent.VK_A):
                    if (checkWallCollision(warehouseKeeper,
                            LEFT_COLLISION)) {
                        return;
                    }
                    if (checkBagCollision(LEFT_COLLISION)) {
                        return;
                    }
                    warehouseKeeper.move(-Config.SPACE, 0);
                    movesCounter++;
                    break;

                case KeyEvent.VK_RIGHT:
                case (KeyEvent.VK_D):
                    if (checkWallCollision(warehouseKeeper, RIGHT_COLLISION)) {
                        return;
                    }
                    if (checkBagCollision(RIGHT_COLLISION)) {
                        return;
                    }
                    warehouseKeeper.move(Config.SPACE, 0);
                    movesCounter++;
                    break;

                case KeyEvent.VK_UP:
                case (KeyEvent.VK_W):
                    if (checkWallCollision(warehouseKeeper, TOP_COLLISION)) {
                        return;
                    }
                    if (checkBagCollision(TOP_COLLISION)) {
                        return;
                    }
                    warehouseKeeper.move(0, -Config.SPACE);
                    movesCounter++;
                    break;

                case KeyEvent.VK_DOWN:
                case (KeyEvent.VK_S):
                    if (checkWallCollision(warehouseKeeper, BOTTOM_COLLISION)) {
                        return;
                    }
                    if (checkBagCollision(BOTTOM_COLLISION)) {
                        return;
                    }
                    warehouseKeeper.move(0, Config.SPACE);
                    movesCounter++;
                    break;

                case KeyEvent.VK_R:
                    restartLevel();
                    movesCounter++;
                    break;

                case KeyEvent.VK_N:
                    isCompleted = true;
                    isComplete(true);
                    break;

                default:
                    break;
            }
            repaint();
        }
    }

    /**
     * This function checks to see if a movable element is colliding with something. A wall or another crate.
     * @param movableMapElement different crates or player model can be checked.
     * @param type Each direction is given a number that correlates to the correct statement in the switch.
     * @return returns a boolean allowing the function to tell other functions if the path is blocked or not.
     */
    private boolean checkWallCollision(MovableMapElement movableMapElement, int type) {


        switch (type) {
            case LEFT_COLLISION:
                for (int i = 0; i < walls.size(); i++) {
                    Wall wall = walls.get(i);

                    if (movableMapElement.isLeftCollision(wall)) {
                        return true;
                    }
                }

                return false;

            case RIGHT_COLLISION:
                for (int i = 0; i < walls.size(); i++) {
                    Wall wall = walls.get(i);

                    if (movableMapElement.isRightCollision(wall)) {
                        return true;
                    }
                }

                return false;

            case TOP_COLLISION:
                for (int i = 0; i < walls.size(); i++) {
                    Wall wall = walls.get(i);

                    if (movableMapElement.isTopCollision(wall)) {
                        return true;
                    }
                }

                return false;


            case BOTTOM_COLLISION:
                for (int i = 0; i < walls.size(); i++) {
                    Wall wall = walls.get(i);

                    if (movableMapElement.isBottomCollision(wall)) {
                        return true;
                    }
                }

                return false;

            default:
                break;

        }
        return false;
    }

    /**
     * This function checks to see if a push crate is colliding with other crates or walls. If they are, they cannot be moved.
     * @param type Each direction to be checked is given a number this number correlates with the correct statement in the switch.
     * @return
     */
    private boolean checkBagCollision(int type) {

        switch (type) {
            case LEFT_COLLISION:

                for (int i = 0; i < crates.size(); i++) {
                    Crate crate = crates.get(i);

                    if (warehouseKeeper.isLeftCollision(crate)) {
                        for (int j = 0; j < crates.size(); j++) {
                            Crate item = crates.get(j);

                            if (!crate.equals(item)) {
                                if (crate.isLeftCollision(item)) {
                                    return true;
                                }
                            }

                            if (checkWallCollision(crate, LEFT_COLLISION)) {
                                return true;
                            }
                        }
                        crate.move(-Config.SPACE, 0);
                        isComplete(false);
                    }
                }

                return false;

            case RIGHT_COLLISION:

                for (int i = 0; i < crates.size(); i++) {
                    Crate crate = crates.get(i);

                    if (warehouseKeeper.isRightCollision(crate)) {
                        for (int j = 0; j < crates.size(); j++) {

                            Crate item = crates.get(j);

                            if (!crate.equals(item)) {

                                if (crate.isRightCollision(item)) {
                                    return true;
                                }
                            }

                            if (checkWallCollision(crate, RIGHT_COLLISION)) {
                                return true;
                            }
                        }

                        crate.move(Config.SPACE, 0);
                        isComplete(false);
                    }
                }
                return false;

            case TOP_COLLISION:

                for (int i = 0; i < crates.size(); i++) {

                    Crate crate = crates.get(i);

                    if (warehouseKeeper.isTopCollision(crate)) {

                        for (int j = 0; j < crates.size(); j++) {

                            Crate item = crates.get(j);

                            if (!crate.equals(item)) {

                                if (crate.isTopCollision(item)) {
                                    return true;
                                }
                            }

                            if (checkWallCollision(crate, TOP_COLLISION)) {
                                return true;
                            }
                        }

                        crate.move(0, -Config.SPACE);
                        isComplete(false);
                    }
                }

                return false;

            case BOTTOM_COLLISION:

                for (int i = 0; i < crates.size(); i++) {

                    Crate crate = crates.get(i);

                    if (warehouseKeeper.isBottomCollision(crate)) {

                        for (int j = 0; j < crates.size(); j++) {

                            Crate item = crates.get(j);

                            if (!crate.equals(item)) {

                                if (crate.isBottomCollision(item)) {
                                    return true;
                                }
                            }

                            if (checkWallCollision(crate, BOTTOM_COLLISION)) {

                                return true;
                            }
                        }

                        crate.move(0, Config.SPACE);
                        isComplete(false);
                    }
                }

                break;

            default:
                break;
        }

        return false;
    }

    /**
     * This function is used to find out if all the diamonds are occupied with crates. If they are all occupied then the level is complete. The program moves onto the next map.
     * @param skipCheck if this parameter is passed true then the diamonds do not all have to be occupied to finish the level. IE when the skip button is pressed.
     */
    public void isComplete(boolean skipCheck) {
        int numberOfDiamonds = diamonds.size();
        int finishedDiamonds = 0;

        if (!skipCheck) {
            for (int i = 0; i < numberOfDiamonds; i++) {
                Crate crate = crates.get(i);
                for (Diamond diamond : diamonds) {
                    if (crate.getX() == diamond.getX() && crate.getY() == diamond.getY()) {
                        finishedDiamonds += 1;
                    }
                }
            }
            if (finishedDiamonds != numberOfDiamonds) {
                return;
            }
        }
        isCompleted = true;
        if (this.maps.hasNextLevel()) {
            this.maps.progressNextLevel();
            this.restartLevel();
        }
        repaint();
    }

    /**
     * When this function is called it resets the level to a fresh state.
     */
    public void restartLevel() {
        diamonds.clear();
        crates.clear();
        walls.clear();

        init();

        if (isCompleted) {
            isCompleted = false;
        }
    }
}
