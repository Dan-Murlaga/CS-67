import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteExample1 {

    public static void main(String[] args) throws SQLException {
        // create a database connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:pets.db");
        Statement statement = connection.createStatement();

        String sqlQuery = "SELECT * FROM Pet"; // Return all (*) rows from Pet table
        ResultSet rs = statement.executeQuery(sqlQuery);

        //loop through all of the results
        while(rs.next()) {
            if (rs.getString("type").equals("Cat")) {
                System.out.println(rs.getString("name"));
            }
        }
        connection.close();
    }
}
