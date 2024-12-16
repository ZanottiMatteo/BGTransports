package bgtransport.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Record11;
import org.jooq.Record2;
import org.jooq.Record6;
import org.jooq.Record7;
import org.jooq.Result;
import org.jxmapviewer.viewer.GeoPosition;

import bgtransport.controller.LineController;
import transportation.jooq.generated.tables.Company;
import transportation.jooq.generated.tables.Funicularstation;
import transportation.jooq.generated.tables.Funiculartimetable;
import transportation.jooq.generated.tables.Pullmanstop;
import transportation.jooq.generated.tables.Pullmantimetable;
import transportation.jooq.generated.tables.Trainstation;
import transportation.jooq.generated.tables.Traintimetable;
import transportation.jooq.generated.tables.Tramstop;
import transportation.jooq.generated.tables.Tramtimetable;
import user.jooq.generated.tables.User;

public class QueryDB {

	public static String[] columnNames;
	public static Object[][] data;

	public static List<String> getLatFunicularStation() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> latitude = new ArrayList<String>();

		@NotNull
		Result<Record1<String>> result = create.select(Funicularstation.FUNICULARSTATION.LAT)
				.from(Funicularstation.FUNICULARSTATION).fetch();

		for (Record1<String> funicularStationLat : result) {
			String lat = funicularStationLat.value1();
			latitude.add(lat);
		}
		return latitude;
	}

	public static List<String> getLonFunicularStation() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> longitude = new ArrayList<String>();

		@NotNull
		Result<Record1<String>> result = create.select(Funicularstation.FUNICULARSTATION.LON)
				.from(Funicularstation.FUNICULARSTATION).fetch();

		for (Record1<String> funicularStationLon : result) {
			String lon = funicularStationLon.value1();
			longitude.add(lon);
		}
		return longitude;
	}

	public static List<GeoPosition> getFunicularGeopositions() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<GeoPosition> geopositions = new ArrayList<>();

		@NotNull
		Result<Record2<String, String>> result = create
				.select(Funicularstation.FUNICULARSTATION.LAT, Funicularstation.FUNICULARSTATION.LON)
				.from(Funicularstation.FUNICULARSTATION).fetch();

		for (Record2<String, String> funicularStationLatLon : result) {
			double lat = Double.parseDouble(funicularStationLatLon.value1());
			double lon = Double.parseDouble(funicularStationLatLon.value2());
			System.out.println("Lat: " + lat + "Long" + lon);
			geopositions.add(new GeoPosition(lat, lon));
		}

		return geopositions;
	}

	public static List<GeoPosition> getPullmanGeopositions() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<GeoPosition> geopositions = new ArrayList<>();

		@NotNull
		Result<Record2<String, String>> result = create.select(Pullmanstop.PULLMANSTOP.LAT, Pullmanstop.PULLMANSTOP.LON)
				.from(Pullmanstop.PULLMANSTOP).fetch();

		for (Record2<String, String> pullmanStopLatLon : result) {
			double lat = Double.parseDouble(pullmanStopLatLon.value1());
			double lon = Double.parseDouble(pullmanStopLatLon.value2());
			GeoPosition geoPosition = new GeoPosition(lat, lon);
			geopositions.add(geoPosition);
		}

		return geopositions;
	}

	public static List<GeoPosition> getTrainGeopositions() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<GeoPosition> geopositions = new ArrayList<>();

		@NotNull
		Result<Record2<String, String>> result = create
				.select(Trainstation.TRAINSTATION.LAT, Trainstation.TRAINSTATION.LON).from(Trainstation.TRAINSTATION)
				.fetch();

		for (Record2<String, String> trainStationLatLon : result) {
			double lat = Double.parseDouble(trainStationLatLon.value1());
			double lon = Double.parseDouble(trainStationLatLon.value2());
			GeoPosition geoPosition = new GeoPosition(lat, lon);
			geopositions.add(geoPosition);
		}

		return geopositions;
	}

	public static List<GeoPosition> getTramGeopositions() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<GeoPosition> geopositions = new ArrayList<>();

		@NotNull
		Result<Record2<String, String>> result = create.select(Tramstop.TRAMSTOP.LAT, Tramstop.TRAMSTOP.LON)
				.from(Tramstop.TRAMSTOP).fetch();

		for (Record2<String, String> tramStopLatLon : result) {
			double lat = Double.parseDouble(tramStopLatLon.value1());
			double lon = Double.parseDouble(tramStopLatLon.value2());
			GeoPosition geoPosition = new GeoPosition(lat, lon);
			geopositions.add(geoPosition);
		}

		return geopositions;
	}

	public static List<String> getNameStation() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> geopositions = new ArrayList<>();

		@NotNull
		Result<Record1<String>> result = create.select(Pullmanstop.PULLMANSTOP.NAME).from(Pullmanstop.PULLMANSTOP)
				.fetch();

		for (Record1<String> nameStation : result) {
			geopositions.add(nameStation.value1());
		}

		return geopositions;
	}
	
	public static List<String> getLineList() throws SQLException{
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> geopositions = new ArrayList<>();
		
		@NotNull
		Result<Record1<String>> result = create.selectDistinct(Pullmantimetable.PULLMANTIMETABLE.LINE).from(Pullmantimetable.PULLMANTIMETABLE)
				.fetch();

		for (Record1<String> line : result) {
			geopositions.add(line.value1());
		}
		
		return geopositions;
	}
	
	public static List<String> getTimeList() throws SQLException{
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> geopositions = new ArrayList<>();
		
		@NotNull
		Result<Record1<String>> result = create.selectDistinct(Pullmantimetable.PULLMANTIMETABLE.DEPARTURETIME).from(Pullmantimetable.PULLMANTIMETABLE).orderBy(Pullmantimetable.PULLMANTIMETABLE.DEPARTURETIME)
				.fetch();

		for (Record1<String> time : result) {
			geopositions.add(time.value1());
		}
		return geopositions;
	}
	
	public static List<String> getWeekList() throws SQLException{
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> geopositions = new ArrayList<>();
		
		@NotNull
		Result<Record1<String>> result = create.selectDistinct(Pullmantimetable.PULLMANTIMETABLE.TYPE).from(Pullmantimetable.PULLMANTIMETABLE)
				.fetch();

		for (Record1<String> weekDay : result) {
			geopositions.add(weekDay.value1());
		}
		return geopositions;
	}

	// --------- Name ---------

	public static String getNameUser(String email) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		// Fetch the name of the user with the given email
		@Nullable
		Record1<String> mail = create.select(User.USER.NAME).from(User.USER).where(User.USER.MAIL.eq(email)).fetchOne();

		// Return the name or null if not found
		return mail != null ? mail.value1() : null;
	}

	public static void setNameUser(String email, String newName) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		// Update the user's name where the email matches
		int rowsUpdated = create.update(User.USER).set(User.USER.NAME, newName).where(User.USER.MAIL.eq(email))
				.execute();

		if (rowsUpdated == 0) {
			throw new SQLException(email);
		}
	}

	// --------- Surname ---------

	public static String getSurnameUser(String email) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		@Nullable
		Record1<String> surname = create.select(User.USER.SURNAME).from(User.USER).where(User.USER.MAIL.eq(email))
				.fetchOne();

		return surname != null ? surname.value1() : null;
	}

	public static void setSurnameUser(String email, String newSurname) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		int rowsUpdated = create.update(User.USER).set(User.USER.SURNAME, newSurname).where(User.USER.MAIL.eq(email))
				.execute();

		if (rowsUpdated == 0) {
			throw new SQLException(email);
		}
	}

	// --------- Username ---------

	public static String getUsernameUser(String email) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		@Nullable
		Record1<String> username = create.select(User.USER.USERNAME).from(User.USER).where(User.USER.MAIL.eq(email))
				.fetchOne();

		return username != null ? username.value1() : null;
	}

	public static void setUsernameUser(String email, String newUsername) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		int rowsUpdated = create.update(User.USER).set(User.USER.USERNAME, newUsername).where(User.USER.MAIL.eq(email))
				.execute();

		if (rowsUpdated == 0) {
			throw new SQLException(email);
		}
	}

	// --------- Birthday ---------

	public static String getBirthdayUser(String email) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		@Nullable
		Record1<String> dateOfBirth = create.select(User.USER.DATEOFBIRTH).from(User.USER)
				.where(User.USER.MAIL.eq(email)).fetchOne();

		return dateOfBirth != null ? dateOfBirth.value1() : null;
	}

	public static void setBirthdayUser(String email, String newBirthday) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		int rowsUpdated = create.update(User.USER).set(User.USER.DATEOFBIRTH, newBirthday)
				.where(User.USER.MAIL.eq(email)).execute();

		if (rowsUpdated == 0) {
			throw new SQLException(email);
		}
	}

	// --------- Address ---------

	public static String getAddressUser(String email) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		@Nullable
		Record1<String> address = create.select(User.USER.ADDRESS).from(User.USER).where(User.USER.MAIL.eq(email))
				.fetchOne();

		return address != null ? address.value1() : null;
	}

	public static void setAddressUser(String email, String newAddress) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		int rowsUpdated = create.update(User.USER).set(User.USER.ADDRESS, newAddress).where(User.USER.MAIL.eq(email))
				.execute();

		if (rowsUpdated == 0) {
			throw new SQLException(email);
		}
	}

	// --------- Town ---------

	public static String getTownUser(String email) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		@Nullable
		Record1<String> town = create.select(User.USER.TOWN).from(User.USER).where(User.USER.MAIL.eq(email)).fetchOne();

		return town != null ? town.value1() : null;
	}

	public static void setTownUser(String email, String newTown) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		int rowsUpdated = create.update(User.USER).set(User.USER.TOWN, newTown).where(User.USER.MAIL.eq(email))
				.execute();

		if (rowsUpdated == 0) {
			throw new SQLException(email);
		}
	}

	// --------- ZIPcode ---------

	public static String getCAPUser(String email) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		@Nullable
		Record1<String> cap = create.select(User.USER.CAP).from(User.USER).where(User.USER.MAIL.eq(email)).fetchOne();

		return cap != null ? cap.value1() : null;
	}

	public static void setCAPUser(String email, String newCAP) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		int rowsUpdated = create.update(User.USER).set(User.USER.CAP, newCAP).where(User.USER.MAIL.eq(email)).execute();

		if (rowsUpdated == 0) {
			throw new SQLException(email);
		}
	}

	// --------- Role ---------

	public static Integer getRoleUser(String email) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		@Nullable
		Record1<Integer> role = create.select(User.USER.ROLE).from(User.USER).where(User.USER.MAIL.eq(email))
				.fetchOne();

		return role != null ? role.value1() : null;
	}

	public static void setRoleUser(String email, Integer newRole) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		int rowsUpdated = create.update(User.USER).set(User.USER.ROLE, newRole).where(User.USER.MAIL.eq(email))
				.execute();

		if (rowsUpdated == 0) {
			throw new SQLException(email);
		}
	}

	// --------- IconUser ---------

	public static Integer getIconUser(String email) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		@Nullable
		Record1<Integer> iconNumber = create.select(User.USER.ICONNUMBER).from(User.USER)
				.where(User.USER.MAIL.eq(email)).fetchOne();

		return iconNumber != null ? iconNumber.value1() : null;
	}

	public static void setIconUser(String email, Integer newIconNumber) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		int rowsUpdated = create.update(User.USER).set(User.USER.ICONNUMBER, newIconNumber)
				.where(User.USER.MAIL.eq(email)).execute();

		if (rowsUpdated == 0) {
			throw new SQLException(email);
		}
	}

	public static void getMailUser() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.MAIL).from(User.USER).fetch();

		for (Record1<String> dbMail : result) {
			String mail = dbMail.value1();
			System.out.println("Mail: " + mail);
		}
	}

	/**
	 * Fetches all email addresses from the User table.
	 *
	 * @return List<String> containing all user emails.
	 * @throws SQLException if a database access error occurs.
	 */
	public static List<String> getAllUserEmails() throws SQLException {
		// Initialize the DSL context to interact with the database
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		// Fetch all emails from the User table
		Result<Record1<String>> result = create.select(User.USER.MAIL).from(User.USER).fetch();

		// Convert the result into a List<String>
		List<String> emails = new ArrayList<>();
		for (Record1<String> mail : result) {
			emails.add(mail.value1());
		}
		return emails;
	}

	/**
	 * Fetches all email addresses from the User table.
	 *
	 * @return List<String> containing all user emails.
	 * @throws SQLException if a database access error occurs.
	 */
	public static List<String> getAllUserPassword() throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		Result<Record1<String>> result = create.select(User.USER.PASSWORD).from(User.USER).fetch();

		List<String> passwords = new ArrayList<>();
		for (Record1<String> password : result) {
			passwords.add(password.value1());
		}
		return passwords;
	}

	public static List<String> getUserDetailsByEmail(String email) throws SQLException {
		DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

		@Nullable
		Record10<String, String, String, String, String, String, String, String, Integer, Integer> data = create
				.select(User.USER.NAME, User.USER.SURNAME, User.USER.USERNAME, User.USER.DATEOFBIRTH, User.USER.ADDRESS,
						User.USER.TOWN, User.USER.CAP, User.USER.MAIL, User.USER.ROLE, User.USER.ICONNUMBER)
				.from(User.USER).where(User.USER.MAIL.eq(email)) // Condition to filter by email
				.fetchOne();

		if (data != null) {
			List<String> userDetails = new ArrayList<>();
			userDetails.add(data.get(User.USER.NAME));
			userDetails.add(data.get(User.USER.SURNAME));
			userDetails.add(data.get(User.USER.USERNAME));
			userDetails.add(data.get(User.USER.DATEOFBIRTH));
			userDetails.add(data.get(User.USER.ADDRESS));
			userDetails.add(data.get(User.USER.TOWN));
			userDetails.add(data.get(User.USER.CAP));
			userDetails.add(data.get(User.USER.MAIL));
			userDetails.add(data.get(User.USER.ROLE).toString());
			userDetails.add(data.get(User.USER.ICONNUMBER).toString());

			return userDetails;
		} else {
			return new ArrayList<>();
		}
	}

	public static List<List<String>> getInfo(String departure) throws SQLException {
	    DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);

	    Result<Record7<String, String, String, String, String, String, String>> data = create
	            .select(Pullmantimetable.PULLMANTIMETABLE.LINE,
	                    Pullmantimetable.PULLMANTIMETABLE.DEPARTURETIME,
	                    Pullmantimetable.PULLMANTIMETABLE.ARRIVALPULLMANSTOP,
	                    Pullmantimetable.PULLMANTIMETABLE.ARRIVALTIME, 
	                    Pullmantimetable.PULLMANTIMETABLE.NEXTSTOP, 
	                    Pullmantimetable.PULLMANTIMETABLE.TIMESTOP,
	                    Pullmantimetable.PULLMANTIMETABLE.TYPE)
	            .from(Pullmantimetable.PULLMANTIMETABLE)
	            .where(Pullmantimetable.PULLMANTIMETABLE.DEPARTUREPULLMANSTOP.eq(departure))
	            .fetch();

	    List<List<String>> allInfo = new ArrayList<>();
	    for (Record7<String, String, String, String, String, String, String> record : data) {
	        List<String> info = new ArrayList<>();
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.LINE));
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.DEPARTURETIME));
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.ARRIVALPULLMANSTOP));
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.ARRIVALTIME));
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.NEXTSTOP));
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.TIMESTOP));
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.TYPE));
	        allInfo.add(info);
	    }
	    return allInfo;
	}
	
	public static List<List<String>> getInfo1(String departuretime) throws SQLException {
	    DSLContext create = Utility.dslContext(ConstantDB.DB_URL_PUBLIC_TRANSPORTATION);

	    Result<Record7<String, String, String, String, String, String, String>> data = create
	            .select(Pullmantimetable.PULLMANTIMETABLE.LINE,
	                    Pullmantimetable.PULLMANTIMETABLE.ARRIVALPULLMANSTOP,
	                    Pullmantimetable.PULLMANTIMETABLE.ARRIVALTIME, 
	                    Pullmantimetable.PULLMANTIMETABLE.NEXTSTOP, 
	                    Pullmantimetable.PULLMANTIMETABLE.TIMESTOP,
	                    Pullmantimetable.PULLMANTIMETABLE.TYPE,
	            		Pullmantimetable.PULLMANTIMETABLE.DEPARTUREPULLMANSTOP)
	            .from(Pullmantimetable.PULLMANTIMETABLE)
	            .where(Pullmantimetable.PULLMANTIMETABLE.DEPARTURETIME.eq(departuretime)).and(Pullmantimetable.PULLMANTIMETABLE.DEPARTUREPULLMANSTOP.eq(LineController.selectedItem))
	            .fetch();

	    List<List<String>> allInfo = new ArrayList<>();
	    for (Record7<String, String, String, String, String, String, String> record : data) {
	        List<String> info = new ArrayList<>();
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.LINE));
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.ARRIVALPULLMANSTOP));
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.ARRIVALTIME));
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.NEXTSTOP));
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.TIMESTOP));
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.TYPE));
	        info.add(record.get(Pullmantimetable.PULLMANTIMETABLE.DEPARTUREPULLMANSTOP));
	        allInfo.add(info);
	    }
	    return allInfo;
	}

	public static void deleteAll(DSLContext create, List<String> myList) throws IOException {
		ArrayList<String> modifiedList = new ArrayList<>();

		for (String item : myList) {
			String modified = item.replace("json/", "").replace(".json", "");
			modifiedList.add(modified);
		}

		for (String tableName : modifiedList) {
			if (tableName.equals(ConstantString.COMPANY)) {
				create.deleteFrom(Company.COMPANY).execute();
				InsertDataDB.company(create);
			}
			if (tableName.equals(ConstantString.FUNICULAR_STATION)) {
				create.deleteFrom(Funicularstation.FUNICULARSTATION).execute();
				InsertDataDB.funicularStation(create);
			}
			if (tableName.equals(ConstantString.TRAIN_STATION)) {
				create.deleteFrom(Trainstation.TRAINSTATION).execute();
				InsertDataDB.trainStation(create);
			}
			if (tableName.equals(ConstantString.TRAM_STOP)) {
				create.deleteFrom(Tramstop.TRAMSTOP).execute();
				InsertDataDB.tramStop(create);
			}
			if (tableName.equals(ConstantString.PULLMAN_STOP)) {
				create.deleteFrom(Pullmanstop.PULLMANSTOP).execute();
				InsertDataDB.pullmanStop(create);
			}
			if (tableName.equals(ConstantString.FUNICULAR_TIMETABLE)) {
				create.deleteFrom(Funiculartimetable.FUNICULARTIMETABLE).execute();
				InsertDataDB.funicularTimetable(create);
			}
			if (tableName.equals(ConstantString.TRAM_TIMETABLE)) {
				create.deleteFrom(Tramtimetable.TRAMTIMETABLE).execute();
				InsertDataDB.tramTimetable(create);
			}
			if (tableName.equals(ConstantString.TRAIN_TIMETABLE)) {
				create.deleteFrom(Traintimetable.TRAINTIMETABLE).execute();
				InsertDataDB.trainTimetable(create);
			}
			if (tableName.equals(ConstantString.PULLMAN_TIMETABLE)) {
				create.deleteFrom(Pullmantimetable.PULLMANTIMETABLE).execute();
				InsertDataDB.pullmanTimetable(create);
			}
		}
		System.out.println("Data updated");
	}

	public static void getDataFromDatabaseUsers(String database) throws SQLException {
		DSLContext create = Utility.dslContext(database);
		@NotNull
		Result<Record> result = create.select().from(User.USER).fetch();
		columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
		data = result.stream().map(record -> record.intoArray()).toArray(Object[][]::new);
	}

	public static void getDataFromCompany(String database) throws SQLException {
		DSLContext create = Utility.dslContext(database);
		@NotNull
		Result<Record> result = create.select().from(Company.COMPANY).fetch();
		columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
		data = result.stream().map(record -> record.intoArray()).toArray(Object[][]::new);
	}

	public static void getDataFromFunicularStation(String database) throws SQLException {
		DSLContext create = Utility.dslContext(database);
		@NotNull
		Result<Record> result = create.select().from(Funicularstation.FUNICULARSTATION).fetch();
		columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
		data = result.stream().map(record -> record.intoArray()).toArray(Object[][]::new);
	}

	public static void getDataFromFunicularTimetable(String database) throws SQLException {
		DSLContext create = Utility.dslContext(database);
		@NotNull
		Result<Record> result = create.select().from(Funiculartimetable.FUNICULARTIMETABLE).fetch();
		columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
		data = result.stream().map(record -> record.intoArray()).toArray(Object[][]::new);
	}

	public static void getDataFromPullmanStop(String database) throws SQLException {
		DSLContext create = Utility.dslContext(database);
		@NotNull
		Result<Record> result = create.select().from(Pullmanstop.PULLMANSTOP).fetch();
		columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
		data = result.stream().map(record -> record.intoArray()).toArray(Object[][]::new);
	}

	public static void getDataFromPullmanTimetable(String database) throws SQLException {
		DSLContext create = Utility.dslContext(database);
		@NotNull
		Result<Record> result = create.select().from(Pullmantimetable.PULLMANTIMETABLE).fetch();
		columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
		data = result.stream().map(record -> record.intoArray()).toArray(Object[][]::new);
	}

	public static void getDataFromTrainStation(String database) throws SQLException {
		DSLContext create = Utility.dslContext(database);
		@NotNull
		Result<Record> result = create.select().from(Trainstation.TRAINSTATION).fetch();
		columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
		data = result.stream().map(record -> record.intoArray()).toArray(Object[][]::new);
	}

	public static void getDataFromTrainTimetable(String database) throws SQLException {
		DSLContext create = Utility.dslContext(database);
		@NotNull
		Result<Record> result = create.select().from(Traintimetable.TRAINTIMETABLE).fetch();
		columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
		data = result.stream().map(record -> record.intoArray()).toArray(Object[][]::new);
	}

	public static void getDataFromTramStop(String database) throws SQLException {
		DSLContext create = Utility.dslContext(database);
		@NotNull
		Result<Record> result = create.select().from(Tramstop.TRAMSTOP).fetch();
		columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
		data = result.stream().map(record -> record.intoArray()).toArray(Object[][]::new);
	}

	public static void getDataFromTramTimetable(String database) throws SQLException {
		DSLContext create = Utility.dslContext(database);
		@NotNull
		Result<Record> result = create.select().from(Tramtimetable.TRAMTIMETABLE).fetch();
		columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
		data = result.stream().map(record -> record.intoArray()).toArray(Object[][]::new);
	}
}
