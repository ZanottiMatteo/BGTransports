package bgtransport.model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.json.JSONArray;

/**
 * Utility class that provides helper methods for handling JSON files, database connections, 
 * and retrieving table names from a database.
 */
public class Utility {

    /**
     * Reads a JSON file and returns its contents as a {@link JSONArray}.
     * This method reads the content of the given file into a string and converts it into a JSONArray.
     *
     * @param jsonFile The JSON file to be read.
     * @return A {@link JSONArray} containing the contents of the JSON file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static JSONArray fileReader(File jsonFile) throws IOException {
        FileReader fileReader = new FileReader(jsonFile);
        StringBuilder jsonContent = new StringBuilder();

        int i;
        while ((i = fileReader.read()) != -1) {
            jsonContent.append((char) i);
        }
        fileReader.close();

        return new JSONArray(jsonContent.toString());
    }

    /**
     * Establishes a connection to the provided database and returns a {@link DSLContext} object
     * that can be used to interact with the database using jOOQ.
     *
     * @param database The JDBC URL of the database to connect to.
     * @return A {@link DSLContext} object for interacting with the database.
     * @throws SQLException If a database access error occurs while establishing the connection.
     */
    public static DSLContext dslContext(String database) throws SQLException {
        Connection connection = DriverManager.getConnection(database);
        return DSL.using(connection, SQLDialect.SQLITE);
    }
    
    /**
     * Retrieves the names of all tables in the provided {@link DSLContext}.
     *
     * @param context The {@link DSLContext} object representing the database connection.
     * @return A list of table names in the database.
     */
    public static List<String> getTableNames(DSLContext context) {
        return context.meta().getTables()
                      .stream()
                      .map(Table::getName)
                      .toList();
    }
}
