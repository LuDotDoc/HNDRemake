package Week10.FileHandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week10.FileHandling                          *
 *************************************************************************/

public class Writer {

    public static File writeToFile(String fileName, String fileContent)  {
        System.out.println("WRITING TO FILE");

        // In similar fashion to reading a file, Java provides some classed to support writing.

        // The FileWriter provides basic writing functionality.
        FileWriter writer = null;

        // The BufferedWriter provides some more sophisticated functionality, buffering the output to make the writing efficient.
        BufferedWriter outputBuffer = null;
        try {

            // We create a FileWriter by passing our File object to the constructor.
            writer = new FileWriter(fileName);

            // Now we can create a BufferedWriter by passing the writer Object to the BufferedWriter constructor.
            outputBuffer = new BufferedWriter(writer);

            // Once we have an Object to write with we can write out some Strings to the file using
            // the write() function.
//            outputBuffer.write("Output file from Java.\n");
//            outputBuffer.write("We have learned a little about the beautiful mind of Ada Lovelace.\n");
//            outputBuffer.write("And we have been introduced to reading and writing files in Java.\n");
            outputBuffer.write(fileContent);

        }catch(IOException ioe){ // both creating FileWriter and write() can throw an Exception so we hava a catch to handle them
            ioe.printStackTrace();

        }finally{	// we have an open file so we must make sure it is disposed of in a finally block
            if(outputBuffer != null){
                try {
                    outputBuffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }



}

                                                                           
