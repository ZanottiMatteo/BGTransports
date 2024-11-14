package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class CreateTables_Users {

	static String id = "ID";
	static String user = "USER";
	static String registered_user = "REGISTERED USER";
	static String manager = "MANAGER";
	static String developer = "DEVELOPER";
	static String name = "NAME";
	static String surname = "SURNAME";
	static String fiscal_code = "FISCAL CODE";
	static String place_of_birth = "PLACE OF BIRTH";
	static String date_of_birth = "DATE OF BIRTH";
	static String CAP = "CAP";
	static String town = "TOWN";
	static String province = "PROVINCE";
	static String street_number = "STREET NUMBER";
	static String address = "ADDRESS";
	static String password = "PASSWORD";
	static String telephone = "TELEPHONE";
	static String mail = "MAIL";
	static String social = "SOCIAL";
	static String web_site = "WEB SITE";
	
	/**
	 * function that creates all the tables for the database Users
	 * @param create = DSL.using(conn, SQLDialect.SQLITE);
	 */
	public static void create(DSLContext create) {
	    // Creates the "USER" table if it does not already exist
	    create.createTableIfNotExists(user)
	            .column(surname, SQLDataType.VARCHAR(100)) // SURNAME column
	            .column(name, SQLDataType.VARCHAR(100).nullable(false)) // NAME column
	            .column(fiscal_code, SQLDataType.VARCHAR(50).nullable(false)) // FISCAL CODE column
	            .column(date_of_birth, SQLDataType.DATE.nullable(false)) // DATE OF BIRTH column
	            .column(place_of_birth, SQLDataType.VARCHAR(50).nullable(false)) // PLACE OF BIRTH column
	            .column(CAP, SQLDataType.INTEGER.nullable(false)) // POSTAL CODE (CAP) column
	            .column(town, SQLDataType.VARCHAR(50).nullable(false)) // MUNICIPALITY column
	            .column(province, SQLDataType.VARCHAR(4).nullable(false)) // PROVINCE column
	            .column(street_number, SQLDataType.VARCHAR(50).nullable(false)) // STREET NUMBER column
	            .column(address, SQLDataType.VARCHAR(50).nullable(false)) // ADDRESS column
	            .column(password, SQLDataType.VARCHAR(50).nullable(false)) // PASSWORD column
	            .column(registered_user, SQLDataType.BOOLEAN) // REGISTERED USER column
	            .column(manager, SQLDataType.BOOLEAN) // MANAGER column
	            .column(developer, SQLDataType.BOOLEAN) // DEVELOPER column
	            .column(telephone, SQLDataType.INTEGER.nullable(false)) // TELEPHONE column
	            .column(mail, SQLDataType.VARCHAR(100).nullable(false)) // MAIL column
	            .column(social, SQLDataType.VARCHAR(100)) // SOCIAL NETWORK column
	            .column(web_site, SQLDataType.VARCHAR(100)) // WEB SITE column
	            .constraints(DSL.constraint("PK_" + user).primaryKey(surname) // Set a primary key
	            ).execute();
	    System.out.println("Table " + user + " created successfully!");
	}

	/**
	 * function that starts the creation of the tables
	 * @param args
	 */
	public static void main(String[] args) {
	    try (Connection conn = DriverManager.getConnection(CreateDB.DB_URL_USERS)) {
	        // Create a jOOQ DSL context
	        DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
	        System.out.println("Creating tables in the database: " + CreateDB.DB_URL_USERS + " ...");
	        create(create);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
