package databases;

import java.util.List;
import java.util.Map;

import org.jooq.DSLContext;

import utility.Control;

public class MainDB {

	public static void main(String[] args) throws Exception {
		// create databases
		CreateDB.createDatabase(utility.Constant.DB_URL_PUBLIC_TRANSPORTATION);
		
		CreateDB.createDatabase(utility.Constant.DB_URL_USERS);
		
		// create tables
		DSLContext createPublicTrasnportation = CreateTablesDB.DSLContext(utility.Constant.DB_URL_PUBLIC_TRANSPORTATION);
		CreateTablesDB.createTablesPublicTransportation(createPublicTrasnportation);
		
		DSLContext createUsers = CreateTablesDB.DSLContext(utility.Constant.DB_URL_USERS);
		CreateTablesDB.createTablesUsers(createUsers);
		
		// create jooq classes
		GenerateCode.generateCode(utility.Constant.DB_URL_PUBLIC_TRANSPORTATION, utility.Constant.JDBC, utility.Constant.SQLiteDatabase, utility.Constant.JOOQ_TRANSPORTATION, utility.Constant.SRC_TRANSPORTATION);
		GenerateCode.generateCode(utility.Constant.DB_URL_USERS, utility.Constant.JDBC, utility.Constant.SQLiteDatabase, utility.Constant.JOOQ_USER, utility.Constant.SRC_USER);

		// create json
		Boolean controlFunicularStation = Control.control(utility.Constant.JSON_FUNICULAR_STATION);
		if (controlFunicularStation==false) {
			System.out.println("start funicular station");
			List<Map<String, String>> funicularStation = CreateJSONFile.readExcelFile(utility.Constant.EXCEL_FUNICULAR_STATION_LIST);
			CreateJSONFile.writeJsonToFile(funicularStation, utility.Constant.JSON_FUNICULAR_STATION);
		}
		
		Boolean controlCompany = Control.control(utility.Constant.JSON_COMPANY);
		if(controlCompany==false) {
			System.out.println("start company");
			List<Map<String, String>> companies = CreateJSONFile.readExcelFile(utility.Constant.EXCEL_COMPANIES_LIST);
			CreateJSONFile.writeJsonToFile(companies, utility.Constant.JSON_COMPANY);
		}
		
		Boolean controlPullmanStop = Control.control(utility.Constant.JSON_PULLMAN_STOP);
		if (controlPullmanStop==false) {
			System.out.println("start pullman stop");
			List<Map<String, String>> pullmanStop = CreateJSONFile.readExcelFile(utility.Constant.EXCEL_PULLMAN_STOP_LIST);
			CreateJSONFile.writeJsonToFile(pullmanStop, utility.Constant.JSON_PULLMAN_STOP);
		}
		
		Boolean controlTrainStation = Control.control(utility.Constant.JSON_TRAIN_STATION);
		if(controlTrainStation==false) {
			System.out.println("start train station");
			List<Map<String, String>> trainStation = CreateJSONFile.readExcelFile(utility.Constant.EXCEL_TRAIN_STATION_LIST);
			CreateJSONFile.writeJsonToFile(trainStation, utility.Constant.JSON_TRAIN_STATION);
		}
		
		Boolean controlTramStop = Control.control(utility.Constant.JSON_TRAM_STOP);
		if (controlTramStop==false) {
			System.out.println("start tram stop");
			List<Map<String, String>> tramStop = CreateJSONFile.readExcelFile(utility.Constant.EXCEL_TRAM_STOP_LIST);
			CreateJSONFile.writeJsonToFile(tramStop, utility.Constant.JSON_TRAM_STOP);
		}
		
		Boolean controlFunicularTimetbale = Control.control(utility.Constant.JSON_FUNICULAR_TIMETABLE);
		if(controlFunicularTimetbale==false) {
			System.out.println("start funicular timetable");
			List<Map<String, String>> funicularTimetable = CreateJSONFile.readExcelFile(utility.Constant.EXCEL_FUNICULAR_TIMETABLE);
			CreateJSONFile.writeJsonToFile(funicularTimetable, utility.Constant.JSON_FUNICULAR_TIMETABLE);
		}
		
		Boolean controlTramTimetable = Control.control(utility.Constant.JSON_TRAM_TIMETABLE);
		if(controlTramTimetable==false) {
			System.out.println("start tram timetable");
			List<Map<String, String>> tramTimetable = CreateJSONFile.readExcelFile(utility.Constant.EXCEL_TRAM_TIMETABLE);
			CreateJSONFile.writeJsonToFile(tramTimetable, utility.Constant.JSON_TRAM_TIMETABLE);
		}
		
		// insert data
		DSLContext insertPublicTransportation = InsertDataDB.connection(utility.Constant.DB_URL_PUBLIC_TRANSPORTATION);
		InsertDataDB.company(insertPublicTransportation);
		InsertDataDB.funicular_station(insertPublicTransportation);
		InsertDataDB.train_station(insertPublicTransportation);
		InsertDataDB.tram_stop(insertPublicTransportation);
		InsertDataDB.pullman_stop(insertPublicTransportation);
		InsertDataDB.funicular(insertPublicTransportation);
		InsertDataDB.tram(insertPublicTransportation);
		
		//DSLContext insertUser = InsertDataDB.connection(utility.Constant.DB_URL_PUBLIC_TRANSPORTATION);
		// user(insertUser);
	}

}
