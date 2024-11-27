package model;

import java.util.List;
import java.util.Map;

import org.jooq.DSLContext;

public class MainModel {

	public static void main(String[] args) throws Exception {
		// create database Public Transportation
		CreateDB.createDatabase(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		System.out.println("Creating tables in the database: " + Constant.DB_URL_PUBLIC_TRANSPORTATION + " ...");
		DSLContext createPublicTrasnportation = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);
		CreateTablesDB.createTablesPublicTransportation(createPublicTrasnportation);

		GenerateCode.generateCode(Constant.DB_URL_PUBLIC_TRANSPORTATION, Constant.JDBC, Constant.SQLiteDatabase,Constant.JOOQ_TRANSPORTATION, Constant.SRC_TRANSPORTATION);

		Boolean controlFunicularStation = ControlDB.control(Constant.JSON_FUNICULAR_STATION);
		if (controlFunicularStation == false) {
			System.out.println("start funicular station");
			List<Map<String, String>> funicularStation = CreateJSONFile.readExcelFile(Constant.EXCEL_FUNICULAR_STATION_LIST);
			CreateJSONFile.writeJsonToFile(funicularStation, Constant.JSON_FUNICULAR_STATION);
		}

		Boolean controlCompany = ControlDB.control(Constant.JSON_COMPANY);
		if (controlCompany == false) {
			System.out.println("start company");
			List<Map<String, String>> companies = CreateJSONFile.readExcelFile(Constant.EXCEL_COMPANIES_LIST);
			CreateJSONFile.writeJsonToFile(companies, Constant.JSON_COMPANY);
		}

		Boolean controlPullmanStop = ControlDB.control(Constant.JSON_PULLMAN_STOP);
		if (controlPullmanStop == false) {
			System.out.println("start pullman stop");
			List<Map<String, String>> pullmanStop = CreateJSONFile.readExcelFile(Constant.EXCEL_PULLMAN_STOP_LIST);
			CreateJSONFile.writeJsonToFile(pullmanStop, Constant.JSON_PULLMAN_STOP);
		}

		Boolean controlTrainStation = ControlDB.control(Constant.JSON_TRAIN_STATION);
		if (controlTrainStation == false) {
			System.out.println("start train station");
			List<Map<String, String>> trainStation = CreateJSONFile.readExcelFile(Constant.EXCEL_TRAIN_STATION_LIST);
			CreateJSONFile.writeJsonToFile(trainStation, Constant.JSON_TRAIN_STATION);
		}

		Boolean controlTramStop = ControlDB.control(Constant.JSON_TRAM_STOP);
		if (controlTramStop == false) {
			System.out.println("start tram stop");
			List<Map<String, String>> tramStop = CreateJSONFile.readExcelFile(Constant.EXCEL_TRAM_STOP_LIST);
			CreateJSONFile.writeJsonToFile(tramStop, Constant.JSON_TRAM_STOP);
		}

		Boolean controlFunicularTimetbale = ControlDB.control(Constant.JSON_FUNICULAR_TIMETABLE);
		if (controlFunicularTimetbale == false) {
			System.out.println("start funicular timetable");
			List<Map<String, String>> funicularTimetable = CreateJSONFile.readExcelFile(Constant.EXCEL_FUNICULAR_TIMETABLE);
			CreateJSONFile.writeJsonToFile(funicularTimetable, Constant.JSON_FUNICULAR_TIMETABLE);
		}

		Boolean controlTramTimetable = ControlDB.control(Constant.JSON_TRAM_TIMETABLE);
		if (controlTramTimetable == false) {
			System.out.println("start tram timetable");
			List<Map<String, String>> tramTimetable = CreateJSONFile.readExcelFile(Constant.EXCEL_TRAM_TIMETABLE);
			CreateJSONFile.writeJsonToFile(tramTimetable, Constant.JSON_TRAM_TIMETABLE);
		}
		
		Boolean controlTrainTimetable = ControlDB.control(Constant.JSON_TRAIN_TIMETABLE);
		if (controlTrainTimetable == false) {
			System.out.println("start train timetable");
			List<Map<String, String>> trainTimetable = CreateJSONFile.readExcelFile(Constant.EXCEL_TRAIN_TIMETABLE);
			CreateJSONFile.writeJsonToFile(trainTimetable, Constant.JSON_TRAIN_TIMETABLE);
		}

		InsertDataDB.company(createPublicTrasnportation);
		InsertDataDB.funicular_station(createPublicTrasnportation);
		InsertDataDB.train_station(createPublicTrasnportation);
		InsertDataDB.tram_stop(createPublicTrasnportation);
		InsertDataDB.pullman_stop(createPublicTrasnportation);
		InsertDataDB.funicular(createPublicTrasnportation);
		InsertDataDB.tram(createPublicTrasnportation);
		InsertDataDB.train(createPublicTrasnportation);

		// create database User
		CreateDB.createDatabase(Constant.DB_URL_USERS);
		
		DSLContext createUsers = ControlDB.DSLContext(Constant.DB_URL_USERS);
		CreateTablesDB.createTablesUsers(createUsers);
		
		GenerateCode.generateCode(Constant.DB_URL_USERS, Constant.JDBC, Constant.SQLiteDatabase, Constant.JOOQ_USER, Constant.SRC_USER);
	}

}
