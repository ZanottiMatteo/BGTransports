package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {

	public static void createDatabase(String database) throws SQLException {
		Connection conn = DriverManager.getConnection(database);
		System.out.println("A new database has been created: " + database);
	}
}
