package Week10.FileHandling;

import java.io.File;

import static Week10.FileHandling.FileCreation.*;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week10.FileReader                          *
 *************************************************************************/

public class DriverMain {

    public static void main(String[] args) {
        String test = Reader.ReadFile(("Week10/FileHandling/TestText"));
        System.out.println(test);

        File test2 = FileCreation.FileCreation("Week10/FileHandling/TestText");

        File test3 = Writer.writeToFile("Week10/FileHandling/TestText","The quick brown fox jumped over the lazy dog!");


    }

}

                                                                           
