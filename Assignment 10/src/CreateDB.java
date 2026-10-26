import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:VideoGames.db";

        // try-with-resources automatically closes the connection and statement.
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // WARNING: Deletes the existing table and all its records.
            // This allows us to start with the same sample data each time.
            statement.executeUpdate("DROP TABLE IF EXISTS VideoGames");

            String sql = "CREATE TABLE VideoGames (" +
                    "title TEXT PRIMARY KEY, " +
                    "genre TEXT, " +
                    "publisher TEXT, " +
                    "releaseYear INTEGER, " +
                    "version TEXT, " +
                    "platform TEXT" +
                    ")";
            statement.executeUpdate(sql);

            // Insert the sample VideoGames into the database.
            statement.executeUpdate("insert into VideoGames values('Shin Megami Tensei: Persona (PSP)', 'RPG', 'ATLUS', 2011, NULL, 'Playstation Portable')");
            statement.executeUpdate("insert into VideoGames values('Persona 2: Innocent Sin (PSP)', 'RPG', 'ATLUS', 2011, NULL, 'Playstation Portable')");
            statement.executeUpdate("insert into VideoGames values('Persona 2: Eternal Punishment (PSP)', 'RPG', 'ATLUS', 2012, NULL, 'Playstation Portable')");
            statement.executeUpdate("insert into VideoGames values('Persona 3 FES', 'RPG', 'ATLUS', 2007, NULL, 'Playstation 2')");
            statement.executeUpdate("insert into VideoGames values('Persona 3 Portable', 'RPG', 'ATLUS', 2009, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Persona 4 Golden', 'RPG', 'ATLUS', 2012, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Persona 4 Arena Ultimax', 'Fighting Game', 'ATLUS', 2013, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Persona 5 Royal', 'RPG', 'ATLUS', 2019, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Persona 5 Strikers', 'Hack and Slash', 'ATLUS', 2020, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Persona 5 Tactica', 'Tactics RPG', 'ATLUS', 2023, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Persona 3 Reload', 'RPG', 'ATLUS', 2024, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Persona 5: The Phantom X', 'Gacha', 'ATLUS', 2025, '4.10.0', 'Mobile')");
            statement.executeUpdate("insert into VideoGames values('Shin Megami Tensei III: Nocturne', 'RPG', 'ATLUS', 2003, NULL, 'Playstation 2')");
            statement.executeUpdate("insert into VideoGames values('Digital Devil Saga: Avatar Tuner', 'RPG', 'ATLUS', 2004, NULL, 'Playstation 2')");
            statement.executeUpdate("insert into VideoGames values('Digital Devil Saga 2: Avatar Tuner', 'RPG', 'ATLUS', 2005, NULL, 'Playstation 2')");
            statement.executeUpdate("insert into VideoGames values('Devil Survivor: Overclocked', 'Tactics RPG', 'ATLUS', 2011, NULL, 'Nintendo 3DS')");
            statement.executeUpdate("insert into VideoGames values('Shin Megami Tensei IV', 'RPG', 'ATLUS', 2013, NULL, 'Nintendo 3DS')");
            statement.executeUpdate("insert into VideoGames values('Devil Survivor 2: Record Breaker', 'Tactics RPG', 'ATLUS', 2015, NULL, 'Nintendo 3DS')");
            statement.executeUpdate("insert into VideoGames values('Shin Megami Tensei IV: Apocalypse', 'RPG', 'ATLUS', 2016, NULL, 'Nintendo 3DS')");
            statement.executeUpdate("insert into VideoGames values('Shin Megami Tensei: Strange Journey Redux', 'RPG', 'ATLUS', 2018, NULL, 'Nintendo 3DS')");
            statement.executeUpdate("insert into VideoGames values('Soul Hackers 2', 'RPG', 'ATLUS', 2022, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Shin Megami Tensei V: Vengeance', 'RPG', 'ATLUS', 2024, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Metaphor: ReFantazio', 'RPG', 'ATLUS', 2024, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Raidou Remastered: The Mystery of the Soulless Army', 'Action RPG', 'ATLUS', 2025, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Fortnite', 'Battle Royale', 'Epic Games', 2017, '42.40', 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Marvel Rivals', 'Hero Shooter', 'Netease', 2024, '1.1.3962284', 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Plants vs. Zombies Garden Warfare 2', 'Hero Shooter', 'Popcap', 2016, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Plants vs. Zombies', 'Tower Defense', 'Popcap', 2009, NULL, 'Mobile')");
            statement.executeUpdate("insert into VideoGames values('Plants vs. Zombies 2', 'Tower Defense', 'Popcap', 2012, '13.5.2', 'Mobile')");
            statement.executeUpdate("insert into VideoGames values('Bloons TD6', 'Tower Defense', 'Ninja Kiwi', 2018, '57.4', 'Mobile')");
            statement.executeUpdate("insert into VideoGames values('Hades', 'Roguelike', 'Supergiant Games', 2020, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('Hades II', 'Roguelike', 'Supergaint Games', 2025, NULL, 'Multiple')");
            statement.executeUpdate("insert into VideoGames values('The Hundred Line -Last Defense Academy-', 'Visual Novel', 'Tokyoo Games', 2025, NULL, 'Steam')");
            statement.executeUpdate("insert into VideoGames values('Lethal Company', 'Friendslop', 'Zeekerss', 2023, '0.80', 'Steam')");
            statement.executeUpdate("insert into VideoGames values('REPO', 'Friendslop', 'semiwork', 2025, '0.4.4', 'Steam')");
            statement.executeUpdate("insert into VideoGames values('Kirby Triple Deluxe', 'Platformer', 'HAL Laboratory', 2014, NULL, 'Nintendo 3DS')");
            statement.executeUpdate("insert into VideoGames values('Kirby Planet Robobot', 'Platformer', 'HAL Laboratory', 2016, NULL, 'Nintendo 3DS')");
            statement.executeUpdate("insert into VideoGames values('Kirby Star Allies', 'Platformer', 'HAL Laboratory', 2018, NULL, 'Nintendo Switch')");
            statement.executeUpdate("insert into VideoGames values('Mario Kart 8 Deluxe', 'Racing Game', 'Nintendo', 2017, '3.0.5', 'Nintendo Switch')");
            statement.executeUpdate("insert into VideoGames values('Mario Kart World', 'Racing Game', 'Nintendo', 2025, '1.1.2', 'Nintendo Switch 2')");
            statement.executeUpdate("insert into VideoGames values('Super Smash Bros. Ultimate', 'Platform Fighter', 'Nintendo', 2018, '13.0.4', 'Nintendo Switch')");
            statement.executeUpdate("insert into VideoGames values('The Legend of Zelda: Breath of the Wild', 'RPG', 'Nintendo', 2017, NULL, 'Nintendo Switch')");
            statement.executeUpdate("insert into VideoGames values('The Legend of Zelda: Tears of the Kingdom', 'RPG', 'Nintendo', 2023, NULL, 'Nintendo Switch')");
            
            
            //display the contents of the VideoGames table
            String sqlQuery = "SELECT * FROM VideoGames"; // Return all (*) rows from VideoGames table
            ResultSet rs = statement.executeQuery(sqlQuery);
                //loop through all of the results
                while(rs.next()) {
                    // read the result set
                    System.out.print(rs.getString("title"));
                    System.out.print(" | Published by: " + rs.getString("publisher"));
                    System.out.print(" (" + rs.getInt("releaseYear") + ")");

                    if (rs.getString("version") != null) {
                        System.out.print(" ver" + rs.getString("version"));
                    }

                    System.out.println();
                }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
