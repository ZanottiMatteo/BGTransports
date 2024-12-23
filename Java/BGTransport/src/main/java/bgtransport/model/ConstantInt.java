package bgtransport.model;

/**
 * The ConstantInt class contains integer constants that represent the
 * number of records for various entities and timetables in the transportation system.
 * 
 * These constants are used to define the expected number of records in different data sets
 * for companies, transportation stops, and timetables for various modes of transport (pullman, train, tram, funicular).
 */
public class ConstantInt {

    /**
     * The number of records for the company data.
     */
    public static final int NUMBER_COMPANY_RECORD = 4;

    /**
     * The number of records for the pullman stop data.
     */
    public static final int NUMBER_PULLMAN_STOP_RECORD = 287;

    /**
     * The number of records for the train station data.
     */
    public static final int NUMBER_TRAIN_STATION_RECORD = 59;

    /**
     * The number of records for the train timetable data.
     */
    public static final int NUMBER_TRAIN_TIMETABLE_RECORD = 3678;

    /**
     * The number of records for the tram stop data.
     */
    public static final int NUMBER_TRAM_STOP_RECORD = 16;

    /**
     * The number of records for the tram timetable data.
     */
    public static final int NUMBER_TRAM_TIMETABLE_RECORD = 3284;

    /**
     * The number of records for the pullman timetable data.
     */
    public static final int NUMBER_PULLMAN_TIMETABLE_RECORD = 30623;

    /**
     * The number of records for the funicular station data.
     */
    public static final int NUMBER_FUNICULAR_STATION_RECORD = 4;

    /**
     * The number of records for the funicular timetable data.
     */
    public static final int NUMBER_FUNICULAR_TIMETABLE_RECORD = 1198;

    /**
     * A boolean flag indicating whether an update is required.
     * 
     * This flag can be used throughout the application to check or trigger updates for certain operations.
     */
    public static Boolean update = false;
}
