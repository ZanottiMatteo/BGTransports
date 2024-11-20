package databases;

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
		create.createTableIfNotExists(utility.Constant.pullman).column(utility.Constant.id, SQLDataType.INTEGER) // ID
																													// column
				.column(utility.Constant.company_name, SQLDataType.VARCHAR(255)) // COMPANY name column
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME column
				.column(utility.Constant.line, SQLDataType.VARCHAR(255)) // type of LINE column
				.column(utility.Constant.departure_stop, SQLDataType.VARCHAR(255)) // Column identifying the DEPARTURE
																					// STOP
				.column(utility.Constant.departure_time, SQLDataType.VARCHAR(255)) // DEPARTURE TIME from the stop
																					// column
				.column(utility.Constant.arrival_stop, SQLDataType.VARCHAR(255)) // Column identifying the ARRIVAL STOP
				.column(utility.Constant.arrival_time, SQLDataType.VARCHAR(255)) // ARRIVAL TIME at the stop column
				.column(utility.Constant.next_stop, SQLDataType.VARCHAR(255)) // STOP column
				.column(utility.Constant.time_stop, SQLDataType.VARCHAR(255)) // TIME column
				.column(utility.Constant.number_of_seats, SQLDataType.VARCHAR(255)) // NUMBER OF SEATS column
				.column(utility.Constant.license_plate, SQLDataType.VARCHAR(255)) // LICENSE PLATE column
				.constraints(DSL.constraint("PK_" + utility.Constant.pullman).primaryKey(utility.Constant.id) // Set a
																												// primary
																												// key
				).execute();
		System.out.println("Table " + utility.Constant.pullman + " created successfully!");

		// Creates the "FUNICULAR" table if it does not already exist
		create.createTableIfNotExists(utility.Constant.funicular).column(utility.Constant.id, SQLDataType.INTEGER) // ID
																													// column
				.column(utility.Constant.company_name, SQLDataType.VARCHAR(255)) // COMPANY name column
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME column
				.column(utility.Constant.departure_funicular_station, SQLDataType.VARCHAR(255)) // Column identifying
																								// the DEPARTURE
																								// FUNICULAR STATION
				.column(utility.Constant.departure_time, SQLDataType.VARCHAR(255)) // DEPARTURE TIME from the station
																					// column
				.column(utility.Constant.arrival_funicular_station, SQLDataType.VARCHAR(255)) // Column identifying the
																								// ARRIVAL FUNICULAR
																								// STATION
				.column(utility.Constant.arrival_time, SQLDataType.VARCHAR(255)) // ARRIVAL TIME at the station column
				.column(utility.Constant.type, SQLDataType.VARCHAR(255)) // holiday and weekday TYPE column
				.column(utility.Constant.number_of_seats, SQLDataType.VARCHAR(255)) // NUMBER_OF_SEATS column
				.constraints(DSL.constraint("PK_" + utility.Constant.funicular).primaryKey(utility.Constant.id) // Set a
																												// primary
																												// key
				).execute();
		System.out.println("Table " + utility.Constant.funicular + " created successfully!");

		// Creates the "TRAIN" table if it does not already exist
		create.createTableIfNotExists(utility.Constant.train).column(utility.Constant.id, SQLDataType.INTEGER) // ID
																												// column
				.column(utility.Constant.company_name, SQLDataType.VARCHAR(255)) // COMPANY name column
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the tram column
				.column(utility.Constant.departure_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the
																							// DEPARTURE TRAM STATION
				.column(utility.Constant.departure_time, SQLDataType.VARCHAR(255)) // DEPARTURE TIME from the station
																					// column
				.column(utility.Constant.arrival_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the
																							// ARRIVAL TRAM STATION
				.column(utility.Constant.arrival_time, SQLDataType.VARCHAR(255)) // ARRIVAL TIME at the station column
				.column(utility.Constant.next_stop, SQLDataType.VARCHAR(255)) // TRAM STOP column
				.column(utility.Constant.time_stop, SQLDataType.VARCHAR(255)) // TIME column
				.column(utility.Constant.type, SQLDataType.VARCHAR(255)) // holiday and weekday TYPE column
				.column(utility.Constant.number_of_seats, SQLDataType.VARCHAR(255)) // NUMBER_OF_SEATS column
				.column(utility.Constant.number_of_carriages, SQLDataType.VARCHAR(255)) // NUMBER_OF_CARRIAGES column
				.constraints(DSL.constraint("PK_" + utility.Constant.train).primaryKey(utility.Constant.id) // Set a
																											// primary
																											// key
				).execute();
		System.out.println("Table " + utility.Constant.train + " created successfully!");

		// Creates the "TRAM" table if it does not already exist
		create.createTableIfNotExists(utility.Constant.tram).column(utility.Constant.id, SQLDataType.INTEGER) // ID
																												// column
				.column(utility.Constant.company_name, SQLDataType.VARCHAR(255)) // COMPANY name column
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the tram column
				.column(utility.Constant.departure_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the
																							// DEPARTURE TRAM STATION
				.column(utility.Constant.departure_time, SQLDataType.VARCHAR(255)) // DEPARTURE TIME from the station
																					// column
				.column(utility.Constant.arrival_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the
																							// ARRIVAL TRAM STATION
				.column(utility.Constant.arrival_time, SQLDataType.VARCHAR(255)) // ARRIVAL TIME at the station column
				.column(utility.Constant.next_stop, SQLDataType.VARCHAR(255)) // TRAM STOP column
				.column(utility.Constant.time_stop, SQLDataType.VARCHAR(255)) // TIME column
				.column(utility.Constant.type, SQLDataType.VARCHAR(255)) // holiday and weekday TYPE column
				.column(utility.Constant.number_of_seats, SQLDataType.VARCHAR(255)) // NUMBER_OF_SEATS column
				.column(utility.Constant.number_of_carriages, SQLDataType.VARCHAR(255)) // NUMBER_OF_CARRIAGES column
				.constraints(DSL.constraint("PK_" + utility.Constant.tram).primaryKey(utility.Constant.id) // Set a
																											// primary
																											// key
				).execute();
		System.out.println("Table " + utility.Constant.tram + " created successfully!");

		// Creates the "COMPANY" table if it does not already exist
		create.createTableIfNotExists(utility.Constant.company).column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME
																														// of
																														// the
																														// company
																														// column
				.column(utility.Constant.legal_structure, SQLDataType.VARCHAR(255)) // LEGAL STRUCTURE of the company
																					// column
				.column(utility.Constant.business_tax_code, SQLDataType.VARCHAR(255)) // BUSINESS TAX CODE column
				.column(utility.Constant.company_registration_number, SQLDataType.VARCHAR(255)) // COMPANY REGISTRATION
																								// NUMBER column
				.column(utility.Constant.incorporation_date, SQLDataType.VARCHAR(255)) // INCORPORATION DATE column
				.column(utility.Constant.legal_representative, SQLDataType.VARCHAR(255)) // LEGAL REPRESENTATIVE column
				.column(utility.Constant.number_of_employees, SQLDataType.VARCHAR(255)) // NUMBER OF EMPLOYEES column
				.column(utility.Constant.ATECO_code, SQLDataType.VARCHAR(255)) // ATECO CODE column
				.column(utility.Constant.registered_office, SQLDataType.VARCHAR(255)) // REGISTERED OFFICE column
				.column(utility.Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
				.column(utility.Constant.CAP, SQLDataType.VARCHAR(255)) // POSTAL CODE (CAP) column
				.column(utility.Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
				.column(utility.Constant.street_number, SQLDataType.VARCHAR(255)) // STREET NUMBER column
				.column(utility.Constant.telephone, SQLDataType.VARCHAR(255)) // TELEPHONE column
				.column(utility.Constant.mail, SQLDataType.VARCHAR(255)) // MAIL column
				.column(utility.Constant.social, SQLDataType.VARCHAR(255)) // SOCIAL NETWORK column
				.column(utility.Constant.web_site, SQLDataType.VARCHAR(255)) // WEB SITE column
				.constraints(DSL.constraint("PK_" + utility.Constant.company).primaryKey(utility.Constant.name) // Set a
																												// primary
																												// key
				).execute();
		System.out.println("Table " + utility.Constant.company + " created successfully!");

		// Creates the "PULLMAN STOP" table if it does not already exist
		create.createTableIfNotExists(utility.Constant.pullman_stop)
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the pullmans stop column
				.column(utility.Constant.town, SQLDataType.VARCHAR(255)) // TOWN column
				.column(utility.Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
				.constraints(DSL.constraint("PK_" + utility.Constant.pullman_stop).primaryKey(utility.Constant.name) // Set
																														// a
																														// primary
																														// key
				).execute();
		System.out.println("Table " + utility.Constant.pullman_stop + " created successfully!");

		// Creates the "TRAM STOP" table if it does not already exist
		create.createTableIfNotExists(utility.Constant.tram_stop)
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the trams stop column
				.column(utility.Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
				.column(utility.Constant.town, SQLDataType.VARCHAR(255)) // TOWN column
				.column(utility.Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
				.constraints(DSL.constraint("PK_" + utility.Constant.tram_stop).primaryKey(utility.Constant.name) // Set
																													// a
																													// primary
																													// key
				).execute();
		System.out.println("Table " + utility.Constant.tram_stop + " created successfully!");

		// Creates the "FUNICULAR STATION" table if it does not already exist
		create.createTableIfNotExists(utility.Constant.funicular_station)
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the funicular stations column
				.column(utility.Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
				.column(utility.Constant.town, SQLDataType.VARCHAR(255)) // TOWN column
				.column(utility.Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
				.constraints(
						DSL.constraint("PK_" + utility.Constant.funicular_station).primaryKey(utility.Constant.name) // Set
																														// a
																														// primary
																														// key
				).execute();
		System.out.println("Table " + utility.Constant.funicular_station + " created successfully!");

		// Creates the "TRAIN STATION" table if it does not already exist
		create.createTableIfNotExists(utility.Constant.train_station)
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the tran stations column
				.column(utility.Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
				.column(utility.Constant.town, SQLDataType.VARCHAR(255)) // TOWN column
				.column(utility.Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
				.constraints(DSL.constraint("PK_" + utility.Constant.train_station).primaryKey(utility.Constant.name) // Set
																														// a
																														// primary
																														// key
				).execute();
		System.out.println("Table " + utility.Constant.train_station + " created successfully!");
	}

	public static void createTablesUsers(DSLContext create) {
		// Creates the "USER" table if it does not already exist
		create.createTableIfNotExists(utility.Constant.user).column(utility.Constant.surname, SQLDataType.VARCHAR(100)) // SURNAME
																														// column
				.column(utility.Constant.name, SQLDataType.VARCHAR(100)) // NAME column
				.column(utility.Constant.fiscal_code, SQLDataType.VARCHAR(50)) // FISCAL CODE column
				.column(utility.Constant.date_of_birth, SQLDataType.VARCHAR(20)) // DATE OF BIRTH column
				.column(utility.Constant.place_of_birth, SQLDataType.VARCHAR(50)) // PLACE OF BIRTH column
				.column(utility.Constant.CAP, SQLDataType.VARCHAR(10)) // POSTAL CODE (CAP) column
				.column(utility.Constant.town, SQLDataType.VARCHAR(50)) // MUNICIPALITY column
				.column(utility.Constant.province, SQLDataType.VARCHAR(4)) // PROVINCE column
				.column(utility.Constant.street_number, SQLDataType.VARCHAR(50)) // STREET NUMBER column
				.column(utility.Constant.address, SQLDataType.VARCHAR(50)) // ADDRESS column
				.column(utility.Constant.password, SQLDataType.VARCHAR(50)) // PASSWORD column
				.column(utility.Constant.registered_user, SQLDataType.BOOLEAN) // REGISTERED USER column
				.column(utility.Constant.manager, SQLDataType.BOOLEAN) // MANAGER column
				.column(utility.Constant.developer, SQLDataType.BOOLEAN) // DEVELOPER column
				.column(utility.Constant.telephone, SQLDataType.VARCHAR(50)) // TELEPHONE column
				.column(utility.Constant.mail, SQLDataType.VARCHAR(100)) // MAIL column
				.column(utility.Constant.social, SQLDataType.VARCHAR(100)) // SOCIAL NETWORK column
				.column(utility.Constant.web_site, SQLDataType.VARCHAR(100)) // WEB SITE column
				.constraints(DSL.constraint("PK_" + utility.Constant.user).primaryKey(utility.Constant.surname) // Set a
																												// primary
																												// key
				).execute();
		System.out.println("Table " + utility.Constant.user + " created successfully!");
	}

	public static DSLContext DSLContext(String database) throws SQLException {
		Connection connPublicTransportation = DriverManager.getConnection(database);
		DSLContext createPublicTrasnportation = DSL.using(connPublicTransportation, SQLDialect.SQLITE);
		System.out.println("Creating tables in the database: " + database + " ...");
		return createPublicTrasnportation;
	}
}
