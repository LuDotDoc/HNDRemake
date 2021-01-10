package Week08.Assessment;

import javax.swing.*;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class Crate extends MovableMapElement {
    /**
     * Holds the x and y coordinates of crate objects. Also holds the image location so that crates have images.
     * @param x x coordinate
     * @param y y coordinate
     */
    public Crate(int x, int y) {
        super(x, y);

        ImageIcon icon = new ImageIcon("Week08/Assessment/WarehouseImages/Crate.png");
        this.setImage(icon.getImage());
    }
}

                                                                           
