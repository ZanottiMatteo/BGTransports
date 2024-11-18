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
	            .column(utility.Constant.id, SQLDataType.INTEGER) // ID column
	            .column(utility.Constant.company_name, SQLDataType.VARCHAR(255)) // COMPANY name column
	            .column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME column
	            .column(utility.Constant.line, SQLDataType.VARCHAR(255)) // type of LINE column
	            .column(utility.Constant.departure_stop, SQLDataType.VARCHAR(255)) // Column identifying the DEPARTURE STOP
	            .column(utility.Constant.departure_time, SQLDataType.VARCHAR(255)) // DEPARTURE TIME from the stop column
	            .column(utility.Constant.arrival_stop, SQLDataType.VARCHAR(255)) // Column identifying the ARRIVAL STOP
	            .column(utility.Constant.arrival_time, SQLDataType.VARCHAR(255)) // ARRIVAL TIME at the stop column
	            .column(utility.Constant.pullman_stop_name, SQLDataType.VARCHAR(255)) // STOP column
	            .column(utility.Constant.time_stop, SQLDataType.VARCHAR(255)) // TIME column
	            .column(utility.Constant.number_of_seats, SQLDataType.VARCHAR(255)) // NUMBER OF SEATS column
	            .column(utility.Constant.license_plate, SQLDataType.VARCHAR(255)) // LICENSE PLATE column
	            .column(utility.Constant.info, SQLDataType.VARCHAR(255)) // INFO column
	            .constraints(DSL.constraint("PK_" + utility.Constant.pullman).primaryKey(utility.Constant.id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.pullman + " created successfully!");

	    // Creates the "FUNICULAR" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.funicular)
	            .column(utility.Constant.id, SQLDataType.INTEGER) // ID column
	            .column(utility.Constant.company_name, SQLDataType.VARCHAR(255)) // COMPANY name column
	            .column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME column
	            .column(utility.Constant.departure_funicular_station, SQLDataType.VARCHAR(255)) // Column identifying the DEPARTURE FUNICULAR STATION
	            .column(utility.Constant.departure_time, SQLDataType.VARCHAR(255)) // DEPARTURE TIME from the station column
	            .column(utility.Constant.arrival_funicular_station, SQLDataType.VARCHAR(255)) // Column identifying the ARRIVAL FUNICULAR STATION
	            .column(utility.Constant.arrival_time, SQLDataType.VARCHAR(255)) // ARRIVAL TIME at the station column
	            .column(utility.Constant.type, SQLDataType.VARCHAR(255)) // holiday and weekday TYPE column
	            .column(utility.Constant.number_of_seats, SQLDataType.VARCHAR(255)) // NUMBER_OF_SEATS column
	            .column(utility.Constant.info, SQLDataType.VARCHAR(255)) // INFO column
	            .constraints(DSL.constraint("PK_" + utility.Constant.funicular).primaryKey(utility.Constant.id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.funicular + " created successfully!");

	    // Creates the "TRAIN" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.train)
	    		.column(utility.Constant.id, SQLDataType.INTEGER) // ID column
	    		.column(utility.Constant.company_name, SQLDataType.VARCHAR(255)) // COMPANY name column
	    		.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the tram column
	    		.column(utility.Constant.departure_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the DEPARTURE TRAM STATION
	    		.column(utility.Constant.departure_time, SQLDataType.VARCHAR(255)) // DEPARTURE TIME from the station column
	    		.column(utility.Constant.arrival_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the ARRIVAL TRAM STATION
	    		.column(utility.Constant.arrival_time, SQLDataType.VARCHAR(255)) // ARRIVAL TIME at the station column
	    		.column(utility.Constant.next_stop, SQLDataType.VARCHAR(255)) // TRAM STOP column
	    		.column(utility.Constant.time_stop, SQLDataType.VARCHAR(255)) // TIME column
	    		.column(utility.Constant.type, SQLDataType.VARCHAR(255)) // holiday and weekday TYPE column
	    		.column(utility.Constant.number_of_seats, SQLDataType.VARCHAR(255)) // NUMBER_OF_SEATS column
	    		.column(utility.Constant.number_of_carriages, SQLDataType.VARCHAR(255)) // NUMBER_OF_CARRIAGES column
	    		.column(utility.Constant.info, SQLDataType.VARCHAR(255)) // INFO column
	            .constraints(DSL.constraint("PK_" + utility.Constant.train).primaryKey(utility.Constant.id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.train + " created successfully!");

	    // Creates the "TRAM" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.tram)
	            .column(utility.Constant.id, SQLDataType.INTEGER) // ID column
	            .column(utility.Constant.company_name, SQLDataType.VARCHAR(255)) // COMPANY name column
	            .column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the tram column
	            .column(utility.Constant.departure_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the DEPARTURE TRAM STATION
	            .column(utility.Constant.departure_time, SQLDataType.VARCHAR(255)) // DEPARTURE TIME from the station column
	            .column(utility.Constant.arrival_tram_station, SQLDataType.VARCHAR(255)) // Column identifying the ARRIVAL TRAM STATION
	            .column(utility.Constant.arrival_time, SQLDataType.VARCHAR(255)) // ARRIVAL TIME at the station column
	            .column(utility.Constant.next_stop, SQLDataType.VARCHAR(255)) // TRAM STOP column
	            .column(utility.Constant.time_stop, SQLDataType.VARCHAR(255)) // TIME column
	            .column(utility.Constant.type, SQLDataType.VARCHAR(255)) // holiday and weekday TYPE column
	            .column(utility.Constant.number_of_seats, SQLDataType.VARCHAR(255)) // NUMBER_OF_SEATS column
	            .column(utility.Constant.number_of_carriages, SQLDataType.VARCHAR(255)) // NUMBER_OF_CARRIAGES column
	            .column(utility.Constant.info, SQLDataType.VARCHAR(255)) // INFO column
	            .constraints(DSL.constraint("PK_" + utility.Constant.tram).primaryKey(utility.Constant.id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.tram + " created successfully!");
	    
	 // Creates the "COMPANY" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.company)
	    		.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the company column
	    		.column(utility.Constant.legal_structure, SQLDataType.VARCHAR(255)) // LEGAL STRUCTURE of the company column
	    		.column(utility.Constant.business_tax_code, SQLDataType.VARCHAR(255)) // BUSINESS TAX CODE column
	    		.column(utility.Constant.company_registration_number, SQLDataType.VARCHAR(255)) // COMPANY REGISTRATION NUMBER column
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
	            .constraints(DSL.constraint("PK_" + utility.Constant.company).primaryKey(utility.Constant.name) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.company + " created successfully!");
	    
	    // Creates the "PULLMAN STOP" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.pullman_stop)
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the pullmans stop column
				.column(utility.Constant.town, SQLDataType.VARCHAR(255)) // TOWN column
				.column(utility.Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
        		.constraints(DSL.constraint("PK_" + utility.Constant.pullman_stop).primaryKey(utility.Constant.name) // Set a primary key
        		).execute();
	    System.out.println("Table " + utility.Constant.pullman_stop + " created successfully!");
	    
	    // Creates the "TRAM STOP" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.tram_stop)
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the trams stop column
				.column(utility.Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
				.column(utility.Constant.town, SQLDataType.VARCHAR(255)) // TOWN column
				.column(utility.Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
        		.constraints(DSL.constraint("PK_" + utility.Constant.tram_stop).primaryKey(utility.Constant.name) // Set a primary key
        		).execute();
	    System.out.println("Table " + utility.Constant.tram_stop + " created successfully!");
	    
	    // Creates the "FUNICULAR STATION" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.funicular_station)
				.column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the funicular stations column
				.column(utility.Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
				.column(utility.Constant.town, SQLDataType.VARCHAR(255)) // TOWN column
				.column(utility.Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
        		.constraints(DSL.constraint("PK_" + utility.Constant.funicular_station).primaryKey(utility.Constant.name) // Set a primary key
        		).execute();
	    System.out.println("Table " + utility.Constant.funicular_station + " created successfully!");
	    
	    // Creates the "TRAIN STATION" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.train_station)
	            .column(utility.Constant.name, SQLDataType.VARCHAR(255)) // NAME of the tran stations column
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
