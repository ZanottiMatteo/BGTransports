package model;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class CreateTablesDB {

	public static void createTablesPublicTransportation(DSLContext create) {
	    createPullmanTimetable(create);
	    createFunicularTimetable(create);
	    createTrainTimetable(create);
	    createTramTimetable(create);
	    createCompanyTable(create);
	    createPullmanStop(create);
	    createTramStop(create);
	    createFunicularStation(create);
	    createTrainStation(create);
	}

	private static void createPullmanTimetable(DSLContext create) {
	    create.createTableIfNotExists(ConstantString.PULLMAN_TIMETABLE)
	            .column(ConstantString.ID, SQLDataType.INTEGER) 
	            .column(ConstantString.COMPANY_NAME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.LINE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.DEPARTURE_PULLMAN_STOP, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.DEPARTURE_TIME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.ARRIVAL_PULLMAN_STOP, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.ARRIVAL_TIME, SQLDataType.VARCHAR(255))
	            .column(ConstantString.NEXT_STOP, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.TIME_STOP, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.TYPE, SQLDataType.VARCHAR(255))
	            .constraints(DSL.constraint("PK_" + ConstantString.PULLMAN_TIMETABLE).primaryKey(ConstantString.ID) 
	            ).execute();
	}

	private static void createFunicularTimetable(DSLContext create) {
	    create.createTableIfNotExists(ConstantString.FUNICULAR_TIMETABLE)
	            .column(ConstantString.ID, SQLDataType.INTEGER) 
	            .column(ConstantString.COMPANY_NAME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.NAME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.DEPARTURE_FUNICULAR_STATION, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.DEPARTURE_TIME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.ARRIVAL_FUNICULAR_STATION, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.ARRIVAL_TIME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.TYPE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.NUMBER_OF_SEATS, SQLDataType.VARCHAR(255)) 
	            .constraints(DSL.constraint("PK_" + ConstantString.FUNICULAR_TIMETABLE).primaryKey(ConstantString.ID) 
	            ).execute();
	}

	private static void createTrainTimetable(DSLContext create) {
	    create.createTableIfNotExists(ConstantString.TRAIN_TIMETABLE)
	            .column(ConstantString.ID, SQLDataType.INTEGER) 
	            .column(ConstantString.COMPANY_NAME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.NAME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.DEPARTURE_TRAIN_STATION, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.DEPARTURE_TIME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.ARRIVAL_TRAIN_STATION, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.ARRIVAL_TIME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.NEXT_STOP, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.TIME_STOP, SQLDataType.VARCHAR(255))
	            .constraints(DSL.constraint("PK_" + ConstantString.TRAIN_TIMETABLE).primaryKey(ConstantString.ID)
	            ).execute();
	}

	private static void createTramTimetable(DSLContext create) {
	    create.createTableIfNotExists(ConstantString.TRAM_TIMETABLE)
	            .column(ConstantString.ID, SQLDataType.INTEGER) 
	            .column(ConstantString.COMPANY_NAME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.NAME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.DEPARTURE_TRAM_STATION, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.DEPARTURE_TIME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.ARRIVAL_TRAM_STATION, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.ARRIVAL_TIME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.NEXT_STOP, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.TIME_STOP, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.TYPE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.NUMBER_OF_SEATS, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.NUMBER_OF_CARRIAGES, SQLDataType.VARCHAR(255))
	            .constraints(DSL.constraint("PK_" + ConstantString.TRAM_TIMETABLE).primaryKey(ConstantString.ID) 
	            ).execute();
	}

	private static void createCompanyTable(DSLContext create) {
	    create.createTableIfNotExists(ConstantString.COMPANY)
	            .column(ConstantString.NAME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.LEGAL_STRUCTURE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.BUSINESS_TAX_CODE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.COMPANY_REGISTRATION_NUMBER, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.INCORPORATION_DATE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.LEGAL_REPRESENTATIVE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.NUMBER_OF_EMPLOYEES, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.ATECO_CODE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.REGISTERED_OFFICE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.PROVINCE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.CAP, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.ADDRESS, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.STREET_NUMBER, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.TELEPHONE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.MAIL, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.SOCIAL, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.WEB_SITE, SQLDataType.VARCHAR(255)) 
	            .constraints(DSL.constraint("PK_" + ConstantString.COMPANY).primaryKey(ConstantString.NAME)
	            ).execute();
	}

	private static void createPullmanStop(DSLContext create) {
	    create.createTableIfNotExists(ConstantString.PULLMAN_STOP)
	            .column(ConstantString.NAME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.TOWN, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.PROVINCE, SQLDataType.VARCHAR(255))
	            .column(ConstantString.LATITUDE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.LONGITUDE, SQLDataType.VARCHAR(255)) 
	            .constraints(DSL.constraint("PK_" + ConstantString.PULLMAN_STOP).primaryKey(ConstantString.NAME) 
	            ).execute();
	}

	private static void createTramStop(DSLContext create) {
	    create.createTableIfNotExists(ConstantString.TRAM_STOP)
	            .column(ConstantString.NAME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.ADDRESS, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.TOWN, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.PROVINCE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.LATITUDE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.LONGITUDE, SQLDataType.VARCHAR(255)) 
	            .constraints(DSL.constraint("PK_" + ConstantString.TRAM_STOP).primaryKey(ConstantString.NAME) 
	            ).execute();
	}

	private static void createFunicularStation(DSLContext create) {
	    create.createTableIfNotExists(ConstantString.FUNICULAR_STATION)
	            .column(ConstantString.NAME, SQLDataType.VARCHAR(255))
	            .column(ConstantString.ADDRESS, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.TOWN, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.PROVINCE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.LATITUDE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.LONGITUDE, SQLDataType.VARCHAR(255)) 
	            .constraints(DSL.constraint("PK_" + ConstantString.FUNICULAR_STATION).primaryKey(ConstantString.NAME) 
	            ).execute();
	}

	private static void createTrainStation(DSLContext create) {
	    create.createTableIfNotExists(ConstantString.TRAIN_STATION)
	            .column(ConstantString.NAME, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.ADDRESS, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.TOWN, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.PROVINCE, SQLDataType.VARCHAR(255))
	            .column(ConstantString.LATITUDE, SQLDataType.VARCHAR(255)) 
	            .column(ConstantString.LONGITUDE, SQLDataType.VARCHAR(255)) 
	            .constraints(DSL.constraint("PK_" + ConstantString.TRAIN_STATION).primaryKey(ConstantString.NAME) 
	            ).execute();
	}

	public static void createTablesUsers(DSLContext create) {
		// Creates the "USER" table if it does not already exist
		create.createTableIfNotExists(ConstantString.USER)
				.column(ConstantString.USERNAME, SQLDataType.VARCHAR(100))
				.column(ConstantString.NAME, SQLDataType.VARCHAR(100)) 
				.column(ConstantString.SURNAME, SQLDataType.VARCHAR(100))
				.column(ConstantString.DATE_OF_BIRTH, SQLDataType.VARCHAR(20)) 
				.column(ConstantString.ADDRESS, SQLDataType.VARCHAR(50)) 
				.column(ConstantString.TOWN, SQLDataType.VARCHAR(50)) 
				.column(ConstantString.CAP, SQLDataType.VARCHAR(100))
				.column(ConstantString.PASSWORD, SQLDataType.VARCHAR(50)) 
				.column(ConstantString.MAIL, SQLDataType.VARCHAR(100)) 
				.column(ConstantString.ROLE, SQLDataType.INTEGER)
				.column(ConstantString.ICON_NUMBER, SQLDataType.INTEGER)
				.constraints(DSL.constraint("PK_" + ConstantString.USER).primaryKey(ConstantString.USERNAME) 
				).execute();
	}
		
}
