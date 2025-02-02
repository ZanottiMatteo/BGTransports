package bgtransport.model;

/**
 * The MainModel class serves as the entry point for running the database operations for public transportation and user management.
 * It calls the necessary methods for controlling JSON-to-Excel transformations and database creation and update.
 */
public class MainModel {
    /**
     * The main method that runs the entire process of controlling JSON-to-Excel transformations,
     * checking and updating the public transportation database, and checking the user database.
     * 
     * @param args command-line arguments, not used in this case
     * @throws Exception if any exception occurs during the execution of database operations
     */
    public static void main(String[] args) throws Exception {
        // Perform JSON-to-Excel transformations for different transportation entities
        ControlDB.controlJSON(ConstantFile.JSON_FUNICULAR_STATION, ConstantFile.EXCEL_FUNICULAR_STATION);
        ControlDB.controlJSON(ConstantFile.JSON_COMPANY, ConstantFile.EXCEL_COMPANY);
        ControlDB.controlJSON(ConstantFile.JSON_PULLMAN_STOP, ConstantFile.EXCEL_PULLMAN_STOP);
        ControlDB.controlJSON(ConstantFile.JSON_TRAIN_STATION, ConstantFile.EXCEL_TRAIN_STATION);
        ControlDB.controlJSON(ConstantFile.JSON_TRAM_STOP, ConstantFile.EXCEL_TRAM_STOP);
        ControlDB.controlJSON(ConstantFile.JSON_FUNICULAR_TIMETABLE, ConstantFile.EXCEL_FUNICULAR_TIMETABLE);
        ControlDB.controlJSON(ConstantFile.JSON_TRAM_TIMETABLE, ConstantFile.EXCEL_TRAM_TIMETABLE);
        ControlDB.controlJSON(ConstantFile.JSON_TRAIN_TIMETABLE, ConstantFile.EXCEL_TRAIN_TIMETABLE);
        ControlDB.controlJSON(ConstantFile.JSON_PULLMAN_TIMETABLE, ConstantFile.EXCEL_PULLMAN_TIMETABLE);
        
        // Check and update the public transportation database
        ControlDB.dbCheck(ConstantDB.DB_PUBLIC_TRANSPORTATION, ConstantDB.DB_URL_PUBLIC_TRANSPORTATION, 
                          ConstantDB.JOOQ_TRANSPORTATION, ConstantDB.SRC_TRANSPORTATION);
        
        ControlDB.dbUpdate(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
        
        // Check the user database
        ControlDB.dbCheck(ConstantDB.DB_USERS, ConstantDB.DB_URL_USERS, 
                          ConstantDB.JOOQ_USER, ConstantDB.SRC_USER);
    }
}
