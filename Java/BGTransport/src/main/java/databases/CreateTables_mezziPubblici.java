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
	static String stazione = "STAZIONE";
	static String orario = "ORARIO";
	static String targa = "TARGA";
	static String id = "ID";
	static String autista = "AUTISTA";
	static String stato = "STATO";
	static String numero_posti = "NUMERO_POSTI";
	static String numero_vagoni = "NUMERO_VAGONI";
	static String indirizzo = "INDIRIZZO";
	static String luogo = "LUOGO";
	static String ora = "ORA";
	static String stazione_partenza = "STAZIONE PARTENZA";
	static String stazione_arrivo = "STAZIONE ARRIVO";
	static String orario_partenza = "ORARIO_PARTENZA";
	static String orario_arrivo = "ORARIO_ARRIVO";
	static String descrizione = "DESCRIZIONE";
	static String nome = "NOME";
	static String cognome = "COGNOME";
	static String codice_fiscale = "CODICE FISCALE";
	static String luogo_di_nascita = "LUOGO DI NASCITA";
	static String data_di_nascita = "DATA DI NASCITA";
	static String CAP = "CAP";
	static String comune = "COMUNE";
	static String provincia = "PROVINCIA";
	

	public static void create(DSLContext create) {
		// Crea la tabella "PULLMAN" se non esiste già
		create.createTableIfNotExists(pullman)
				.column(id, SQLDataType.INTEGER.identity(true)) // Colonna ID con auto-incremento																
				.column(targa, SQLDataType.VARCHAR(255).nullable(false)) // Colonna TARGA
				.column(autista, SQLDataType.VARCHAR(255)) // Colonna AUTISTA
				.column(stato, SQLDataType.VARCHAR(255)) // Colonna STATO
				.column(numero_posti, SQLDataType.INTEGER) // Colonna NUMERO_POSTI
				.column(stazione_partenza, SQLDataType.INTEGER) // Colonna che identifica la STAZIONE PARTENZA
				.column(stazione_arrivo, SQLDataType.INTEGER) // Colonna che identifica la STAZIONE ARRIVO
				.column(orario_partenza, SQLDataType.TIME) //Colonna ORARIO PARTENZA dalla stazione
				.column(orario_arrivo, SQLDataType.TIME) //Colonna ORARIO ARRIVO alla stazione
				.constraints(DSL.constraint("PK_" + pullman).primaryKey(id) // Imposta una chiave primaria
				).execute();
		System.out.println("Tabella " + pullman + " creata con successo!");

		// Crea la tabella "FUNICOLARE" se non esiste già
		create.createTableIfNotExists(funicolare)
				.column(id, SQLDataType.INTEGER.identity(true)) // Colonna ID con auto-incremento																			
				.column(autista, SQLDataType.VARCHAR(255)) // Colonna AUTISTA
				.column(stato, SQLDataType.VARCHAR(255)) // Colonna STATO
				.column(numero_posti, SQLDataType.INTEGER) // Colonna NUMERO_POSTI
				.column(stazione_partenza, SQLDataType.INTEGER) // Colonna che identifica la STAZIONE PARTENZA
				.column(stazione_arrivo, SQLDataType.INTEGER) // Colonna che identifica la STAZIONE ARRIVO
				.column(orario_partenza, SQLDataType.TIME) //Colonna ORARIO PARTENZA dalla stazione
				.column(orario_arrivo, SQLDataType.TIME) //Colonna ORARIO ARRIVO alla stazione
				.constraints(DSL.constraint("PK_" + funicolare).primaryKey(id) // Imposta una chiave primaria
				).execute();
		System.out.println("Tabella " + funicolare + " creata con successo!");

		// Crea la tabella "TRENO" se non esiste già
		create.createTableIfNotExists(treno)
				.column(id, SQLDataType.INTEGER.identity(true)) // Colonna ID con auto-incremento
				.column(autista, SQLDataType.VARCHAR(255)) // Colonna AUTISTA
				.column(stato, SQLDataType.VARCHAR(255)) // Colonna STATO
				.column(numero_posti, SQLDataType.INTEGER) // Colonna NUMERO_POSTI
				.column(numero_vagoni, SQLDataType.INTEGER) // Colonna NUMERO_VAGONI
				.column(stazione_partenza, SQLDataType.INTEGER) // Colonna che identifica la STAZIONE PARTENZA
				.column(stazione_arrivo, SQLDataType.INTEGER) // Colonna che identifica la STAZIONE ARRIVO 
				.column(orario_partenza, SQLDataType.TIME) //Colonna ORARIO PARTENZA dalla stazione
				.column(orario_arrivo, SQLDataType.TIME) //Colonna ORARIO ARRIVO alla stazione
				.constraints(DSL.constraint("PK_" + treno).primaryKey(id) // Imposta una chiave primaria
				).execute();
		System.out.println("Tabella " + treno + " creata con successo!");

		// Crea la tabella "TRAM" se non esiste già
		create.createTableIfNotExists(tram)
				.column(id, SQLDataType.INTEGER.identity(true)) // Colonna ID con auto-incremento																			
				.column(autista, SQLDataType.VARCHAR(255)) // Colonna AUTISTA
				.column(stato, SQLDataType.VARCHAR(255)) // Colonna STATO
				.column(numero_posti, SQLDataType.INTEGER) // Colonna NUMERO_POSTI
				.column(numero_vagoni, SQLDataType.INTEGER) // Colonna NUMERO_VAGONI
				.column(stazione_partenza, SQLDataType.INTEGER) // Colonna che identifica la STAZIONE PARTENZA
				.column(stazione_arrivo, SQLDataType.INTEGER) // Colonna che identifica la STAZIONE ARRIVO 
				.column(orario_partenza, SQLDataType.TIME) //Colonna ORARIO PARTENZA dalla stazione
				.column(orario_arrivo, SQLDataType.TIME) //Colonna ORARIO ARRIVO alla stazione
				.constraints(DSL.constraint("PK_" + tram).primaryKey(id) // Imposta una chiave primaria
				).execute();
		System.out.println("Tabella " + tram + " creata con successo!");
		
		// Crea la tabella "STAZIONE" se non esiste già
		create.createTableIfNotExists(stazione)
				.column(id, SQLDataType.INTEGER.identity(true)) // Colonna ID con auto-incremento	
				.column(luogo, SQLDataType.VARCHAR(255)) // Colonna STATO
				.column(indirizzo, SQLDataType.VARCHAR(255)) // Colonna INDIRIZZO
				.constraints(DSL.constraint("PK_" + stazione).primaryKey(id) // Imposta una chiave primaria
				).execute();
		System.out.println("Tabella " + stazione + " creata con successo!");

		// Crea la tabella "ORARIO" se non esiste già
		create.createTableIfNotExists(orario)
				.column(ora, SQLDataType.TIME) // Colonna ORARI
				.constraints(DSL.constraint("PK_" + orario).primaryKey(ora) // Imposta una chiave primaria
				).execute();
		System.out.println("Tabella " + orario + " creata con successo!");
		
		//Crea la tabella "STATO" se non esiste già
		create.createTableIfNotExists(stato)
				.column(descrizione, SQLDataType.VARCHAR(20)) //Colonna DESCRIZIONE dello STATO
				.constraints(DSL.constraint("PK_" + stato).primaryKey(descrizione) // Imposta una chiave primaria
				).execute();
		System.out.println("Tabella " + stato + " creata con successo!");
		
		//Crea la tabella "AUTISTA" se non esiste già
		create.createTableIfNotExists(autista)
				.column(id, SQLDataType.INTEGER.identity(true)) // Colonna ID con auto-incremento																			
				.column(cognome, SQLDataType.VARCHAR(255)) // Colonna COGNOME
				.column(nome, SQLDataType.VARCHAR(255)) // Colonna NOME
				.column(codice_fiscale, SQLDataType.VARCHAR(255)) // Colonna CODICE FISCALE
				.column(indirizzo, SQLDataType.VARCHAR(255)) // Colonna INDIRIZZO
				.column(comune, SQLDataType.VARCHAR(255)) // Colonna COMUNE 
				.column(provincia, SQLDataType.VARCHAR(255)) // Colonna PROVINCIA
				.column(CAP, SQLDataType.INTEGER) // Colonna CAP
				.column(data_di_nascita, SQLDataType.DATE) // Colonna DATA DI NASCITA
				.column(luogo_di_nascita, SQLDataType.VARCHAR(255)) // Colonna LUOGO DI NASCITA
				.constraints(DSL.constraint("PK_" + autista).primaryKey(id) // Imposta una chiave primaria
				).execute();
		System.out.println("Tabella " + autista + " creata con successo!");
	}

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(CreateDB.DB_URL_MEZZI_PUBBLICI)) {
			// Crea un contesto DSL jOOQ
			DSLContext create = DSL.using(conn, SQLDialect.SQLITE);
			System.out.println("Creazione tabelle nel database: " + CreateDB.DB_URL_MEZZI_PUBBLICI + " ...");
			create(create);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
