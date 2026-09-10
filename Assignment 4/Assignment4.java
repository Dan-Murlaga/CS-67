// Dan Murlaga CS 67 Assignment 4
import java.io.*;
import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args) throws IOException {

// Initiates variables
        String message1, message2, message3, currentLine;
        File inputFile = new File("Assignment4Input.txt");
        Scanner inputText = new Scanner(inputFile);

// Creates empty strings
        message1 = "";
        message2 = "";
        message3 = "";

// Main while loop to go through lines
        while (inputText.hasNext()) {
            currentLine = inputText.nextLine();

// Checks every character within an individual line
            for (int i=0; i<currentLine.length(); i++) {
                if (currentLine.charAt(i) == 'X') { // If the program finds 'X', it will add the third next char to message1
                    message1 += currentLine.charAt(i+3);
                } else if (currentLine.charAt(i) == 'Y') { // If the program finds 'Y', it will add the fifth next char to message2
                    message2 += currentLine.charAt(i+5);
                } else if (currentLine.charAt(i) == 'W') { // If the program finds 'W', it will add the fourth next char to message3
                    message3 += currentLine.charAt(i+4);
                }
            }
        }

// Prints all messages
        System.out.println(message1);
        System.out.println(message2);
        System.out.println(message3);
        inputText.close();
    }
}