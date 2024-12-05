package controller;

import java.awt.TextField;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.MainController;
import model.QueryDB;
import model.RegisteredUser;
import view.LoginView;

public class LoginController {
	
	public static RegisteredUser userlogged = new RegisteredUser();
	public static String email;
	public static void Login(JTextField emailField, JPasswordField passwordField) {
		email = emailField.getText();
		
		String password = new String(passwordField.getPassword());

		System.out.println("Email: " + email + " Password: " + password);
		
		if ((email != null)) {
				try {
					for(int i = 0; i < QueryDB.getAllUserEmails().size(); i++) {
					if ((email.equals(QueryDB.getAllUserEmails().get(i)) && (password.equals(QueryDB.getAllUserPassword().get(i))))) {
						System.out.println("Login OK");
						userlogged.setEmail(email);
						NewWindowController.openUserPanel(MainController.userV);
						MainController.loginV.setVisible(false);
					}										
					else if ((email.equals(QueryDB.getAllUserEmails().get(i)) && (!password.equals(QueryDB.getAllUserPassword().get(i))))){
						MainController.loginV.passwordField.setText("");
						MainController.loginV.ErrorLabel.setVisible(true);
						MainController.loginV.ErrorLabel.setText("Password Errata !");
					}
					else {
						MainController.loginV.ErrorLabel.setVisible(true);
						MainController.loginV.ErrorLabel.setText("Non esiste nessun account con questa mail !");						
					}
					
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
}
