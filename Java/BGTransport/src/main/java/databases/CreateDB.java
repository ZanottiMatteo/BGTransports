package databases;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {

	/**
	 * function that creates the databases (Public Transportation, Users)
	 * @param args
	 * @throws IOException: exception
	 * @throws SQLException: exception
	 */
	public static void main(String[] args) throws IOException, SQLException {

		for (int i = 0; i < utility.Constant.URLS.length; i++) {
			// Establish a connection to the database using the URL from the URLS array
			Connection conn = DriverManager.getConnection(utility.Constant.URLS[i]);

			// Retrieve metadata about the database
			DatabaseMetaData meta = conn.getMetaData();

			// Print the driver name used for the connection
			System.out.println("The driver name is " + meta.getDriverName());

			// Print a message indicating that a new database has been created
			System.out.println("A new database has been created: " + utility.Constant.URLS[i]);

			// Check if the database file exists at this point
			System.out.println("Does the database " + utility.Constant.DBS[i] + " exist? " + new File(utility.Constant.DBS[i]).exists());
		}
	}
}
