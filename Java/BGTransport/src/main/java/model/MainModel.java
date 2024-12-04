package model;

public class MainModel {

	public static void main(String[] args) throws Exception {
		// create database Public Transportation
		ControlDB.controlJSON(Constant.JSON_FUNICULAR_STATION, Constant.EXCEL_FUNICULAR_STATION_LIST);
		ControlDB.controlJSON(Constant.JSON_COMPANY, Constant.EXCEL_COMPANIES_LIST);
		ControlDB.controlJSON(Constant.JSON_PULLMAN_STOP, Constant.EXCEL_PULLMAN_STOP_LIST);
		ControlDB.controlJSON(Constant.JSON_TRAIN_STATION, Constant.EXCEL_TRAIN_STATION_LIST);
		ControlDB.controlJSON(Constant.JSON_TRAM_STOP, Constant.EXCEL_TRAM_STOP_LIST);
		ControlDB.controlJSON(Constant.JSON_FUNICULAR_TIMETABLE, Constant.EXCEL_FUNICULAR_TIMETABLE);
		ControlDB.controlJSON(Constant.JSON_TRAM_TIMETABLE, Constant.EXCEL_TRAM_TIMETABLE);
		ControlDB.controlJSON(Constant.JSON_TRAIN_TIMETABLE, Constant.EXCEL_TRAIN_TIMETABLE);
		ControlDB.controlJSON(Constant.JSON_PULLMAN_TIMETABLE, Constant.EXCEL_PULLMAN_TIMETABLE);
		
		ControlDB.DBcheck(Constant.DB_PUBLIC_TRANSPORTATION, Constant.DB_URL_PUBLIC_TRANSPORTATION, Constant.JOOQ_TRANSPORTATION, Constant.SRC_TRANSPORTATION);
		
		// create database User
		ControlDB.DBcheck(Constant.DB_USERS, Constant.DB_URL_USERS, Constant.JOOQ_USER, Constant.SRC_USER);
	}

}
