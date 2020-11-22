package Week10.FileHandling;

import java.io.File;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week10.FileReader                          *
 *************************************************************************/

public class DriverMain {

    public static void main(String[] args) {
        String test = Reader.ReadFromFile(("Week10/FileHandling/TestText"));
        System.out.println(test);

        FileCreation.CreateFile("Week10/FileHandling/TestText");

        Writer.WriteToFile("Week10/FileHandling/TestText","The quick brown fox jumped over the lazy dog!");


    }

}

                                                                           
