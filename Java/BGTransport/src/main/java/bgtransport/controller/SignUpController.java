package bgtransport.controller;

import java.sql.SQLException;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jooq.DSLContext;

import bgtransport.model.ConstantDB;
import bgtransport.model.RegisteredUser;
import bgtransport.model.Utility;
import user.jooq.generated.tables.User;

/**
 * Controller class for handling the sign-up process of new users.
 * This class facilitates user registration by validating input fields and 
 * storing the user's information into the database.
 */
public class SignUpController {

    static RegisteredUser newUser;
    public static int control;
    /**
     * Handles the sign-up process for a new user. Validates the input fields 
     * and inserts the user's data into the database if the inputs meet the 
     * required criteria.
     *
     * @param nameField          TextField containing the user's first name.
     * @param surnameField       TextField containing the user's last name.
     * @param brithdayField      TextField containing the user's date of birth.
     * @param emailField         TextField containing the user's email address.
     * @param passwordField      PasswordField containing the user's password.
     * @param passwordconfField  PasswordField containing the password confirmation.
     * @param usernameField      TextField containing the user's username.
     * @param addressField       TextField containing the user's address.
     * @param cityField          TextField containing the user's city.
     * @param zipcodeField       TextField containing the user's ZIP code.
     * @throws SQLException      If there is an error during database interaction.
     */
    public static void signUp(JTextField nameField, JTextField surnameField, JTextField brithdayField,
            JTextField emailField, JPasswordField passwordField, JPasswordField passwordconfField,
            JTextField usernameField, JTextField addressField, JTextField cityField, JTextField zipcodeField)
            throws SQLException {
    	control = 0;
        // Create a DSLContext instance for database operations
        DSLContext user = Utility.dslContext(ConstantDB.DB_URL_USERS);

        // Retrieve and validate input values
        String name = nameField.getText();
        nameField.setText("");
        String surname = surnameField.getText();
        surnameField.setText("");
        String birthday = brithdayField.getText();
        brithdayField.setText("");
        int role = 1; // Default role ID for new users
        int imageaccount = 0; // Default icon number
        String email = emailField.getText();
        emailField.setText("");
        String password = new String(passwordField.getPassword());
        passwordField.setText("");
        String passwordconf = new String(passwordconfField.getPassword());
        passwordconfField.setText("");
        String username = usernameField.getText();
        usernameField.setText("");
        String address = addressField.getText();
        addressField.setText("");
        String city = cityField.getText();
        cityField.setText("");
        String zipcode = zipcodeField.getText();
        zipcodeField.setText("");

        // Print input data for debugging purposes
        System.out.println("Name: " + name + "\nsurname: " + surname + "\nbirthday: " + birthday + "\nEmail: " + email
                + "\nPassword: " + password + "\npasswordconf: " + passwordconf + "\nusername: " + username
                + "\naddress: " + address + "\ncity: " + city + "\nzipcode: " + zipcode);

        // Input validation
        if (name != null && surname != null && birthday != null && (birthday.contains("/") || birthday.contains("-"))
                && email != null && email.contains("@") && email.contains(".") && password.equals(passwordconf)
                && username != null && !username.contains(" ")) {

            // Insert user data into the database
            user.insertInto(User.USER).set(User.USER.NAME, name).set(User.USER.SURNAME, surname)
                    .set(User.USER.DATEOFBIRTH, birthday).set(User.USER.ROLE, role)
                    .set(User.USER.ICONNUMBER, imageaccount).set(User.USER.MAIL, email)
                    .set(User.USER.PASSWORD, password).set(User.USER.USERNAME, username).set(User.USER.ADDRESS, address)
                    .set(User.USER.TOWN, city).set(User.USER.CAP, zipcode).execute();
            MainController.signupV.setVisible(false);
            MainController.signupV.errorLabel.setVisible(false);
        }
        else {
        	MainController.signupV.errorLabel.setVisible(true);
        	MainController.signupV.errorLabel.setText("Utente non registrato, inserire i dati correttamente");
        }
    }
}
