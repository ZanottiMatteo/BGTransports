package bgtransport.model;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.impl.DSL;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ControlDB {

	protected static ArrayList<String> myList = new ArrayList<>();
	protected static List<String> tableNames = new ArrayList<>();
	public static int progress = 0;
	public static String[] currentTableName = { "" };

	public static void controlJSON(String json, String excel) throws Exception {
		File jsonFile = new File(json);

		if (!jsonFile.exists()) {
			System.out.println("File JSON creation: " + json);
			List<Map<String, String>> list = CreateJSONFile.readExcelFile(excel);
			CreateJSONFile.writeJsonToFile(list, json);
		} else {
			System.out.println("Check if file JSON is up-to-date: " + json);
			List<Map<String, String>> excelData = CreateJSONFile.readExcelFile(excel);

			ObjectMapper objectMapper = new ObjectMapper();
			List<Map<String, Object>> jsonData = objectMapper.readValue(jsonFile,
					new TypeReference<List<Map<String, Object>>>() {
					});

			if (!excelData.equals(jsonData)) {
				objectMapper.writeValue(jsonFile, excelData);
				ConstantRecordNumber.update = true;
				System.out.println("File JSON need to be updated: " + json);
				myList.add(json);

			} else {
				System.out.println("File JSON is already up-to-date: " + json);
			}
		}
	}

	public static void dbCheck(String databasePath, String database, String jooq, String src) throws Exception {
		File dbFile = new File(databasePath);
		if (!dbFile.exists()) {
			System.out.println("Database creation: " + database);
			CreateDB.createDatabase(database);

			System.out.println("Creating tables in the database: " + database + " ...");
			DSLContext create = Utility.dslContext(database);

			if (databasePath.equals(ConstantDB.DB_PUBLIC_TRANSPORTATION)) {
				CreateTablesDB.createTablesPublicTransportation(create);
			} else {
				CreateTablesDB.createTablesUsers(create);
			}
			GenerateCode.generateCode(database, ConstantDB.JDBC, ConstantDB.SQLITEDATABASE, jooq, src);
		} else {
			System.out.println("Database already exists: " + database);
		}
		
	}
	

	public static void dbUpdate(String database) throws IOException, SQLException {
		if (Boolean.TRUE.equals(ConstantRecordNumber.update)) {
			System.out.println("Database update: " + database);
			DSLContext create = Utility.dslContext(database);
			QueryDB.deleteAll(create, myList);
			ConstantRecordNumber.update = false;
		}
	}
	public static int totalRecordCount(String database) throws Exception{
		DSLContext create = Utility.dslContext(database);
		Result<Record1<String>> tables = create.select(DSL.field("name", String.class)).from("sqlite_master")
				.where(DSL.field("type").eq("table")).and(DSL.field("name").notLike("sqlite_%")).fetch();

		tableNames = tables.stream().map(Record1::value1).toList();

		int totalRecord = 0;
		
		for (int i = 0; i < tableNames.size(); i++) {
			System.out.println("Check table: " + tableNames.get(i));

			currentTableName[0] = tableNames.get(i);

			int count = create.fetchCount(DSL.table(DSL.name(tableNames.get(i))));

			if (count == 0) {
				System.out.println(tableNames.get(i) + " is empty");
				System.out.println("Insert in table " + tableNames.get(i));

				if (tableNames.get(i).equals(ConstantString.COMPANY)) {
					totalRecord += ConstantString.NUMBER_COMPANY_RECORD;
				} else if (tableNames.get(i).equals(ConstantString.FUNICULAR_STATION)) {
					totalRecord += ConstantString.NUMBER_FUNICULAR_STATION_RECORD;
				} else if (tableNames.get(i).equals(ConstantString.TRAIN_STATION)) {
					totalRecord += ConstantString.NUMBER_TRAIN_STATION_RECORD;
				} else if (tableNames.get(i).equals(ConstantString.TRAM_STOP)) {
					totalRecord += ConstantString.NUMBER_TRAM_STOP_RECORD;
				} else if (tableNames.get(i).equals(ConstantString.PULLMAN_STOP)) {
					totalRecord += ConstantString.NUMBER_PULLMAN_STOP_RECORD;
				} else if (tableNames.get(i).equals(ConstantString.FUNICULAR_TIMETABLE)) {
					totalRecord += ConstantString.NUMBER_FUNICULAR_TIMETABLE_RECORD;
				} else if (tableNames.get(i).equals(ConstantString.TRAM_TIMETABLE)) {
					totalRecord += ConstantString.NUMBER_TRAM_TIMETABLE_RECORD;
				} else if (tableNames.get(i).equals(ConstantString.TRAIN_TIMETABLE)) {
					totalRecord += ConstantString.NUMBER_TRAIN_TIMETABLE_RECORD;
				} else if (tableNames.get(i).equals(ConstantString.PULLMAN_TIMETABLE)) {
					totalRecord += ConstantString.NUMBER_PULLMAN_TIMETABLE_RECORD;
				}
			}
		}
		if (totalRecord == 0) return -1;
		return totalRecord;
	}

	public static void progressiveTotalCount(String database) throws IOException, SQLException {
		DSLContext create = Utility.dslContext(database);

		Result<Record1<String>> tables = create.select(DSL.field("name", String.class)).from("sqlite_master")
				.where(DSL.field("type").eq("table")).and(DSL.field("name").notLike("sqlite_%")).fetch();

		tableNames = tables.stream().map(Record1::value1).toList();

		for (int i = 0; i < tableNames.size(); i++) {
			System.out.println("Check table: " + tableNames.get(i));

			currentTableName[0] = tableNames.get(i);

			int count = create.fetchCount(DSL.table(DSL.name(tableNames.get(i))));

			if (count == 0) {
				System.out.println(tableNames.get(i) + " is empty");
				System.out.println("Insert in table " + tableNames.get(i));

				if (tableNames.get(i).equals(ConstantString.COMPANY)) {
					progress += InsertDataDB.company(create);
				} else if (tableNames.get(i).equals(ConstantString.FUNICULAR_STATION)) {
					progress += InsertDataDB.funicularStation(create);
				} else if (tableNames.get(i).equals(ConstantString.TRAIN_STATION)) {
					progress += InsertDataDB.trainStation(create);
				} else if (tableNames.get(i).equals(ConstantString.TRAM_STOP)) {
					progress += InsertDataDB.tramStop(create);
				} else if (tableNames.get(i).equals(ConstantString.PULLMAN_STOP)) {
					progress += InsertDataDB.pullmanStop(create);
				} else if (tableNames.get(i).equals(ConstantString.FUNICULAR_TIMETABLE)) {
					progress += InsertDataDB.funicularTimetable(create);
				} else if (tableNames.get(i).equals(ConstantString.TRAM_TIMETABLE)) {
					progress += InsertDataDB.tramTimetable(create);
				} else if (tableNames.get(i).equals(ConstantString.TRAIN_TIMETABLE)) {
					progress += InsertDataDB.trainTimetable(create);
				} else if (tableNames.get(i).equals(ConstantString.PULLMAN_TIMETABLE)) {
					progress += InsertDataDB.pullmanTimetable(create);
				}
			} else {
				System.out.println(tableNames.get(i) + " has records");
			}
		}
	}
}
