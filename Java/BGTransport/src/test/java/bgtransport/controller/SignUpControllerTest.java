package bgtransport.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jooq.DSLContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bgtransport.model.ConstantDB;
import bgtransport.model.Utility;
import user.jooq.generated.tables.User;

class SignUpControllerTest {

    private DSLContext dslContext;

    @BeforeEach
    void setUp() throws SQLException {
        // Connect to a test database (you may need to adjust this to match your setup)
        dslContext = Utility.dslContext(ConstantDB.DB_URL_USERS);
    }

    @AfterEach
    void tearDown() {
        // Rimuovi gli utenti creati durante i test
        dslContext.deleteFrom(User.USER)
                .where(User.USER.USERNAME.in("piero"))
                .execute();
    }

    @Test
    void testSignUpSuccess() throws SQLException {
        // Prepare input fields
        JTextField nameField = new JTextField("Piero");
        JTextField surnameField = new JTextField("Rossi");
        JTextField brithdayField = new JTextField("1990-01-01");
        JTextField emailField = new JTextField("pierorossi@example.com");
        JPasswordField passwordField = new JPasswordField("password123");
        JPasswordField passwordconfField = new JPasswordField("password123");
        JTextField usernameField = new JTextField("piero");
        JTextField addressField = new JTextField("Via Baioni, 12");
        JTextField cityField = new JTextField("Bergamo");
        JTextField zipcodeField = new JTextField("12345");

        // Call the method
        SignUpController.signUp(nameField, surnameField, brithdayField, emailField, passwordField, passwordconfField,
                usernameField, addressField, cityField, zipcodeField);

        // Verify the database entry
        var userRecord = dslContext.selectFrom(User.USER)
                .where(User.USER.USERNAME.eq("piero"))
                .fetchOne();

        assertNotNull(userRecord, "User should be inserted into the database");
        assertEquals("Piero", userRecord.get(User.USER.NAME));
        assertEquals("Rossi", userRecord.get(User.USER.SURNAME));
        assertEquals("1990-01-01", userRecord.get(User.USER.DATEOFBIRTH));
        assertEquals("pierorossi@example.com", userRecord.get(User.USER.MAIL));
        assertEquals("password123", userRecord.get(User.USER.PASSWORD));
        assertEquals("piero", userRecord.get(User.USER.USERNAME));
        assertEquals("Via Baioni, 12", userRecord.get(User.USER.ADDRESS));
        assertEquals("Bergamo", userRecord.get(User.USER.TOWN));
        assertEquals("12345", userRecord.get(User.USER.CAP));
    }

    @Test
    void testSignUpInvalidEmail() {
        // Prepare input fields with invalid email
        JTextField nameField = new JTextField("Piero");
        JTextField surnameField = new JTextField("Rossi");
        JTextField brithdayField = new JTextField("1990-01-01");
        JTextField emailField = new JTextField("invalid-email");
        JPasswordField passwordField = new JPasswordField("password123");
        JPasswordField passwordconfField = new JPasswordField("password123");
        JTextField usernameField = new JTextField("mario");
        JTextField addressField = new JTextField("Via Baioni, 12");
        JTextField cityField = new JTextField("Bergamo");
        JTextField zipcodeField = new JTextField("12345");

        // Call the method and expect no exception but no insertion
        assertDoesNotThrow(() -> SignUpController.signUp(nameField, surnameField, brithdayField, emailField,
                passwordField, passwordconfField, usernameField, addressField, cityField, zipcodeField));

        // Verify that no user is inserted into the database
        var userRecord = dslContext.selectFrom(User.USER)
                .where(User.USER.USERNAME.eq("mario"))
                .fetchOne();

        assertNull(userRecord, "User should be inserted into the database");
    }

    @Test
    void testSignUpPasswordMismatch() {
        // Prepare input fields with mismatched passwords
        JTextField nameField = new JTextField("Piero");
        JTextField surnameField = new JTextField("Rossi");
        JTextField brithdayField = new JTextField("1990-01-01");
        JTextField emailField = new JTextField("pierorossi@example.com");
        JPasswordField passwordField = new JPasswordField("password123");
        JPasswordField passwordconfField = new JPasswordField("password321"); // Mismatch
        JTextField usernameField = new JTextField("piero");
        JTextField addressField = new JTextField("Via Baioni, 12");
        JTextField cityField = new JTextField("Bergamo");
        JTextField zipcodeField = new JTextField("12345");

        // Call the method and expect no exception but no insertion
        assertDoesNotThrow(() -> SignUpController.signUp(nameField, surnameField, brithdayField, emailField,
                passwordField, passwordconfField, usernameField, addressField, cityField, zipcodeField));

        // Verify that no user is inserted into the database
        var userRecord = dslContext.selectFrom(User.USER)
                .where(User.USER.USERNAME.eq("gigi"))
                .fetchOne();

        assertNull(userRecord, "User should be inserted into the database");
    }
}

