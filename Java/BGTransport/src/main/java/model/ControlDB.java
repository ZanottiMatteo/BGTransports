package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.impl.DSL;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import view.DownloadDataDB;

public class ControlDB {

	static ArrayList<String> myList = new ArrayList<>();
	public static int totalRecordCount = 0;

	public static void controlJSON(String json, String excel) throws Exception {
		File jsonFile = new File(json);

		if (!jsonFile.exists()) {
			System.out.println("File JSON creation: " + json);
			List<Map<String, String>> list = CreateJSONFile.readExcelFile(excel);
			CreateJSONFile.writeJsonToFile(list, json);
			Constant.update = true;
			myList.add(json);
		} else {
			System.out.println("Check if file JSON is up-to-date: " + json);
			List<Map<String, String>> excelData = CreateJSONFile.readExcelFile(excel);

			ObjectMapper objectMapper = new ObjectMapper();
			List<Map<String, Object>> jsonData = objectMapper.readValue(jsonFile,
					new TypeReference<List<Map<String, Object>>>() {
					});

			if (!excelData.equals(jsonData)) {
				objectMapper.writeValue(jsonFile, excelData);
				Constant.update = true;
				System.out.println("File JSON is up-to-date: " + json);
				myList.add(json);

			} else {
				System.out.println("File JSON is already up-to-date: " + json);
			}
		}
	}

	public static void DBcheck(String databasePath, String database, String jooq, String src) throws Exception {
		File dbFile = new File(databasePath);
		if (!dbFile.exists()) {
			System.out.println("Database creation: " + database);
			CreateDB.createDatabase(database);

			System.out.println("Creating tables in the database: " + database + " ...");
			DSLContext create = Utility.DSLContext(database);

			if (databasePath == Constant.DBPublicTransportation) {
				CreateTablesDB.createTablesPublicTransportation(create);
			} else {
				CreateTablesDB.createTablesUsers(create);
			}
			GenerateCode.generateCode(database, Constant.JDBC, Constant.SQLiteDatabase, jooq, src);
		} else {
			System.out.println("Database already exists: " + database);
		}
	}

	public static void DBupdate(Boolean update, String database) throws IOException, SQLException {
		if (Constant.update) {
			System.out.println("Database update: " + database);
			DSLContext create = Utility.DSLContext(database);
			QueryDB.deleteAll(create, myList);
			Constant.update = false;
		}
	}

	public static void DBNotEmpty(String databasePath, String database) throws Exception {
	    DSLContext create = Utility.DSLContext(database);
	    Result<Record1<String>> tables = create.select(DSL.field("name", String.class))
	                                           .from("sqlite_master")
	                                           .where(DSL.field("type").eq("table"))
	                                           .and(DSL.field("name").notLike("sqlite_%"))
	                                           .fetch();

	    List<String> tableNames = tables.stream().map(Record1::value1).collect(Collectors.toList());
	    
	    // Calcolo totale dei record da inserire
	    int totalRecordCount = Utility.sumNumberOfRecords(tableNames);
	    
	    DownloadDataDB db = new DownloadDataDB(totalRecordCount);
	    db.setVisible(true);

	    int progress = 0;
	    
	    final String[] currentTableName = {""};
	    
	    Timer timer = new Timer(500, new ActionListener() {
	        private int dotCount = 0;

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            dotCount = (dotCount + 1) % 4; // Cicla tra 0, 1, 2, 3
	            String dots = ".".repeat(dotCount);
	            SwingUtilities.invokeLater(() -> 
	                db.lblNewLabel.setText("Processing table: " + currentTableName[0] + dots)
	            );
	        }
	    });
	    timer.start();

	    for (Record1<String> table : tables) {
	        String tableName = table.value1();
	        System.out.println("Check table: " + tableName);
	        
	        currentTableName[0] = tableName;

	        int count = create.fetchCount(DSL.table(DSL.name(tableName)));

	        if (count == 0) {
	            System.out.println(tableName + " is empty");
	            System.out.println("Insert in table " + tableName);

	            if (tableName.equals(Constant.company)) {
	                progress += InsertDataDB.company(create);
	            } else if (tableName.equals(Constant.funicularStation)) {
	                progress += InsertDataDB.funicular_station(create);
	            } else if (tableName.equals(Constant.trainStation)) {
	                progress += InsertDataDB.train_station(create);
	            } else if (tableName.equals(Constant.tramStop)) {
	                progress += InsertDataDB.tram_stop(create);
	            } else if (tableName.equals(Constant.pullmanStop)) {
	                progress += InsertDataDB.pullman_stop(create);
	            } else if (tableName.equals(Constant.funicularTimetable)) {
	                progress += InsertDataDB.funicularTimetable(create);
	            } else if (tableName.equals(Constant.tramTimetable)) {
	                progress += InsertDataDB.tramTimetable(create);
	            } else if (tableName.equals(Constant.trainTimetable)) {
	                progress += InsertDataDB.trainTimetable(create);
	            } else if (tableName.equals(Constant.pullmanTimetable)) {
	                progress += InsertDataDB.pullmanTimetable(create);
	            }

	            db.updateProgress(progress);
	        } else {
	            System.out.println(tableName + " has records");
	        }
	    }
	    SwingUtilities.invokeLater(() -> {
	        db.labelDownloadDataDatabases.setText("Download Complete");
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        db.dispose();
	    });
	}
}
