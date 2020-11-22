package Week10.FileHandling;

import java.io.File;
import java.io.IOException;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week10.FileHandling                          *
 *************************************************************************/

public class FileCreation {

    public static void CreateFile(String fileName) {
        System.out.println("CREATING A FILE");

        // We can also use the File class to create new files

        // This time we use the filename for the file we want to create as a parameter
        File outputFile = new File(fileName);

        try {
            // we want to create the file so we call createNewFile()
            if (outputFile.createNewFile()) {
                // if createNewFile() returns true it means the file was created
                System.out.println("New file created : " + outputFile.getAbsolutePath() + "/" + outputFile.getName());

            } else {
                // if createNewFile() returns false it means the file already exists
                System.out.println("File already exists : " + outputFile.getAbsolutePath() + "/" + outputFile.getName());
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }



    }


}

                                                                           
