package Week08.Assessment;

import javax.swing.*;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class Diamond extends MapElement {

    Boolean hasCrate;

    /**
     * Holds the x and y coordinates of diamond objects. Also holds the image location so that diamonds have images.
     * @param x x coordinate
     * @param y y coordinate
     */
    public Diamond(int x, int y) {
        super(x, y);

        ImageIcon icon = new ImageIcon("Week08/Assessment/WarehouseImages/Diamond.png");
        this.setImage(icon.getImage());
    }

    public Boolean getHasCrate() {
        return hasCrate;
    }

    public void setHasCrate(Boolean hasCrate) {
        this.hasCrate = hasCrate;
    }
}

                                                                           
