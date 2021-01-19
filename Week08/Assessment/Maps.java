package Week08.Assessment;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class Maps {
    /**
     * Holds an array of arrays containing strings. This strings are text based representations of levels. Different characters are used to define different level elements
     * X = wall, * = crate, . = diamond, @ = warehouse keeper, spaces = spaces
     */
    private int current;

    private ArrayList<String> mapPaths;

    /**
     * Allows the program to store which map is currently being displayed.
     */
    public Maps() {
        this.current = 0;

        this.loadMapList();
    }

    private void loadMapList() {
        File folder = new File("Week08/Assessment/Levels");
        File[] mapList = folder.listFiles();

        this.mapPaths = new ArrayList<>();

        for (int i = 0; i < mapList.length; i++) {
            if (mapList[i].isFile() && mapList[i].getName().toLowerCase().contains("level")) {
                this.mapPaths.add(mapList[i].getAbsolutePath());
                //System.out.println(mapList[i].getAbsolutePath()); // debug
            }
        }
    }

    private String loadMap(String filePath) {
        StringBuilder out = new StringBuilder();

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                out.append(data + "\n");
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return out.toString();
    }

    /**
     * Retrieves which map number is stored.
     * @return returns the number of the map stored.
     */
    public int getCurrentLevel() {
        return this.current;
    }

    public Map getCurrentMap() {
        Map map = new Map();

        String mapPath = this.mapPaths.get(this.current);
        String mapString = this.loadMap(mapPath);

        // If the map encounters a problem, load a default map.
        if (mapString == null) {
            System.out.println("Error: Map file  '" + mapPath + "' cannot be loaded.");
            mapString = ". * @\n";
        }

        map.setMapString(mapString);

        return map;
    }

    /**
     * calculates how many different map strings are contained in the array.
     * @return returns the amount of map strings. Currently there are 5.
     */
    public int getLevelAmount() {
        return this.mapPaths.size();
    }

    /**
     * changes the level counter by increasing the amount by 1 each time a level is either completed or skipped.
     */
    public void progressNextLevel() {
        this.current++;
        if (current > this.getLevelAmount()) {
            this.current = this.getLevelAmount() - 1;
        }
    }

    /**
     * Allows the program to calculate if there is more levels to complete or if the pool of levels is finished.
     * @return if there are more levels returns true otherwise returns false.
     */
    public boolean hasNextLevel() {
        return current + 1 <= this.getLevelAmount() - 1;
    }
}
