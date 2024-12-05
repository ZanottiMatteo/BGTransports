package model;

public class Constant {

	public static String JDBC = "org.sqlite.JDBC";
	public static String SQLiteDatabase = "org.jooq.meta.sqlite.SQLiteDatabase";
	
	public static String srcTransportation = "src_generated_transportation/";
	public static String srcUser = "src_generated_user/";
	
	public static String DBPublicTransportation = "database/PublicTransportation.db3";
	public static String DBUrlPublicTransportation = "jdbc:sqlite:" + DBPublicTransportation;
	public static String DBUsers = "database/Users.db3";
	public static String DBUrlUsers = "jdbc:sqlite:" + DBUsers;
	
	public static String jooqTransportation = "transportation.jooq.generated";
	public static String jooqUser = "user.jooq.generated";
	
	public static String jsonCompany = "json/company.json";
	public static String jsonTramStop = "json/tramStop.json";
	public static String jsonTrainStation = "json/trainStation.json";
	public static String jsonFunicularStation = "json/funicularStation.json";
	public static String jsonPullmanStop = "json/pullmanStop.json";
	public static String jsonFunicularTimetable = "json/funicularTimetable.json";
	public static String jsonTramTimetable = "json/tramTimetable.json";
	public static String jsonPullmanTimetable = "json/pullmanTimetable.json";
	public static String jsonTrainTimetable = "json/trainTimetable.json";
	
	public static String excelCompany = "src/main/resources/excel/list/company.xlsx";
	public static String excelFunicularStation = "src/main/resources/excel/list/funicularStation.xlsx";
	public static String excelPullmanStop = "src/main/resources/excel/list/pullmanStop.xlsx";
	public static String excelTrainStation = "src/main/resources/excel/list/trainStation.xlsx";
	public static String excelTramStop = "src/main/resources/excel/list/tramStop.xlsx";
	public static String excelFunicularTimetable = "src/main/resources/excel/timetable/funicularTimetable.xlsx";
	public static String excelTramTimetable = "src/main/resources/excel/timetable/tramTimetable.xlsx";
	public static String excelPullmanTimetable = "src/main/resources/excel/timetable/pullmanTimetable.xlsx";
	public static String excelTrainTimetable = "src/main/resources/excel/timetable/trainTimetable.xlsx";
	
	public static String address = "address";
	public static String arrivalFunicularStation = "arrivalFunicularStation";
	public static String arrivalPullmanStop = "arrivalPullmanStop";
	public static String arrivalTime = "arrivalTime";
	public static String arrivalTrainStation = "arrivalTrainStation";
	public static String arrivalTramStation = "arrivalTramStation";
	public static String atecoCode = "atecoCode";
	public static String businessTaxCode = "businessTaxCode";
	public static String CAP = "cap";
	public static String company = "company";
	public static String companyName = "companyName";
	public static String companyRegistrationNumber = "companyRegistrationNumber";
	public static String dateOfBirth = "dateOfBirth";
	public static String departureFunicularStation = "departureFunicularStation";
	public static String departurePullmanStop = "departurePullmanStop";
	public static String departureTime = "departureTime";
	public static String departureTrainStation = "departureTrainStation";
	public static String departureTramStation = "departureTramStation";
	public static String developer = "developer";
	public static String fiscalCode = "fiscalCode";
	public static String funicularTimetable = "funicularTimetable";
	public static String funicularStation = "funicularStation";
	public static String id = "id";
	public static String incorporationDate = "incorporationDate";
	public static String legalRepresentative = "legalRepresentative";
	public static String legalStructure = "legalStructure";
	public static String line = "line";
	public static String mail = "mail";
	public static String manager = "manager";
	public static String name = "name";
	public static String numberOfCarriages = "numberOfCarriages";
	public static String numberOfEmployees = "numberOfEmployees";
	public static String numberOfSeats = "numberOfSeats";
	public static String password = "password";
	public static String place = "place";
	public static String placeOfBirth = "placeOfBirth";
	public static String province = "province";
	public static String pullmanTimetable = "pullmanTimetable";
	public static String pullmanStop = "pullmanStop";
	public static String registeredOffice = "registeredOffice";
	public static String registeredUser = "registeredUser";
	public static String role = "role";
	public static String social = "social";
	public static String streetNumber = "streetNumber";
	public static String surname = "surname";
	public static String telephone = "telephone";
	public static String timeStop = "timeStop";
	public static String town = "town";
	public static String trainTimetable = "trainTimetable";
	public static String trainStation = "trainStation";
	public static String trainStop = "trainStop";
	public static String tramTimetable = "tramTimetable";
	public static String tramStop = "tramStop";
	public static String type = "type";
	public static String nextStop = "nextStop";
	public static String user = "user";
	public static String username = "username";
	public static String webSite = "webSite";
	public static String latitude = "lat";
	public static String longitude = "lon";
	public static String iconaccount = "IconNumber";
	
	public static Boolean update = false;
	
	public static final int NumberCompanyRecord = 4;
	public static final int NumberPullmanStopRecord = 287;
	public static final int NumberTrainStationRecord = 59;
	public static final int NumberTrainTimetableRecord = 3678;
	public static final int NumberTramStopRecord = 16;
	public static final int NumberTramTimetableRecord = 3284;
	public static final int NumberPullmanTimetableRecord = 30623;
	public static final int NumberFunicularStationRecord = 4;
	public static final int NumberFunicularTimetableRecord = 1198;
	
}
