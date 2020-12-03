package Week08.TestingCode;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Area extends Actor {

    public Area(int x, int y) {
        super(x, y);

        initArea();
    }

    private void initArea() {

        ImageIcon iicon = new ImageIcon("Week08/TestingCode/Diamond.png");
        Image image = iicon.getImage();
        setImage(image);
    }
}