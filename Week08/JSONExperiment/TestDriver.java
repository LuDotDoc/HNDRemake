package Week08.JSONExperiment;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileOutputStream;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.JSONExperiment                          *
 *************************************************************************/

public class TestDriver {

    public static void main(String[] args) {
        ObjectMapper objmap = new ObjectMapper();
        LevelTest level = new LevelTest();
        level.reference = "level-01";
        level.name = "level 1";
        level.map = new String[]{
                "ooooXXXXXooooooooooooo",
                "ooooXoooXooooooooooooo",
                "ooooX*ooXooooooooooooo",
                "ooXXXoo*XXXooooooooooo",
                "ooXoo*oo*oXooooooooooo",
                "XXXoXoXXXoXoooooXXXXXX",
                "XoooXoXXXoXXXXXXXoo..X",
                "Xo*oo*ooooooooooooo..X",
                "XXXXXoXXXXoX@XXXXoo..X",
                "ooooXooooooXXXooXXXXXX",
                "ooooXXXXXXXXoooooooooo",
                "oooooooooooooooooooooo",
                "oooooooooooooooooooooo"};

        LevelTest level2 = new LevelTest();
        level2.reference = "level-02";
        level2.name = "level 2";
        level2.map = new String[]{
                "XXXXXXXXXXXXoo",
                "X..ooXoooooXXX",
                "X..ooXo*oo*ooX",
                "X..ooX*XXXXooX",
                "X..oooo@oXXooX",
                "X..ooXoXoo*oXX",
                "XXXXXXoXX*o*oX",
                "ooXo*oo*o*o*oX",
                "ooXooooXoooooX",
                "ooXXXXXXXXXXXX",
                "oooooooooooooo",
                "oooooooooooooo",
                "oooooooooooooo"
        };


        LevelsContainer container = new LevelsContainer();
        container.levels = new LevelTest[]{level,level2};


        try {
            objmap.writeValue(new FileOutputStream("Week08/JSONExperiment/levelConstruction.json"), container);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something done fucked up " + e.getMessage());
        }
    }
}

                                                                           
