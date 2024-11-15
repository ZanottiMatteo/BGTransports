package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class CreateTables_Users {
	
	/**
	 * function that creates all the tables for the database Users
	 * @param create = DSL.using(conn, SQLDialect.SQLITE);
	 */
	public static void create(DSLContext create) {
	    // Creates the "USER" table if it does not already exist
	    create.createTableIfNotExists(utility.Constant.user)
	            .column(utility.Constant.surname, SQLDataType.VARCHAR(100)) // SURNAME column
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
	            .constraints(DSL.constraint("PK_" + utility.Constant.user).primaryKey(utility.Constant.surname) // Set a primary key
	            ).execute();
	    System.out.println("Table " + utility.Constant.user + " created successfully!");
	}

	/**
	 * function that starts the creation of the tables
	 * @param args
	 */
	public static void main(String[] args) {
	    try (Connection conn = DriverManager.getConnection(utility.Constant.DB_URL_USERS)) {
	        // Create a jOOQ DSL context
	        DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
	        System.out.println("Creating tables in the database: " + utility.Constant.DB_URL_USERS + " ...");
	        create(create);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
