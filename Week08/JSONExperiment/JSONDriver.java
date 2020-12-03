//package Week08.JSONExperiment;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.File;
//import java.io.FileOutputStream;
//
//public class JSONDriver {
//
//    public static void main(String[] args) {


        //TRYING TO FIGURE OUT HOW TO GET THIS ARRAY OF ARRAYS FROM THE JSON FILE IS NOT WORKING.
//        String[][] levelsTest = {
//                {"LEVEL 001             ",
//                 "ooooXXXXXooooooooooooo",
//                 "ooooXoooXooooooooooooo",
//                 "ooooX*ooXooooooooooooo",
//                 "ooXXXoo*XXXooooooooooo",
//                 "ooXoo*oo*oXooooooooooo",
//                 "XXXoXoXXXoXoooooXXXXXX",
//                 "XoooXoXXXoXXXXXXXoo..X",
//                 "Xo*oo*ooooooooooooo..X",
//                 "XXXXXoXXXXoX@XXXXoo..X",
//                 "ooooXooooooXXXooXXXXXX",
//                 "ooooXXXXXXXXoooooooooo",
//                 "oooooooooooooooooooooo",
//                 "oooooooooooooooooooooo"},
//                {"LEVEL 002     ",
//                 "XXXXXXXXXXXXoo",
//                 "X..ooXoooooXXX",
//                 "X..ooXo*oo*ooX",
//                 "X..ooX*XXXXooX",
//                 "X..oooo@oXXooX",
//                 "X..ooXoXoo*oXX",
//                 "XXXXXXoXX*o*oX",
//                 "ooXo*oo*o*o*oX",
//                 "ooXooooXoooooX",
//                 "ooXXXXXXXXXXXX",
//                 "oooooooooooooo",
//                 "oooooooooooooo",
//                 "oooooooooooooo"}
//        };
//
//        for (int x=0; x<levelsTest.length; x++) {
//            for (int y = 0; y < levelsTest[x].length; y++) {
//                System.out.println(levelsTest[x][y].toString());
//            }
//        }

//        levelTest level1 = new levelTest();
//        level1.levelMap = new String[]{
//                "level 001",
//                "ooooXXXXXooooooooooooo",
//                "ooooXoooXooooooooooooo",
//                "ooooX*ooXooooooooooooo",
//                "ooXXXoo*XXXooooooooooo",
//                "ooXoo*oo*oXooooooooooo",
//                "XXXoXoXXXoXoooooXXXXXX",
//                "XoooXoXXXoXXXXXXXoo..X",
//                "Xo*oo*ooooooooooooo..X",
//                "XXXXXoXXXXoX@XXXXoo..X",
//                "ooooXooooooXXXooXXXXXX",
//                "ooooXXXXXXXXoooooooooo",
//                "oooooooooooooooooooooo",
//                "oooooooooooooooooooooo"};
//
//        levelTest level2 = new levelTest();
//        level2.levelMap = new String[]{
//                "level 002",
//                "XXXXXXXXXXXXoo",
//                "X..ooXoooooXXX",
//                "X..ooXo*oo*ooX",
//                "X..ooX*XXXXooX",
//                "X..oooo@oXXooX",
//                "X..ooXoXoo*oXX",
//                "XXXXXXoXX*o*oX",
//                "ooXo*oo*o*o*oX",
//                "ooXooooXoooooX",
//                "ooXXXXXXXXXXXX",
//                "oooooooooooooo",
//                "oooooooooooooo",
//                "oooooooooooooo"};
//
//        levelsContainer container = new levelsContainer();
//        container.levels = new levelTest[]{level1, level2};
//        ObjectMapper objmap = new ObjectMapper();
//
//        try {
//            objmap.writeValue(new FileOutputStream("Week08/JSONExperiment/levelTest.json"), container);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Something done fucked up " + e.getMessage());
//        }


//        ObjectMapper objmap = new ObjectMapper();
//
//        // Write
//        TestThing tt = new TestThing();
//        tt.wobble = "warble";
//        tt.module = "who knows";
//        tt.numbers = new int[]{1,2,3,4,5,6,7,8};
//        tt.ignorethis = "NJOOOOOEOAFMEAOFM";
//
//        TestThing tt2 = new TestThing();
//        tt2.wobble = "aaaa";
//        tt2.module = "bbbb";
//        tt2.numbers = new int[]{9,10,11,12};
//
//        TestThingContainer container = new TestThingContainer();
//        container.store = new TestThing[]{tt, tt2};
//
//        try {
//            objmap.writeValue(new FileOutputStream("Week08/JSONExperiment/potato.json"), container);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Something done fucked up " + e.getMessage());
//        }

        // Read
//        try {
//            File file = new File("Week08/JSONExperiment/potato.json");
//            TestThing tw = objmap.readValue(file, TestThing.class);
//
//            System.out.println(tw.module);
//            System.out.println(tw.wobble);
//
//            for (int n : tw.numbers) {
//                System.out.println(n);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Something done fucked up " + e.getMessage());
//        }


//        ObjectMapper objmap = new ObjectMapper();
//
//        try {
//            File file = new File("Week08/JSONExperiment/levelTest.json");
//            levelsContainer test  = objmap.readValue(file, levelsContainer.class);
//
//            System.out.println(test);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Something done fucked up " + e.getMessage());
//        }
//
//
//    }
//}