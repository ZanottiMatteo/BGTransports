package bgtransport.model;

public class MainModel {
	public static void main(String[] args) throws Exception {
		// create database Public Transportation
		ControlDB.controlJSON(ConstantFile.JSON_FUNICULAR_STATION, ConstantFile.EXCEL_FUNICULAR_STATION);
		ControlDB.controlJSON(ConstantFile.JSON_COMPANY, ConstantFile.EXCEL_COMPANY);
		ControlDB.controlJSON(ConstantFile.JSON_PULLMAN_STOP, ConstantFile.EXCEL_PULLMAN_STOP);
		ControlDB.controlJSON(ConstantFile.JSON_TRAIN_STATION, ConstantFile.EXCEL_TRAIN_STATION);
		ControlDB.controlJSON(ConstantFile.JSON_TRAM_STOP, ConstantFile.EXCEL_TRAM_STOP);
		ControlDB.controlJSON(ConstantFile.JSON_FUNICULAR_TIMETABLE, ConstantFile.EXCEL_FUNICULAR_TIMETABLE);
		ControlDB.controlJSON(ConstantFile.JSON_TRAM_TIMETABLE, ConstantFile.EXCEL_TRAM_TIMETABLE);
		ControlDB.controlJSON(ConstantFile.JSON_TRAIN_TIMETABLE, ConstantFile.EXCEL_TRAIN_TIMETABLE);
		ControlDB.controlJSON(ConstantFile.JSON_PULLMAN_TIMETABLE, ConstantFile.EXCEL_PULLMAN_TIMETABLE);
		
		ControlDB.dbCheck(ConstantDB.DB_PUBLIC_TRANSPORTATION, ConstantDB.DB_URL_PUBLIC_TRANSPORTATION, ConstantDB.JOOQ_TRANSPORTATION, ConstantDB.SRC_TRANSPORTATION);
		
		ControlDB.dbUpdate(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		
		// create database User
		ControlDB.dbCheck(ConstantDB.DB_USERS, ConstantDB.DB_URL_USERS, ConstantDB.JOOQ_USER, ConstantDB.SRC_USER);
	}

}
