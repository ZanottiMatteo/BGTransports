package model;

import java.sql.SQLException;

import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import transportation.jooq.generated.tables.FunicularStation;
import transportation.jooq.generated.tables.PullmanStop;
import transportation.jooq.generated.tables.TrainStation;
import transportation.jooq.generated.tables.TramStop;
import user.jooq.generated.tables.User;

public class QueryDB {

	public static void getLat_funicularStation() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(FunicularStation.FUNICULAR_STATION.LAT)
				.from(FunicularStation.FUNICULAR_STATION).fetch();

		for (Record1<String> record : result) {
			String lat = record.value1();
			System.out.println("Latitude: " + lat);
		}
	}

	public static void getLon_funicularStation() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(FunicularStation.FUNICULAR_STATION.LON)
				.from(FunicularStation.FUNICULAR_STATION).fetch();

		for (Record1<String> record : result) {
			String lon = record.value1();
			System.out.println("Longitude: " + lon);
		}
	}

	public static void getLat_pullmanStop() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(PullmanStop.PULLMAN_STOP.LAT).from(PullmanStop.PULLMAN_STOP)
				.fetch();

		for (Record1<String> record : result) {
			String lat = record.value1();
			System.out.println("Latitude: " + lat);
		}
	}

	public static void getLon_pullmanStop() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(PullmanStop.PULLMAN_STOP.LON).from(PullmanStop.PULLMAN_STOP)
				.fetch();

		for (Record1<String> record : result) {
			String lon = record.value1();
			System.out.println("Longitude: " + lon);
		}
	}

	public static void getLat_trainStation() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(TrainStation.TRAIN_STATION.LAT).from(TrainStation.TRAIN_STATION)
				.fetch();

		for (Record1<String> record : result) {
			String lat = record.value1();
			System.out.println("Latitude: " + lat);
		}
	}

	public static void getLon_trainStation() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(TrainStation.TRAIN_STATION.LON).from(TrainStation.TRAIN_STATION)
				.fetch();

		for (Record1<String> record : result) {
			String lon = record.value1();
			System.out.println("Longitude: " + lon);
		}
	}

	public static void getLat_tramStop() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(TramStop.TRAM_STOP.LAT).from(TramStop.TRAM_STOP).fetch();

		for (Record1<String> record : result) {
			String lat = record.value1();
			System.out.println("Latitude: " + lat);
		}
	}

	public static void getLon_tramStop() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_PUBLIC_TRANSPORTATION);

		@NotNull
		Result<Record1<String>> result = create.select(TramStop.TRAM_STOP.LON).from(TramStop.TRAM_STOP).fetch();

		for (Record1<String> record : result) {
			String lon = record.value1();
			System.out.println("Longitude: " + lon);
		}
	}

	public static void getName_user() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.NAME).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String name = record.value1();
			System.out.println("Name: " + name);
		}
	}

	public static void getSurname_user() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.SURNAME).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String surname = record.value1();
			System.out.println("Surname: " + surname);
		}
	}

	public static void getUsername_user() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.USERNAME).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String username = record.value1();
			System.out.println("Username: " + username);
		}
	}

	public static void getBirthday_user() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.DATE_OF_BIRTH).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String birthday = record.value1();
			System.out.println("Birthday: " + birthday);
		}
	}

	public static void getAddress_user() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.ADDRESS).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String address = record.value1();
			System.out.println("Address: " + address);
		}
	}

	public static void getTown_user() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.TOWN).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String town = record.value1();
			System.out.println("Town: " + town);
		}
	}

	public static void getCAP_user() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.CAP).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String cap = record.value1();
			System.out.println("CAP: " + cap);
		}
	}

	public static void getMail_user() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<String>> result = create.select(User.USER.MAIL).from(User.USER).fetch();

		for (Record1<String> record : result) {
			String mail = record.value1();
			System.out.println("Mail: " + mail);
		}
	}

	public static void getRole_user() throws SQLException {
		DSLContext create = ControlDB.DSLContext(Constant.DB_URL_USERS);

		@NotNull
		Result<Record1<Integer>> result = create.select(User.USER.ROLE).from(User.USER).fetch();

		for (Record1<Integer> record : result) {
			Integer role = record.value1();
			System.out.println("Role: " + role);
		}
	}

}
