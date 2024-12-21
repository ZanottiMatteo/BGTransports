package bgtransport.model;

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
import org.jooq.Result;
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

public class UserQueryDB {

	public static String[] columnNames;
	public static Object[][] data;

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
