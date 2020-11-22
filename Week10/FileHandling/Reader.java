package Week10.FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week10.FileHandling                      *
 *************************************************************************/

public class Reader {
    public static String ReadFromFile(String filename) {
        java.io.FileReader reader;
        BufferedReader inputBuffer = null;
        StringBuilder out = new StringBuilder();
        String line;

        try {
            reader = new FileReader(filename);
            inputBuffer = new BufferedReader(reader);
            line = inputBuffer.readLine();

            while (line != null) {
                out.append(line).append("\n");
                line = inputBuffer.readLine();
            }

        } catch (IOException error) {
            error.printStackTrace();

        } finally {
            if (inputBuffer != null) {
                try {
                    inputBuffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return out.toString();
    }
}

                                                                           
