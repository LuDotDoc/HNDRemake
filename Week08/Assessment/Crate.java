package Week08.Assessment;

import javax.swing.*;
import java.util.ArrayList;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class Crate extends MovableMapElement {

    private ImageIcon crateOnDiamond;
    private ImageIcon crateOffDiamond;

    /**
     * Holds the x and y coordinates of crate objects. Also holds the image location so that crates have images.
     * @param x x coordinate
     * @param y y coordinate
     */
    public Crate(int x, int y) {
        super(x, y);
        this.crateOnDiamond = new ImageIcon("Week08/Assessment/WarehouseImages/CrateInPlace.png");
        this.crateOffDiamond = new ImageIcon("Week08/Assessment/WarehouseImages/Crate.png");

        this.setImage(this.crateOffDiamond.getImage());
    }

    /**
     * This function allows the crate to be moved on screen. Also when a crate occupies a diamond it changes the image.
     * @param x x coordinate
     * @param y y coordinate
     * @param diamonds The array list of diamonds holds their coordinates in case a player moves a crate onto a diamond and it needs to use a different image.
     */
    public void move(int x, int y, ArrayList<Diamond> diamonds) {
        super.move(x, y);

        for (Diamond diamond : diamonds) {
            if (MapElement.checkOverlap(this, diamond)) {
                this.setImage(this.crateOnDiamond.getImage());
                break;
            }
        }
    }
}
