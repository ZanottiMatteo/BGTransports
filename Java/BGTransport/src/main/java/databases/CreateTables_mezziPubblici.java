package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

public class CreateTables_mezziPubblici {

	static String pullman = "PULLMAN";
	static String funicolare = "FUNICOLARE";
	static String treno = "TRENO";
	static String tram = "TRAM";
	static String targa = "TARGA";
	static String id = "ID";
	static String autista = "AUTISTA";
	static String stato = "STATO";
	static String numero_posti = "NUMERO_POSTI";
	static String numero_vagoni = "NUMERO_VAGONI";

	public static void create(DSLContext create) {
		// Crea la tabella "PULLMAN" se non esiste già
		create.createTableIfNotExists(pullman).column(id, SQLDataType.INTEGER.identity(true)) // Colonna ID con auto-incremento																
				.column(targa, SQLDataType.VARCHAR(255).nullable(false)) // Colonna TARGA
				.column(autista, SQLDataType.VARCHAR(255)) // Colonna AUTISTA
				.column(stato, SQLDataType.VARCHAR(255)) // Colonna STATO
				.column(numero_posti, SQLDataType.INTEGER) // Colonna NUMERO_POSTI
				.constraints(DSL.constraint("PK_" + pullman).primaryKey(id) // Imposta una chiave primaria
				).execute();

		System.out.println("Tabella " + pullman + " creata con successo!");

		// Crea la tabella "FUNICOLARE" se non esiste già
		create.createTableIfNotExists(funicolare).column(id, SQLDataType.INTEGER.identity(true)) // Colonna ID con
																									// auto-incremento
				.column(autista, SQLDataType.VARCHAR(255)) // Colonna AUTISTA
				.column(stato, SQLDataType.VARCHAR(255)) // Colonna STATO
				.column(numero_posti, SQLDataType.INTEGER) // Colonna NUMERO_POSTI
				.constraints(DSL.constraint("PK_" + funicolare).primaryKey(id) // Imposta una chiave primaria
				).execute();

		System.out.println("Tabella " + funicolare + " creata con successo!");

		// Crea la tabella "TRENO" se non esiste già
		create.createTableIfNotExists(treno).column(id, SQLDataType.INTEGER.identity(true)) // Colonna ID con auto-incremento
				.column(autista, SQLDataType.VARCHAR(255)) // Colonna AUTISTA
				.column(stato, SQLDataType.VARCHAR(255)) // Colonna STATO
				.column(numero_posti, SQLDataType.INTEGER) // Colonna NUMERO_POSTI
				.column(numero_vagoni, SQLDataType.INTEGER) // Colonna NUMERO_VAGONI
				.constraints(DSL.constraint("PK_" + treno).primaryKey(id) // Imposta una chiave primaria
				).execute();

		System.out.println("Tabella " + treno + " creata con successo!");

		// Crea la tabella "TRAM" se non esiste già
		create.createTableIfNotExists(tram).column(id, SQLDataType.INTEGER.identity(true)) // Colonna ID con auto-incremento																			
				.column(autista, SQLDataType.VARCHAR(255)) // Colonna AUTISTA
				.column(stato, SQLDataType.VARCHAR(255)) // Colonna STATO
				.column(numero_posti, SQLDataType.INTEGER) // Colonna NUMERO_POSTI
				.column(numero_vagoni, SQLDataType.INTEGER) // Colonna NUMERO_VAGONI
				.constraints(DSL.constraint("PK_" + tram).primaryKey(id) // Imposta una chiave primaria
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
