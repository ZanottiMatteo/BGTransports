package controller;

import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jooq.DSLContext;

import model.Constant;
import model.ControlDB;
import model.RegisteredUser;
import user.jooq.generated.tables.User;

public class SignUpController {

	static RegisteredUser newUser;
	
	public static void SignUp(JTextField nameField, JTextField surnameField, JTextField brithdayField, JTextField emailField, 
							  JPasswordField passwordField, JPasswordField passwordconfField, JTextField usernameField, 
							  JTextField addressField, JTextField cityField, JTextField zipcodeField) throws SQLException {
		
		DSLContext user = ControlDB.DSLContext(Constant.DB_URL_USERS);
		
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
			user.insertInto(User.USER)
			.set(User.USER.NAME, name)
			.set(User.USER.SURNAME, surname)
			.set(User.USER.DATE_OF_BIRTH, birthday)
			.set(User.USER.ROLE, role)
			.execute();
		}
		
		if (email != null && email.contains("@") && email.contains(".")) {
			newUser.setEmail(email);
			user.insertInto(User.USER)
			.set(User.USER.MAIL, email)
			.execute();
		}
		
		if ((password != null && passwordconf != null) && (password == passwordconf)) {
			newUser.setPassword(password);
			user.insertInto(User.USER)
			.set(User.USER.PASSWORD, password)
			.execute();
		}
		
		if (username != null && !username.contains(" ")) {
			newUser.setUsername(username);
			user.insertInto(User.USER)
			.set(User.USER.USERNAME, username)
			.execute();
		}
		
		if (address != null) {
			newUser.setAddress(address);
			user.insertInto(User.USER)
			.set(User.USER.ADDRESS, address)
			.execute();
		}
		
		if (city != null) {
			newUser.setCity(city);
			user.insertInto(User.USER)
			.set(User.USER.TOWN, city)
			.execute();
		}
		
		if (zipcode != null) {
			newUser.setZIPcode(zipcode);
			user.insertInto(User.USER)
			.set(User.USER.CAP, zipcode)
			.execute();
		}		
	}
}
