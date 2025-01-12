package bgtransport.model;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.impl.DSL;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The <code>ControlDB</code> class provides various methods for managing and controlling
 * database operations, including checking and updating databases, validating JSON files,
 * and inserting data into tables.
 * <p>
 * This class also handles the creation of databases, updating JSON files with data from
 * Excel files, and inserting data into different tables depending on the database's current state.
 * </p>
 */
public class ControlDB {

    /**
     * A list used to store the names of JSON files that need to be updated.
     */
    protected static ArrayList<String> myList = new ArrayList<>();

    /**
     * A list of table names found in the database.
     */
    protected static List<String> tableNames = new ArrayList<>();

    /**
     * A variable to track the progress of data insertion into tables.
     */
    public static int progress = 0;

    /**
     * An array used to store the name of the currently processed table.
     */
    public static String[] currentTableName = { "" };

    /**
     * Controls the creation and validation of a JSON file by comparing its contents
     * with the corresponding Excel file. If necessary, it updates the JSON file and
     * sets a flag indicating that a database update is needed.
     *
     * @param json   The path to the JSON file.
     * @param excel  The path to the corresponding Excel file.
     * @throws Exception If an error occurs during file reading, writing, or comparison.
     */
    public static void controlJSON(String json, String excel) throws Exception {
        File jsonFile = new File(json);

        if (!jsonFile.exists()) {
            System.out.println("File JSON creation: " + json);
            List<Map<String, String>> list = CreateJSONFile.readExcelFile(excel);
            CreateJSONFile.writeJsonToFile(list, json);
        } else {
            System.out.println("Check if file JSON is up-to-date: " + json);
            List<Map<String, String>> excelData = CreateJSONFile.readExcelFile(excel);

            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> jsonData = objectMapper.readValue(jsonFile,
                    new TypeReference<List<Map<String, Object>>>() {});

            if (!excelData.equals(jsonData)) {
                objectMapper.writeValue(jsonFile, excelData);
                ConstantInt.update = true;
                System.out.println("File JSON need to be updated: " + json);
                myList.add(json);
            } else {
                System.out.println("File JSON is already up-to-date: " + json);
            }
        }
    }

    /**
     * Checks the existence of the specified database file and creates the database
     * if it does not exist. It also creates the corresponding tables and generates
     * the necessary code for database access.
     *
     * @param databasePath The path to the database file.
     * @param database     The name of the database.
     * @param jooq         The name of the JOOQ configuration.
     * @param src          The source path for generated code.
     * @throws Exception If an error occurs during database creation or table generation.
     */
    public static void dbCheck(String databasePath, String database, String jooq, String src) throws Exception {
        File dbFile = new File(databasePath);
        if (!dbFile.exists()) {
            System.out.println("Database creation: " + database);
            CreateDB.createDatabase(database);

            System.out.println("Creating tables in the database: " + database + " ...");
            DSLContext create = Utility.dslContext(database);

            if (databasePath.equals(ConstantDB.DB_PUBLIC_TRANSPORTATION)) {
                CreateTablesDB.createTablesPublicTransportation(create);
            } else {
                CreateTablesDB.createTablesUsers(create);
            }
            GenerateCode.generateCode(database, ConstantDB.JDBC, ConstantDB.SQLITEDATABASE, jooq, src);
        } else {
            System.out.println("Database already exists: " + database);
        }
    }

    /**
     * Updates the database if changes are detected in the associated JSON files.
     * This method deletes all existing data in the tables that are associated with
     * the updated JSON files and flags the update as complete.
     *
     * @param database The name of the database to be updated.
     * @throws IOException If an error occurs during database update.
     * @throws SQLException If an error occurs while accessing the database.
     */
    public static void dbUpdate(String database) throws IOException, SQLException {
        if (Boolean.TRUE.equals(ConstantInt.update)) {
            System.out.println("Database update: " + database);
            DSLContext create = Utility.dslContext(database);
            PublicTransportationQueryDB.deleteAll(create, myList);
            ConstantInt.update = false;
        }
    }

