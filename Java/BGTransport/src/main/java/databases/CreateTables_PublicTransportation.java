package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class CreateTables_PublicTransportation {

	/**
	 * function that creates all the tables for the database Public Transportation
	 * @param create = DSL.using(conn, SQLDialect.SQLITE);
	 */
	public static void create(DSLContext create) {
	    // Creates the "PULLMAN" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.pullman)
	            .column(utility.Constant.id, SQLDataType.INTEGER) // ID column with auto-increment
	            .column(utility.Constant.license_plate, SQLDataType.VARCHAR(255)) // LICENSE PLATE column
	            .column(utility.Constant.driver, SQLDataType.VARCHAR(255)) // DRIVER column
	            .column(utility.Constant.state, SQLDataType.VARCHAR(255)) // STATE column
	            .column(utility.Constant.number_of_seats, SQLDataType.INTEGER) // NUMBER OF SEATS column
	            .column(utility.Constant.departure_stop, SQLDataType.VARCHAR(255)) // Column identifying the DEPARTURE STOP
	            .column(utility.Constant.departure_timetable, SQLDataType.TIME) // DEPARTURE TIME from the stop column
	            .column(utility.Constant.arrival_stop, SQLDataType.VARCHAR(255)) // Column identifying the ARRIVAL STOP
	            .column(utility.Constant.arrival_timetable, SQLDataType.TIME) // ARRIVAL TIME at the stop column
	            .column(utility.Constant.company, SQLDataType.VARCHAR(255)) // COMPANY name column
	            .column(utility.Constant.pullman_stop, SQLDataType.VARCHAR(255)) // STOP column
	            .column(utility.Constant.time, SQLDataType.VARCHAR(255)) // TIME column
	            .constraints(DSL.constraint("PK_" + utility.Constant.pullman).primaryKey(utility.Constant.id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.pullman + " created successfully!");

	    // Creates the "FUNICULAR" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.funicular)
	            .column(utility.Constant.id, SQLDataType.INTEGER) // ID column with auto-increment
	            .column(utility.Constant.driver, SQLDataType.VARCHAR(255)) // DRIVER column
	            .column(utility.Constant.state, SQLDataType.VARCHAR(255)) // STATE column
	            .column(utility.Constant.number_of_seats, SQLDataType.INTEGER) // NUMBER_OF_SEATS column
	            .column(utility.Constant.departure_funicular_station, SQLDataType.VARCHAR(255)) // Column identifying the DEPARTURE FUNICULAR STATION
	            .column(utility.Constant.arrival_funicular_station, SQLDataType.VARCHAR(255)) // Column identifying the ARRIVAL FUNICULAR STATION
	            .column(utility.Constant.departure_timetable, SQLDataType.TIME) // DEPARTURE TIME from the station column
	            .column(utility.Constant.arrival_timetable, SQLDataType.TIME) // ARRIVAL TIME at the station column
	            .column(utility.Constant.company, SQLDataType.VARCHAR(255)) // COMPANY name column
	            .constraints(DSL.constraint("PK_" + utility.Constant.funicular).primaryKey(utility.Constant.id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.funicular + " created successfully!");

	    // Creates the "TRAIN" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.train)
	            .column(utility.Constant.id, SQLDataType.INTEGER) // ID column with auto-increment
	            .column(utility.Constant.driver, SQLDataType.VARCHAR(255)) // DRIVER column
	            .column(utility.Constant.state, SQLDataType.VARCHAR(255)) // STATE column
	            .column(utility.Constant.number_of_seats, SQLDataType.INTEGER) // NUMBER_OF_SEATS column
	            .column(utility.Constant.number_of_carriages, SQLDataType.INTEGER) // NUMBER_OF_CARRIAGES column
	            .column(utility.Constant.departure_train_station, SQLDataType.VARCHAR(255)) // Column identifying the DEPARTURE TRAIN STATION
	            .column(utility.Constant.arrival_train_station, SQLDataType.VARCHAR(255)) // Column identifying the ARRIVAL TRAIN STATION
	            .column(utility.Constant.departure_timetable, SQLDataType.TIME) // DEPARTURE TIME from the station column
	            .column(utility.Constant.arrival_timetable, SQLDataType.TIME) // ARRIVAL TIME at the station column
	            .column(utility.Constant.company, SQLDataType.VARCHAR(255)) // COMPANY name column
	            .column(utility.Constant.train_stop, SQLDataType.VARCHAR(255)) // TRAIN STOP column
	            .column(utility.Constant.time, SQLDataType.VARCHAR(255)) // TIME column
	            .constraints(DSL.constraint("PK_" + utility.Constant.train).primaryKey(utility.Constant.id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.train + " created successfully!");

	    // Creates the "TRAM" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.tram)
	            .column(utility.Constant.id, SQLDataType.INTEGER) // ID column with auto-increment
	            .column(utility.Constant.driver, SQLDataType.VARCHAR(255)) // DRIVER column
	            .column(utility.Constant.state, SQLDataType.VARCHAR(255)) // STATE column
	            .column(utility.Constant.number_of_seats, SQLDataType.INTEGER) // NUMBER_OF_SEATS column
	            .column(utility.Constant.number_of_carriages, SQLDataType.INTEGER) // NUMBER_OF_CARRIAGES column
	            .column(utility.Constant.departure_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the DEPARTURE TRAM STATION
	            .column(utility.Constant.arrival_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the ARRIVAL TRAM STATION
	            .column(utility.Constant.departure_timetable, SQLDataType.TIME) // DEPARTURE TIME from the station column
	            .column(utility.Constant.arrival_timetable, SQLDataType.TIME) // ARRIVAL TIME at the station column
	            .column(utility.Constant.company, SQLDataType.VARCHAR(255)) // COMPANY name column
	            .column(utility.Constant.tram_stop, SQLDataType.VARCHAR(255)) // TRAM STOP column
	            .column(utility.Constant.time, SQLDataType.VARCHAR(255)) // TIME column
	            .constraints(DSL.constraint("PK_" + utility.Constant.tram).primaryKey(utility.Constant.id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.tram + " created successfully!");

	    // Creates the "SCHEDULE" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.timetable)
	            .column(utility.Constant.time, SQLDataType.TIME) // TIME column
	            .constraints(DSL.constraint("PK_" + utility.Constant.timetable).primaryKey(utility.Constant.time) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.timetable + " created successfully!");
	    
	    // Creates the "STATUS" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.state)
	            .column(utility.Constant.description, SQLDataType.VARCHAR(20)) // STATUS DESCRIPTION column
	            .constraints(DSL.constraint("PK_" + utility.Constant.state).primaryKey(utility.Constant.description) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.state + " created successfully!");
	    
	    // Creates the "DRIVER" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.driver)
	            .column(utility.Constant.id, SQLDataType.INTEGER) // ID column with auto-increment
	            .column(utility.Constant.surname, SQLDataType.VARCHAR(255)) // SURNAME column
	            .column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME column
	            .column(utility.Constant.fiscal_code, SQLDataType.VARCHAR(255)) // FISCAL CODE column
	            .column(utility.Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
	            .column(utility.Constant.street_number, SQLDataType.VARCHAR(255)) // STREET NUMBER column
	            .column(utility.Constant.town, SQLDataType.VARCHAR(255)) // MUNICIPALITY column
	            .column(utility.Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
	            .column(utility.Constant.CAP, SQLDataType.INTEGER) // POSTAL CODE (CAP) column
	            .column(utility.Constant.date_of_birth, SQLDataType.DATE) // DATE OF BIRTH column
	            .column(utility.Constant.place_of_birth, SQLDataType.VARCHAR(255)) // PLACE OF BIRTH column
	            .column(utility.Constant.telephone, SQLDataType.INTEGER) // TELEPHONE column
	            .column(utility.Constant.mail, SQLDataType.VARCHAR(255)) // MAIL column
	            .column(utility.Constant.social, SQLDataType.VARCHAR(255)) // SOCIAL NETWORK column
	            .column(utility.Constant.web_site, SQLDataType.VARCHAR(255)) // WEB SITE column
	            .constraints(DSL.constraint("PK_" + utility.Constant.driver).primaryKey(utility.Constant.id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.driver + " created successfully!");
	    
	 // Creates the "COMPANY" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.company)
	    		.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the company column
	    		.column(utility.Constant.legal_structure, SQLDataType.VARCHAR(255)) // LEGAL STRUCTURE of the company column
	    		.column(utility.Constant.business_tax_code, SQLDataType.VARCHAR(255)) // BUSINESS TAX CODE column
	    		.column(utility.Constant.company_registration_number, SQLDataType.INTEGER) // COMPANY REGISTRATION NUMBER column
	    		.column(utility.Constant.incorporation_date, SQLDataType.DATE) // INCORPORATION DATE column
	    		.column(utility.Constant.legal_representative, SQLDataType.VARCHAR(255)) // LEGAL REPRESENTATIVE column
	    		.column(utility.Constant.number_of_employees, SQLDataType.VARCHAR(255)) // NUMBER OF EMPLOYEES column
	    		.column(utility.Constant.ATECO_code, SQLDataType.VARCHAR(255)) // ATECO CODE column
	    		.column(utility.Constant.registered_office, SQLDataType.VARCHAR(255)) // REGISTERED OFFICE column
	    		.column(utility.Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
	    		.column(utility.Constant.CAP, SQLDataType.INTEGER) // POSTAL CODE (CAP) column
	    		.column(utility.Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
	    		.column(utility.Constant.street_number, SQLDataType.VARCHAR(255)) // STREET NUMBER column
	    		.column(utility.Constant.telephone, SQLDataType.INTEGER) // TELEPHONE column
	    		.column(utility.Constant.mail, SQLDataType.VARCHAR(255)) // MAIL column
	    		.column(utility.Constant.social, SQLDataType.VARCHAR(255)) // SOCIAL NETWORK column
	    		.column(utility.Constant.web_site, SQLDataType.VARCHAR(255)) // WEB SITE column
	            .constraints(DSL.constraint("PK_" + utility.Constant.company).primaryKey(utility.Constant.name) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.company + " created successfully!");
	    
	    // Creates the "PULLMAN STOP" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.pullman_stop)
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the company column
        		.constraints(DSL.constraint("PK_" + utility.Constant.pullman_stop).primaryKey(utility.Constant.name) // Set a primary key
        		).execute();
	    System.out.println("Table " + utility.Constant.pullman_stop + " created successfully!");
	    
	    // Creates the "TRAM STOP" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.tram_stop)
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the company column
        		.constraints(DSL.constraint("PK_" + utility.Constant.tram_stop).primaryKey(utility.Constant.name) // Set a primary key
        		).execute();
	    System.out.println("Table " + utility.Constant.tram_stop + " created successfully!");
	    
	    // Creates the "FUNICULAR STATION" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.funicular_station)
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the company column
        		.constraints(DSL.constraint("PK_" + utility.Constant.funicular_station).primaryKey(utility.Constant.name) // Set a primary key
        		).execute();
	    System.out.println("Table " + utility.Constant.funicular_station + " created successfully!");
	    
	    // Creates the "TRAIN STATION" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.train_station)
	            .column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME column
	            .column(utility.Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
	            .column(utility.Constant.town, SQLDataType.VARCHAR(255)) // TOWN column
	            .column(utility.Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
	            .constraints(DSL.constraint("PK_" + utility.Constant.train_station).primaryKey(utility.Constant.name) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.train_station + " created successfully!");
	}

	/**
	 * function that starts the creation of the tables
	 * @param args
	 */
	public static void main(String[] args) {
	    try (Connection conn = DriverManager.getConnection(utility.Constant.DB_URL_PUBLIC_TRANSPORTATION)) {
	        // Create a jOOQ DSL context
	        DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
	        System.out.println("Creating tables in the database: " + utility.Constant.DB_URL_PUBLIC_TRANSPORTATION + " ...");
	        create(create);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
