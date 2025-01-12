package bgtransport.controller;

import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bgtransport.model.UserQueryDB;
import bgtransport.model.Developer;
import bgtransport.model.RegisteredUser;
import bgtransport.model.User;

/**
 * This class is responsible for handling the login and logout functionality in
 * the system. It checks user credentials against the database and manages the
 * user session.
 */
public class LoginController {

	/** The object that holds the information of the logged-in user */
	public static User uservolatile = new User();
	

	/** The email address of the currently logged-in user */
	public static String email; 

	/**
	 * Handles the login process by verifying the email and password against the
	 * database. If the credentials are valid, the user is logged in, and their role
	 * is set. If the credentials are invalid, appropriate error messages are shown.
	 * 
	 * @param emailField    the JTextField that contains the user's email
	 * @param passwordField the JPasswordField that contains the user's password
	 */
	public static void login(JTextField emailField, JPasswordField passwordField) {
		email = emailField.getText();

		String password = new String(passwordField.getPassword());

		// Check if email is not null before proceeding
		if ((email != null)) {
			try {
				// Loop through all the emails in the database to verify the user credentials
				for (int i = 0; i < UserQueryDB.getAllUserEmails().size(); i++) {
					// If email and password match
					if ((email.equals(UserQueryDB.getAllUserEmails().get(i)) && (password.equals(UserQueryDB.getAllUserPassword().get(i))))) {
						uservolatile.setEmail(email);
						int role = uservolatile.getRole();
						MainController.userlogged = null;
						if (role == 1) MainController.userlogged = new RegisteredUser();
						else if (role == 2) MainController.userlogged = new Developer();
						MainController.userlogged.setEmail(email);
						RoleController.roleManager(role);
						NewWindowController.openUserPanel(MainController.userV);
						MainController.loginV.setVisible(false);
					}
					// If email matches but password does not
					else if ((email.equals(UserQueryDB.getAllUserEmails().get(i))
							&& (!password.equals(UserQueryDB.getAllUserPassword().get(i))))) {
						MainController.loginV.passwordField.setText("");
						MainController.loginV.errorLabel.setVisible(true);
						MainController.loginV.errorLabel.setText("Password Errata !");
					}
					// If email does not exist in the database
					else {
						MainController.loginV.errorLabel.setVisible(true);
						MainController.loginV.errorLabel.setText("Non esiste nessun account con questa mail !");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Handles the logout process. Resets the logged-in user, clears the session
	 * data, and returns to the home screen.
	 */
	public static void logout() {
		// Reset the logged-in user information
		MainController.userlogged = new User();
		email = null;
		RoleController.roleManager(0);
		UserInfoController.hideDataWidget();
		NewWindowController.openHomePanel(MainController.homeV);	
		MainController.loginV.passwordField.setText(""); // Clears the password field
		MainController.loginV.errorLabel.setVisible(false); // Hides error messages
	}
}
