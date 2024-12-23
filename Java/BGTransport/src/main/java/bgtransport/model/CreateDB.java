package bgtransport.model;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The CreateDB class is responsible for creating a new database.
 * 
 * This class provides a method to establish a connection to a specified database
 * and create it if it does not already exist.
 */
public class CreateDB {

    /**
     * Creates a new database by establishing a connection to the specified database URL.
     * If the database does not exist, it will be created.
     *
     * @param database The URL of the database to be created.
     * @throws SQLException If an SQL error occurs during the database creation process.
     */
    public static void createDatabase(String database) throws SQLException {
        DriverManager.getConnection(database);
        System.out.println("A new database has been created: " + database);
    }
}
