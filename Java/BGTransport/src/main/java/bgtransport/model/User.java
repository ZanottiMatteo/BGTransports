package bgtransport.model;

import java.sql.SQLException;
import java.util.List;

/**
 * Represents a User in the system with various details such as name, surname,
 * email, and more. This class provides methods to load and manage user details
 * from the database.
 */
public class User {

	private String name;
	private String surname;
	private String birthday;
	private String email;
	private String password;
	private String username;
	private String address;
	private String city;
	private String zipCode;
	private int imageAccount;
	private int role = 0;

	/**
	 * Loads the user details from the database using the provided email. The
	 * details are stored in the respective fields of the User object.
	 * 
	 * @throws SQLException if there is an issue retrieving data from the database
	 */
	public void loadUserDetails() throws SQLException {
		List<String> userDetails = UserQueryDB.getUserDetailsByEmail(this.email);

		if (!userDetails.isEmpty()) {
			this.name = userDetails.get(0);
			this.surname = userDetails.get(1);
			this.username = userDetails.get(2);
			this.birthday = userDetails.get(3);
			this.address = userDetails.get(4);
			this.city = userDetails.get(5);
			this.zipCode = userDetails.get(6);
			this.password = userDetails.get(7);
			this.role = Integer.parseInt(userDetails.get(8));
			this.imageAccount = Integer.parseInt(userDetails.get(9));
		}
	}

	/**
	 * Gets the user's name.
	 *
	 * @return the user's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the user's name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the user's surname.
	 *
	 * @return the user's surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the user's surname.
	 *
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the user's birthday.
	 *
	 * @return the user's birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * Sets the user's birthday.
	 *
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * Gets the user's email address.
	 *
	 * @return the user's email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the user's email address and loads the user details based on the email.
	 *
	 * @param email the email address to set
	 */
	public void setEmail(String email) {
		this.email = email;
		try {
			loadUserDetails();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the user's username.
	 *
	 * @return the user's username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the user's username.
	 *
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the user's address.
	 *
	 * @return the user's address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the user's address.
	 *
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the user's city.
	 *
	 * @return the user's city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the user's city.
	 *
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the user's zip code.
	 *
	 * @return the user's zip code
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the user's zip code.
	 *
	 * @param zipCode the zip code to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Gets the user's password.
	 *
	 * @return the user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the user's password.
	 *
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the user's role.
	 *
	 * @return the user's role as an integer
	 */
	public int getRole() {
		return this.role;
	}

	/**
	 * Sets the user's role.
	 *
	 * @param role the role to set
	 */
	public void setRole(int role) {
		this.role = role;
	}

	/**
	 * Gets the user's account image identifier.
	 *
	 * @return the image account identifier
	 */
	public int getImageAccount() {
		return imageAccount;
	}

	/**
	 * Sets the user's account image identifier.
	 *
	 * @param imageAccount the image account identifier to set
	 */
	public void setImageAccount(int imageAccount) {
		this.imageAccount = imageAccount;
	}

}
