package databases;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {

	public static String DB_PUBLIC_TRANSPORTATION = "db/Public Transportation.db3";
	public static String DB_URL_PUBLIC_TRANSPORTATION = "jdbc:sqlite:" + DB_PUBLIC_TRANSPORTATION;

	public static String DB_USERS = "db/Users.db3";
	public static String DB_URL_USERS = "jdbc:sqlite:" + DB_USERS;

	static String[] URLS = { DB_URL_PUBLIC_TRANSPORTATION, DB_URL_USERS };
	static String[] DBS = { DB_PUBLIC_TRANSPORTATION, DB_USERS };

	/**
	 * function that creates the databases (Public Transportation, Users)
	 * @param args
	 * @throws IOException: exception
	 * @throws SQLException: exception
	 */
	public static void main(String[] args) throws IOException, SQLException {

		for (int i = 0; i < URLS.length; i++) {
			// Establish a connection to the database using the URL from the URLS array
			Connection conn = DriverManager.getConnection(URLS[i]);

			// Retrieve metadata about the database
			DatabaseMetaData meta = conn.getMetaData();

			// Print the driver name used for the connection
			System.out.println("The driver name is " + meta.getDriverName());

			// Print a message indicating that a new database has been created
			System.out.println("A new database has been created: " + URLS[i]);

			// Check if the database file exists at this point
			System.out.println("Does the database " + DBS[i] + " exist? " + new File(DBS[i]).exists());
		}
	}
}
