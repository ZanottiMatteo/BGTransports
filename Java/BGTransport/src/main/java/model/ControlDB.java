package model;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ControlDB {

	public static void control(String json, String excel) throws Exception {
		File jsonFile = new File(json);
		if (!jsonFile.exists()) {
			System.out.println("Creazione file JSON: " + json);
			List<Map<String, String>> list = CreateJSONFile.readExcelFile(excel);
			CreateJSONFile.writeJsonToFile(list, json);
		}
		else if(jsonFile.exists()) {
			System.out.println("Controllo se il file JSON " + json + " e' aggiornato");
			List<Map<String, String>> excelData = CreateJSONFile.readExcelFile(excel);
			
			ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonData = new HashMap<>();
            objectMapper.readValue(jsonFile, Map.class);
            
            if (!excelData.equals(jsonData)) {
                // 4. Aggiorna il JSON se i dati sono cambiati
                objectMapper.writeValue(jsonFile, excelData);
                System.out.println("File JSON aggiornato con i dati dall'Excel.");
            } else {
                System.out.println("Il file JSON è già aggiornato.");
            }
		}
	}
	
	public static DSLContext DSLContext(String database) throws SQLException {
		Connection connection = DriverManager.getConnection(database);
		DSLContext create = DSL.using(connection, SQLDialect.SQLITE);
		return create;
	}
}
