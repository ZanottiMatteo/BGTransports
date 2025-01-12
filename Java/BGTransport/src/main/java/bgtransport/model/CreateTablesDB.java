package bgtransport.model;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

/**
 * The CreateTablesDB class provides methods for creating database tables 
 * related to public transportation and user information. These tables include timetables, 
 * stations, and user management.
 * 
 * The class uses JOOQ to generate SQL queries to create tables with specific columns and constraints.
 */
public class CreateTablesDB {

    /**
     * Creates tables for public transportation information, including timetables, 
     * stations, and stops for different modes of transport (e.g., Pullman, Funicular, Train, Tram).
     * 
     * @param create The DSLContext used to execute SQL queries.
     */
    public static void createTablesPublicTransportation(DSLContext create) {
        createPullmanTimetable(create);
        createFunicularTimetable(create);
        createTrainTimetable(create);
        createTramTimetable(create);
        createCompanyTable(create);
        createPullmanStop(create);
        createTramStop(create);
        createFunicularStation(create);
        createTrainStation(create);
    }

    /**
     * Creates the Pullman timetable table.
     * 
     * @param create The DSLContext used to execute SQL queries.
     */
    private static void createPullmanTimetable(DSLContext create) {
        create.createTableIfNotExists(ConstantString2.PULLMAN_TIMETABLE)
                .column(ConstantString1.ID, SQLDataType.INTEGER)
                .column(ConstantString1.COMPANY_NAME, SQLDataType.VARCHAR(255))
                .column(ConstantString1.LINE, SQLDataType.VARCHAR(255))
                .column(ConstantString1.DEPARTURE_PULLMAN_STOP, SQLDataType.VARCHAR(255))
                .column(ConstantString1.DEPARTURE_TIME, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ARRIVAL_PULLMAN_STOP, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ARRIVAL_TIME, SQLDataType.VARCHAR(255))
                .column(ConstantString2.NEXT_STOP, SQLDataType.VARCHAR(255))
                .column(ConstantString2.TIME_STOP, SQLDataType.VARCHAR(255))
                .column(ConstantString2.TYPE, SQLDataType.VARCHAR(255))
                .constraints(DSL.constraint("PK_" + ConstantString2.PULLMAN_TIMETABLE).primaryKey(ConstantString1.ID))
                .execute();
    }

    /**
     * Creates the Funicular timetable table.
     * 
     * @param create The DSLContext used to execute SQL queries.
     */
    private static void createFunicularTimetable(DSLContext create) {
        create.createTableIfNotExists(ConstantString1.FUNICULAR_TIMETABLE)
                .column(ConstantString1.ID, SQLDataType.INTEGER)
                .column(ConstantString1.COMPANY_NAME, SQLDataType.VARCHAR(255))
                .column(ConstantString2.NAME, SQLDataType.VARCHAR(255))
                .column(ConstantString1.DEPARTURE_FUNICULAR_STATION, SQLDataType.VARCHAR(255))
                .column(ConstantString1.DEPARTURE_TIME, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ARRIVAL_FUNICULAR_STATION, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ARRIVAL_TIME, SQLDataType.VARCHAR(255))
                .column(ConstantString2.TYPE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.NUMBER_OF_SEATS, SQLDataType.VARCHAR(255))
                .constraints(DSL.constraint("PK_" + ConstantString1.FUNICULAR_TIMETABLE).primaryKey(ConstantString1.ID))
                .execute();
    }

