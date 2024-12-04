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
		
		DSLContext user = ControlDB.DSLContext(Constant.DBUrlUsers);
		
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
		
		if (name != null && surname != null && birthday != null && (birthday.contains("/") || birthday.contains("-")) 
		        && email != null && email.contains("@") && email.contains(".") 
		        && password != null && passwordconf != null && password.equals(passwordconf) 
		        && username != null && !username.contains(" ")) {
			
			MainController.users.add(newUser = new RegisteredUser());
			newUser.setName(name);
			newUser.setSurname(surname);
			newUser.setBirthday(birthday);
			newUser.setRole(role);
			newUser.setEmail(email);
			newUser.setPassword(password);
			newUser.setUsername(username);
			newUser.setAddress(address);
			newUser.setCity(city);
			newUser.setZIPcode(zipcode);
			
			user.insertInto(User.USER)
			.set(User.USER.NAME, name)
			.set(User.USER.SURNAME, surname)
			.set(User.USER.DATEOFBIRTH, birthday)
			.set(User.USER.ROLE, role)
			.set(User.USER.MAIL, email)
			.set(User.USER.PASSWORD, password)
			.set(User.USER.USERNAME, username)
			.set(User.USER.ADDRESS, address)
			.set(User.USER.TOWN, city)
			.set(User.USER.CAP, zipcode)
			.execute();
		}
	}
}
