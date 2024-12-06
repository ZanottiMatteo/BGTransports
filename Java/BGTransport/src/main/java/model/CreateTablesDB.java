package model;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class CreateTablesDB {

	public static void createTablesPublicTransportation(DSLContext create) {
		// Creates the "PULLMAN TIMETABLE" table if it does not already exist
		create.createTableIfNotExists(Constant.PULLMAN_TIMETABLE)
				.column(Constant.ID, SQLDataType.INTEGER) 
				.column(Constant.COMPANY_NAME, SQLDataType.VARCHAR(255)) 
				.column(Constant.LINE, SQLDataType.VARCHAR(255)) 
				.column(Constant.DEPARTURE_PULLMAN_STOP, SQLDataType.VARCHAR(255)) 
				.column(Constant.DEPARTURE_TIME, SQLDataType.VARCHAR(255)) 
				.column(Constant.ARRIVAL_PULLMAN_STOP, SQLDataType.VARCHAR(255)) 
				.column(Constant.ARRIVAL_TIME, SQLDataType.VARCHAR(255))
				.column(Constant.NEXT_STOP, SQLDataType.VARCHAR(255)) 
				.column(Constant.TIME_STOP, SQLDataType.VARCHAR(255)) 
				.column(Constant.TYPE, SQLDataType.VARCHAR(255))
				.constraints(DSL.constraint("PK_" + Constant.PULLMAN_TIMETABLE).primaryKey(Constant.ID) 
				).execute();

		// Creates the "FUNICULAR TIMETABLE" table if it does not already exist
		create.createTableIfNotExists(Constant.FUNICULAR_TIMETABLE)
				.column(Constant.ID, SQLDataType.INTEGER) 
				.column(Constant.COMPANY_NAME, SQLDataType.VARCHAR(255)) 
				.column(Constant.NAME, SQLDataType.VARCHAR(255)) 
				.column(Constant.DEPARTURE_FUNICULAR_STATION, SQLDataType.VARCHAR(255)) 
				.column(Constant.DEPARTURE_TIME, SQLDataType.VARCHAR(255)) 
				.column(Constant.ARRIVAL_FUNICULAR_STATION, SQLDataType.VARCHAR(255)) 
				.column(Constant.ARRIVAL_TIME, SQLDataType.VARCHAR(255)) 
				.column(Constant.TYPE, SQLDataType.VARCHAR(255)) 
				.column(Constant.NUMBER_OF_SEATS, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.FUNICULAR_TIMETABLE).primaryKey(Constant.ID) 
				).execute();

		// Creates the "TRAIN TIMETABLE" table if it does not already exist
		create.createTableIfNotExists(Constant.TRAIN_TIMETABLE)
				.column(Constant.ID, SQLDataType.INTEGER) 
				.column(Constant.COMPANY_NAME, SQLDataType.VARCHAR(255)) 
				.column(Constant.NAME, SQLDataType.VARCHAR(255)) 
				.column(Constant.DEPARTURE_TRAIN_STATION, SQLDataType.VARCHAR(255)) 
				.column(Constant.DEPARTURE_TIME, SQLDataType.VARCHAR(255)) 
				.column(Constant.ARRIVAL_TRAIN_STATION, SQLDataType.VARCHAR(255)) 
				.column(Constant.ARRIVAL_TIME, SQLDataType.VARCHAR(255)) 
				.column(Constant.NEXT_STOP, SQLDataType.VARCHAR(255)) 
				.column(Constant.TIME_STOP, SQLDataType.VARCHAR(255))
				.constraints(DSL.constraint("PK_" + Constant.TRAIN_TIMETABLE).primaryKey(Constant.ID)
				).execute();

		// Creates the "TRAM TIMETABLE" table if it does not already exist
		create.createTableIfNotExists(Constant.TRAM_TIMETABLE)
				.column(Constant.ID, SQLDataType.INTEGER) 
				.column(Constant.COMPANY_NAME, SQLDataType.VARCHAR(255)) 
				.column(Constant.NAME, SQLDataType.VARCHAR(255)) 
				.column(Constant.DEPARTURE_TRAM_STATION, SQLDataType.VARCHAR(255)) 
				.column(Constant.DEPARTURE_TIME, SQLDataType.VARCHAR(255)) 
				.column(Constant.ARRIVAL_TRAM_STATION, SQLDataType.VARCHAR(255)) 
				.column(Constant.ARRIVAL_TIME, SQLDataType.VARCHAR(255)) 
				.column(Constant.NEXT_STOP, SQLDataType.VARCHAR(255)) 
				.column(Constant.TIME_STOP, SQLDataType.VARCHAR(255)) 
				.column(Constant.TYPE, SQLDataType.VARCHAR(255)) 
				.column(Constant.NUMBER_OF_SEATS, SQLDataType.VARCHAR(255)) 
				.column(Constant.NUMBER_OF_CARRIAGES, SQLDataType.VARCHAR(255))
				.constraints(DSL.constraint("PK_" + Constant.TRAM_TIMETABLE).primaryKey(Constant.ID) 
				).execute();

		// Creates the "COMPANY" table if it does not already exist
		create.createTableIfNotExists(Constant.COMPANY)
				.column(Constant.NAME, SQLDataType.VARCHAR(255)) 
				.column(Constant.LEGAL_STRUCTURE, SQLDataType.VARCHAR(255)) 
				.column(Constant.BUSINESS_TAX_CODE, SQLDataType.VARCHAR(255)) // BUSINESS TAX CODE column
				.column(Constant.COMPANY_REGISTRATION_NUMBER, SQLDataType.VARCHAR(255)) // COMPANY REGISTRATION column
				.column(Constant.INCORPORATION_DATE, SQLDataType.VARCHAR(255)) // INCORPORATION DATE column
				.column(Constant.LEGAL_REPRESENTATIVE, SQLDataType.VARCHAR(255)) // LEGAL REPRESENTATIVE column
				.column(Constant.NUMBER_OF_EMPLOYEES, SQLDataType.VARCHAR(255)) // NUMBER OF EMPLOYEES column
				.column(Constant.ATECO_CODE, SQLDataType.VARCHAR(255)) // ATECO CODE column
				.column(Constant.REGISTERED_OFFICE, SQLDataType.VARCHAR(255)) // REGISTERED OFFICE column
				.column(Constant.PROVINCE, SQLDataType.VARCHAR(255)) // PROVINCE column
				.column(Constant.CAP, SQLDataType.VARCHAR(255)) // POSTAL CODE (CAP) column
				.column(Constant.ADDRESS, SQLDataType.VARCHAR(255)) // ADDRESS column
				.column(Constant.STREET_NUMBER, SQLDataType.VARCHAR(255)) // STREET NUMBER column
				.column(Constant.TELEPHONE, SQLDataType.VARCHAR(255)) // TELEPHONE column
				.column(Constant.MAIL, SQLDataType.VARCHAR(255)) // MAIL column
				.column(Constant.SOCIAL, SQLDataType.VARCHAR(255)) // SOCIAL NETWORK column
				.column(Constant.WEB_SITE, SQLDataType.VARCHAR(255)) // WEB SITE column
				.constraints(DSL.constraint("PK_" + Constant.COMPANY).primaryKey(Constant.NAME)
				).execute();

		// Creates the "PULLMAN STOP" table if it does not already exist
		create.createTableIfNotExists(Constant.PULLMAN_STOP)
				.column(Constant.NAME, SQLDataType.VARCHAR(255)) 
				.column(Constant.TOWN, SQLDataType.VARCHAR(255)) 
				.column(Constant.PROVINCE, SQLDataType.VARCHAR(255))
				.column(Constant.LATITUDE, SQLDataType.VARCHAR(255)) 
				.column(Constant.LONGITUDE, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.PULLMAN_STOP).primaryKey(Constant.NAME) 
				).execute();

		// Creates the "TRAM STOP" table if it does not already exist
		create.createTableIfNotExists(Constant.TRAM_STOP)
				.column(Constant.NAME, SQLDataType.VARCHAR(255)) 
				.column(Constant.ADDRESS, SQLDataType.VARCHAR(255)) 
				.column(Constant.TOWN, SQLDataType.VARCHAR(255)) 
				.column(Constant.PROVINCE, SQLDataType.VARCHAR(255)) 
				.column(Constant.LATITUDE, SQLDataType.VARCHAR(255)) 
				.column(Constant.LONGITUDE, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.TRAM_STOP).primaryKey(Constant.NAME) 
				).execute();

		// Creates the "FUNICULAR STATION" table if it does not already exist
		create.createTableIfNotExists(Constant.FUNICULAR_STATION)
				.column(Constant.NAME, SQLDataType.VARCHAR(255))
				.column(Constant.ADDRESS, SQLDataType.VARCHAR(255)) 
				.column(Constant.TOWN, SQLDataType.VARCHAR(255)) 
				.column(Constant.PROVINCE, SQLDataType.VARCHAR(255)) 
				.column(Constant.LATITUDE, SQLDataType.VARCHAR(255)) 
				.column(Constant.LONGITUDE, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.FUNICULAR_STATION).primaryKey(Constant.NAME) 
				).execute();

		// Creates the "TRAIN STATION" table if it does not already exist
		create.createTableIfNotExists(Constant.TRAIN_STATION)
				.column(Constant.NAME, SQLDataType.VARCHAR(255)) 
				.column(Constant.ADDRESS, SQLDataType.VARCHAR(255)) 
				.column(Constant.TOWN, SQLDataType.VARCHAR(255)) 
				.column(Constant.PROVINCE, SQLDataType.VARCHAR(255))
				.column(Constant.LATITUDE, SQLDataType.VARCHAR(255)) 
				.column(Constant.LONGITUDE, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.TRAIN_STATION).primaryKey(Constant.NAME) 
				).execute();
	}

	public static void createTablesUsers(DSLContext create) {
		// Creates the "USER" table if it does not already exist
		create.createTableIfNotExists(Constant.USER)
				.column(Constant.USERNAME, SQLDataType.VARCHAR(100))
				.column(Constant.NAME, SQLDataType.VARCHAR(100)) 
				.column(Constant.SURNAME, SQLDataType.VARCHAR(100))
				.column(Constant.DATE_OF_BIRTH, SQLDataType.VARCHAR(20)) 
				.column(Constant.ADDRESS, SQLDataType.VARCHAR(50)) 
				.column(Constant.TOWN, SQLDataType.VARCHAR(50)) 
				.column(Constant.CAP, SQLDataType.VARCHAR(100))
				.column(Constant.PASSWORD, SQLDataType.VARCHAR(50)) 
				.column(Constant.MAIL, SQLDataType.VARCHAR(100)) 
				.column(Constant.ROLE, SQLDataType.INTEGER)
				.column(Constant.ICON_NUMBER, SQLDataType.INTEGER)
				.constraints(DSL.constraint("PK_" + Constant.USER).primaryKey(Constant.USERNAME) 
				).execute();
	}
		
}
