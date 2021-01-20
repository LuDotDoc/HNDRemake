package Week08.Assessment;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class MovableMapElement extends MapElement {

    public MovableMapElement(int x, int y) {
        super(x, y);
    }

    /**
     * Checks to see if there is space to the left, right, top or bottom of an object. Allowing another object to occupy that space.
     * @param mapElement This could be various crates or player model.
     * @return returns a boolean value if there is a collision or not.
     */
    public boolean isLeftCollision(MapElement mapElement) {
        return getX() - Config.SPACE == mapElement.getX() && getY() == mapElement.getY();
    }

    public boolean isRightCollision(MapElement mapElement) {
        return getX() + Config.SPACE == mapElement.getX() && getY() == mapElement.getY();
    }

    public boolean isTopCollision(MapElement mapElement) {
        return getY() - Config.SPACE == mapElement.getY() && getX() == mapElement.getX();
    }

    public boolean isBottomCollision(MapElement mapElement) {
        return getY() + Config.SPACE == mapElement.getY() && getX() == mapElement.getX();
    }

    public void move(int x, int y) {
        int dx = getX() + x;
        int dy = getY() + y;
        setX(dx);
        setY(dy);
    }
}

                                                                           
