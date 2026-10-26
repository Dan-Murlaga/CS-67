import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VideoGamesAPI {
    /**
     * Retrieves every game in the database.
     *
     * @return the games, formatted with their title, publisher, release year,
     *         and version when available
     * @throws SQLException if a database access error occurs
     */
    public static ArrayList<String> allGames() throws SQLException {
        return queryGames("SELECT * FROM VideoGames");
    }

    /**
     * Retrieves games whose genre matches the supplied genre.
     *
     * @param genre the genre to search for
     * @return the matching games, formatted with their title, publisher,
     *         release year, and version when available
     * @throws SQLException if a database access error occurs
     */
    public static ArrayList<String> gamesByGenre(String genre) throws SQLException {
        return queryGames("SELECT * FROM VideoGames WHERE genre = ?", genre);
    }

    /**
     * Retrieves games published by the supplied publisher.
     *
     * @param publisher the publisher to search for
     * @return the matching games, formatted with their title, publisher,
     *         release year, and version when available
     * @throws SQLException if a database access error occurs
     */
    public static ArrayList<String> gamesByPublisher(String publisher) throws SQLException {
        return queryGames("SELECT * FROM VideoGames WHERE publisher = ?", publisher);
    }

    /**
     * Retrieves games released in the specified year.
     *
     * @param year the release year to search for
     * @return the matching games, formatted with their title, publisher,
     *         release year, and version when available
     * @throws SQLException if a database access error occurs
     */
    public static ArrayList<String> gamesByYear(int year) throws SQLException {
        return queryGames("SELECT * FROM VideoGames WHERE releaseYear = ?", year);
    }

    /**
     * Retrieves games released before the specified year.
     *
     * @param year the year used as the exclusive upper bound
     * @return the matching games, formatted with their title, publisher,
     *         release year, and version when available
     * @throws SQLException if a database access error occurs
     */
    public static ArrayList<String> gamesBeforeYear(int year) throws SQLException {
        return queryGames("SELECT * FROM VideoGames WHERE releaseYear < ?", year);
    }

    /**
     * Retrieves games released after the specified year.
     *
     * @param year the year used as the exclusive lower bound
     * @return the matching games, formatted with their title, publisher,
     *         release year, and version when available
     * @throws SQLException if a database access error occurs
     */
    public static ArrayList<String> gamesAfterYear(int year) throws SQLException {
        return queryGames("SELECT * FROM VideoGames WHERE releaseYear > ?", year);
    }

    /**
     * Retrieves games available on the supplied platform.
     *
     * @param platform the platform to search for
     * @return the matching games, formatted with their title, publisher,
     *         release year, and version when available
     * @throws SQLException if a database access error occurs
     */
    public static ArrayList<String> gamesByPlatform(String platform) throws SQLException {
        return queryGames("SELECT * FROM VideoGames WHERE platform = ?", platform);
    }

    private static ArrayList<String> queryGames(String sql, Object... parameters) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:VideoGames.db");
             PreparedStatement statement = connection.prepareStatement(sql)) {
            for (int i = 0; i < parameters.length; i++) {
                statement.setObject(i + 1, parameters[i]);
            }

            try (ResultSet rs = statement.executeQuery()) {
                return formatGames(rs, new ArrayList<String>());
            }
        }
    }

    private static ArrayList<String> formatGames(ResultSet rs, ArrayList<String> gamesList) throws SQLException {
        while(rs.next()) {
            String game = "";
            game += rs.getString("title") + " | Published by: " + rs.getString("publisher") + " (" + rs.getInt("releaseYear") + ")";
            if (rs.getString("version") != null) {
                game += " ver" + rs.getString("version");
            }
            gamesList.add(game);
        }

        return gamesList;
    }
}
