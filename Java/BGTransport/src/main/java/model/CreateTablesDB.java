package model;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class CreateTablesDB {

	public static void createTablesPublicTransportation(DSLContext create) {
		// Creates the "PULLMAN TIMETABLE" table if it does not already exist
		create.createTableIfNotExists(Constant.pullman)
				.column(Constant.id, SQLDataType.INTEGER) 
				.column(Constant.company_name, SQLDataType.VARCHAR(255)) 
				.column(Constant.line, SQLDataType.VARCHAR(255)) 
				.column(Constant.departure_pullman_stop, SQLDataType.VARCHAR(255)) 
				.column(Constant.departure_time, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrival_pullman_stop, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrival_time, SQLDataType.VARCHAR(255))
				.column(Constant.next_stop, SQLDataType.VARCHAR(255)) 
				.column(Constant.time_stop, SQLDataType.VARCHAR(255)) 
				.column(Constant.type, SQLDataType.VARCHAR(255))
				.constraints(DSL.constraint("PK_" + Constant.pullman).primaryKey(Constant.id) 
				).execute();
		System.out.println("Table " + Constant.pullman + " created successfully!");

		// Creates the "FUNICULAR TIMETABLE" table if it does not already exist
		create.createTableIfNotExists(Constant.funicular)
				.column(Constant.id, SQLDataType.INTEGER) 
				.column(Constant.company_name, SQLDataType.VARCHAR(255)) 
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.departure_funicular_station, SQLDataType.VARCHAR(255)) 
				.column(Constant.departure_time, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrival_funicular_station, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrival_time, SQLDataType.VARCHAR(255)) 
				.column(Constant.type, SQLDataType.VARCHAR(255)) 
				.column(Constant.number_of_seats, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.funicular).primaryKey(Constant.id) 
				).execute();
		System.out.println("Table " + Constant.funicular + " created successfully!");

		// Creates the "TRAIN TIMETABLE" table if it does not already exist
		create.createTableIfNotExists(Constant.train)
				.column(Constant.id, SQLDataType.INTEGER) 
				.column(Constant.company_name, SQLDataType.VARCHAR(255)) 
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.departure_train_station, SQLDataType.VARCHAR(255)) 
				.column(Constant.departure_time, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrival_train_station, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrival_time, SQLDataType.VARCHAR(255)) 
				.column(Constant.next_stop, SQLDataType.VARCHAR(255)) 
				.column(Constant.time_stop, SQLDataType.VARCHAR(255))
				.constraints(DSL.constraint("PK_" + Constant.train).primaryKey(Constant.id)
				).execute();
		System.out.println("Table " + Constant.train + " created successfully!");

		// Creates the "TRAM TIMETABLE" table if it does not already exist
		create.createTableIfNotExists(Constant.tram)
				.column(Constant.id, SQLDataType.INTEGER) 
				.column(Constant.company_name, SQLDataType.VARCHAR(255)) 
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.departure_tram_station, SQLDataType.VARCHAR(255)) 
				.column(Constant.departure_time, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrival_tram_station, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrival_time, SQLDataType.VARCHAR(255)) 
				.column(Constant.next_stop, SQLDataType.VARCHAR(255)) 
				.column(Constant.time_stop, SQLDataType.VARCHAR(255)) 
				.column(Constant.type, SQLDataType.VARCHAR(255)) 
				.column(Constant.number_of_seats, SQLDataType.VARCHAR(255)) 
				.column(Constant.number_of_carriages, SQLDataType.VARCHAR(255))
				.constraints(DSL.constraint("PK_" + Constant.tram).primaryKey(Constant.id) 
				).execute();
		System.out.println("Table " + Constant.tram + " created successfully!");

		// Creates the "COMPANY" table if it does not already exist
		create.createTableIfNotExists(Constant.company)
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.legal_structure, SQLDataType.VARCHAR(255)) 
				.column(Constant.business_tax_code, SQLDataType.VARCHAR(255)) // BUSINESS TAX CODE column
				.column(Constant.company_registration_number, SQLDataType.VARCHAR(255)) // COMPANY REGISTRATION column
				.column(Constant.incorporation_date, SQLDataType.VARCHAR(255)) // INCORPORATION DATE column
				.column(Constant.legal_representative, SQLDataType.VARCHAR(255)) // LEGAL REPRESENTATIVE column
				.column(Constant.number_of_employees, SQLDataType.VARCHAR(255)) // NUMBER OF EMPLOYEES column
				.column(Constant.ATECO_code, SQLDataType.VARCHAR(255)) // ATECO CODE column
				.column(Constant.registered_office, SQLDataType.VARCHAR(255)) // REGISTERED OFFICE column
				.column(Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
				.column(Constant.CAP, SQLDataType.VARCHAR(255)) // POSTAL CODE (CAP) column
				.column(Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
				.column(Constant.street_number, SQLDataType.VARCHAR(255)) // STREET NUMBER column
				.column(Constant.telephone, SQLDataType.VARCHAR(255)) // TELEPHONE column
				.column(Constant.mail, SQLDataType.VARCHAR(255)) // MAIL column
				.column(Constant.social, SQLDataType.VARCHAR(255)) // SOCIAL NETWORK column
				.column(Constant.web_site, SQLDataType.VARCHAR(255)) // WEB SITE column
				.constraints(DSL.constraint("PK_" + Constant.company).primaryKey(Constant.name)
				).execute();
		System.out.println("Table " + Constant.company + " created successfully!");

		// Creates the "PULLMAN STOP" table if it does not already exist
		create.createTableIfNotExists(Constant.pullman_stop)
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.town, SQLDataType.VARCHAR(255)) 
				.column(Constant.province, SQLDataType.VARCHAR(255))
				.column(Constant.latitude, SQLDataType.VARCHAR(255)) 
				.column(Constant.longitude, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.pullman_stop).primaryKey(Constant.name) 
				).execute();
		System.out.println("Table " + Constant.pullman_stop + " created successfully!");

		// Creates the "TRAM STOP" table if it does not already exist
		create.createTableIfNotExists(Constant.tram_stop)
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.address, SQLDataType.VARCHAR(255)) 
				.column(Constant.town, SQLDataType.VARCHAR(255)) 
				.column(Constant.province, SQLDataType.VARCHAR(255)) 
				.column(Constant.latitude, SQLDataType.VARCHAR(255)) 
				.column(Constant.longitude, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.tram_stop).primaryKey(Constant.name) 
				).execute();
		System.out.println("Table " + Constant.tram_stop + " created successfully!");

		// Creates the "FUNICULAR STATION" table if it does not already exist
		create.createTableIfNotExists(Constant.funicular_station)
				.column(Constant.name, SQLDataType.VARCHAR(255))
				.column(Constant.address, SQLDataType.VARCHAR(255)) 
				.column(Constant.town, SQLDataType.VARCHAR(255)) 
				.column(Constant.province, SQLDataType.VARCHAR(255)) 
				.column(Constant.latitude, SQLDataType.VARCHAR(255)) 
				.column(Constant.longitude, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.funicular_station).primaryKey(Constant.name) 
				).execute();
		System.out.println("Table " + Constant.funicular_station + " created successfully!");

		// Creates the "TRAIN STATION" table if it does not already exist
		create.createTableIfNotExists(Constant.train_station)
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.address, SQLDataType.VARCHAR(255)) 
				.column(Constant.town, SQLDataType.VARCHAR(255)) 
				.column(Constant.province, SQLDataType.VARCHAR(255))
				.column(Constant.latitude, SQLDataType.VARCHAR(255)) 
				.column(Constant.longitude, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.train_station).primaryKey(Constant.name) 
				).execute();
		System.out.println("Table " + Constant.train_station + " created successfully!");
	}

	public static void createTablesUsers(DSLContext create) {
		// Creates the "USER" table if it does not already exist
		create.createTableIfNotExists(Constant.user)
				.column(Constant.username, SQLDataType.VARCHAR(100))
				.column(Constant.name, SQLDataType.VARCHAR(100)) 
				.column(Constant.surname, SQLDataType.VARCHAR(100))
				.column(Constant.date_of_birth, SQLDataType.VARCHAR(20)) 
				.column(Constant.address, SQLDataType.VARCHAR(50)) 
				.column(Constant.town, SQLDataType.VARCHAR(50)) 
				.column(Constant.CAP, SQLDataType.VARCHAR(100))
				.column(Constant.password, SQLDataType.VARCHAR(50)) 
				.column(Constant.mail, SQLDataType.VARCHAR(100)) 
				.column(Constant.role, SQLDataType.INTEGER)
				.constraints(DSL.constraint("PK_" + Constant.user).primaryKey(Constant.username) 
				).execute();
		System.out.println("Table " + Constant.user + " created successfully!");
	}
		
}
