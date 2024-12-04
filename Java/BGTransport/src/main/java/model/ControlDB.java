package model;

import java.io.File;
import java.io.IOException;
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

import transportation.jooq.generated.tables.Company;
import transportation.jooq.generated.tables.Funicularstation;
import transportation.jooq.generated.tables.Funiculartimetable;
import transportation.jooq.generated.tables.Pullmanstop;
import transportation.jooq.generated.tables.Pullmantimetable;
import transportation.jooq.generated.tables.Trainstation;
import transportation.jooq.generated.tables.Traintimetable;
import transportation.jooq.generated.tables.Tramstop;
import transportation.jooq.generated.tables.Tramtimetable;

public class ControlDB {

	static ArrayList<String> myList = new ArrayList<>();

	public static void controlJSON(String json, String excel) throws Exception {
		File jsonFile = new File(json);

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
				myList.add(json);

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

			if (databasePath == Constant.DBPublicTransportation) {
				CreateTablesDB.createTablesPublicTransportation(create);
			} else {
				CreateTablesDB.createTablesUsers(create);
			}

			GenerateCode.generateCode(database, Constant.JDBC, Constant.SQLiteDatabase, jooq, src);

			if (databasePath == Constant.DBPublicTransportation) {
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
			DSLContext create = ControlDB.DSLContext(database);
			deleteAll(create, myList);
			Constant.update = false;
		} else {
			System.out.println("Database already existed and is up-to-date: " + database);
		}
	}

	public static void deleteAll(DSLContext ctx, ArrayList<String> myList) throws IOException {
		ArrayList<String> modifiedList = new ArrayList<>();

		for (String item : myList) {
			String modified = item.replace("json/", "").replace(".json", "");
			modifiedList.add(modified);
		}

		for (String tableName : modifiedList) {
			if (tableName.equals(Constant.company)) {
				ctx.deleteFrom(Company.COMPANY).execute();
				InsertDataDB.company(ctx);
			}
			if (tableName.equals(Constant.funicularStation)) {
				ctx.deleteFrom(Funicularstation.FUNICULARSTATION).execute();
				InsertDataDB.funicular_station(ctx);
			}
			if (tableName.equals(Constant.trainStation)) {
				ctx.deleteFrom(Trainstation.TRAINSTATION).execute();
				InsertDataDB.train_station(ctx);
			}
			if (tableName.equals(Constant.tramStop)) {
				ctx.deleteFrom(Tramstop.TRAMSTOP).execute();
				InsertDataDB.tram_stop(ctx);
			}
			if (tableName.equals(Constant.pullmanStop)) {
				ctx.deleteFrom(Pullmanstop.PULLMANSTOP).execute();
				InsertDataDB.pullman_stop(ctx);
			}
			if (tableName.equals(Constant.funicularTimetable)) {
				ctx.deleteFrom(Funiculartimetable.FUNICULARTIMETABLE).execute();
				InsertDataDB.funicularTimetable(ctx);
			}
			if (tableName.equals(Constant.tramTimetable)) {
				ctx.deleteFrom(Tramtimetable.TRAMTIMETABLE).execute();
				InsertDataDB.tramTimetable(ctx);
			}
			if (tableName.equals(Constant.trainTimetable)) {
				ctx.deleteFrom(Traintimetable.TRAINTIMETABLE).execute();
				InsertDataDB.trainTimetable(ctx);
			}
			if (tableName.equals(Constant.pullmanTimetable)) {
				ctx.deleteFrom(Pullmantimetable.PULLMANTIMETABLE).execute();
				InsertDataDB.pullmanTimetable(ctx);
			}
		}
	}

	public static DSLContext DSLContext(String database) throws SQLException {
		Connection connection = DriverManager.getConnection(database);
		DSLContext create = DSL.using(connection, SQLDialect.SQLITE);
		return create;
	}
}
