package model;

public class Constant {

	public static final String JDBC = "org.sqlite.JDBC";
	public static final String SQLITEDATABASE = "org.jooq.meta.sqlite.SQLiteDatabase";

	public static final String SRC_TRANSPORTATION = "src_generated_transportation/";
	public static final String SRC_USER = "src_generated_user/";

	public static final String DB_PUBLIC_TRANSPORTATION = "database/PublicTransportation.db3";
	public static final String DB_URL_PUBLIC_TRANSPORTATION = "jdbc:sqlite:" + DB_PUBLIC_TRANSPORTATION;
	public static final String DB_USERS = "database/Users.db3";
	public static final String DB_URL_USERS = "jdbc:sqlite:" + DB_USERS;

	public static final String JOOQ_TRANSPORTATION = "transportation.jooq.generated";
	public static final String JOOQ_USER = "user.jooq.generated";

	public static final String JSON_COMPANY = "json/company.json";
	public static final String JSON_TRAM_STOP = "json/tramStop.json";
	public static final String JSON_TRAIN_STATION = "json/trainStation.json";
	public static final String JSON_FUNICULAR_STATION = "json/funicularStation.json";
	public static final String JSON_PULLMAN_STOP = "json/pullmanStop.json";
	public static final String JSON_FUNICULAR_TIMETABLE = "json/funicularTimetable.json";
	public static final String JSON_TRAM_TIMETABLE = "json/tramTimetable.json";
	public static final String JSON_PULLMAN_TIMETABLE = "json/pullmanTimetable.json";
	public static final String JSON_TRAIN_TIMETABLE = "json/trainTimetable.json";

	public static final String EXCEL_COMPANY = "src/main/resources/excel/list/company.xlsx";
	public static final String EXCEL_FUNICULAR_STATION = "src/main/resources/excel/list/funicularStation.xlsx";
	public static final String EXCEL_PULLMAN_STOP = "src/main/resources/excel/list/pullmanStop.xlsx";
	public static final String EXCEL_TRAIN_STATION = "src/main/resources/excel/list/trainStation.xlsx";
	public static final String EXCEL_TRAM_STOP = "src/main/resources/excel/list/tramStop.xlsx";
	public static final String EXCEL_FUNICULAR_TIMETABLE = "src/main/resources/excel/timetable/funicularTimetable.xlsx";
	public static final String EXCEL_TRAM_TIMETABLE = "src/main/resources/excel/timetable/tramTimetable.xlsx";
	public static final String EXCEL_PULLMAN_TIMETABLE = "src/main/resources/excel/timetable/pullmanTimetable.xlsx";
	public static final String EXCEL_TRAIN_TIMETABLE = "src/main/resources/excel/timetable/trainTimetable.xlsx";

	public static final String ADDRESS = "address";
	public static final String ARRIVAL_FUNICULAR_STATION = "arrivalFunicularStation";
	public static final String ARRIVAL_PULLMAN_STOP = "arrivalPullmanStop";
	public static final String ARRIVAL_TIME = "arrivalTime";
	public static final String ARRIVAL_TRAIN_STATION = "arrivalTrainStation";
	public static final String ARRIVAL_TRAM_STATION = "arrivalTramStation";
	public static final String ATECO_CODE = "atecoCode";
	public static final String BUSINESS_TAX_CODE = "businessTaxCode";
	public static final String CAP = "cap";
	public static final String COMPANY = "company";
	public static final String COMPANY_NAME = "companyName";
	public static final String COMPANY_REGISTRATION_NUMBER = "companyRegistrationNumber";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String DEPARTURE_FUNICULAR_STATION = "departureFunicularStation";
	public static final String DEPARTURE_PULLMAN_STOP = "departurePullmanStop";
	public static final String DEPARTURE_TIME = "departureTime";
	public static final String DEPARTURE_TRAIN_STATION = "departureTrainStation";
	public static final String DEPARTURE_TRAM_STATION = "departureTramStation";
	public static final String DEVELOPER = "developer";
	public static final String FISCAL_CODE = "fiscalCode";
	public static final String FUNICULAR_TIMETABLE = "funicularTimetable";
	public static final String FUNICULAR_STATION = "funicularStation";
	public static final String ID = "id";
	public static final String INCORPORATION_DATE = "incorporationDate";
	public static final String LEGAL_REPRESENTATIVE = "legalRepresentative";
	public static final String LEGAL_STRUCTURE = "legalStructure";
	public static final String LINE = "line";
	public static final String MAIL = "mail";
	public static final String MANAGER = "manager";
	public static final String NAME = "name";
	public static final String NUMBER_OF_CARRIAGES = "numberOfCarriages";
	public static final String NUMBER_OF_EMPLOYEES = "numberOfEmployees";
	public static final String NUMBER_OF_SEATS = "numberOfSeats";
	public static final String PASSWORD = "password";
	public static final String PLACE = "place";
	public static final String PLACE_OF_BIRTH = "placeOfBirth";
	public static final String PROVINCE = "province";
	public static final String PULLMAN_TIMETABLE = "pullmanTimetable";
	public static final String PULLMAN_STOP = "pullmanStop";
	public static final String REGISTERED_OFFICE = "registeredOffice";
	public static final String REGISTERED_USER = "registeredUser";
	public static final String ROLE = "role";
	public static final String SOCIAL = "social";
	public static final String STREET_NUMBER = "streetNumber";
	public static final String SURNAME = "surname";
	public static final String TELEPHONE = "telephone";
	public static final String TIME_STOP = "timeStop";
	public static final String TOWN = "town";
	public static final String TRAIN_TIMETABLE = "trainTimetable";
	public static final String TRAIN_STATION = "trainStation";
	public static final String TRAIN_STOP = "trainStop";
	public static final String TRAM_TIMETABLE = "tramTimetable";
	public static final String TRAM_STOP = "tramStop";
	public static final String TYPE = "type";
	public static final String NEXT_STOP = "nextStop";
	public static final String USER = "user";
	public static final String USERNAME = "username";
	public static final String WEB_SITE = "webSite";
	public static final String LATITUDE = "lat";
	public static final String LONGITUDE = "lon";
	public static final String ICON_NUMBER = "IconNumber";
	public static final String SANSSERIF = "SansSerif";
	
	public static Boolean update = false;
	
	public static final int NUMBER_COMPANY_RECORD = 4;
	public static final int NUMBER_PULLMAN_STOP_RECORD = 287;
	public static final int NUMBER_TRAIN_STATION_RECORD = 59;
	public static final int NUMBER_TRAIN_TIMETABLE_RECORD = 3678;
	public static final int NUMBER_TRAM_STOP_RECORD = 16;
	public static final int NUMBER_TRAM_TIMETABLE_RECORD = 3284;
	public static final int NUMBER_PULLMAN_TIMETABLE_RECORD = 30623;
	public static final int NUMBER_FUNICULAR_STATION_RECORD = 4;
	public static final int NUMBER_FUNICULAR_TIMETABLE_RECORD = 1198;
	
}
