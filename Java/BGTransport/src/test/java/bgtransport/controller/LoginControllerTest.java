package bgtransport.controller;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bgtransport.model.User;

class LoginControllerTest {

	private JTextField emailField;
	private JPasswordField passwordField;

	@BeforeEach
	void setUp() {
		// Inizializza i campi input
		emailField = new JTextField();
		passwordField = new JPasswordField();
		LoginController.uservolatile = new User();
		LoginController.email = null;
		MainController.userlogged = null;
		try {
			MainController.main(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testLoginWithNonExistentEmail() {
		emailField.setText("nonexistent@example.com");
		passwordField.setText("password123");

		LoginController.login(emailField, passwordField);

		assertNull(MainController.userlogged, "L'utente non dovrebbe essere loggato con un'email non esistente.");
	}

	@Test
	void testLoginWithWrongPassword() {
		emailField.setText("testRU@example.com");
		passwordField.setText("wrongpassword");

		LoginController.login(emailField, passwordField);

		assertNull(MainController.userlogged, "L'utente non dovrebbe essere loggato con una password errata.");
	}

	@Test
	void testSuccessfulLoginandLogoutRegUser() {
		emailField.setText("testRU@example.com");
		passwordField.setText("password123");

		LoginController.login(emailField, passwordField);

		assertNotNull(MainController.userlogged, "L'utente dovrebbe essere loggato con credenziali corrette.");
		assertEquals("testRU@example.com", MainController.userlogged.getEmail(), "L'email dell'utente loggato dovrebbe corrispondere.");
		LoginController.logout();
		assertNull(MainController.userlogged.getEmail(), "L'utente dovrebbe essere disconnesso dopo il logout.");
	}
	
	@Test
	void testSuccessfulLoginandLogoutDev() {
		emailField.setText("testD@example.com");
		passwordField.setText("password123");

		LoginController.login(emailField, passwordField);

		assertNotNull(MainController.userlogged, "L'utente dovrebbe essere loggato con credenziali corrette.");
		assertEquals("testD@example.com", MainController.userlogged.getEmail(), "L'email dell'utente loggato dovrebbe corrispondere.");
		LoginController.logout();
		assertNull(MainController.userlogged.getEmail(), "L'utente dovrebbe essere disconnesso dopo il logout.");
	}
}
