package controller;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.RegisteredUser;

public class SignUpController {

	static RegisteredUser newUser;
	
	public static void SignUp(JTextField nameField, JTextField surnameField, JTextField brithdayField, JTextField emailField, 
							  JPasswordField passwordField, JPasswordField passwordconfField, JTextField usernameField, 
							  JTextField addressField, JTextField cityField, JTextField zipcodeField) {
		
		String name = nameField.getText();
		String surname = surnameField.getText();
		String birthday = brithdayField.getText();
		int role = 1;
		String email = emailField.getText();		
		String password = new String(passwordField.getPassword());
		String passwordconf = new String(passwordconfField.getPassword());
		String username = usernameField.getText();	
		String address = addressField.getText();	
		String city = cityField.getText();	
		String zipcode = zipcodeField.getText();			

		System.out.println( "Name: " + name + "\nsurname: " + surname + "\nbirthday: " + birthday + "\nEmail: " + email + "\nPassword: " + password +
							"\npasswordconf: " + passwordconf + "\nusername: " + username + "\naddress: " + address + "\ncity: " + city + "\nzipcode: " + zipcode);
		
		if (name != null && surname != null && birthday != null && (birthday.contains("/") || birthday.contains("-"))) {
			MainController.users.add(newUser = new RegisteredUser(name, surname, birthday, role));
		}
		
		if (email != null && email.contains("@") && email.contains(".")) {
			newUser.setEmail(email);
		}
		
		if ((password != null && passwordconf != null) && (password == passwordconf)) {
			newUser.setPassword(password);
		}
		
		if (username != null && !username.contains(" ")) {
			newUser.setUsername(username);
		}
		
		if (address != null) {
			newUser.setAddress(address);
		}
		
		if (city != null) {
			newUser.setCity(city);
		}
		
		if (zipcode != null) {
			newUser.setZIPcode(zipcode);
		}		
	}
}
