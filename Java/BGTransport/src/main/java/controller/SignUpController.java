package controller;

import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jooq.DSLContext;

import model.Constant;
import model.RegisteredUser;
import model.Utility;
import user.jooq.generated.tables.User;

public class SignUpController {

	static RegisteredUser newUser;

	public static void signUp(JTextField nameField, JTextField surnameField, JTextField brithdayField,
			JTextField emailField, JPasswordField passwordField, JPasswordField passwordconfField,
			JTextField usernameField, JTextField addressField, JTextField cityField, JTextField zipcodeField)
			throws SQLException {

		DSLContext user = Utility.dslContext(Constant.DB_URL_USERS);

		String name = nameField.getText();
		String surname = surnameField.getText();
		String birthday = brithdayField.getText();
		int role = 1;
		int imageaccount = 0;
		String email = emailField.getText();
		String password = new String(passwordField.getPassword());
		String passwordconf = new String(passwordconfField.getPassword());
		String username = usernameField.getText();
		String address = addressField.getText();
		String city = cityField.getText();
		String zipcode = zipcodeField.getText();

		System.out.println("Name: " + name + "\nsurname: " + surname + "\nbirthday: " + birthday + "\nEmail: " + email
				+ "\nPassword: " + password + "\npasswordconf: " + passwordconf + "\nusername: " + username
				+ "\naddress: " + address + "\ncity: " + city + "\nzipcode: " + zipcode);

		if (name != null && surname != null && birthday != null && (birthday.contains("/") || birthday.contains("-"))
				&& email != null && email.contains("@") && email.contains(".") && password.equals(passwordconf)
				&& username != null && !username.contains(" ")) {

			user.insertInto(User.USER).set(User.USER.NAME, name).set(User.USER.SURNAME, surname)
					.set(User.USER.DATEOFBIRTH, birthday).set(User.USER.ROLE, role)
					.set(User.USER.ICONNUMBER, imageaccount).set(User.USER.MAIL, email)
					.set(User.USER.PASSWORD, password).set(User.USER.USERNAME, username).set(User.USER.ADDRESS, address)
					.set(User.USER.TOWN, city).set(User.USER.CAP, zipcode).execute();
		}
	}
}
