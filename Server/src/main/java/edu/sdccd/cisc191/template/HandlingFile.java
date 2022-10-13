package edu.sdccd.cisc191.template;

import java.io.*;

/**
 * This class saves the entire game of DigitsGame into a
 * file as an output, and reads it back to the terminal
 * in the Server class. A simple showcase of I/O streams.
 */
public class HandlingFile {
    //  writes the entire DigitsGame into the output.txt file in the directory
    public static void createFile() {
        try {
            BufferedWriter writer  = new BufferedWriter(new FileWriter("results.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  reads all lines of the output.txt file
    public static void readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("results.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  deletes the output.txt created in the directory
    public static void deleteFile() {
        File file = new File("results.txt");

        if(file.exists()) {
            if (file.delete()) {
                System.out.println("\n" + file.getName() + " is successfully deleted.");
            } else {
                System.out.println("\nFailed to delete " + file.getName() + " file");
            }
        }
    }

    public HandlingFile() {
        HandlingFile.createFile();
        HandlingFile.readFile();
    }

    //  calls createFile() and readFile() methods -- does NOT delete the output file!

}
