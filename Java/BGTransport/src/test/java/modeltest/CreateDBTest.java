package modeltest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CreateDBTest {

	private static final String DB_URL = "jdbc:sqlite:./testdb.db3";
	private static Connection conn = null;

	@BeforeAll
	public static void setup() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Test
    void testCreateDatabase() {
        try {
            conn = DriverManager.getConnection(DB_URL);
            assertNotNull(conn, "La connessione al database SQLite è fallita!");
        } catch (SQLException e) {
            fail("SQLException durante il test: " + e.getMessage());
        }
    }
	
	@AfterAll
    public static void cleanup() {
        try {
            if (conn != null) {
                conn.close();
            }
            java.nio.file.Files.deleteIfExists(java.nio.file.Paths.get("testdb.db3"));
        } catch (SQLException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