    /**
     * Creates the Train timetable table.
     * 
     * @param create The DSLContext used to execute SQL queries.
     */
    private static void createTrainTimetable(DSLContext create) {
        create.createTableIfNotExists(ConstantString2.TRAIN_TIMETABLE)
                .column(ConstantString1.ID, SQLDataType.INTEGER)
                .column(ConstantString1.COMPANY_NAME, SQLDataType.VARCHAR(255))
                .column(ConstantString2.NAME, SQLDataType.VARCHAR(255))
                .column(ConstantString1.DEPARTURE_TRAIN_STATION, SQLDataType.VARCHAR(255))
                .column(ConstantString1.DEPARTURE_TIME, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ARRIVAL_TRAIN_STATION, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ARRIVAL_TIME, SQLDataType.VARCHAR(255))
                .column(ConstantString2.NEXT_STOP, SQLDataType.VARCHAR(255))
                .column(ConstantString2.TIME_STOP, SQLDataType.VARCHAR(255))
                .constraints(DSL.constraint("PK_" + ConstantString2.TRAIN_TIMETABLE).primaryKey(ConstantString1.ID))
                .execute();
    }

    /**
     * Creates the Tram timetable table.
     * 
     * @param create The DSLContext used to execute SQL queries.
     */
    private static void createTramTimetable(DSLContext create) {
        create.createTableIfNotExists(ConstantString2.TRAM_TIMETABLE)
                .column(ConstantString1.ID, SQLDataType.INTEGER)
                .column(ConstantString1.COMPANY_NAME, SQLDataType.VARCHAR(255))
                .column(ConstantString2.NAME, SQLDataType.VARCHAR(255))
                .column(ConstantString1.DEPARTURE_TRAM_STATION, SQLDataType.VARCHAR(255))
                .column(ConstantString1.DEPARTURE_TIME, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ARRIVAL_TRAM_STATION, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ARRIVAL_TIME, SQLDataType.VARCHAR(255))
                .column(ConstantString2.NEXT_STOP, SQLDataType.VARCHAR(255))
                .column(ConstantString2.TIME_STOP, SQLDataType.VARCHAR(255))
                .column(ConstantString2.TYPE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.NUMBER_OF_SEATS, SQLDataType.VARCHAR(255))
                .column(ConstantString2.NUMBER_OF_CARRIAGES, SQLDataType.VARCHAR(255))
                .constraints(DSL.constraint("PK_" + ConstantString2.TRAM_TIMETABLE).primaryKey(ConstantString1.ID))
                .execute();
    }

    /**
     * Creates the Company table.
     * 
     * @param create The DSLContext used to execute SQL queries.
     */
    private static void createCompanyTable(DSLContext create) {
        create.createTableIfNotExists(ConstantString1.COMPANY)
                .column(ConstantString2.NAME, SQLDataType.VARCHAR(255))
                .column(ConstantString1.LEGAL_STRUCTURE, SQLDataType.VARCHAR(255))
                .column(ConstantString1.BUSINESS_TAX_CODE, SQLDataType.VARCHAR(255))
                .column(ConstantString1.COMPANY_REGISTRATION_NUMBER, SQLDataType.VARCHAR(255))
                .column(ConstantString1.INCORPORATION_DATE, SQLDataType.VARCHAR(255))
                .column(ConstantString1.LEGAL_REPRESENTATIVE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.NUMBER_OF_EMPLOYEES, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ATECO_CODE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.REGISTERED_OFFICE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.PROVINCE, SQLDataType.VARCHAR(255))
                .column(ConstantString1.CAP, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ADDRESS, SQLDataType.VARCHAR(255))
                .column(ConstantString2.STREET_NUMBER, SQLDataType.VARCHAR(255))
                .column(ConstantString2.TELEPHONE, SQLDataType.VARCHAR(255))
                .column(ConstantString1.MAIL, SQLDataType.VARCHAR(255))
                .column(ConstantString2.SOCIAL, SQLDataType.VARCHAR(255))
                .column(ConstantString2.WEB_SITE, SQLDataType.VARCHAR(255))
                .constraints(DSL.constraint("PK_" + ConstantString1.COMPANY).primaryKey(ConstantString2.NAME))
                .execute();
    }

