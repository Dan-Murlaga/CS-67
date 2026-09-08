package Notes;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Sep8 {
    public static void main(String[] args) throws IOException {
        PrintWriter outputFile = new PrintWriter("Sep8RandomNumbers.txt");
        File myFile = new File("Sep8RandomNumbers.txt");
        Scanner inputFile = new Scanner(myFile);

        Random randomNumber = new Random();
        int number, average, count;

        for (int i=0; i<5; i++) {
            number = randomNumber.nextInt(100);
            outputFile.println(number);
        }
        outputFile.close();

        average = 0;
        count = 0;
        while (inputFile.hasNext()) {
            average += inputFile.nextInt();
            count++;
        }
        inputFile.close();

        average = average / count;
        System.out.println(average);
    }
}