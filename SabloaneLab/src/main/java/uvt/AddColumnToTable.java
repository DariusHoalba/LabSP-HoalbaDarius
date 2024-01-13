package uvt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AddColumnToTable {
    public static void main(String[] args) {
        // JDBC URL, username, and password of H2 database
        String url = "jdbc:h2:~/test";
        String user = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            // Define CREATE TABLE SQL statement if the table doesn't exist
            String createTableSql = "CREATE TABLE IF NOT EXISTS Book_authors ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "author_name VARCHAR(255) NOT NULL"
                    + ")";

            // Create a statement and execute the CREATE TABLE statement
            try (Statement createTableStatement = connection.createStatement()) {
                createTableStatement.execute(createTableSql);
                System.out.println("Table 'Book_authors' created or already exists.");
            }

            // Define the ALTER TABLE SQL statement to add the new column
            String alterTableSql = "ALTER TABLE Book_authors ADD COLUMN Book_id INT NOT NULL DEFAULT 0";

            // Create a statement and execute the ALTER TABLE statement
            try (Statement alterTableStatement = connection.createStatement()) {
                alterTableStatement.execute(alterTableSql);
                System.out.println("Column 'Book_id' added to 'Book_authors' table.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

