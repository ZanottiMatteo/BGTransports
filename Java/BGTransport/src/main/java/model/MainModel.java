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

		ControlDB.control(Constant.JSON_FUNICULAR_STATION, Constant.EXCEL_FUNICULAR_STATION_LIST);
		ControlDB.control(Constant.JSON_COMPANY, Constant.EXCEL_COMPANIES_LIST);
		ControlDB.control(Constant.JSON_PULLMAN_STOP, Constant.EXCEL_PULLMAN_STOP_LIST);
		ControlDB.control(Constant.JSON_TRAIN_STATION, Constant.EXCEL_TRAIN_STATION_LIST);
		ControlDB.control(Constant.JSON_TRAM_STOP, Constant.EXCEL_TRAM_STOP_LIST);
		ControlDB.control(Constant.JSON_FUNICULAR_TIMETABLE, Constant.EXCEL_FUNICULAR_TIMETABLE);
		ControlDB.control(Constant.JSON_TRAM_TIMETABLE, Constant.EXCEL_TRAM_TIMETABLE);
		ControlDB.control(Constant.JSON_TRAIN_TIMETABLE, Constant.EXCEL_TRAIN_TIMETABLE);

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