    /**
     * Retrieves the total number of records in the database by counting records
     * in each table and returning the total. If no records are found, it returns -1.
     *
     * @param database The name of the database to check.
     * @return The total number of records in the database, or -1 if no records are found.
     * @throws Exception If an error occurs during the database query.
     */
    public static int totalRecordCount(String database) throws Exception {
        DSLContext create = Utility.dslContext(database);
        Result<Record1<String>> tables = create.select(DSL.field("name", String.class))
                .from("sqlite_master")
                .where(DSL.field("type").eq("table"))
                .and(DSL.field("name").notLike("sqlite_%")).fetch();

        tableNames = tables.stream().map(Record1::value1).toList();

        int totalRecord = 0;

        for (int i = 0; i < tableNames.size(); i++) {
            System.out.println("Check table: " + tableNames.get(i));

            currentTableName[0] = tableNames.get(i);

            int count = create.fetchCount(DSL.table(DSL.name(tableNames.get(i))));

            if (count == 0) {
                System.out.println(tableNames.get(i) + " is empty");
                System.out.println("Insert in table " + tableNames.get(i));

                if (tableNames.get(i).equals(ConstantString1.COMPANY)) {
                    totalRecord += ConstantInt.NUMBER_COMPANY_RECORD;
                } else if (tableNames.get(i).equals(ConstantString1.FUNICULAR_STATION)) {
                    totalRecord += ConstantInt.NUMBER_FUNICULAR_STATION_RECORD;
                } else if (tableNames.get(i).equals(ConstantString2.TRAIN_STATION)) {
                    totalRecord += ConstantInt.NUMBER_TRAIN_STATION_RECORD;
                } else if (tableNames.get(i).equals(ConstantString2.TRAM_STOP)) {
                    totalRecord += ConstantInt.NUMBER_TRAM_STOP_RECORD;
                } else if (tableNames.get(i).equals(ConstantString2.PULLMAN_STOP)) {
                    totalRecord += ConstantInt.NUMBER_PULLMAN_STOP_RECORD;
                } else if (tableNames.get(i).equals(ConstantString1.FUNICULAR_TIMETABLE)) {
                    totalRecord += ConstantInt.NUMBER_FUNICULAR_TIMETABLE_RECORD;
                } else if (tableNames.get(i).equals(ConstantString2.TRAM_TIMETABLE)) {
                    totalRecord += ConstantInt.NUMBER_TRAM_TIMETABLE_RECORD;
                } else if (tableNames.get(i).equals(ConstantString2.TRAIN_TIMETABLE)) {
                    totalRecord += ConstantInt.NUMBER_TRAIN_TIMETABLE_RECORD;
                } else if (tableNames.get(i).equals(ConstantString2.PULLMAN_TIMETABLE)) {
                    totalRecord += ConstantInt.NUMBER_PULLMAN_TIMETABLE_RECORD;
                }
            }
        }
        if (totalRecord == 0) return -1;
        return totalRecord;
    }

    /**
     * Updates the database by inserting data into each table. The progress of
     * data insertion is tracked and updated incrementally.
     *
     * @param database The name of the database to update.
     * @throws IOException If an error occurs during data insertion.
     * @throws SQLException If an error occurs during database operations.
     */
    public static void progressiveTotalCount(String database) throws IOException, SQLException {
        DSLContext create = Utility.dslContext(database);

        Result<Record1<String>> tables = create.select(DSL.field("name", String.class))
                .from("sqlite_master")
                .where(DSL.field("type").eq("table"))
                .and(DSL.field("name").notLike("sqlite_%")).fetch();

        tableNames = tables.stream().map(Record1::value1).toList();

        for (int i = 0; i < tableNames.size(); i++) {
            System.out.println("Check table: " + tableNames.get(i));

            currentTableName[0] = tableNames.get(i);

            int count = create.fetchCount(DSL.table(DSL.name(tableNames.get(i))));

            if (count == 0) {
                System.out.println(tableNames.get(i) + " is empty");
                System.out.println("Insert in table " + tableNames.get(i));

                if (tableNames.get(i).equals(ConstantString1.COMPANY)) {
                    progress += InsertDataDB.company(create);
                } else if (tableNames.get(i).equals(ConstantString1.FUNICULAR_STATION)) {
                    progress += InsertDataDB.funicularStation(create);
                } else if (tableNames.get(i).equals(ConstantString2.TRAIN_STATION)) {
                    progress += InsertDataDB.trainStation(create);
                } else if (tableNames.get(i).equals(ConstantString2.TRAM_STOP)) {
                    progress += InsertDataDB.tramStop(create);
                } else if (tableNames.get(i).equals(ConstantString2.PULLMAN_STOP)) {
                    progress += InsertDataDB.pullmanStop(create);
                } else if (tableNames.get(i).equals(ConstantString1.FUNICULAR_TIMETABLE)) {
                    progress += InsertDataDB.funicularTimetable(create);
                } else if (tableNames.get(i).equals(ConstantString2.TRAM_TIMETABLE)) {
                    progress += InsertDataDB.tramTimetable(create);
                } else if (tableNames.get(i).equals(ConstantString2.TRAIN_TIMETABLE)) {
                    progress += InsertDataDB.trainTimetable(create);
                } else if (tableNames.get(i).equals(ConstantString2.PULLMAN_TIMETABLE)) {
                    progress += InsertDataDB.pullmanTimetable(create);
                }
            } else {
                System.out.println(tableNames.get(i) + " has records");
            }
        }
    }
}
