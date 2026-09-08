import java.io.*;
import java.util.Scanner;

public class Assignment4 {
    public static void main(String[] args) throws IOException {
        String message1, message2, message3, currentLine;
        File inputFile = new File("Assignment4Input.txt");
        Scanner inputText = new Scanner(inputFile);

        message1 = "";
        message2 = "";
        message3 = "";
        while (inputText.hasNext()) {
            currentLine = inputText.nextLine();

            for (int i=0; i<currentLine.length(); i++) {
                if (currentLine.charAt(i) == 'X') {
                    message1 += currentLine.charAt(i+3);
                } else if (currentLine.charAt(i) == 'Y') {
                    message2 += currentLine.charAt(i+5);
                } else if (currentLine.charAt(i) == 'W') {
                    message3 += currentLine.charAt(i+4);
                }
            }
        }
        
        System.out.println(message1);
        System.out.println(message2);
        System.out.println(message3);
        inputText.close();
    }
}
