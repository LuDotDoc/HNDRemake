package Week08.Assessment;

import Week08.TestingCode.Actor;

import java.awt.Image;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                        *
 *************************************************************************/

public class MapElement {

    private Image image;
    private int x;
    private int y;

    public MapElement(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Image getImage() {
        return image;
    }
    public void setImage(Image image) {
        this.image = image;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public static boolean checkOverlap(MapElement e1, MapElement e2) {
        if (e1.getX() == e2.getX() && e1.getY() == e2.getY()) {
            return true;
        }

        return false;
    }
}
