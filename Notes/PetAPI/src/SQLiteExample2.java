import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLiteExample2 {

    public static int countOfType(String animalType) throws SQLException {
        // create a database connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:pets.db");
        Statement statement = connection.createStatement();

        // Return count of rows from Pet table
        String sqlQuery = "SELECT count(*) as count FROM Pet where type = '" + animalType + "'"; 
        ResultSet rs = statement.executeQuery(sqlQuery);
        int result = rs.getInt("count");
        if(connection != null) {
            connection.close();
        }
        return result;
    }

    public static ArrayList<String> namesOfType(String animalType) throws SQLException {
        ArrayList<String> result = new ArrayList<String>();
        // create a database connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:pets.db");
        Statement statement = connection.createStatement();

        // Return all rows from Pet table
        String sqlQuery = "SELECT * FROM Pet where type = '" + animalType + "'"; 
        ResultSet rs = statement.executeQuery(sqlQuery);
        while(rs.next())
        {
            result.add(rs.getString("name"));
        }        
        if(connection != null) {
            connection.close();
        }
        return result;
    }

    public static void main(String[] args) throws SQLException 
    {
        ArrayList<String> result = namesOfType("Dog");
        System.out.println("Here are the dogs:");
        for(String s : result)
        {
            System.out.println(s);
        } 
        System.out.println("There are " + countOfType("Dog") + " dogs.");
        System.out.println("There are " + countOfType("Cat") + " cats.");
    }
    
}
