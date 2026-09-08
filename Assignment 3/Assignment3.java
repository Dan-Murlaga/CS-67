import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int year, loopNumber;
        String title, publisher;
        VideoGame game;

        System.out.print("How many games would you like to make? ");
        loopNumber = keyboard.nextInt();
        keyboard.nextLine();

        VideoGame[] gameShelf;
        gameShelf = new VideoGame[loopNumber];

        for (int i=0; i<loopNumber; i++) {
            System.out.println("\nCreating new game");
            System.out.print("Enter the game's title: ");
            title = keyboard.nextLine();

            System.out.print("Enter the game's release year: ");
            year = keyboard.nextInt();
            keyboard.nextLine();

            System.out.print("Enter the game's publisher: ");
            publisher = keyboard.nextLine();

            game = new VideoGame(title, year, publisher);
            gameShelf[i] = game;
        }

        keyboard.close();

        System.out.println("\nGame Shelf:");
        for (int i=0; i<loopNumber; i++) {
            gameShelf[i].displayGame();
        }
    }
}