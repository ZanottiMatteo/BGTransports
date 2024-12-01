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
	
	public static RegisteredUser user = new RegisteredUser();

	public static void Login(JTextField emailField, JPasswordField passwordField) {
		String email = emailField.getText();
		
		String password = new String(passwordField.getPassword());

		System.out.println("Email: " + email + " Password: " + password);
		
		if ((email != null) && (password != null)) {
				try {
					for(int i = 0; i < QueryDB.getAllUserEmails().size(); i++) {
					if ((email.equals(QueryDB.getAllUserEmails().get(i)) && (password.equals(QueryDB.getAllUserPassword().get(i))))) {
						System.out.println("Login OK");
						user.setEmail(email);;
					}
			else System.out.println(QueryDB.getAllUserEmails().get(i) + QueryDB.getAllUserPassword().get(i));
}
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
