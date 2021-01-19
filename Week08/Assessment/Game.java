package Week08.Assessment;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class Game extends JPanel {
    private final int LEFT_COLLISION = 1;
    private final int RIGHT_COLLISION = 2;
    private final int TOP_COLLISION = 3;
    private final int BOTTOM_COLLISION = 4;

    private Maps maps;
    private Level level;

    private boolean isCompleted = false;
    private Long movesCounter;

    public Game() {
        this.movesCounter = 0L;
        addKeyListener(new MovementController(this));
        this.setFocusable(true);

        this.maps = new Maps();

        this.level = new Level(this.maps.getCurrentMap());
    }

    /**
     * Draws the map given the information passed from the array lists. Sets the default window background colour and size.
     * @param g default parameter for swing
     */
    public void drawWorld(Graphics g) {
        g.setColor(new Color(250, 221, 186));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        ArrayList<MapElement> world = this.level.getMapElements();
        world.add(this.level.getWarehouseKeeper());

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

    /**
     * This function is used to find out if all the diamonds are occupied with crates. If they are all occupied then the level is complete. The program moves onto the next map.
     * @param skipCheck if this parameter is passed true then the diamonds do not all have to be occupied to finish the level. IE when the skip button is pressed.
     */
    public void isGameComplete(boolean skipCheck) {
        int numberOfDiamonds = this.level.getDiamonds().size();
        int finishedDiamonds = 0;

        if (!skipCheck) {
            for (int i = 0; i < numberOfDiamonds; i++) {
                Crate crate = this.level.getCrates().get(i);
                for (Diamond diamond : this.level.getDiamonds()) {
                    if (MapElement.checkOverlap(crate, diamond)) {
                        finishedDiamonds += 1;
                    }
                }
            }
            if (finishedDiamonds != numberOfDiamonds) {
                return;
            }
        }

        this.isCompleted = true;

        if (this.maps.hasNextLevel()) {
            this.maps.progressNextLevel();
            this.level = new Level(this.maps.getCurrentMap());
            this.isCompleted = false;
        }

        repaint();
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
                for (int i = 0; i < this.level.getWalls().size(); i++) {
                    Wall wall = this.level.getWalls().get(i);

                    if (movableMapElement.isLeftCollision(wall)) {
                        return true;
                    }
                }
                return false;

            case RIGHT_COLLISION:
                for (int i = 0; i < this.level.getWalls().size(); i++) {
                    Wall wall = this.level.getWalls().get(i);

                    if (movableMapElement.isRightCollision(wall)) {
                        return true;
                    }
                }
                return false;

            case TOP_COLLISION:
                for (int i = 0; i < this.level.getWalls().size(); i++) {
                    Wall wall = this.level.getWalls().get(i);

                    if (movableMapElement.isTopCollision(wall)) {
                        return true;
                    }
                }
                return false;


            case BOTTOM_COLLISION:
                for (int i = 0; i < this.level.getWalls().size(); i++) {
                    Wall wall = this.level.getWalls().get(i);

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
    private boolean checkCrateCollision(int type) {
        switch (type) {
            case LEFT_COLLISION:
                for (int i = 0; i < this.level.getCrates().size(); i++) {
                    Crate crate = this.level.getCrates().get(i);
                    if (this.level.getWarehouseKeeper().isLeftCollision(crate)) {
                        for (int j = 0; j < this.level.getCrates().size(); j++) {
                            Crate item = this.level.getCrates().get(j);
                            if (!crate.equals(item)) {
                                if (crate.isLeftCollision(item)) {
                                    return true;
                                }
                            }
                            if (checkWallCollision(crate, LEFT_COLLISION)) {
                                return true;
                            }
                        }
                        crate.move(-Config.SPACE, 0, this.level.getDiamonds());
                        isGameComplete(false);
                    }
                }
                return false;

            case RIGHT_COLLISION:
                for (int i = 0; i < this.level.getCrates().size(); i++) {
                    Crate crate = this.level.getCrates().get(i);
                    if (this.level.getWarehouseKeeper().isRightCollision(crate)) {
                        for (int j = 0; j < this.level.getCrates().size(); j++) {
                            Crate item = this.level.getCrates().get(j);
                            if (!crate.equals(item)) {
                                if (crate.isRightCollision(item)) {
                                    return true;
                                }
                            }
                            if (checkWallCollision(crate, RIGHT_COLLISION)) {
                                return true;
                            }
                        }
                        crate.move(Config.SPACE, 0, this.level.getDiamonds());
                        isGameComplete(false);
                    }
                }
                return false;

            case TOP_COLLISION:

                for (int i = 0; i < this.level.getCrates().size(); i++) {
                    Crate crate = this.level.getCrates().get(i);
                    if (this.level.getWarehouseKeeper().isTopCollision(crate)) {
                        for (int j = 0; j < this.level.getCrates().size(); j++) {
                            Crate item = this.level.getCrates().get(j);
                            if (!crate.equals(item)) {
                                if (crate.isTopCollision(item)) {
                                    return true;
                                }
                            }
                            if (checkWallCollision(crate, TOP_COLLISION)) {
                                return true;
                            }
                        }
                        crate.move(0, -Config.SPACE, this.level.getDiamonds());
                        isGameComplete(false);
                    }
                }
                return false;

            case BOTTOM_COLLISION:
                for (int i = 0; i < this.level.getCrates().size(); i++) {
                    Crate crate = this.level.getCrates().get(i);
                    if (this.level.getWarehouseKeeper().isBottomCollision(crate)) {
                        for (int j = 0; j < this.level.getCrates().size(); j++) {
                            Crate item = this.level.getCrates().get(j);
                            if (!crate.equals(item)) {
                                if (crate.isBottomCollision(item)) {
                                    return true;
                                }
                            }
                            if (checkWallCollision(crate, BOTTOM_COLLISION)) {

                                return true;
                            }
                        }
                        crate.move(0, Config.SPACE, this.level.getDiamonds());
                        isGameComplete(false);
                    }
                }
                break;

            default:
                break;
        }
        return false;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.drawWorld(g);
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void moveLeft() {
        if (checkWallCollision(this.level.getWarehouseKeeper(),
                LEFT_COLLISION)) {
            return;
        }
        if (checkCrateCollision(LEFT_COLLISION)) {
            return;
        }
        this.level.getWarehouseKeeper().move(-Config.SPACE, 0);
        movesCounter++;
    }

    public void moveRight() {
        if (checkWallCollision(this.level.getWarehouseKeeper(), RIGHT_COLLISION)) {
            return;
        }
        if (checkCrateCollision(RIGHT_COLLISION)) {
            return;
        }
        this.level.getWarehouseKeeper().move(Config.SPACE, 0);
        movesCounter++;
    }

    public void moveUp() {
        if (checkWallCollision(this.level.getWarehouseKeeper(), TOP_COLLISION)) {
            return;
        }
        if (checkCrateCollision(TOP_COLLISION)) {
            return;
        }
        this.level.getWarehouseKeeper().move(0, -Config.SPACE);
        movesCounter++;
    }

    public void moveDown() {
        if (checkWallCollision(this.level.getWarehouseKeeper(), BOTTOM_COLLISION)) {
            return;
        }
        if (checkCrateCollision(BOTTOM_COLLISION)) {
            return;
        }
        this.level.getWarehouseKeeper().move(0, Config.SPACE);
        movesCounter++;
    }

    public void moveResetMap() {
        this.level = new Level(this.maps.getCurrentMap());
        movesCounter++;
    }

    public void skipLevelCheat() {
        isCompleted = true;
        isGameComplete(true);
    }

    public Level getLevel() {
        return level;
    }
}
