package model;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.impl.DSL;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ControlDB {

	public static ArrayList<String> myList = new ArrayList<>();
	public static List<String> tableNames = new ArrayList<>();
	public static int progress = 0;
	public static String[] currentTableName = { "" };

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
			DSLContext create = Utility.DSLContext(database);

			if (databasePath == Constant.DBPublicTransportation) {
				CreateTablesDB.createTablesPublicTransportation(create);
			} else {
				CreateTablesDB.createTablesUsers(create);
			}
			GenerateCode.generateCode(database, Constant.JDBC, Constant.SQLiteDatabase, jooq, src);
		} else {
			System.out.println("Database already exists: " + database);
		}
	}

	public static void DBupdate(Boolean update, String database) throws IOException, SQLException {
		if (Constant.update) {
			System.out.println("Database update: " + database);
			DSLContext create = Utility.DSLContext(database);
			QueryDB.deleteAll(create, myList);
			Constant.update = false;
		}
	}

	public static int totalRecordCount(String database) throws IOException, SQLException {
		DSLContext create = Utility.DSLContext(database);
		Result<Record1<String>> tables = create.select(DSL.field("name", String.class)).from("sqlite_master")
				.where(DSL.field("type").eq("table")).and(DSL.field("name").notLike("sqlite_%")).fetch();

		tableNames = tables.stream().map(Record1::value1).collect(Collectors.toList());

		return Utility.sumNumberOfRecords(tableNames);
	}

	public static int progressiveTotalCount(String database) throws IOException, SQLException {
		DSLContext create = Utility.DSLContext(database);
	    
		Result<Record1<String>> tables = create.select(DSL.field("name", String.class)).from("sqlite_master")
				.where(DSL.field("type").eq("table")).and(DSL.field("name").notLike("sqlite_%")).fetch();
		
		tableNames = tables.stream().map(Record1::value1).collect(Collectors.toList());
		
		for (int i=0; i <tableNames.size() ; i++) {
			System.out.println("Check table: " + tableNames.get(i));

			currentTableName[0] = tableNames.get(i);

			int count = create.fetchCount(DSL.table(DSL.name(tableNames.get(i))));

			if (count == 0) {
				System.out.println(tableNames.get(i) + " is empty");
				System.out.println("Insert in table " + tableNames.get(i));

				if (tableNames.get(i).equals(Constant.company)) {
					progress += InsertDataDB.company(create);
				} else if (tableNames.get(i).equals(Constant.funicularStation)) {
					progress += InsertDataDB.funicular_station(create);
				} else if (tableNames.get(i).equals(Constant.trainStation)) {
					progress += InsertDataDB.train_station(create);
				} else if (tableNames.get(i).equals(Constant.tramStop)) {
					progress += InsertDataDB.tram_stop(create);
				} else if (tableNames.get(i).equals(Constant.pullmanStop)) {
					progress += InsertDataDB.pullman_stop(create);
				} else if (tableNames.get(i).equals(Constant.funicularTimetable)) {
					progress += InsertDataDB.funicularTimetable(create);
				} else if (tableNames.get(i).equals(Constant.tramTimetable)) {
					progress += InsertDataDB.tramTimetable(create);
				} else if (tableNames.get(i).equals(Constant.trainTimetable)) {
					progress += InsertDataDB.trainTimetable(create);
				} else if (tableNames.get(i).equals(Constant.pullmanTimetable)) {
					progress += InsertDataDB.pullmanTimetable(create);
				}
			} else {
				System.out.println(tableNames.get(i) + " has records");
			}
		}
		return progress;
	}
}
