package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class CreateTablesDB {

	public static void createTablesPublicTransportation(DSLContext create) {
		// Creates the "PULLMAN" table if it does not already exist
		create.createTableIfNotExists(Constant.pullman).column(Constant.id, SQLDataType.INTEGER) // ID
																									// column
				.column(Constant.company_name, SQLDataType.VARCHAR(255)) // COMPANY name column
				.column(Constant.name, SQLDataType.VARCHAR(255)) // NAME column
				.column(Constant.line, SQLDataType.VARCHAR(255)) // type of LINE column
				.column(Constant.departure_stop, SQLDataType.VARCHAR(255)) // Column identifying the DEPARTURE
																			// STOP
				.column(Constant.departure_time, SQLDataType.VARCHAR(255)) // DEPARTURE TIME from the stop
																			// column
				.column(Constant.arrival_stop, SQLDataType.VARCHAR(255)) // Column identifying the ARRIVAL STOP
				.column(Constant.arrival_time, SQLDataType.VARCHAR(255)) // ARRIVAL TIME at the stop column
				.column(Constant.next_stop, SQLDataType.VARCHAR(255)) // STOP column
				.column(Constant.time_stop, SQLDataType.VARCHAR(255)) // TIME column
				.column(Constant.number_of_seats, SQLDataType.VARCHAR(255)) // NUMBER OF SEATS column
				.column(Constant.license_plate, SQLDataType.VARCHAR(255)) // LICENSE PLATE column
				.constraints(DSL.constraint("PK_" + Constant.pullman).primaryKey(Constant.id) // Set a
																								// primary
																								// key
				).execute();
		System.out.println("Table " + Constant.pullman + " created successfully!");

		// Creates the "FUNICULAR" table if it does not already exist
		create.createTableIfNotExists(Constant.funicular).column(Constant.id, SQLDataType.INTEGER) // ID
																									// column
				.column(Constant.company_name, SQLDataType.VARCHAR(255)) // COMPANY name column
				.column(Constant.name, SQLDataType.VARCHAR(255)) // NAME column
				.column(Constant.departure_funicular_station, SQLDataType.VARCHAR(255)) // Column identifying
																						// the DEPARTURE
																						// FUNICULAR STATION
				.column(Constant.departure_time, SQLDataType.VARCHAR(255)) // DEPARTURE TIME from the station
																			// column
				.column(Constant.arrival_funicular_station, SQLDataType.VARCHAR(255)) // Column identifying the
																						// ARRIVAL FUNICULAR
																						// STATION
				.column(Constant.arrival_time, SQLDataType.VARCHAR(255)) // ARRIVAL TIME at the station column
				.column(Constant.type, SQLDataType.VARCHAR(255)) // holiday and weekday TYPE column
				.column(Constant.number_of_seats, SQLDataType.VARCHAR(255)) // NUMBER_OF_SEATS column
				.constraints(DSL.constraint("PK_" + Constant.funicular).primaryKey(Constant.id) // Set a
																								// primary
																								// key
				).execute();
		System.out.println("Table " + Constant.funicular + " created successfully!");

		// Creates the "TRAIN" table if it does not already exist
		create.createTableIfNotExists(Constant.train).column(Constant.id, SQLDataType.INTEGER) // ID
																								// column
				.column(Constant.company_name, SQLDataType.VARCHAR(255)) // COMPANY name column
				.column(Constant.name, SQLDataType.VARCHAR(255)) // NAME of the tram column
				.column(Constant.departure_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the
																					// DEPARTURE TRAM STATION
				.column(Constant.departure_time, SQLDataType.VARCHAR(255)) // DEPARTURE TIME from the station
																			// column
				.column(Constant.arrival_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the
																					// ARRIVAL TRAM STATION
				.column(Constant.arrival_time, SQLDataType.VARCHAR(255)) // ARRIVAL TIME at the station column
				.column(Constant.next_stop, SQLDataType.VARCHAR(255)) // TRAM STOP column
				.column(Constant.time_stop, SQLDataType.VARCHAR(255)) // TIME column
				.column(Constant.type, SQLDataType.VARCHAR(255)) // holiday and weekday TYPE column
				.column(Constant.number_of_seats, SQLDataType.VARCHAR(255)) // NUMBER_OF_SEATS column
				.column(Constant.number_of_carriages, SQLDataType.VARCHAR(255)) // NUMBER_OF_CARRIAGES column
				.constraints(DSL.constraint("PK_" + Constant.train).primaryKey(Constant.id) // Set a
																							// primary
																							// key
				).execute();
		System.out.println("Table " + Constant.train + " created successfully!");

		// Creates the "TRAM" table if it does not already exist
		create.createTableIfNotExists(Constant.tram).column(Constant.id, SQLDataType.INTEGER) // ID
																								// column
				.column(Constant.company_name, SQLDataType.VARCHAR(255)) // COMPANY name column
				.column(Constant.name, SQLDataType.VARCHAR(255)) // NAME of the tram column
				.column(Constant.departure_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the
																					// DEPARTURE TRAM STATION
				.column(Constant.departure_time, SQLDataType.VARCHAR(255)) // DEPARTURE TIME from the station
																			// column
				.column(Constant.arrival_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the
																					// ARRIVAL TRAM STATION
				.column(Constant.arrival_time, SQLDataType.VARCHAR(255)) // ARRIVAL TIME at the station column
				.column(Constant.next_stop, SQLDataType.VARCHAR(255)) // TRAM STOP column
				.column(Constant.time_stop, SQLDataType.VARCHAR(255)) // TIME column
				.column(Constant.type, SQLDataType.VARCHAR(255)) // holiday and weekday TYPE column
				.column(Constant.number_of_seats, SQLDataType.VARCHAR(255)) // NUMBER_OF_SEATS column
				.column(Constant.number_of_carriages, SQLDataType.VARCHAR(255)) // NUMBER_OF_CARRIAGES column
				.constraints(DSL.constraint("PK_" + Constant.tram).primaryKey(Constant.id) // Set a
																							// primary
																							// key
				).execute();
		System.out.println("Table " + Constant.tram + " created successfully!");

		// Creates the "COMPANY" table if it does not already exist
		create.createTableIfNotExists(Constant.company).column(Constant.name, SQLDataType.VARCHAR(255)) // NAME
																										// of
																										// the
																										// company
																										// column
				.column(Constant.legal_structure, SQLDataType.VARCHAR(255)) // LEGAL STRUCTURE of the company
																			// column
				.column(Constant.business_tax_code, SQLDataType.VARCHAR(255)) // BUSINESS TAX CODE column
				.column(Constant.company_registration_number, SQLDataType.VARCHAR(255)) // COMPANY REGISTRATION
																						// NUMBER column
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
				.constraints(DSL.constraint("PK_" + Constant.company).primaryKey(Constant.name) // Set a
																								// primary
																								// key
				).execute();
		System.out.println("Table " + Constant.company + " created successfully!");

		// Creates the "PULLMAN STOP" table if it does not already exist
		create.createTableIfNotExists(Constant.pullman_stop).column(Constant.name, SQLDataType.VARCHAR(255)) // NAME of
																												// the
																												// pullmans
																												// stop
																												// column
				.column(Constant.town, SQLDataType.VARCHAR(255)) // TOWN column
				.column(Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
				.constraints(DSL.constraint("PK_" + Constant.pullman_stop).primaryKey(Constant.name) // Set
																										// a
																										// primary
																										// key
				).execute();
		System.out.println("Table " + Constant.pullman_stop + " created successfully!");

		// Creates the "TRAM STOP" table if it does not already exist
		create.createTableIfNotExists(Constant.tram_stop).column(Constant.name, SQLDataType.VARCHAR(255)) // NAME of the
																											// trams
																											// stop
																											// column
				.column(Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
				.column(Constant.town, SQLDataType.VARCHAR(255)) // TOWN column
				.column(Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
				.constraints(DSL.constraint("PK_" + Constant.tram_stop).primaryKey(Constant.name) // Set
																									// a
																									// primary
																									// key
				).execute();
		System.out.println("Table " + Constant.tram_stop + " created successfully!");

		// Creates the "FUNICULAR STATION" table if it does not already exist
		create.createTableIfNotExists(Constant.funicular_station).column(Constant.name, SQLDataType.VARCHAR(255)) // NAME
																													// of
																													// the
																													// funicular
																													// stations
																													// column
				.column(Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
				.column(Constant.town, SQLDataType.VARCHAR(255)) // TOWN column
				.column(Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
				.constraints(DSL.constraint("PK_" + Constant.funicular_station).primaryKey(Constant.name) // Set
																											// a
																											// primary
																											// key
				).execute();
		System.out.println("Table " + Constant.funicular_station + " created successfully!");

		// Creates the "TRAIN STATION" table if it does not already exist
		create.createTableIfNotExists(Constant.train_station).column(Constant.name, SQLDataType.VARCHAR(255)) // NAME of
																												// the
																												// tran
																												// stations
																												// column
				.column(Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
				.column(Constant.town, SQLDataType.VARCHAR(255)) // TOWN column
				.column(Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
				.constraints(DSL.constraint("PK_" + Constant.train_station).primaryKey(Constant.name) // Set
																										// a
																										// primary
																										// key
				).execute();
		System.out.println("Table " + Constant.train_station + " created successfully!");
	}

	public static void createTablesUsers(DSLContext create) {
		// Creates the "USER" table if it does not already exist
		create.createTableIfNotExists(Constant.user)
				.column(Constant.username, SQLDataType.VARCHAR(100))
				.column(Constant.name, SQLDataType.VARCHAR(100)) // NAME column
				.column(Constant.surname, SQLDataType.VARCHAR(100))
				.column(Constant.date_of_birth, SQLDataType.VARCHAR(20)) // DATE OF BIRTH column
				.column(Constant.address, SQLDataType.VARCHAR(50)) // ADDRESS column
				.column(Constant.town, SQLDataType.VARCHAR(50)) // MUNICIPALITY column
				.column(Constant.CAP, SQLDataType.VARCHAR(100))
				.column(Constant.password, SQLDataType.VARCHAR(50)) // PASSWORD column
				.column(Constant.mail, SQLDataType.VARCHAR(100)) // MAIL column
				.column(Constant.role, SQLDataType.INTEGER)
				.constraints(DSL.constraint("PK_" + Constant.user).primaryKey(Constant.username) // Set a
																								// primary
																								// key
				).execute();
		System.out.println("Table " + Constant.user + " created successfully!");
	}
		
}
