/*
 * Bootcamp 2 Solution
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package MessageGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Generates scrambled messages from user input and saves the coded message
 * to the file.
 * @author bc2soln
 */
public class P2MessageGen {
    /**
     * Main entry point of the generator program
     * @param args not used
     * @throws FileNotFoundException when file error occurs
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Determine the message to scramble
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter message: ");
        String msg = kbd.nextLine();

        // Create a list of message elements, in order, starting from 1 posn
        ArrayList<Entry> list = new ArrayList<>();
        int posn = 1;
        for (char c : msg.toCharArray()) {
            list.add(new Entry(c, posn++));
        }

        // Shuffle the elements of the message, keeping original positions
        long seed = System.nanoTime();
        Random rand = new Random(seed);
        Collections.shuffle(list, rand);

        // Display the scrambled message to the user
        System.out.println("Scambled Message: ");
        outputList(list, System.out);

        // Save the scrambled message to a file given by the user
        System.out.print("Enter file name: ");
        String fname = kbd.nextLine();
        File path = new File(fname);
        PrintStream fstream = new PrintStream(path);
        outputList(list, fstream);
        fstream.close();

        System.out.println("Your file was saved to:");
        System.out.println(path.getAbsolutePath());
        kbd.close();
    }

    /**
     * Displays the contents of the message elements sequence as they appear
     * in the container.
     * @param list elements of the message
     * @param strm location to print the contents
     */
    private static void outputList(ArrayList<Entry> list, PrintStream strm) {
        for (Entry e : list) {
            strm.print(e.ch);
            strm.print(" ");
            strm.println(e.posn);
        }
    }

    /**
     * Represents a message element.
     */
    static class Entry {
        /**
         * character of the message
         */
        public char ch;
        /**
         * position of the character entry, starting from 1
         */
        public int posn;

        /**
         * Constructs an entry of the message
         * @param ch   character of the message
         * @param posn position of the character, starting from 1
         */
        Entry(char ch, int posn) {
            this.ch = ch;
            this.posn = posn;
        }
    }
}
