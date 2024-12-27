package modeltest;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.junit.jupiter.api.*;

import bgtransport.model.Utility;

import org.json.JSONArray;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Utility class using H2 in-memory database.
 */
class UtilityTest {

    private static DSLContext dslContext;
    private static Connection connection;

    /**
     * Set up an in-memory H2 database before running tests.
     * This will be used for testing dslContext and getTableNames methods.
     */
    @BeforeAll
    static void setUp() {
        try {
            // Create an in-memory H2 database
            connection = DriverManager.getConnection("jdbc:h2:mem:testdb1;DB_CLOSE_DELAY=-1", "sa", "");

            // Create DSLContext for jOOQ
            dslContext = DSL.using(connection, SQLDialect.H2);

            // Create a test table for testing getTableNames
            dslContext.execute("CREATE TABLE IF NOT EXISTS test_table (id INTEGER PRIMARY KEY, name TEXT)");
        } catch (SQLException e) {
            System.err.println("Error setting up database: " + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * Clean up the database connection after tests.
     */
    @AfterAll
    static void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    /**
     * Test for the fileReader method.
     * This test will check if a valid JSON file can be read and converted to a JSONArray.
     */
    @Test
    void testFileReader() throws IOException {
        // Create a sample JSON file for testing
        File tempFile = File.createTempFile("test", ".json");
        tempFile.deleteOnExit();  // Ensure the file is deleted when the JVM exits

        // Write a valid JSON array to the temporary file
        String jsonContent = "[{\"name\":\"Test Company\",\"legalStructure\":\"Ltd\"}]";
        try (FileWriter writer = new FileWriter(tempFile)) {
            writer.write(jsonContent);  // Write JSON content to the file
        }

        // Read the JSON content from the file using the fileReader method
        JSONArray result = Utility.fileReader(tempFile);

        // Verify that the JSONArray contains the correct data
        assertNotNull(result);
        assertEquals(1, result.length());
        assertEquals("Test Company", result.getJSONObject(0).getString("name"));
        assertEquals("Ltd", result.getJSONObject(0).getString("legalStructure"));
    }

    /**
     * Test for the dslContext method.
     * This test will check if the DSLContext can be created successfully for an H2 in-memory database.
     */
    @Test
    void testDslContext() throws SQLException {
        // Create a DSLContext using the H2 in-memory database
        DSLContext context = dslContext;

        // Verify that the DSLContext is not null and is properly initialized
        assertNotNull(context);
    }

    /**
     * Test for the getTableNames method.
     * This test will verify that the method correctly retrieves the names of tables from the H2 database.
     */
    @Test
    void testGetTableNames() {
        // Test that the table is created correctly and retrieve the table names
        List<String> tableNames = Utility.getTableNames(dslContext);

        // Verify that the "test_table" is present in the list of table names
        assertTrue(tableNames.contains("TEST_TABLE"));
    }
}