    /**
     * Creates the Pullman stop table.
     * 
     * @param create The DSLContext used to execute SQL queries.
     */
    private static void createPullmanStop(DSLContext create) {
        create.createTableIfNotExists(ConstantString2.PULLMAN_STOP)
                .column(ConstantString2.NAME, SQLDataType.VARCHAR(255))
                .column(ConstantString2.TOWN, SQLDataType.VARCHAR(255))
                .column(ConstantString2.PROVINCE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.LATITUDE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.LONGITUDE, SQLDataType.VARCHAR(255))
                .constraints(DSL.constraint("PK_" + ConstantString2.PULLMAN_STOP).primaryKey(ConstantString2.NAME))
                .execute();
    }

    /**
     * Creates the Tram stop table.
     * 
     * @param create The DSLContext used to execute SQL queries.
     */
    private static void createTramStop(DSLContext create) {
        create.createTableIfNotExists(ConstantString2.TRAM_STOP)
                .column(ConstantString2.NAME, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ADDRESS, SQLDataType.VARCHAR(255))
                .column(ConstantString2.TOWN, SQLDataType.VARCHAR(255))
                .column(ConstantString2.PROVINCE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.LATITUDE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.LONGITUDE, SQLDataType.VARCHAR(255))
                .constraints(DSL.constraint("PK_" + ConstantString2.TRAM_STOP).primaryKey(ConstantString2.NAME))
                .execute();
    }

    /**
     * Creates the Funicular station table.
     * 
     * @param create The DSLContext used to execute SQL queries.
     */
    private static void createFunicularStation(DSLContext create) {
        create.createTableIfNotExists(ConstantString1.FUNICULAR_STATION)
                .column(ConstantString2.NAME, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ADDRESS, SQLDataType.VARCHAR(255))
                .column(ConstantString2.TOWN, SQLDataType.VARCHAR(255))
                .column(ConstantString2.PROVINCE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.LATITUDE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.LONGITUDE, SQLDataType.VARCHAR(255))
                .constraints(DSL.constraint("PK_" + ConstantString1.FUNICULAR_STATION).primaryKey(ConstantString2.NAME))
                .execute();
    }

    /**
     * Creates the Train station table.
     * 
     * @param create The DSLContext used to execute SQL queries.
     */
    private static void createTrainStation(DSLContext create) {
        create.createTableIfNotExists(ConstantString2.TRAIN_STATION)
                .column(ConstantString2.NAME, SQLDataType.VARCHAR(255))
                .column(ConstantString1.ADDRESS, SQLDataType.VARCHAR(255))
                .column(ConstantString2.TOWN, SQLDataType.VARCHAR(255))
                .column(ConstantString2.PROVINCE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.LATITUDE, SQLDataType.VARCHAR(255))
                .column(ConstantString2.LONGITUDE, SQLDataType.VARCHAR(255))
                .constraints(DSL.constraint("PK_" + ConstantString2.TRAIN_STATION).primaryKey(ConstantString2.NAME))
                .execute();
    }

    /**
     * Creates the Users table.
     * 
     * @param create The DSLContext used to execute SQL queries.
     */
    public static void createTablesUsers(DSLContext create) {
        create.createTableIfNotExists(ConstantString2.USER)
                .column(ConstantString2.USERNAME, SQLDataType.VARCHAR(100))
                .column(ConstantString2.NAME, SQLDataType.VARCHAR(100))
                .column(ConstantString2.SURNAME, SQLDataType.VARCHAR(100))
                .column(ConstantString1.DATE_OF_BIRTH, SQLDataType.VARCHAR(20))
                .column(ConstantString1.ADDRESS, SQLDataType.VARCHAR(50))
                .column(ConstantString2.TOWN, SQLDataType.VARCHAR(50))
                .column(ConstantString1.CAP, SQLDataType.VARCHAR(100))
                .column(ConstantString2.PASSWORD, SQLDataType.VARCHAR(50))
                .column(ConstantString1.MAIL, SQLDataType.VARCHAR(100))
                .column(ConstantString2.ROLE, SQLDataType.INTEGER)
                .column(ConstantString2.ICON_NUMBER, SQLDataType.INTEGER)
                .constraints(DSL.constraint("PK_" + ConstantString2.USER).primaryKey(ConstantString2.USERNAME))
                .execute();
    }
}
