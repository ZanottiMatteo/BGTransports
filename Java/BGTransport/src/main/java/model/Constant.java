package model;

public class Constant {

	public static final String JDBC = "org.sqlite.JDBC";
	public static final String SQLITEDATABASE = "org.jooq.meta.sqlite.SQLiteDatabase";

	public static final String srcTransportation = "src_generated_transportation/";
	public static final String srcUser = "src_generated_user/";

	public static final String DBPublicTransportation = "database/PublicTransportation.db3";
	public static final String DBUrlPublicTransportation = "jdbc:sqlite:" + DBPublicTransportation;
	public static final String DBUsers = "database/Users.db3";
	public static final String DBUrlUsers = "jdbc:sqlite:" + DBUsers;

	public static final String jooqTransportation = "transportation.jooq.generated";
	public static final String jooqUser = "user.jooq.generated";

	public static final String jsonCompany = "json/company.json";
	public static final String jsonTramStop = "json/tramStop.json";
	public static final String jsonTrainStation = "json/trainStation.json";
	public static final String jsonFunicularStation = "json/funicularStation.json";
	public static final String jsonPullmanStop = "json/pullmanStop.json";
	public static final String jsonFunicularTimetable = "json/funicularTimetable.json";
	public static final String jsonTramTimetable = "json/tramTimetable.json";
	public static final String jsonPullmanTimetable = "json/pullmanTimetable.json";
	public static final String jsonTrainTimetable = "json/trainTimetable.json";

	public static final String excelCompany = "src/main/resources/excel/list/company.xlsx";
	public static final String excelFunicularStation = "src/main/resources/excel/list/funicularStation.xlsx";
	public static final String excelPullmanStop = "src/main/resources/excel/list/pullmanStop.xlsx";
	public static final String excelTrainStation = "src/main/resources/excel/list/trainStation.xlsx";
	public static final String excelTramStop = "src/main/resources/excel/list/tramStop.xlsx";
	public static final String excelFunicularTimetable = "src/main/resources/excel/timetable/funicularTimetable.xlsx";
	public static final String excelTramTimetable = "src/main/resources/excel/timetable/tramTimetable.xlsx";
	public static final String excelPullmanTimetable = "src/main/resources/excel/timetable/pullmanTimetable.xlsx";
	public static final String excelTrainTimetable = "src/main/resources/excel/timetable/trainTimetable.xlsx";

	public static final String address = "address";
	public static final String arrivalFunicularStation = "arrivalFunicularStation";
	public static final String arrivalPullmanStop = "arrivalPullmanStop";
	public static final String arrivalTime = "arrivalTime";
	public static final String arrivalTrainStation = "arrivalTrainStation";
	public static final String arrivalTramStation = "arrivalTramStation";
	public static final String atecoCode = "atecoCode";
	public static final String businessTaxCode = "businessTaxCode";
	public static final String CAP = "cap";
	public static final String company = "company";
	public static final String companyName = "companyName";
	public static final String companyRegistrationNumber = "companyRegistrationNumber";
	public static final String dateOfBirth = "dateOfBirth";
	public static final String departureFunicularStation = "departureFunicularStation";
	public static final String departurePullmanStop = "departurePullmanStop";
	public static final String departureTime = "departureTime";
	public static final String departureTrainStation = "departureTrainStation";
	public static final String departureTramStation = "departureTramStation";
	public static final String developer = "developer";
	public static final String fiscalCode = "fiscalCode";
	public static final String funicularTimetable = "funicularTimetable";
	public static final String funicularStation = "funicularStation";
	public static final String ID = "id";
	public static final String incorporationDate = "incorporationDate";
	public static final String legalRepresentative = "legalRepresentative";
	public static final String legalStructure = "legalStructure";
	public static final String line = "line";
	public static final String mail = "mail";
	public static final String manager = "manager";
	public static final String name = "name";
	public static final String numberOfCarriages = "numberOfCarriages";
	public static final String numberOfEmployees = "numberOfEmployees";
	public static final String numberOfSeats = "numberOfSeats";
	public static final String password = "password";
	public static final String place = "place";
	public static final String placeOfBirth = "placeOfBirth";
	public static final String province = "province";
	public static final String pullmanTimetable = "pullmanTimetable";
	public static final String pullmanStop = "pullmanStop";
	public static final String registeredOffice = "registeredOffice";
	public static final String registeredUser = "registeredUser";
	public static final String role = "role";
	public static final String social = "social";
	public static final String streetNumber = "streetNumber";
	public static final String surname = "surname";
	public static final String telephone = "telephone";
	public static final String timeStop = "timeStop";
	public static final String town = "town";
	public static final String trainTimetable = "trainTimetable";
	public static final String trainStation = "trainStation";
	public static final String trainStop = "trainStop";
	public static final String tramTimetable = "tramTimetable";
	public static final String tramStop = "tramStop";
	public static final String type = "type";
	public static final String nextStop = "nextStop";
	public static final String user = "user";
	public static final String username = "username";
	public static final String webSite = "webSite";
	public static final String latitude = "lat";
	public static final String longitude = "lon";
	public static final String iconaccount = "IconNumber";
	public static final String sansSerif = "SansSerif";
	
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
