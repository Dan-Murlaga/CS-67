import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;

public class Assignment10 {
    public static void main(String[] args) throws SQLException {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.print("\n------Dan's Video Games Database------\n"
                + "1. List all games\n"
                + "2. List games by genre\n"
                + "3. List games by publisher\n"
                + "4. List games by release year\n"
                + "5. List games before release year\n"
                + "6. List games after release year\n"
                + "7. List games by platform\n"
                + "8. Exit\n"
                + "Enter your choice: ");

            int choice;
            try {
                choice = keyboard.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer between 1 and 8.");
                keyboard.nextLine(); // Clear the invalid input
                continue;
            }
            keyboard.nextLine();
            if (choice < 1 || choice > 8) {
                System.out.println("Invalid choice. Number must be between 1 and 8.");
                continue;
            }

            ArrayList<String> gamesList = new ArrayList<String>();
            switch (choice) {
                case 1:
                    gamesList = VideoGamesAPI.allGames();
                    System.out.println("\n" + gamesList.size() + " games found:");
                    break;

                case 2:
                    System.out.print("Enter genre: ");
                    String genre = keyboard.nextLine();
                    gamesList = VideoGamesAPI.gamesByGenre(genre);

                    if (gamesList.isEmpty()) {
                        System.out.println("No games found for the genre: " + genre);
                    } else {
                        System.out.println("\n" + gamesList.size() + " games found:");
                    }
                    break;

                case 3:
                    System.out.print("Enter publisher: ");
                    String publisher = keyboard.nextLine();
                    gamesList = VideoGamesAPI.gamesByPublisher(publisher);

                    if (gamesList.isEmpty()) {
                        System.out.println("No games found for the publisher: " + publisher);
                    } else {
                        System.out.println("\n" + gamesList.size() + " games found:");
                    }
                    break;

                case 4:
                    System.out.print("Enter release year: ");
                    int releaseYear = keyboard.nextInt();
                    gamesList = VideoGamesAPI.gamesByYear(releaseYear);

                    if (gamesList.isEmpty()) {
                        System.out.println("No games found for the release year: " + releaseYear);
                    } else {
                        System.out.println("\n" + gamesList.size() + " games found:");
                    }
                    break;

                case 5:
                    System.out.print("Enter release year: ");
                    int beforeYear = keyboard.nextInt();
                    gamesList = VideoGamesAPI.gamesBeforeYear(beforeYear);

                    if (gamesList.isEmpty()) {
                        System.out.println("No games found before the release year: " + beforeYear);
                    } else {
                        System.out.println("\n" + gamesList.size() + " games found:");
                    }
                    break;

                case 6:
                    System.out.print("Enter release year: ");
                    int afterYear = keyboard.nextInt();
                    gamesList = VideoGamesAPI.gamesAfterYear(afterYear);

                    if (gamesList.isEmpty()) {
                        System.out.println("No games found after the release year: " + afterYear);
                    } else {
                        System.out.println("\n" + gamesList.size() + " games found:");
                    }
                    break;

                case 7:
                    System.out.print("Enter platform: ");
                    String platform = keyboard.nextLine();
                    gamesList = VideoGamesAPI.gamesByPlatform(platform);

                    if (gamesList.isEmpty()) {
                        System.out.println("No games found for the platform: " + platform);
                    } else {
                        System.out.println("\n" + gamesList.size() + " games found:");
                    }
                    break;

                case 8:
                    System.out.println("Exiting the program.");
                    keyboard.close();
                    return;
            }

            for (String game : gamesList) {
                System.out.println(game);
            }
        }
    }
}
