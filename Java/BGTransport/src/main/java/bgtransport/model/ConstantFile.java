package bgtransport.model;

/**
 * The ConstantFile class contains constants representing file paths
 * for various resources such as JSON files and Excel spreadsheets used in the
 * transportation system. These files store data related to companies, transport stops,
 * and timetables for different types of transport (tram, train, pullman, funicular).
 * 
 * The paths point to the respective resources in the project's directory structure,
 * which are used for data processing and integration within the application.
 */
public class ConstantFile {

    // JSON file paths for different transportation entities and timetables

    /**
     * The file path to the JSON file containing company data.
     */
    public static final String JSON_COMPANY = "json/company.json";

    /**
     * The file path to the JSON file containing tram stop data.
     */
    public static final String JSON_TRAM_STOP = "json/tramStop.json";

    /**
     * The file path to the JSON file containing train station data.
     */
    public static final String JSON_TRAIN_STATION = "json/trainStation.json";

    /**
     * The file path to the JSON file containing funicular station data.
     */
    public static final String JSON_FUNICULAR_STATION = "json/funicularStation.json";

    /**
     * The file path to the JSON file containing pullman stop data.
     */
    public static final String JSON_PULLMAN_STOP = "json/pullmanStop.json";

    /**
     * The file path to the JSON file containing the funicular timetable.
     */
    public static final String JSON_FUNICULAR_TIMETABLE = "json/funicularTimetable.json";

    /**
     * The file path to the JSON file containing the tram timetable.
     */
    public static final String JSON_TRAM_TIMETABLE = "json/tramTimetable.json";

    /**
     * The file path to the JSON file containing the pullman timetable.
     */
    public static final String JSON_PULLMAN_TIMETABLE = "json/pullmanTimetable.json";

    /**
     * The file path to the JSON file containing the train timetable.
     */
    public static final String JSON_TRAIN_TIMETABLE = "json/trainTimetable.json";

    // Excel file paths for different transportation entities and timetables

    /**
     * The file path to the Excel file containing the list of companies.
     */
    public static final String EXCEL_COMPANY = "src/main/resources/excel/list/company.xlsx";

    /**
     * The file path to the Excel file containing the list of funicular stations.
     */
    public static final String EXCEL_FUNICULAR_STATION = "src/main/resources/excel/list/funicularStation.xlsx";

    /**
     * The file path to the Excel file containing the list of pullman stops.
     */
    public static final String EXCEL_PULLMAN_STOP = "src/main/resources/excel/list/pullmanStop.xlsx";

    /**
     * The file path to the Excel file containing the list of train stations.
     */
    public static final String EXCEL_TRAIN_STATION = "src/main/resources/excel/list/trainStation.xlsx";

    /**
     * The file path to the Excel file containing the list of tram stops.
     */
    public static final String EXCEL_TRAM_STOP = "src/main/resources/excel/list/tramStop.xlsx";

    /**
     * The file path to the Excel file containing the funicular timetable.
     */
    public static final String EXCEL_FUNICULAR_TIMETABLE = "src/main/resources/excel/timetable/funicularTimetable.xlsx";

    /**
     * The file path to the Excel file containing the tram timetable.
     */
    public static final String EXCEL_TRAM_TIMETABLE = "src/main/resources/excel/timetable/tramTimetable.xlsx";

    /**
     * The file path to the Excel file containing the pullman timetable.
     */
    public static final String EXCEL_PULLMAN_TIMETABLE = "src/main/resources/excel/timetable/pullmanTimetable.xlsx";

    /**
     * The file path to the Excel file containing the train timetable.
     */
    public static final String EXCEL_TRAIN_TIMETABLE = "src/main/resources/excel/timetable/trainTimetable.xlsx";
}
