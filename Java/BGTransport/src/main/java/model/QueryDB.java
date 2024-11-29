package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Result;
import org.jxmapviewer.viewer.GeoPosition;

import transportation.jooq.generated.tables.FunicularStation;
import transportation.jooq.generated.tables.PullmanStop;
import transportation.jooq.generated.tables.TrainStation;
import transportation.jooq.generated.tables.TramStop;
import user.jooq.generated.tables.User;

public class QueryDB {

	public static List<String> getLatFunicularStation() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> latitude = new ArrayList();
		
		@NotNull
		Result<Record1<String>> result = create.select(FunicularStation.FUNICULAR_STATION.LAT)
				.from(FunicularStation.FUNICULAR_STATION).fetch();

		for (Record1<String> record : result) {
			String lat = record.value1();
			latitude.add(lat);
			System.out.println("Latitude: " + lat);
		}
		return latitude;
	}

	public static String getLatFunicularStation(int index) throws SQLException {
	    // Creazione del contesto DSL
	    DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

	    // Esegui la query per ottenere tutte le latitudini
	    @NotNull
	    Result<Record1<String>> result = create.select(FunicularStation.FUNICULAR_STATION.LAT)
	            .from(FunicularStation.FUNICULAR_STATION)
	            .fetch();

	    // Controllo che l'indice sia valido
	    if (index < 0 || index >= result.size()) {
	        throw new IllegalArgumentException("Indice non valido: " + index);
	    }

	    // Recupero il valore corrispondente all'indice
	    String lat = result.get(index).value1();
	    System.out.println("Latitude (indice " + index + "): " + lat);

	    return lat;
	}
	
	public static List<String> getLonFunicularStation() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);
		List<String> longitude = new ArrayList();
		
		@NotNull
		Result<Record1<String>> result = create.select(FunicularStation.FUNICULAR_STATION.LON)
				.from(FunicularStation.FUNICULAR_STATION).fetch();

		for (Record1<String> record : result) {
			String lon = record.value1();
			longitude.add(lon);
			System.out.println("Longitude: " + lon);
		}
		return longitude;
	}
	
	public static String getLongFunicularStation(int index) throws SQLException {
	    // Creazione del contesto DSL
	    DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

	    // Esegui la query per ottenere tutte le latitudini
	    @NotNull
	    Result<Record1<String>> result = create.select(FunicularStation.FUNICULAR_STATION.LON)
	            .from(FunicularStation.FUNICULAR_STATION)
	            .fetch();

	    // Controllo che l'indice sia valido
	    if (index < 0 || index >= result.size()) {
	        throw new IllegalArgumentException("Indice non valido: " + index);
	    }

	    // Recupero il valore corrispondente all'indice
	    String lon = result.get(index).value1();
	    System.out.println("Latitude (indice " + index + "): " + lon);
	    return lon;
	}
	
	public static List<GeoPosition> getFunicularGeopositions() throws SQLException {
	    DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);
	    List<GeoPosition> geopositions = new ArrayList<>();

	    @NotNull
	    Result<Record2<String, String>> result = create.select(FunicularStation.FUNICULAR_STATION.LAT, FunicularStation.FUNICULAR_STATION.LON)
	            .from(FunicularStation.FUNICULAR_STATION)
	            .fetch();

	    for (Record2<String, String> record : result) {
	        double lat = Double.parseDouble(record.value1());
	        double lon = Double.parseDouble(record.value2());
	        System.out.println("Lat: " + lat + "Long" + lon);
	        geopositions.add(new GeoPosition(lat, lon));
	    }

	    return geopositions;
	}

	public static void getLatPullmanStop() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(PullmanStop.PULLMAN_STOP.LAT).from(PullmanStop.PULLMAN_STOP)
				.fetch();

		for (Record1<String> record : result) {
			String lat = record.value1();
			System.out.println("Latitude: " + lat);
		}
	}

	public static void getLonPullmanStop() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(PullmanStop.PULLMAN_STOP.LON).from(PullmanStop.PULLMAN_STOP)
				.fetch();

		for (Record1<String> record : result) {
			String lon = record.value1();
			System.out.println("Longitude: " + lon);
		}
	}
	
	public static List<GeoPosition> getPullmanGeopositions() throws SQLException {
	    DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);
	    List<GeoPosition> geopositions = new ArrayList<>();

	    @NotNull
	    Result<Record2<String, String>> result = create.select(PullmanStop.PULLMAN_STOP.LAT, PullmanStop.PULLMAN_STOP.LON)
	            .from(PullmanStop.PULLMAN_STOP)
	            .fetch();

	    for (Record2<String, String> record : result) {
	        double lat = Double.parseDouble(record.value1());
	        double lon = Double.parseDouble(record.value2());
	        GeoPosition geoPosition = new GeoPosition(lat, lon);
	        geopositions.add(geoPosition);
	        System.out.println("Latitude: " + lat + ", Longitude: " + lon);
	    }

	    return geopositions;
	}

	public static void getLatTrainStation() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(TrainStation.TRAIN_STATION.LAT).from(TrainStation.TRAIN_STATION)
				.fetch();

		for (Record1<String> record : result) {
			String lat = record.value1();
			System.out.println("Latitude: " + lat);
		}
	}

	public static void getLonTrainStation() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(TrainStation.TRAIN_STATION.LON).from(TrainStation.TRAIN_STATION)
				.fetch();

		for (Record1<String> record : result) {
			String lon = record.value1();
			System.out.println("Longitude: " + lon);
		}
	}

	public static List<GeoPosition> getTrainGeopositions() throws SQLException {
	    DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);
	    List<GeoPosition> geopositions = new ArrayList<>();

	    @NotNull
	    Result<Record2<String, String>> result = create.select(TrainStation.TRAIN_STATION.LAT, TrainStation.TRAIN_STATION.LON)
	            .from(TrainStation.TRAIN_STATION)
	            .fetch();

	    for (Record2<String, String> record : result) {
	        double lat = Double.parseDouble(record.value1());
	        double lon = Double.parseDouble(record.value2());
	        GeoPosition geoPosition = new GeoPosition(lat, lon);
	        geopositions.add(geoPosition);
	        System.out.println("Latitude: " + lat + ", Longitude: " + lon);
	    }

	    return geopositions;
	}
	
	public static void getLatTramStop() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(TramStop.TRAM_STOP.LAT).from(TramStop.TRAM_STOP).fetch();

		for (Record1<String> record : result) {
			String lat = record.value1();
			System.out.println("Latitude: " + lat);
		}
	}

	public static void getLonTramStop() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(TramStop.TRAM_STOP.LON).from(TramStop.TRAM_STOP).fetch();

		for (Record1<String> record : result) {
			String lon = record.value1();
			System.out.println("Longitude: " + lon);
		}
	}
	
	public static List<GeoPosition> getTramGeopositions() throws SQLException {
	    DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);
	    List<GeoPosition> geopositions = new ArrayList<>();

	    @NotNull
	    Result<Record2<String, String>> result = create.select(TramStop.TRAM_STOP.LAT, TramStop.TRAM_STOP.LON)
	            .from(TramStop.TRAM_STOP)
	            .fetch();

	    for (Record2<String, String> record : result) {
	        double lat = Double.parseDouble(record.value1());
	        double lon = Double.parseDouble(record.value2());
	        GeoPosition geoPosition = new GeoPosition(lat, lon);
	        geopositions.add(geoPosition);
	        System.out.println("Latitude: " + lat + ", Longitude: " + lon);
	    }

	    return geopositions;
	}


	public static void getNameUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.NAME).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String name = record.value1();
			System.out.println("Name: " + name);
		}
	}

	public static void getSurnameUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.SURNAME).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String surname = record.value1();
			System.out.println("Surname: " + surname);
		}
	}

	public static void getUsernameUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.USERNAME).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String username = record.value1();
			System.out.println("Username: " + username);
		}
	}

	public static void getBirthdayUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.DATE_OF_BIRTH).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String birthday = record.value1();
			System.out.println("Birthday: " + birthday);
		}
	}

	public static void getAddressUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.ADDRESS).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String address = record.value1();
			System.out.println("Address: " + address);
		}
	}

	public static void getTownUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.TOWN).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String town = record.value1();
			System.out.println("Town: " + town);
		}
	}

	public static void getCAPUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.CAP).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String cap = record.value1();
			System.out.println("CAP: " + cap);
		}
	}

	public static void getMailUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.MAIL).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String mail = record.value1();
			System.out.println("Mail: " + mail);
		}
	}

	public static void getRoleUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<Integer>> result = create.select(User.USER.ROLE).from(User.USER).fetch();

		for (Record1<Integer> record : result) {
			Integer role = record.value1();
			System.out.println("Role: " + role);
		}
	}

}
