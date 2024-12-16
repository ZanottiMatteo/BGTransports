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

public class Utility {
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

	public static DSLContext dslContext(String database) throws SQLException {
		Connection connection = DriverManager.getConnection(database);
		return DSL.using(connection, SQLDialect.SQLITE);
	}
	
	public static List<String> getTableNames(DSLContext context) {
        return context.meta().getTables()
                      .stream()
                      .map(Table::getName)
                      .toList();
    }
}
