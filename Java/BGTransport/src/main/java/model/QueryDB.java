package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Record9;
import org.jooq.Result;
import org.jxmapviewer.viewer.GeoPosition;

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

	public static List<String> getLatFunicularStation() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);
		List<String> latitude = new ArrayList<String>();
		
		@NotNull
		Result<Record1<String>> result = create.select(Funicularstation.FUNICULARSTATION.LAT)
				.from(Funicularstation.FUNICULARSTATION).fetch();

		for (Record1<String> record : result) {
			String lat = record.value1();
			latitude.add(lat);
			System.out.println("Latitude: " + lat);
		}
		return latitude;
	}

	public static String getLatFunicularStation(int index) throws SQLException {
	    // Creazione del contesto DSL
	    DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);

	    // Esegui la query per ottenere tutte le latitudini
	    @NotNull
	    Result<Record1<String>> result = create.select(Funicularstation.FUNICULARSTATION.LAT)
	            .from(Funicularstation.FUNICULARSTATION)
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
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);
		List<String> longitude = new ArrayList<String>();
		
		@NotNull
		Result<Record1<String>> result = create.select(Funicularstation.FUNICULARSTATION.LON)
				.from(Funicularstation.FUNICULARSTATION).fetch();

		for (Record1<String> record : result) {
			String lon = record.value1();
			longitude.add(lon);
			System.out.println("Longitude: " + lon);
		}
		return longitude;
	}
	
	public static String getLongFunicularStation(int index) throws SQLException {
	    // Creazione del contesto DSL
	    DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);

	    // Esegui la query per ottenere tutte le latitudini
	    @NotNull
	    Result<Record1<String>> result = create.select(Funicularstation.FUNICULARSTATION.LON)
	            .from(Funicularstation.FUNICULARSTATION)
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
	    DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);
	    List<GeoPosition> geopositions = new ArrayList<>();

	    @NotNull
	    Result<Record2<String, String>> result = create.select(Funicularstation.FUNICULARSTATION.LAT, Funicularstation.FUNICULARSTATION.LON)
	            .from(Funicularstation.FUNICULARSTATION)
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
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);

		@NotNull
		Result<Record1<String>> result = create.select(Pullmanstop.PULLMANSTOP.LAT).from(Pullmanstop.PULLMANSTOP)
				.fetch();

		for (Record1<String> record : result) {
			String lat = record.value1();
			System.out.println("Latitude: " + lat);
		}
	}

	public static void getLonPullmanStop() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);

		@NotNull
		Result<Record1<String>> result = create.select(Pullmanstop.PULLMANSTOP.LON).from(Pullmanstop.PULLMANSTOP)
				.fetch();

		for (Record1<String> record : result) {
			String lon = record.value1();
			System.out.println("Longitude: " + lon);
		}
	}
	
	public static List<GeoPosition> getPullmanGeopositions() throws SQLException {
	    DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);
	    List<GeoPosition> geopositions = new ArrayList<>();

	    @NotNull
	    Result<Record2<String, String>> result = create.select(Pullmanstop.PULLMANSTOP.LAT, Pullmanstop.PULLMANSTOP.LON)
	            .from(Pullmanstop.PULLMANSTOP)
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
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);

		@NotNull
		Result<Record1<String>> result = create.select(Trainstation.TRAINSTATION.LAT).from(Trainstation.TRAINSTATION)
				.fetch();

		for (Record1<String> record : result) {
			String lat = record.value1();
			System.out.println("Latitude: " + lat);
		}
	}

	public static void getLonTrainStation() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);

		@NotNull
		Result<Record1<String>> result = create.select(Trainstation.TRAINSTATION.LON).from(Trainstation.TRAINSTATION)
				.fetch();

		for (Record1<String> record : result) {
			String lon = record.value1();
			System.out.println("Longitude: " + lon);
		}
	}

	public static List<GeoPosition> getTrainGeopositions() throws SQLException {
	    DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);
	    List<GeoPosition> geopositions = new ArrayList<>();

	    @NotNull
	    Result<Record2<String, String>> result = create.select(Trainstation.TRAINSTATION.LAT, Trainstation.TRAINSTATION.LON)
	            .from(Trainstation.TRAINSTATION)
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
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);

		@NotNull
		Result<Record1<String>> result = create.select(Tramstop.TRAMSTOP.LAT).from(Tramstop.TRAMSTOP).fetch();

		for (Record1<String> record : result) {
			String lat = record.value1();
			System.out.println("Latitude: " + lat);
		}
	}

	public static void getLonTramStop() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);

		@NotNull
		Result<Record1<String>> result = create.select(Tramstop.TRAMSTOP.LON).from(Tramstop.TRAMSTOP).fetch();

		for (Record1<String> record : result) {
			String lon = record.value1();
			System.out.println("Longitude: " + lon);
		}
	}
	
	public static List<GeoPosition> getTramGeopositions() throws SQLException {
	    DSLContext create = ControlDB.DSLContext(Constant.DBUrlPublicTransportation);
	    List<GeoPosition> geopositions = new ArrayList<>();

	    @NotNull
	    Result<Record2<String, String>> result = create.select(Tramstop.TRAMSTOP.LAT, Tramstop.TRAMSTOP.LON)
	            .from(Tramstop.TRAMSTOP)
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
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlUsers);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.NAME).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String name = record.value1();
			System.out.println("Name: " + name);
		}
	}

	public static void getSurnameUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlUsers);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.SURNAME).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String surname = record.value1();
			System.out.println("Surname: " + surname);
		}
	}

	public static void getUsernameUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlUsers);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.USERNAME).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String username = record.value1();
			System.out.println("Username: " + username);
		}
	}

	public static void getBirthdayUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlUsers);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.DATEOFBIRTH).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String birthday = record.value1();
			System.out.println("Birthday: " + birthday);
		}
	}

	public static void getAddressUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlUsers);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.ADDRESS).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String address = record.value1();
			System.out.println("Address: " + address);
		}
	}

	public static void getTownUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlUsers);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.TOWN).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String town = record.value1();
			System.out.println("Town: " + town);
		}
	}

	public static void getCAPUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlUsers);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.CAP).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String cap = record.value1();
			System.out.println("CAP: " + cap);
		}
	}

	public static void getMailUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlUsers);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.MAIL).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String mail = record.value1();
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
        DSLContext create = ControlDB.DSLContext(Constant.DBUrlUsers);

        // Fetch all emails from the User table
        Result<Record1<String>> result = create.select(User.USER.MAIL)
                                               .from(User.USER)
                                               .fetch();

        // Convert the result into a List<String>
        List<String> emails = new ArrayList<>();
        for (Record1<String> record : result) {
            emails.add(record.value1());
        }

        // Return the list of emails
        return emails;
    }
    
    /**
     * Fetches all email addresses from the User table.
     *
     * @return List<String> containing all user emails.
     * @throws SQLException if a database access error occurs.
     */
    public static List<String> getAllUserPassword() throws SQLException {
        // Initialize the DSL context to interact with the database
        DSLContext create = ControlDB.DSLContext(Constant.DBUrlUsers);

        // Fetch all emails from the User table
        Result<Record1<String>> result = create.select(User.USER.PASSWORD)
                                               .from(User.USER)
                                               .fetch();

        // Convert the result into a List<String>
        List<String> passwords = new ArrayList<>();
        for (Record1<String> record : result) {
        	passwords.add(record.value1());
        }

        // Return the list of emails
        return passwords;
    }

	public static void getRoleUser() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DBUrlUsers);

		@NotNull
		Result<Record1<Integer>> result = create.select(User.USER.ROLE).from(User.USER).fetch();

		for (Record1<Integer> record : result) {
			Integer role = record.value1();
			System.out.println("Role: " + role);
		}
	}

	
	public static List<String> getUserDetailsByEmail(String email) throws SQLException {
        DSLContext create = ControlDB.DSLContext(Constant.DBUrlUsers);

        // Fetch the user record with the specified email
        @Nullable Record9<String, String, String, String, String, String, String, String, Integer> record = create.select(
                User.USER.NAME,
                User.USER.SURNAME,
                User.USER.USERNAME,
                User.USER.DATEOFBIRTH,
                User.USER.ADDRESS,
                User.USER.TOWN,
                User.USER.CAP,
                User.USER.MAIL,
                User.USER.ROLE
        ).from(User.USER)
         .where(User.USER.MAIL.eq(email)) // Condition to filter by email
         .fetchOne();

        if (record != null) {
            // Create a list of user details
            List<String> userDetails = new ArrayList<>();
            userDetails.add(record.get(User.USER.NAME));
            userDetails.add(record.get(User.USER.SURNAME));
            userDetails.add(record.get(User.USER.USERNAME));
            userDetails.add(record.get(User.USER.DATEOFBIRTH));
            userDetails.add(record.get(User.USER.ADDRESS));
            userDetails.add(record.get(User.USER.TOWN));
            userDetails.add(record.get(User.USER.CAP));
            userDetails.add(record.get(User.USER.MAIL));
            userDetails.add(record.get(User.USER.ROLE).toString());

            return userDetails; // Return the list
        } else {
            // Return an empty list if no user is found
            return new ArrayList<>();
        }
    }
	
	public static void deleteAll(DSLContext ctx, ArrayList<String> myList) throws IOException {
		ArrayList<String> modifiedList = new ArrayList<>();

		for (String item : myList) {
			String modified = item.replace("json/", "").replace(".json", "");
			modifiedList.add(modified);
		}

		for (String tableName : modifiedList) {
			if (tableName.equals(Constant.company)) {
				ctx.deleteFrom(Company.COMPANY).execute();
				InsertDataDB.company(ctx);
			}
			if (tableName.equals(Constant.funicularStation)) {
				ctx.deleteFrom(Funicularstation.FUNICULARSTATION).execute();
				InsertDataDB.funicular_station(ctx);
			}
			if (tableName.equals(Constant.trainStation)) {
				ctx.deleteFrom(Trainstation.TRAINSTATION).execute();
				InsertDataDB.train_station(ctx);
			}
			if (tableName.equals(Constant.tramStop)) {
				ctx.deleteFrom(Tramstop.TRAMSTOP).execute();
				InsertDataDB.tram_stop(ctx);
			}
			if (tableName.equals(Constant.pullmanStop)) {
				ctx.deleteFrom(Pullmanstop.PULLMANSTOP).execute();
				InsertDataDB.pullman_stop(ctx);
			}
			if (tableName.equals(Constant.funicularTimetable)) {
				ctx.deleteFrom(Funiculartimetable.FUNICULARTIMETABLE).execute();
				InsertDataDB.funicularTimetable(ctx);
			}
			if (tableName.equals(Constant.tramTimetable)) {
				ctx.deleteFrom(Tramtimetable.TRAMTIMETABLE).execute();
				InsertDataDB.tramTimetable(ctx);
			}
			if (tableName.equals(Constant.trainTimetable)) {
				ctx.deleteFrom(Traintimetable.TRAINTIMETABLE).execute();
				InsertDataDB.trainTimetable(ctx);
			}
			if (tableName.equals(Constant.pullmanTimetable)) {
				ctx.deleteFrom(Pullmantimetable.PULLMANTIMETABLE).execute();
				InsertDataDB.pullmanTimetable(ctx);
			}
		}
		
		System.out.println("Data updated");
	}
}

