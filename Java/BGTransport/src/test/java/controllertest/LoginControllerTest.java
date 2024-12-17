package controllertest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bgtransport.controller.LoginController;
import bgtransport.model.QueryDB;
import bgtransport.model.RegisteredUser;

class LoginControllerTest {

    private JTextField emailField;
    private JPasswordField passwordField;

    @BeforeEach
    void setUp() {
        // Inizializza i campi input
        emailField = new JTextField();
        passwordField = new JPasswordField();

        // Configura dati statici di QueryDB per i test
        TestQueryDB.initializeTestData();
    }

    @Test
    void testLoginNonExistentEmail() throws SQLException {
        // Simula input con email non esistente
        emailField.setText("unknown@example.com");
        passwordField.setText("password123");

        // Esegui login
        LoginController.login(emailField, passwordField);

        // Verifica che l'utente non sia loggato
        assertNull(LoginController.userlogged.getEmail(), "L'utente non dovrebbe essere loggato con email inesistente.");
        LoginController.logout();
    }
    
    @Test
    void testLoginWrongPassword() throws SQLException {
        // Simula input con password errata
        emailField.setText("test2@example.com");
        passwordField.setText("wrongPassword");

        // Esegui login
        LoginController.login(emailField, passwordField);

        // Verifica che l'utente non sia loggato
        assertNull(LoginController.userlogged.getEmail(), "L'utente non dovrebbe essere loggato con password errata.");
        
        LoginController.logout();
    }
    
    @Test
    void testLoginSuccess() throws SQLException {
        // Simula input corretto
        emailField.setText("test@example.com");
        passwordField.setText("password123");

        // Esegui login
        LoginController.login(emailField, passwordField);

        // Verifica se l'utente è loggato
        assertEquals("test@example.com", LoginController.userlogged.getEmail(), "L'utente dovrebbe essere loggato correttamente.");  
        LoginController.logout();
    }    

    // Classe statica di supporto per simulare QueryDB con dati statici
    static class TestQueryDB extends QueryDB {

        private static final List<String> testEmails = new ArrayList<>();
        private static final List<String> testPasswords = new ArrayList<>();

        public static void initializeTestData() {
            // Pulisce i dati e inserisce utenti di test
            testEmails.clear();
            testPasswords.clear();
            testEmails.add("test@example.com");
            testPasswords.add("password123");
        }

        public static List<String> getAllUserEmails() {
            return testEmails;
        }

        public static List<String> getAllUserPassword() {
            return testPasswords;
        }
    }
}
