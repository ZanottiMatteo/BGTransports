package model;

public class MainModel {
	public static void main(String[] args) throws Exception {
		// create database Public Transportation
		ControlDB.controlJSON(Constant.JSON_FUNICULAR_STATION, Constant.EXCEL_FUNICULAR_STATION);
		ControlDB.controlJSON(Constant.JSON_COMPANY, Constant.EXCEL_COMPANY);
		ControlDB.controlJSON(Constant.JSON_PULLMAN_STOP, Constant.EXCEL_PULLMAN_STOP);
		ControlDB.controlJSON(Constant.JSON_TRAIN_STATION, Constant.EXCEL_TRAIN_STATION);
		ControlDB.controlJSON(Constant.JSON_TRAM_STOP, Constant.EXCEL_TRAM_STOP);
		ControlDB.controlJSON(Constant.JSON_FUNICULAR_TIMETABLE, Constant.EXCEL_FUNICULAR_TIMETABLE);
		ControlDB.controlJSON(Constant.JSON_TRAM_TIMETABLE, Constant.EXCEL_TRAM_TIMETABLE);
		ControlDB.controlJSON(Constant.JSON_TRAIN_TIMETABLE, Constant.EXCEL_TRAIN_TIMETABLE);
		ControlDB.controlJSON(Constant.JSON_PULLMAN_TIMETABLE, Constant.EXCEL_PULLMAN_TIMETABLE);
		
		ControlDB.dbCheck(Constant.DB_PUBLIC_TRANSPORTATION, Constant.DB_URL_PUBLIC_TRANSPORTATION, Constant.JOOQ_TRANSPORTATION, Constant.SRC_TRANSPORTATION);
		
		ControlDB.dbUpdate(Constant.DB_URL_PUBLIC_TRANSPORTATION);
		
		// create database User
		ControlDB.dbCheck(Constant.DB_USERS, Constant.DB_URL_USERS, Constant.JOOQ_USER, Constant.SRC_USER);
	}

}
