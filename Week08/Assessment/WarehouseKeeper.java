package Week08.Assessment;

import javafx.scene.image.Image;

import javax.swing.*;


/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class WarehouseKeeper extends MovableMapElement {
    /**
     * Holds the x and y coordinates of player character. Also holds the image location so that the character has am image.
     * @param x x coordinate
     * @param y y coordinate
     */
    public WarehouseKeeper(int x, int y) {
        super(x, y);

        ImageIcon icon = new ImageIcon("Week08/Assessment/WarehouseImages/WarehouseKeeper.png");
        this.setImage(icon.getImage());
    }
}

                                                                           
