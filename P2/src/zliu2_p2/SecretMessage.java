package zliu2_p2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * Zhou Liu
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
/**
 * This is the program that converts a scrambled message file into plain text.
 * The program will read the message from the file, then organize the
 * characters in the proper order.
 */
public class SecretMessage {
    /**
     * This is the main method.
     * This method will ask the user for the name of a file.
     * Check to see that the file exists and contains some data.
     * Open and read this file exactly once
     * Using your MessageDecoder class, unravel and display the message
     * Offer to do it again on another file
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //Holds integer from the file.
        int index;
        //Holds string from the file.
        String value;
        //Get the input from the user if they want to repeat the program.
        String input;
        //Set a boolean repeat the program.
        boolean repeat = false;
        //Set a constant
        final String NO = "no";
        //Create a Scanner Object.
        Scanner keyboard = new Scanner(System.in);
        //Call a method that prints welcome message.
        welcomeMessage();
        //repeat the program
        while (!repeat) {
            //Holds the name of file.
            String filename;
            do {
                //Ask user the file name.
                System.out.print("Enter secret file name: ");
                //Initialize the file name.
                filename = keyboard.nextLine();
                //Ask user again if the file is not valid.
            } while (!isValidFile(filename));
            //Create a new File Object.
            File file = new File(filename);
            //Create a Scanner to read from the file.
            Scanner reader = new Scanner(file);
            //Create a new MessageDecoder Object.
            MessageDecoder decoder = new MessageDecoder();
            //Read elements from the file
            while (reader.hasNext()) {
                //Split the elements by the whitespace.
                String[] part = reader.nextLine().split("\\s+");
                //To check if the element is a space.
                if (part[0].length()== 0)
                //Initialize the String
                    value = " ";
                else
                //Initialized the String.
                    value = part[0];
                //Initialize the integer element.
                index = Integer.parseInt(part[1]);
                //Add elements to the list.
                decoder.add(value, index);
            }
            //Prints out the plain text message.
            System.out.print("Decoded: " + decoder.getPlainTextMessage());
            //Ask user if they want to repeat the program.
            System.out.print("\nWould you like to try again? (no to exit): ");
            //Get the answer from the user.
            input = keyboard.nextLine().toLowerCase();
            if (input.compareTo(NO) == 0)
                repeat = true;
        }
        //Calls the method that prints a goodbye message.
        goodbyeMessage();
        //Close scanner.
        keyboard.close();
    }

    /**
     * This method will print out a welcome message.
     */
    public static void welcomeMessage() {
    System.out.println("This program reads an encoded message from a file " +
            "supplied by the user and\n" +
            "displays the contents of the message before it was encoded.\n");
    }

    /**
     * This method will print out a goodbye message.
     */
    public static void goodbyeMessage(){
        System.out.print("\nThank you for using the message decoder.\n");
    }
    /**
     * Checks to see that the user-specified file name refers to a valid
     * file on the disk and not a directory. Displays an error message to the
     * user if that is not the case.
     * @param name file name string to check
     * @return true if file exists on disk and is not a directory
     */
    private static boolean isValidFile(String name) {
        //Create a new File object.
        File path = new File(name);
        //To check if the file is valid.
        boolean isValid = path.exists() && !path.isDirectory();
        if (!isValid) {
            // Display a proper error message
            System.out.print("File is not found. Please try again.\n");
        }
        //return if the file is valid.
        return isValid;
    }
}

