package model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.json.JSONArray;
import org.json.JSONObject;

public class Utility {
	public static JSONArray fileReader(File jsonFile) throws IOException {
		FileReader fileReader = new FileReader(jsonFile);
		StringBuilder jsonContent = new StringBuilder();

		int i;
		while ((i = fileReader.read()) != -1) {
			jsonContent.append((char) i);
		}
		fileReader.close();

		// Converti il contenuto JSON in un JSONArray
		JSONArray JsonArray = new JSONArray(jsonContent.toString());

		return JsonArray;
	}

	public static DSLContext DSLContext(String database) throws SQLException {
		Connection connection = DriverManager.getConnection(database);
		DSLContext create = DSL.using(connection, SQLDialect.SQLITE);
		return create;
	}

	public static void sumNumberOfRecords(Result<Record1<String>> tables) throws IOException {
		File jsonFile = new File("json/recordCount.json");
		JSONArray jsonArray = fileReader(jsonFile);
		int totalRecordCount = 0;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String tableName = jsonObject.getString("table");
			int recordCount = jsonObject.getInt("recordCount");
			totalRecordCount += recordCount;
		}
	}
}
