package bgtransport.model;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserQueryDBTest {

    /**
     * Tests the `setNameUser` method for a non-existent user.
     * Expects a `SQLException` to be thrown when attempting to update the name of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testSetNameUser() {
        // Attempting to update the name of a non-existent user should throw a SQLException
        assertThrows(SQLException.class, () -> {
            UserQueryDB.setNameUser("nonexistent.user@example.com", "Michael");
        });
    }

    /**
     * Tests the `setSurnameUser` method for a non-existent user.
     * Expects a `SQLException` to be thrown when attempting to update the surname of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testSetSurnameUser() {
        // Attempting to update the surname of a non-existent user should throw a SQLException
        assertThrows(SQLException.class, () -> {
            UserQueryDB.setSurnameUser("nonexistent.user@example.com", "Johnson");
        });
    }

    /**
     * Tests the `setUsernameUser` method for a non-existent user.
     * Expects a `SQLException` to be thrown when attempting to update the username of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testSetUsernameUser() {
        // Attempting to update the username of a non-existent user should throw a SQLException
        assertThrows(SQLException.class, () -> {
            UserQueryDB.setUsernameUser("nonexistent.user@example.com", "newUsername");
        });
    }

    /**
     * Tests the `setBirthdayUser` method for a non-existent user.
     * Expects a `SQLException` to be thrown when attempting to update the birthday of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testSetBirthdayUser() {
        // Attempting to update the birthday of a non-existent user should throw a SQLException
        assertThrows(SQLException.class, () -> {
            UserQueryDB.setBirthdayUser("nonexistent.user@example.com", "2000-01-01");
        });
    }

    /**
     * Tests the `getNameUser` method for a non-existent user.
     * Expects the method to return `null` when querying the name of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetNameUser() throws SQLException {
        // Attempting to get the name of a non-existent user should return null
        String name = UserQueryDB.getNameUser("nonexistent.user@example.com");
        assertNull(name, "The name of the non-existent user should be null.");
    }

    /**
     * Tests the `getSurnameUser` method for a non-existent user.
     * Expects the method to return `null` when querying the surname of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetSurnameUser() throws SQLException {
        // Attempting to get the surname of a non-existent user should return null
        String surname = UserQueryDB.getSurnameUser("nonexistent.user@example.com");
        assertNull(surname, "The surname of the non-existent user should be null.");
    }

    /**
     * Tests the `getUsernameUser` method for a non-existent user.
     * Expects the method to return `null` when querying the username of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetUsernameUser() throws SQLException {
        // Attempting to get the username of a non-existent user should return null
        String username = UserQueryDB.getUsernameUser("nonexistent.user@example.com");
        assertNull(username, "The username of the non-existent user should be null.");
    }

    /**
     * Tests the `getBirthdayUser` method for a non-existent user.
     * Expects the method to return `null` when querying the birthday of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetBirthdayUser() throws SQLException {
        // Attempting to get the birthday of a non-existent user should return null
        String birthday = UserQueryDB.getBirthdayUser("nonexistent.user@example.com");
        assertNull(birthday, "The birthday of the non-existent user should be null.");
    }

    /**
     * Tests the `setAddressUser` method for a non-existent user.
     * Expects a `SQLException` to be thrown when attempting to update the address of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testSetAddressUser() {
        // Attempting to update the address of a non-existent user should throw a SQLException
        assertThrows(SQLException.class, () -> {
            UserQueryDB.setAddressUser("nonexistent.user@example.com", "123 New Street");
        });
    }

    /**
     * Tests the `getAddressUser` method for a non-existent user.
     * Expects the method to return `null` when querying the address of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetAddressUser() throws SQLException {
        // Attempting to get the address of a non-existent user should return null
        String address = UserQueryDB.getAddressUser("nonexistent.user@example.com");
        assertNull(address, "The address of the non-existent user should be null.");
    }

    /**
     * Tests the `setTownUser` method for a non-existent user.
     * Expects a `SQLException` to be thrown when attempting to update the town of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testSetTownUser() {
        // Attempting to update the town of a non-existent user should throw a SQLException
        assertThrows(SQLException.class, () -> {
            UserQueryDB.setTownUser("nonexistent.user@example.com", "New Town");
        });
    }

    /**
     * Tests the `getTownUser` method for a non-existent user.
     * Expects the method to return `null` when querying the town of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetTownUser() throws SQLException {
        // Attempting to get the town of a non-existent user should return null
        String town = UserQueryDB.getTownUser("nonexistent.user@example.com");
        assertNull(town, "The town of the non-existent user should be null.");
    }

    /**
     * Tests the `setCAPUser` method for a non-existent user.
     * Expects a `SQLException` to be thrown when attempting to update the CAP of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testSetCAPUser() {
        // Attempting to update the CAP of a non-existent user should throw a SQLException
        assertThrows(SQLException.class, () -> {
            UserQueryDB.setCAPUser("nonexistent.user@example.com", "12345");
        });
    }

    /**
     * Tests the `getCAPUser` method for a non-existent user.
     * Expects the method to return `null` when querying the CAP of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetCAPUser() throws SQLException {
        // Attempting to get the CAP of a non-existent user should return null
        String cap = UserQueryDB.getCAPUser("nonexistent.user@example.com");
        assertNull(cap, "The CAP of the non-existent user should be null.");
    }

    /**
     * Tests the `setRoleUser` method for a non-existent user.
     * Expects a `SQLException` to be thrown when attempting to update the role of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testSetRoleUser() {
        // Attempting to update the role of a non-existent user should throw a SQLException
        assertThrows(SQLException.class, () -> {
            UserQueryDB.setRoleUser("nonexistent.user@example.com", 1);
        });
    }

    /**
     * Tests the `getRoleUser` method for a non-existent user.
     * Expects the method to return `null` when querying the role of a non-existent user.
     *
     * @throws SQLException If an SQL error occurs during the execution of the query.
     */
    @Test
    void testGetRoleUser() throws SQLException {
        // Attempting to get the role of a non-existent user should return null
        Integer role = UserQueryDB.getRoleUser("nonexistent.user@example.com");
        assertNull(role, "The role of the non-existent user should be null.");
    }
    
    //Same for the rest of the tests
}
