package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class CreateTables_PublicTransportation {

	static String pullman = "PULLMAN";
	static String funicular = "FUNICULAR";
	static String train = "TRAIN";
	static String tram = "TRAM";
	static String station = "STATION";
	static String timetable = "TIMETABLE";
	static String license_plate = "LICENSE PLATE";
	static String id = "ID";
	static String driver = "DRIVER";
	static String state = "STATE";
	static String number_of_seats = "NUMBER OF SEATS";
	static String number_of_carriages = "NUMBER OF CARRIAGES";
	static String address = "ADDRESS";
	static String place = "PLACE";
	static String time = "TIME";
	static String departure_station = "DEPARTURE STATION";
	static String arrival_station = "ARRIVAL STATION";
	static String departure_timetable = "DEPARTURE TIMETABLE";
	static String arrival_timetable = "ARRIVAL TIMETABLE";
	static String description = "DESCRIPTION";
	static String name = "NAME";
	static String surname = "SURNAME";
	static String fiscal_code = "FISCAL CODE";
	static String place_of_birth = "PLACE OF BIRTH";
	static String date_of_birth = "DATE OF BIRTH";
	static String CAP = "CAP";
	static String town = "TOWN";
	static String province = "PROVINCE";
	

	/**
	 * function that creates all the tables for the database Public Transportation
	 * @param create = DSL.using(conn, SQLDialect.SQLITE);
	 */
	public static void create(DSLContext create) {
	    // Creates the "PULLMAN" table if it does not already exist
	    create.createTableIfNotExists(pullman)
	            .column(id, SQLDataType.INTEGER.identity(true)) // ID column with auto-increment
	            .column(license_plate, SQLDataType.VARCHAR(255).nullable(false)) // TARGA column
	            .column(driver, SQLDataType.VARCHAR(255)) // DRIVER column
	            .column(state, SQLDataType.VARCHAR(255)) // STATE column
	            .column(number_of_seats, SQLDataType.INTEGER) // NUMBER_OF_SEATS column
	            .column(departure_station, SQLDataType.INTEGER) // Column identifying the DEPARTURE STATION
	            .column(arrival_station, SQLDataType.INTEGER) // Column identifying the ARRIVAL STATION
	            .column(departure_timetable, SQLDataType.TIME) // DEPARTURE TIME from the station column
	            .column(arrival_timetable, SQLDataType.TIME) // ARRIVAL TIME at the station column
	            .constraints(DSL.constraint("PK_" + pullman).primaryKey(id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + pullman + " created successfully!");

	    // Creates the "FUNICULAR" table if it does not already exist
	    create.createTableIfNotExists(funicular)
	            .column(id, SQLDataType.INTEGER.identity(true)) // ID column with auto-increment
	            .column(driver, SQLDataType.VARCHAR(255)) // DRIVER column
	            .column(state, SQLDataType.VARCHAR(255)) // STATE column
	            .column(number_of_seats, SQLDataType.INTEGER) // NUMBER_OF_SEATS column
	            .column(departure_station, SQLDataType.INTEGER) // Column identifying the DEPARTURE STATION
	            .column(arrival_station, SQLDataType.INTEGER) // Column identifying the ARRIVAL STATION
	            .column(departure_timetable, SQLDataType.TIME) // DEPARTURE TIME from the station column
	            .column(arrival_timetable, SQLDataType.TIME) // ARRIVAL TIME at the station column
	            .constraints(DSL.constraint("PK_" + funicular).primaryKey(id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + funicular + " created successfully!");

	    // Creates the "TRAIN" table if it does not already exist
	    create.createTableIfNotExists(train)
	            .column(id, SQLDataType.INTEGER.identity(true)) // ID column with auto-increment
	            .column(driver, SQLDataType.VARCHAR(255)) // DRIVER column
	            .column(state, SQLDataType.VARCHAR(255)) // STATE column
	            .column(number_of_seats, SQLDataType.INTEGER) // NUMBER_OF_SEATS column
	            .column(number_of_carriages, SQLDataType.INTEGER) // NUMBER_OF_CARRIAGES column
	            .column(departure_station, SQLDataType.INTEGER) // Column identifying the DEPARTURE STATION
	            .column(arrival_station, SQLDataType.INTEGER) // Column identifying the ARRIVAL STATION
	            .column(departure_timetable, SQLDataType.TIME) // DEPARTURE TIME from the station column
	            .column(arrival_timetable, SQLDataType.TIME) // ARRIVAL TIME at the station column
	            .constraints(DSL.constraint("PK_" + train).primaryKey(id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + train + " created successfully!");

	    // Creates the "TRAM" table if it does not already exist
	    create.createTableIfNotExists(tram)
	            .column(id, SQLDataType.INTEGER.identity(true)) // ID column with auto-increment
	            .column(driver, SQLDataType.VARCHAR(255)) // DRIVER column
	            .column(state, SQLDataType.VARCHAR(255)) // STATE column
	            .column(number_of_seats, SQLDataType.INTEGER) // NUMBER_OF_SEATS column
	            .column(number_of_carriages, SQLDataType.INTEGER) // NUMBER_OF_CARRIAGES column
	            .column(departure_station, SQLDataType.INTEGER) // Column identifying the DEPARTURE STATION
	            .column(arrival_station, SQLDataType.INTEGER) // Column identifying the ARRIVAL STATION
	            .column(departure_timetable, SQLDataType.TIME) // DEPARTURE TIME from the station column
	            .column(arrival_timetable, SQLDataType.TIME) // ARRIVAL TIME at the station column
	            .constraints(DSL.constraint("PK_" + tram).primaryKey(id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + tram + " created successfully!");
	    
	    // Creates the "STATION" table if it does not already exist
	    create.createTableIfNotExists(station)
	            .column(id, SQLDataType.INTEGER.identity(true)) // ID column with auto-increment
	            .column(place, SQLDataType.VARCHAR(255)) // STATE column
	            .column(address, SQLDataType.VARCHAR(255)) // ADDRESS column
	            .constraints(DSL.constraint("PK_" + station).primaryKey(id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + station + " created successfully!");

	    // Creates the "SCHEDULE" table if it does not already exist
	    create.createTableIfNotExists(timetable)
	            .column(time, SQLDataType.TIME) // TIME column
	            .constraints(DSL.constraint("PK_" + timetable).primaryKey(time) // Set a primary key
	            ).execute();
	    System.out.println("Table " + timetable + " created successfully!");
	    
	    // Creates the "STATUS" table if it does not already exist
	    create.createTableIfNotExists(state)
	            .column(description, SQLDataType.VARCHAR(20)) // STATUS DESCRIPTION column
	            .constraints(DSL.constraint("PK_" + state).primaryKey(description) // Set a primary key
	            ).execute();
	    System.out.println("Table " + state + " created successfully!");
	    
	    // Creates the "DRIVER" table if it does not already exist
	    create.createTableIfNotExists(driver)
	            .column(id, SQLDataType.INTEGER.identity(true)) // ID column with auto-increment
	            .column(surname, SQLDataType.VARCHAR(255)) // SURNAME column
	            .column(name, SQLDataType.VARCHAR(255)) // NAME column
	            .column(fiscal_code, SQLDataType.VARCHAR(255)) // FISCAL CODE column
	            .column(address, SQLDataType.VARCHAR(255)) // ADDRESS column
	            .column(town, SQLDataType.VARCHAR(255)) // MUNICIPALITY column
	            .column(province, SQLDataType.VARCHAR(255)) // PROVINCE column
	            .column(CAP, SQLDataType.INTEGER) // POSTAL CODE (CAP) column
	            .column(date_of_birth, SQLDataType.DATE) // DATE OF BIRTH column
	            .column(place_of_birth, SQLDataType.VARCHAR(255)) // PLACE OF BIRTH column
	            .constraints(DSL.constraint("PK_" + driver).primaryKey(id) // Set a primary key
	            ).execute();
	    System.out.println("Table " + driver + " created successfully!");
	}

	/**
	 * function that starts the creation of the tables
	 * @param args
	 */
	public static void main(String[] args) {
	    try (Connection conn = DriverManager.getConnection(CreateDB.DB_URL_PUBLIC_TRANSPORTATION)) {
	        // Create a jOOQ DSL context
	        DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
	        System.out.println("Creating tables in the database: " + CreateDB.DB_URL_PUBLIC_TRANSPORTATION + " ...");
	        create(create);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
