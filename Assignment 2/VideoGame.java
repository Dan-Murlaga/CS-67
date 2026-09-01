public class VideoGame {
    String title, publisher;
    int year;

    public VideoGame(String gameTitle, int gameYear, String gamePublisher) {
        title = gameTitle;
        year = gameYear;
        publisher = gamePublisher;
    }

    public void displayGame() {
        System.out.println(title + " (" + year + ") Published by: " + publisher);
    }
}