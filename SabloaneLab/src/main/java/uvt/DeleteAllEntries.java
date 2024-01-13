package uvt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteAllEntries {
    public static void main(String[] args) {
        // JDBC URL, username, and password of your database
        String url = "jdbc:h2:~/test";
        String user = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Define the DELETE statement to delete all entries in the table
            String deleteAllSql = "DELETE FROM Book_authors";

            // Create a statement and execute the DELETE statement
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(deleteAllSql);
                System.out.println("All entries deleted from 'Book_authors' table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
