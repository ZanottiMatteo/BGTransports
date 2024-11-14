package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class CreateTables_mezziPubblici {

	static String autobus = "AUTOBUS";
	static String funicolare = "FUNICOLARE";
	static String treno = "TRENO";
	static String tram = "TRAM";

	public static void create(DSLContext create) {
		// Crea la tabella "AUTOBUS" se non esiste già
		create.createTableIfNotExists(autobus).column("ID", SQLDataType.INTEGER.identity(true)) // Colonna ID con
																								// auto-incremento
				.column("NOME", SQLDataType.VARCHAR(255).nullable(false)) // Colonna NOME
				.column("EMAIL", SQLDataType.VARCHAR(255)) // Colonna EMAIL
				.column("TELEFONO", SQLDataType.VARCHAR(20)) // Colonna TELEFONO
				.constraints(DSL.constraint("PK_" + autobus).primaryKey("ID") // Imposta una chiave primaria
				).execute();

		System.out.println("Tabella " + autobus + " creata con successo!");

		// Crea la tabella "FUNICOLARE" se non esiste già
		create.createTableIfNotExists(funicolare).column("ID", SQLDataType.INTEGER.identity(true)) // Colonna ID con
																									// auto-incremento
				.column("NOME", SQLDataType.VARCHAR(255).nullable(false)) // Colonna NOME
				.column("EMAIL", SQLDataType.VARCHAR(255)) // Colonna EMAIL
				.column("TELEFONO", SQLDataType.VARCHAR(20)) // Colonna TELEFONO
				.constraints(DSL.constraint("PK_" + funicolare).primaryKey("ID") // Imposta una chiave primaria
				).execute();

		System.out.println("Tabella " + funicolare + " creata con successo!");

		// Crea la tabella "TRENO" se non esiste già
		create.createTableIfNotExists(treno).column("ID", SQLDataType.INTEGER.identity(true)) // Colonna ID con
																								// auto-incremento
				.column("NOME", SQLDataType.VARCHAR(255).nullable(false)) // Colonna NOME
				.column("EMAIL", SQLDataType.VARCHAR(255)) // Colonna EMAIL
				.column("TELEFONO", SQLDataType.VARCHAR(20)) // Colonna TELEFONO
				.constraints(DSL.constraint("PK_" + treno).primaryKey("ID") // Imposta una chiave primaria
				).execute();

		System.out.println("Tabella " + treno + " creata con successo!");

		// Crea la tabella "TRAM" se non esiste già
		create.createTableIfNotExists(tram).column("ID", SQLDataType.INTEGER.identity(true)) // Colonna ID con
																								// auto-incremento
				.column("NOME", SQLDataType.VARCHAR(255).nullable(false)) // Colonna NOME
				.column("EMAIL", SQLDataType.VARCHAR(255)) // Colonna EMAIL
				.column("TELEFONO", SQLDataType.VARCHAR(20)) // Colonna TELEFONO
				.constraints(DSL.constraint("PK_" + tram).primaryKey("ID") // Imposta una chiave primaria
				).execute();

		System.out.println("Tabella " + tram + " creata con successo!");
	}

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(CreateDB.DB_URL_MEZZI_PUBBLICI)) {
			// Crea un contesto DSL jOOQ
			DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
			create(create);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
