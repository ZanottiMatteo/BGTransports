package model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ControlDB {
	public static void controlJSON(String json, String excel) throws Exception {
		File jsonFile = new File(json);
		ArrayList<String> myList = new ArrayList<>();
		if (!jsonFile.exists()) {
			System.out.println("File JSON creation: " + json);
			List<Map<String, String>> list = CreateJSONFile.readExcelFile(excel);
			CreateJSONFile.writeJsonToFile(list, json);
			Constant.update = true;
			myList.add(json);
		} else {
			System.out.println("Check if file JSON is up-to-date: " + json);
			List<Map<String, String>> excelData = CreateJSONFile.readExcelFile(excel);

			ObjectMapper objectMapper = new ObjectMapper();
			List<Map<String, Object>> jsonData = objectMapper.readValue(jsonFile,
					new TypeReference<List<Map<String, Object>>>() {
					});

			if (!excelData.equals(jsonData)) {
				objectMapper.writeValue(jsonFile, excelData);
				Constant.update = true;
				System.out.println("File JSON is up-to-date: " + json);

			} else {
				System.out.println("File JSON is already up-to-date: " + json);
			}
		}
	}

	public static void DBcheck(String databasePath, String database, String jooq, String src) throws Exception {
		File dbFile = new File(databasePath);
		if (!dbFile.exists()) {
			System.out.println("Database creation: " + database);
			CreateDB.createDatabase(database);

			System.out.println("Creating tables in the database: " + database + " ...");
			DSLContext create = ControlDB.DSLContext(database);
			
			if (databasePath == Constant.DB_PUBLIC_TRANSPORTATION) {
				CreateTablesDB.createTablesPublicTransportation(create);
			} else {
				CreateTablesDB.createTablesUsers(create);
			}

			GenerateCode.generateCode(database, Constant.JDBC, Constant.SQLiteDatabase, jooq, src);

			if (databasePath == Constant.DB_PUBLIC_TRANSPORTATION) {
				InsertDataDB.company(create);
				InsertDataDB.funicular_station(create);
				InsertDataDB.train_station(create);
				InsertDataDB.tram_stop(create);
				InsertDataDB.pullman_stop(create);
				InsertDataDB.funicularTimetable(create);
				InsertDataDB.tramTimetable(create);
				InsertDataDB.trainTimetable(create);
				InsertDataDB.pullmanTimetable(create);
			}

		} else if (Constant.update) {
			System.out.println("Database update: " + database);
			// dbFile.delete();
			// CreateDB.createDatabase(database);

			// System.out.println("Creating tables in the database: " + database + " ...");
			// DSLContext createPublicTrasnportation = ControlDB.DSLContext(database);
			// CreateTablesDB.createTablesPublicTransportation(createPublicTrasnportation);
			// GenerateCode.generateCode(database, Constant.JDBC, Constant.SQLiteDatabase,
			// jooq, src);

			// InsertDataDB.company(createPublicTrasnportation);
			// InsertDataDB.funicular_station(createPublicTrasnportation);
			// InsertDataDB.train_station(createPublicTrasnportation);
			// InsertDataDB.tram_stop(createPublicTrasnportation);
			// InsertDataDB.pullman_stop(createPublicTrasnportation);
			// InsertDataDB.funicularTimetable(createPublicTrasnportation);
			// InsertDataDB.tramTimetable(createPublicTrasnportation);
			// InsertDataDB.trainTimetable(createPublicTrasnportation);
			// InsertDataDB.pullmanTimetable(createPublicTrasnportation);

			Constant.update = false;
		} else {
			System.out.println("Database already existed and is up-to-date: " + database);
		}
	}

	public static void deleteAll(DSLContext ctx) {
		// ctx.deleteFrom(TABLE_NAME)
		// .execute();
	}

	public static DSLContext DSLContext(String database) throws SQLException {
		Connection connection = DriverManager.getConnection(database);
		DSLContext create = DSL.using(connection, SQLDialect.SQLITE);
		return create;
	}
}
