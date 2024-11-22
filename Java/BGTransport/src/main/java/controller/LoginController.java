package controller;

import java.awt.TextField;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.MainController;
import model.RegisteredUser;
import view.LoginView;

public class LoginController {

	public static void Login(JTextField emailField, JPasswordField passwordField) {
		String email = emailField.getText();
		
		String password = new String(passwordField.getPassword());

		System.out.println("Email: " + email + " Password: " + password);
		
		if ((email != null) && (password != null)) {
			for (int x = 0; x < MainController.users.size(); x++) {
				RegisteredUser user = MainController.users.get(x);
				System.out.println("2 - Email: " + user.getEmail() + " Password: " +  user.getPassword());
				if ((email.equals(user.getEmail())) && (password.equals(user.getPassword()))) {
					System.out.println("Login OK");
				}
				else System.out.println("Login Failed");
			}
		}
		
	}
}
