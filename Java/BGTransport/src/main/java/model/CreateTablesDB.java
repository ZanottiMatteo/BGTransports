package model;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class CreateTablesDB {

	public static void createTablesPublicTransportation(DSLContext create) {
		// Creates the "PULLMAN TIMETABLE" table if it does not already exist
		create.createTableIfNotExists(Constant.pullmanTimetable)
				.column(Constant.id, SQLDataType.INTEGER) 
				.column(Constant.companyName, SQLDataType.VARCHAR(255)) 
				.column(Constant.line, SQLDataType.VARCHAR(255)) 
				.column(Constant.departurePullmanStop, SQLDataType.VARCHAR(255)) 
				.column(Constant.departureTime, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrivalPullmanStop, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrivalTime, SQLDataType.VARCHAR(255))
				.column(Constant.nextStop, SQLDataType.VARCHAR(255)) 
				.column(Constant.timeStop, SQLDataType.VARCHAR(255)) 
				.column(Constant.type, SQLDataType.VARCHAR(255))
				.constraints(DSL.constraint("PK_" + Constant.pullmanTimetable).primaryKey(Constant.id) 
				).execute();
		System.out.println("Table " + Constant.pullmanTimetable + " created successfully!");

		// Creates the "FUNICULAR TIMETABLE" table if it does not already exist
		create.createTableIfNotExists(Constant.funicularTimetable)
				.column(Constant.id, SQLDataType.INTEGER) 
				.column(Constant.companyName, SQLDataType.VARCHAR(255)) 
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.departureFunicularStation, SQLDataType.VARCHAR(255)) 
				.column(Constant.departureTime, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrivalFunicularStation, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrivalTime, SQLDataType.VARCHAR(255)) 
				.column(Constant.type, SQLDataType.VARCHAR(255)) 
				.column(Constant.numberOfSeats, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.funicularTimetable).primaryKey(Constant.id) 
				).execute();
		System.out.println("Table " + Constant.funicularTimetable + " created successfully!");

		// Creates the "TRAIN TIMETABLE" table if it does not already exist
		create.createTableIfNotExists(Constant.trainTimetable)
				.column(Constant.id, SQLDataType.INTEGER) 
				.column(Constant.companyName, SQLDataType.VARCHAR(255)) 
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.departureTrainStation, SQLDataType.VARCHAR(255)) 
				.column(Constant.departureTime, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrivalTrainStation, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrivalTime, SQLDataType.VARCHAR(255)) 
				.column(Constant.nextStop, SQLDataType.VARCHAR(255)) 
				.column(Constant.timeStop, SQLDataType.VARCHAR(255))
				.constraints(DSL.constraint("PK_" + Constant.trainTimetable).primaryKey(Constant.id)
				).execute();
		System.out.println("Table " + Constant.trainTimetable + " created successfully!");

		// Creates the "TRAM TIMETABLE" table if it does not already exist
		create.createTableIfNotExists(Constant.tramTimetable)
				.column(Constant.id, SQLDataType.INTEGER) 
				.column(Constant.companyName, SQLDataType.VARCHAR(255)) 
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.departureTramStation, SQLDataType.VARCHAR(255)) 
				.column(Constant.departureTime, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrivalTramStation, SQLDataType.VARCHAR(255)) 
				.column(Constant.arrivalTime, SQLDataType.VARCHAR(255)) 
				.column(Constant.nextStop, SQLDataType.VARCHAR(255)) 
				.column(Constant.timeStop, SQLDataType.VARCHAR(255)) 
				.column(Constant.type, SQLDataType.VARCHAR(255)) 
				.column(Constant.numberOfSeats, SQLDataType.VARCHAR(255)) 
				.column(Constant.numberOfCarriages, SQLDataType.VARCHAR(255))
				.constraints(DSL.constraint("PK_" + Constant.tramTimetable).primaryKey(Constant.id) 
				).execute();
		System.out.println("Table " + Constant.tramTimetable + " created successfully!");

		// Creates the "COMPANY" table if it does not already exist
		create.createTableIfNotExists(Constant.company)
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.legalStructure, SQLDataType.VARCHAR(255)) 
				.column(Constant.businessTaxCode, SQLDataType.VARCHAR(255)) // BUSINESS TAX CODE column
				.column(Constant.companyRegistrationNumber, SQLDataType.VARCHAR(255)) // COMPANY REGISTRATION column
				.column(Constant.incorporationDate, SQLDataType.VARCHAR(255)) // INCORPORATION DATE column
				.column(Constant.legalRepresentative, SQLDataType.VARCHAR(255)) // LEGAL REPRESENTATIVE column
				.column(Constant.numberOfEmployees, SQLDataType.VARCHAR(255)) // NUMBER OF EMPLOYEES column
				.column(Constant.atecoCode, SQLDataType.VARCHAR(255)) // ATECO CODE column
				.column(Constant.registeredOffice, SQLDataType.VARCHAR(255)) // REGISTERED OFFICE column
				.column(Constant.province, SQLDataType.VARCHAR(255)) // PROVINCE column
				.column(Constant.CAP, SQLDataType.VARCHAR(255)) // POSTAL CODE (CAP) column
				.column(Constant.address, SQLDataType.VARCHAR(255)) // ADDRESS column
				.column(Constant.streetNumber, SQLDataType.VARCHAR(255)) // STREET NUMBER column
				.column(Constant.telephone, SQLDataType.VARCHAR(255)) // TELEPHONE column
				.column(Constant.mail, SQLDataType.VARCHAR(255)) // MAIL column
				.column(Constant.social, SQLDataType.VARCHAR(255)) // SOCIAL NETWORK column
				.column(Constant.webSite, SQLDataType.VARCHAR(255)) // WEB SITE column
				.constraints(DSL.constraint("PK_" + Constant.company).primaryKey(Constant.name)
				).execute();
		System.out.println("Table " + Constant.company + " created successfully!");

		// Creates the "PULLMAN STOP" table if it does not already exist
		create.createTableIfNotExists(Constant.pullmanStop)
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.town, SQLDataType.VARCHAR(255)) 
				.column(Constant.province, SQLDataType.VARCHAR(255))
				.column(Constant.latitude, SQLDataType.VARCHAR(255)) 
				.column(Constant.longitude, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.pullmanStop).primaryKey(Constant.name) 
				).execute();
		System.out.println("Table " + Constant.pullmanStop + " created successfully!");

		// Creates the "TRAM STOP" table if it does not already exist
		create.createTableIfNotExists(Constant.tramStop)
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.address, SQLDataType.VARCHAR(255)) 
				.column(Constant.town, SQLDataType.VARCHAR(255)) 
				.column(Constant.province, SQLDataType.VARCHAR(255)) 
				.column(Constant.latitude, SQLDataType.VARCHAR(255)) 
				.column(Constant.longitude, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.tramStop).primaryKey(Constant.name) 
				).execute();
		System.out.println("Table " + Constant.tramStop + " created successfully!");

		// Creates the "FUNICULAR STATION" table if it does not already exist
		create.createTableIfNotExists(Constant.funicularStation)
				.column(Constant.name, SQLDataType.VARCHAR(255))
				.column(Constant.address, SQLDataType.VARCHAR(255)) 
				.column(Constant.town, SQLDataType.VARCHAR(255)) 
				.column(Constant.province, SQLDataType.VARCHAR(255)) 
				.column(Constant.latitude, SQLDataType.VARCHAR(255)) 
				.column(Constant.longitude, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.funicularStation).primaryKey(Constant.name) 
				).execute();
		System.out.println("Table " + Constant.funicularStation + " created successfully!");

		// Creates the "TRAIN STATION" table if it does not already exist
		create.createTableIfNotExists(Constant.trainStation)
				.column(Constant.name, SQLDataType.VARCHAR(255)) 
				.column(Constant.address, SQLDataType.VARCHAR(255)) 
				.column(Constant.town, SQLDataType.VARCHAR(255)) 
				.column(Constant.province, SQLDataType.VARCHAR(255))
				.column(Constant.latitude, SQLDataType.VARCHAR(255)) 
				.column(Constant.longitude, SQLDataType.VARCHAR(255)) 
				.constraints(DSL.constraint("PK_" + Constant.trainStation).primaryKey(Constant.name) 
				).execute();
		System.out.println("Table " + Constant.trainStation + " created successfully!");
	}

	public static void createTablesUsers(DSLContext create) {
		// Creates the "USER" table if it does not already exist
		create.createTableIfNotExists(Constant.user)
				.column(Constant.username, SQLDataType.VARCHAR(100))
				.column(Constant.name, SQLDataType.VARCHAR(100)) 
				.column(Constant.surname, SQLDataType.VARCHAR(100))
				.column(Constant.dateOfBirth, SQLDataType.VARCHAR(20)) 
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
