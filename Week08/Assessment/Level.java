package Week08.Assessment;

import java.util.ArrayList;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class Level {

    private WarehouseKeeper warehouseKeeper;

    private ArrayList<Wall> walls;
    private ArrayList<Crate> crates;
    private ArrayList<Diamond> diamonds;

    private int levelWidth = 0;
    private int levelHeight = 0;

    private Map map;

    /**
     * This function allows the map to be generated based on the array of strings given in the Maps class. Each different character in the array is assigned a different object.
     * Capital Xs are placeholders for walls on the map, *s are crates, . are the places to put crates etc
     * This information is stored in array lists so that it can be used in the draw world function.
     */
    public Level(Map map) {
        this.walls = new ArrayList<>();
        this.crates = new ArrayList<>();
        this.diamonds = new ArrayList<>();

        this.map = map;

        int x = Config.OFFSET;
        int y = Config.OFFSET;

        String level = map.getMapString();

        for (int i = 0; i < level.length(); i++) {
            char item = level.charAt(i);

            switch (item) {
                case '\n':
                    y += Config.SPACE;
                    if (this.levelWidth < x) {
                        this.levelWidth = x;
                    }
                    x = Config.OFFSET;
                    break;

                case 'X':
                    this.walls.add(new Wall(x, y));
                    x += Config.SPACE;
                    break;

                case '*':
                    this.crates.add(new Crate(x, y));
                    x += Config.SPACE;
                    break;

                case '.':
                    this.diamonds.add(new Diamond(x, y));
                    x += Config.SPACE;
                    break;

                case '@':
                    this.warehouseKeeper = new WarehouseKeeper(x, y);
                    x += Config.SPACE;
                    break;

                case ' ':
                    x += Config.SPACE;
                    break;

                default:
                    break;
            }
        }

        this.levelHeight = y;
    }

    /**
     * Takes the created lists of walls,diamonds and crates and adds them to a singular list. Allowing easy manipulation in case of level restart or completion.
     * @return
     */
    public ArrayList<MapElement> getMapElements() {
        ArrayList<MapElement> elements = new ArrayList<>();

        elements.addAll(this.walls);
        elements.addAll(this.diamonds);
        elements.addAll(this.crates);

        return elements;
    }

    /**
     * Removes all the diamonds, crates and walls from the lists
     */
    public void clear() {
        this.diamonds.clear();
        this.crates.clear();
        this.walls.clear();
    }

    public ArrayList<Wall> getWalls() {
        return walls;
    }

    public ArrayList<Crate> getCrates() {
        return crates;
    }

    public ArrayList<Diamond> getDiamonds() {
        return diamonds;
    }

    public WarehouseKeeper getWarehouseKeeper() {
        return warehouseKeeper;
    }

    public void setWarehouseKeeper(WarehouseKeeper warehouseKeeper) {
        this.warehouseKeeper = warehouseKeeper;
    }

    public int getLevelWidth() {
        return levelWidth;
    }

    public void setLevelWidth(int levelWidth) {
        this.levelWidth = levelWidth;
    }

    public int getLevelHeight() {
        return levelHeight;
    }

    public void setLevelHeight(int levelHeight) {
        this.levelHeight = levelHeight;
    }
}

