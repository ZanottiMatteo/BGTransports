package bgtransport.controller;

import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bgtransport.model.UserQueryDB;
import bgtransport.model.RegisteredUser;

public class LoginController {
	
	public static int role = 0;
	public static RegisteredUser userlogged = new RegisteredUser();
	public static String email;
	public static void login(JTextField emailField, JPasswordField passwordField) {
		email = emailField.getText();
		
		String password = new String(passwordField.getPassword());

		System.out.println("Email: " + email + " Password: " + password);
		
		if ((email != null)) {
				try {
					for(int i = 0; i < UserQueryDB.getAllUserEmails().size(); i++) {
					if ((email.equals(UserQueryDB.getAllUserEmails().get(i)) && (password.equals(UserQueryDB.getAllUserPassword().get(i))))) {
						System.out.println("Login OK");
						userlogged.setEmail(email);
						role = userlogged.getRole();
						RoleController.roleManager();
						NewWindowController.openUserPanel(MainController.userV);
						MainController.loginV.setVisible(false);
						
					}										
					else if ((email.equals(UserQueryDB.getAllUserEmails().get(i)) && (!password.equals(UserQueryDB.getAllUserPassword().get(i))))){
						MainController.loginV.passwordField.setText("");
						MainController.loginV.errorLabel.setVisible(true);
						MainController.loginV.errorLabel.setText("Password Errata !");
					}
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
	public static void logout() {
        // Resetta l'utente loggato
        userlogged = new RegisteredUser();
        email = null;
        role = 0;
        RoleController.roleManager();

        System.out.println("Logout eseguito.");
        NewWindowController.openHomePanel(MainController.homeV);
        UserInfoController.hideDataWidget();
        MainController.loginV.passwordField.setText(""); // Pulisce il campo password
        MainController.loginV.errorLabel.setVisible(false); // Nasconde errori
    }
}
