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

/**
 * This class provides methods for querying and updating user information in the database.
 * The information includes name, surname, username, birthday, address, and town associated with a user's email.
 */
public class UserQueryDB {

    public static String[] columnNames;
    public static Object[][] data;
    
    /**
     * Retrieves the name of the user with the given email.
     * 
     * @param email the email of the user whose name is to be fetched
     * @return the name of the user, or null if the user is not found
     * @throws SQLException if a database access error occurs
     */
    public static String getNameUser(String email) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        @Nullable
        Record1<String> mail = create.select(User.USER.NAME).from(User.USER).where(User.USER.MAIL.eq(email)).fetchOne();

        return mail != null ? mail.value1() : null;
    }

    /**
     * Updates the name of the user with the given email.
     * 
     * @param email the email of the user whose name is to be updated
     * @param newName the new name to be set for the user
     * @throws SQLException if a database access error occurs, or if the user is not found
     */
    public static void setNameUser(String email, String newName) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        int rowsUpdated = create.update(User.USER).set(User.USER.NAME, newName).where(User.USER.MAIL.eq(email))
                .execute();

        if (rowsUpdated == 0) {
            throw new SQLException(email);
        }
    }

    /**
     * Retrieves the surname of the user with the given email.
     * 
     * @param email the email of the user whose surname is to be fetched
     * @return the surname of the user, or null if the user is not found
     * @throws SQLException if a database access error occurs
     */
    public static String getSurnameUser(String email) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        @Nullable
        Record1<String> surname = create.select(User.USER.SURNAME).from(User.USER).where(User.USER.MAIL.eq(email))
                .fetchOne();

        return surname != null ? surname.value1() : null;
    }

    /**
     * Updates the surname of the user with the given email.
     * 
     * @param email the email of the user whose surname is to be updated
     * @param newSurname the new surname to be set for the user
     * @throws SQLException if a database access error occurs, or if the user is not found
     */
    public static void setSurnameUser(String email, String newSurname) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        int rowsUpdated = create.update(User.USER).set(User.USER.SURNAME, newSurname).where(User.USER.MAIL.eq(email))
                .execute();

        if (rowsUpdated == 0) {
            throw new SQLException(email);
        }
    }

    /**
     * Retrieves the username of the user with the given email.
     * 
     * @param email the email of the user whose username is to be fetched
     * @return the username of the user, or null if the user is not found
     * @throws SQLException if a database access error occurs
     */
    public static String getUsernameUser(String email) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        @Nullable
        Record1<String> username = create.select(User.USER.USERNAME).from(User.USER).where(User.USER.MAIL.eq(email))
                .fetchOne();

        return username != null ? username.value1() : null;
    }

    /**
     * Updates the username of the user with the given email.
     * 
     * @param email the email of the user whose username is to be updated
     * @param newUsername the new username to be set for the user
     * @throws SQLException if a database access error occurs, or if the user is not found
     */
    public static void setUsernameUser(String email, String newUsername) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        int rowsUpdated = create.update(User.USER).set(User.USER.USERNAME, newUsername).where(User.USER.MAIL.eq(email))
                .execute();

        if (rowsUpdated == 0) {
            throw new SQLException(email);
        }
    }

    /**
     * Retrieves the birthday of the user with the given email.
     * 
     * @param email the email of the user whose birthday is to be fetched
     * @return the birthday of the user, or null if the user is not found
     * @throws SQLException if a database access error occurs
     */
    public static String getBirthdayUser(String email) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        @Nullable
        Record1<String> dateOfBirth = create.select(User.USER.DATEOFBIRTH).from(User.USER)
                .where(User.USER.MAIL.eq(email)).fetchOne();

        return dateOfBirth != null ? dateOfBirth.value1() : null;
    }

    /**
     * Updates the birthday of the user with the given email.
     * 
     * @param email the email of the user whose birthday is to be updated
     * @param newBirthday the new birthday to be set for the user
     * @throws SQLException if a database access error occurs, or if the user is not found
     */
    public static void setBirthdayUser(String email, String newBirthday) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        int rowsUpdated = create.update(User.USER).set(User.USER.DATEOFBIRTH, newBirthday)
                .where(User.USER.MAIL.eq(email)).execute();

        if (rowsUpdated == 0) {
            throw new SQLException(email);
        }
    }

    /**
     * Retrieves the address of the user with the given email.
     * 
     * @param email the email of the user whose address is to be fetched
     * @return the address of the user, or null if the user is not found
     * @throws SQLException if a database access error occurs
     */
    public static String getAddressUser(String email) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        @Nullable
        Record1<String> address = create.select(User.USER.ADDRESS).from(User.USER).where(User.USER.MAIL.eq(email))
                .fetchOne();

        return address != null ? address.value1() : null;
    }

    /**
     * Updates the address of the user with the given email.
     * 
     * @param email the email of the user whose address is to be updated
     * @param newAddress the new address to be set for the user
     * @throws SQLException if a database access error occurs, or if the user is not found
     */
    public static void setAddressUser(String email, String newAddress) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        int rowsUpdated = create.update(User.USER).set(User.USER.ADDRESS, newAddress).where(User.USER.MAIL.eq(email))
                .execute();

        if (rowsUpdated == 0) {
            throw new SQLException(email);
        }
    }

    /**
     * Retrieves the town of the user with the given email.
     * 
     * @param email the email of the user whose town is to be fetched
     * @return the town of the user, or null if the user is not found
     * @throws SQLException if a database access error occurs
     */
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

    /**
     * Fetches the postal code (CAP) for the user with the specified email.
     *
     * @param email The email address of the user.
     * @return The user's postal code (CAP), or null if not found.
     * @throws SQLException if a database access error occurs.
     */
    public static String getCAPUser(String email) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        @Nullable
        Record1<String> cap = create.select(User.USER.CAP).from(User.USER).where(User.USER.MAIL.eq(email)).fetchOne();

        return cap != null ? cap.value1() : null;
    }

    /**
     * Updates the postal code (CAP) for the user with the specified email.
     *
     * @param email The email address of the user.
     * @param newCAP The new postal code to be set.
     * @throws SQLException if a database access error occurs or no rows are updated.
     */
    public static void setCAPUser(String email, String newCAP) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        // Update the user's postal code (CAP) where the email matches
        int rowsUpdated = create.update(User.USER).set(User.USER.CAP, newCAP).where(User.USER.MAIL.eq(email)).execute();

        if (rowsUpdated == 0) {
            throw new SQLException(email);
        }
    }

    /**
     * Fetches the role of the user with the specified email.
     *
     * @param email The email address of the user.
     * @return The user's role as an integer, or null if not found.
     * @throws SQLException if a database access error occurs.
     */
    public static Integer getRoleUser(String email) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        @Nullable
        Record1<Integer> role = create.select(User.USER.ROLE).from(User.USER).where(User.USER.MAIL.eq(email))
                .fetchOne();

        return role != null ? role.value1() : null;
    }

    /**
     * Updates the role for the user with the specified email.
     *
     * @param email The email address of the user.
     * @param newRole The new role to be set.
     * @throws SQLException if a database access error occurs or no rows are updated.
     */
    public static void setRoleUser(String email, Integer newRole) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        // Update the user's role where the email matches
        int rowsUpdated = create.update(User.USER).set(User.USER.ROLE, newRole).where(User.USER.MAIL.eq(email))
                .execute();

        if (rowsUpdated == 0) {
            throw new SQLException(email);
        }
    }

    /**
     * Fetches the icon number for the user with the specified email.
     *
     * @param email The email address of the user.
     * @return The user's icon number, or null if not found.
     * @throws SQLException if a database access error occurs.
     */
    public static Integer getIconUser(String email) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        @Nullable
        Record1<Integer> iconNumber = create.select(User.USER.ICONNUMBER).from(User.USER)
                .where(User.USER.MAIL.eq(email)).fetchOne();

        return iconNumber != null ? iconNumber.value1() : null;
    }

    /**
     * Updates the icon number for the user with the specified email.
     *
     * @param email The email address of the user.
     * @param newIconNumber The new icon number to be set.
     * @throws SQLException if a database access error occurs or no rows are updated.
     */
    public static void setIconUser(String email, Integer newIconNumber) throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        // Update the user's icon number where the email matches
        int rowsUpdated = create.update(User.USER).set(User.USER.ICONNUMBER, newIconNumber)
                .where(User.USER.MAIL.eq(email)).execute();

        if (rowsUpdated == 0) {
            throw new SQLException(email);
        }
    }

    /**
     * Retrieves all email addresses from the User table and prints them.
     *
     * @throws SQLException if a database access error occurs.
     */
    public static void getMailUser() throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        // Fetch all emails from the User table
        @NotNull
        Result<Record1<String>> result = create.select(User.USER.MAIL).from(User.USER).fetch();

        for (Record1<String> dbMail : result) {
            String mail = dbMail.value1();
            System.out.println("Mail: " + mail);
        }
    }

    /**
     * Fetches all email addresses from the User table and returns them as a List.
     *
     * @return A List of email addresses.
     * @throws SQLException if a database access error occurs.
     */
    public static List<String> getAllUserEmails() throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        Result<Record1<String>> result = create.select(User.USER.MAIL).from(User.USER).fetch();

        List<String> emails = new ArrayList<>();
        for (Record1<String> mail : result) {
            emails.add(mail.value1());
        }
        return emails;
    }

    /**
     * Fetches all user passwords from the User table.
     *
     * @return A List of user passwords.
     * @throws SQLException if a database access error occurs.
     */
    public static List<String> getAllUserPassword() throws SQLException {
        DSLContext create = Utility.dslContext(ConstantDB.DB_URL_USERS);

        // Fetch all passwords from the User table
        Result<Record1<String>> result = create.select(User.USER.PASSWORD).from(User.USER).fetch();

        List<String> passwords = new ArrayList<>();
        for (Record1<String> password : result) {
            passwords.add(password.value1());
        }
        return passwords;
    }

    /**
     * Fetches detailed information for a user by their email address.
     *
     * @param email The email address of the user.
     * @return A List of user details (name, surname, etc.).
     * @throws SQLException if a database access error occurs.
     */
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

    /**
     * Fetches all data from the User table and stores it in the columnNames and data arrays.
     *
     * @param database The database URL to connect to.
     * @throws SQLException if a database access error occurs.
     */
    public static void getDataFromDatabaseUsers(String database) throws SQLException {
        DSLContext create = Utility.dslContext(database);
        @NotNull
        Result<Record> result = create.select().from(User.USER).fetch();
        columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
        data = result.stream().map(list -> list.intoArray()).toArray(Object[][]::new);
    }

    /**
     * Fetches all data from the "Company" table in the specified database.
     * 
     * @param database The name of the database to fetch data from.
     * @throws SQLException If a database access error occurs.
     */
    public static void getDataFromCompany(String database) throws SQLException {
        DSLContext create = Utility.dslContext(database);
        @NotNull
        Result<Record> result = create.select().from(Company.COMPANY).fetch();
        columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
        data = result.stream().map(list -> list.intoArray()).toArray(Object[][]::new);
    }

    /**
     * Fetches all data from the "FunicularStation" table in the specified database.
     * 
     * @param database The name of the database to fetch data from.
     * @throws SQLException If a database access error occurs.
     */
    public static void getDataFromFunicularStation(String database) throws SQLException {
        DSLContext create = Utility.dslContext(database);
        @NotNull
        Result<Record> result = create.select().from(Funicularstation.FUNICULARSTATION).fetch();
        columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
        data = result.stream().map(list -> list.intoArray()).toArray(Object[][]::new);
    }

    /**
     * Fetches all data from the "FunicularTimetable" table in the specified database.
     * 
     * @param database The name of the database to fetch data from.
     * @throws SQLException If a database access error occurs.
     */
    public static void getDataFromFunicularTimetable(String database) throws SQLException {
        DSLContext create = Utility.dslContext(database);
        @NotNull
        Result<Record> result = create.select().from(Funiculartimetable.FUNICULARTIMETABLE).fetch();
        columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
        data = result.stream().map(list -> list.intoArray()).toArray(Object[][]::new);
    }

    /**
     * Fetches all data from the "PullmanStop" table in the specified database.
     * 
     * @param database The name of the database to fetch data from.
     * @throws SQLException If a database access error occurs.
     */
    public static void getDataFromPullmanStop(String database) throws SQLException {
        DSLContext create = Utility.dslContext(database);
        @NotNull
        Result<Record> result = create.select().from(Pullmanstop.PULLMANSTOP).fetch();
        columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
        data = result.stream().map(list -> list.intoArray()).toArray(Object[][]::new);
    }

    /**
     * Fetches all data from the "PullmanTimetable" table in the specified database.
     * 
     * @param database The name of the database to fetch data from.
     * @throws SQLException If a database access error occurs.
     */
    public static void getDataFromPullmanTimetable(String database) throws SQLException {
        DSLContext create = Utility.dslContext(database);
        @NotNull
        Result<Record> result = create.select().from(Pullmantimetable.PULLMANTIMETABLE).fetch();
        columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
        data = result.stream().map(list -> list.intoArray()).toArray(Object[][]::new);
    }

    /**
     * Fetches all data from the "TrainStation" table in the specified database.
     * 
     * @param database The name of the database to fetch data from.
     * @throws SQLException If a database access error occurs.
     */
    public static void getDataFromTrainStation(String database) throws SQLException {
        DSLContext create = Utility.dslContext(database);
        @NotNull
        Result<Record> result = create.select().from(Trainstation.TRAINSTATION).fetch();
        columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
        data = result.stream().map(list -> list.intoArray()).toArray(Object[][]::new);
    }

    /**
     * Fetches all data from the "TrainTimetable" table in the specified database.
     * 
     * @param database The name of the database to fetch data from.
     * @throws SQLException If a database access error occurs.
     */
    public static void getDataFromTrainTimetable(String database) throws SQLException {
        DSLContext create = Utility.dslContext(database);
        @NotNull
        Result<Record> result = create.select().from(Traintimetable.TRAINTIMETABLE).fetch();
        columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
        data = result.stream().map(list -> list.intoArray()).toArray(Object[][]::new);
    }

    /**
     * Fetches all data from the "TramStop" table in the specified database.
     * 
     * @param database The name of the database to fetch data from.
     * @throws SQLException If a database access error occurs.
     */
    public static void getDataFromTramStop(String database) throws SQLException {
        DSLContext create = Utility.dslContext(database);
        @NotNull
        Result<Record> result = create.select().from(Tramstop.TRAMSTOP).fetch();
        columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
        data = result.stream().map(list -> list.intoArray()).toArray(Object[][]::new);
    }

    /**
     * Fetches all data from the "TramTimetable" table in the specified database.
     * 
     * @param database The name of the database to fetch data from.
     * @throws SQLException If a database access error occurs.
     */
    public static void getDataFromTramTimetable(String database) throws SQLException {
        DSLContext create = Utility.dslContext(database);
        @NotNull
        Result<Record> result = create.select().from(Tramtimetable.TRAMTIMETABLE).fetch();
        columnNames = Arrays.stream(result.fields()).map(field -> field.getName()).toArray(String[]::new);
        data = result.stream().map(list -> list.intoArray()).toArray(Object[][]::new);
    }

}
