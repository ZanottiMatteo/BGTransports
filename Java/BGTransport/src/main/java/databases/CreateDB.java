package databases;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateDB {

	// questo è il percordo relativo del file che contiene il DB
	public static String DB_MEZZI_PUBBLICI = "db/mezziPubblici.db3";
	public static String DB_URL_MEZZI_PUBBLICI = "jdbc:sqlite:" + DB_MEZZI_PUBBLICI;

	public static String DB_UTENTI = "db/utenti.db3";
	public static String DB_URL_UTENTI = "jdbc:sqlite:" + DB_UTENTI;

	static String[] URLS = { DB_URL_MEZZI_PUBBLICI, DB_URL_UTENTI };
	static String[] DBS = { DB_MEZZI_PUBBLICI, DB_UTENTI };

	public static void main(String[] args) throws IOException, SQLException {

		for (int i = 0; i < URLS.length; i++) {
			Connection conn = DriverManager.getConnection(URLS[i]);
			DatabaseMetaData meta = conn.getMetaData();
			System.out.println("The driver name is " + meta.getDriverName());
			System.out.println("A new database has been created: " + URLS[i]);
			// controllo che il file esista a questo punto
			System.out.println("Il database " + DBS[i] + " esiste? " + new File(DBS[i]).exists());
		}
	}
}
