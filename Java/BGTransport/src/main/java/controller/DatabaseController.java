package controller;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.Table;

import model.Utility;

public class DatabaseController {
	
	/*public void showDatabase(String database, String query) throws SQLException {

		Connection conn = (Connection) Utility.dslContext(database);

		JTable table = executeQuery(conn, query);

		if (table != null) {
			JScrollPane scrollPane = new JScrollPane(table);
			databaseLabel.add(scrollPane, BorderLayout.CENTER);
		} else {
			databaseLabel.add(new JLabel("Nessun dato trovato."), BorderLayout.CENTER);
		}

		databaseLabel.setVisible(true);

		conn.close();

	}*/

	/*public static JTable executeQuery(DSLContext context, Table<?> table) throws SQLException {
		JTable tableComponent = null;

        try {
            // Esegui la query
            Result<Record> result = context.selectFrom(table).fetch();

            // Ottieni i nomi delle colonne
            List<String> columnNames = result.fieldsRow().fieldNames();

            // Ottieni i dati
            Object[][] data = new Object[result.size()][columnNames.size()];
            for (int i = 0; i < result.size(); i++) {
                Record record = result.get(i);
                for (int j = 0; j < columnNames.size(); j++) {
                    data[i][j] = record.get(j);
                }
            }

            // Crea la JTable
            tableComponent = new JTable(data, columnNames.toArray());

        } catch (Exception e) {
            System.out.println("Errore durante il recupero dei dati: " + e.getMessage());
        }

        return tableComponent;
    }*/
}
