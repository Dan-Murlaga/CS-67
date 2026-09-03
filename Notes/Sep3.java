package Notes;
import java.util.Scanner;

public class Sep3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Double temperature;
        int sleepHours, num, sum;

        System.out.print("Enter the current temperature: ");
        temperature = keyboard.nextDouble();

        if (temperature > 90.0) {
            System.out.println("Time for ice cream");
        } else {
            System.out.println("Time for cake");
        }

        System.out.print("How many hours of sleep did you get? ");
        sleepHours = keyboard.nextInt();

        if (sleepHours > 8) {
            System.out.println("You are well-rested!");
        } else if (sleepHours > 4) {
            System.out.println("The coffee shop is right around the corner.");
        } else if (sleepHours >= 0) {
            System.out.println("Are you sure you are awake?");
        } else {
            System.out.println("Input error.");
        }

        num = 0;
        while (num != 7) {
            System.out.print("Enter an integer: ");
            num = keyboard.nextInt();
        }
        keyboard.close();

        num = 1;
        while (num <= 512) {
            System.out.println(num * 2);
            num++;
        }

        while (num == 513) {
            System.out.println(num);
        }

        for (int i=1; i<=5; i++) {
            System.out.println(i);
        }

        for (int i=33; i<=66; i+=3) {
            System.out.println(i);
        }

        for (int i=1; i>0; i++) {
            System.out.println(i);
        }

        sum = 0;
        for (int i=0; i<99; i+=2) {
            sum += i;
        }
        System.out.println(sum);

        for (int i=100; i>=0; i--) {
            System.out.println(i);
        }
    }
}
