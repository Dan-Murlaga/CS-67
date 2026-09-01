import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String title1, title2, publisher1, publisher2;
        int year1, year2;

        System.out.println("Create 2 video games");

        System.out.println("Enter the title of the first game:");
        title1 = keyboard.nextLine();

        System.out.println("Enter the year of release:");
        year1 = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Enter the publisher of the first game:");
        publisher1 = keyboard.nextLine();

        System.out.println("\nNow for the second game");

        System.out.println("Enter the title of the second game:");
        title2 = keyboard.nextLine();

        System.out.println("Enter the year of release:");
        year2 = keyboard.nextInt();
        keyboard.nextLine();

        System.out.println("Enter the publisher of the second game:");
        publisher2 = keyboard.nextLine();
        keyboard.close();

        VideoGame game1 = new VideoGame(title1, year1, publisher1);
        game1.displayGame();

        VideoGame game2 = new VideoGame(title2, year2, publisher2);
        game2.displayGame();
    }
}