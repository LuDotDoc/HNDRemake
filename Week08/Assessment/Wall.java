package Week08.Assessment;

import javax.swing.*;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class Wall extends MapElement {
    /**
     * Holds the x and y coordinates of wall objects. Also holds the image location so that walls have images.
     * @param x x coordinate
     * @param y y coordinate
     */
    public Wall(int x, int y) {
        super(x, y);

        ImageIcon icon = new ImageIcon("Week08/Assessment/WarehouseImages/Wall.png");
        this.setImage(icon.getImage());
    }
}
