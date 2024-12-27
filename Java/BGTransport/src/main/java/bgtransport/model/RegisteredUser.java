package bgtransport.model;

import java.sql.SQLException;
import java.util.List;

/**
 * Represents a registered user in the system.
 * This class contains user details such as name, surname, email, password, and other related information.
 * It also provides methods to get and set these details, with changes being persisted in the database.
 */
public class RegisteredUser {

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
    private int role;

    /**
     * Loads user details from the database based on the user's email.
     * This method retrieves user information from the database and populates the user's attributes.
     * 
     * @throws SQLException if a database error occurs while fetching user details.
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
     * @return the user's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the user's name and updates it in the database.
     * 
     * @param name the new name to be set.
     * @throws SQLException if a database error occurs while updating the name.
     */
    public void setName(String name) throws SQLException {
        this.name = name;
        UserQueryDB.setNameUser(this.email, name);
    }

    /**
     * Gets the user's surname.
     * 
     * @return the user's surname.
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Sets the user's surname and updates it in the database.
     * 
     * @param surname the new surname to be set.
     * @throws SQLException if a database error occurs while updating the surname.
     */
    public void setSurname(String surname) throws SQLException {
        this.surname = surname;
        UserQueryDB.setSurnameUser(this.email, surname);
    }

    /**
     * Gets the user's birthday.
     * 
     * @return the user's birthday.
     */
    public String getBirthday() {
        return this.birthday;
    }

    /**
     * Sets the user's birthday and updates it in the database.
     * 
     * @param birthday the new birthday to be set.
     * @throws SQLException if a database error occurs while updating the birthday.
     */
    public void setBirthday(String birthday) throws SQLException {
        this.birthday = birthday;
        UserQueryDB.setBirthdayUser(this.email, birthday);
    }

    /**
     * Gets the user's role.
     * 
     * @return the user's role.
     */
    public int getRole() {
        return this.role;
    }

    /**
     * Sets the user's role and updates it in the database.
     * 
     * @param role the new role to be set.
     * @throws SQLException if a database error occurs while updating the role.
     */
    public void setRole(int role) throws SQLException {
        this.role = role;
        UserQueryDB.setRoleUser(this.email, role);
    }

    /**
     * Gets the user's email address.
     * 
     * @return the user's email address.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the user's email address and reloads the user details from the database.
     * 
     * @param email the new email address to be set.
     * @throws SQLException if a database error occurs while loading the user details.
     */
    public void setEmail(String email) throws SQLException {
        this.email = email;
        loadUserDetails();
    }

    /**
     * Gets the user's password.
     * 
     * @return the user's password.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the user's password.
     * 
     * @param password the new password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user's username.
     * 
     * @return the user's username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the user's username and updates it in the database.
     * 
     * @param username the new username to be set.
     * @throws SQLException if a database error occurs while updating the username.
     */
    public void setUsername(String username) throws SQLException {
        this.username = username;
        UserQueryDB.setUsernameUser(this.email, username);
    }

    /**
     * Gets the user's address.
     * 
     * @return the user's address.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Sets the user's address and updates it in the database.
     * 
     * @param address the new address to be set.
     * @throws SQLException if a database error occurs while updating the address.
     */
    public void setAddress(String address) throws SQLException {
        this.address = address;
        UserQueryDB.setAddressUser(this.email, address);
    }

    /**
     * Gets the user's city.
     * 
     * @return the user's city.
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the user's city and updates it in the database.
     * 
     * @param city the new city to be set.
     * @throws SQLException if a database error occurs while updating the city.
     */
    public void setCity(String city) throws SQLException {
        this.city = city;
        UserQueryDB.setTownUser(this.email, city);
    }

    /**
     * Gets the user's ZIP code.
     * 
     * @return the user's ZIP code.
     */
    public String getZIPcode() {
        return this.zipCode;
    }

    /**
     * Sets the user's ZIP code and updates it in the database.
     * 
     * @param zipCode the new ZIP code to be set.
     * @throws SQLException if a database error occurs while updating the ZIP code.
     */
    public void setZIPcode(String zipCode) throws SQLException {
        this.zipCode = zipCode;
        UserQueryDB.setCAPUser(this.email, zipCode);
    }

    /**
     * Gets the user's account image ID.
     * 
     * @return the user's account image ID.
     */
    public int getImageAccount() {
        return this.imageAccount;
    }

    /**
     * Sets the user's account image ID and updates it in the database.
     * 
     * @param imageAccount the new image account ID to be set.
     * @throws SQLException if a database error occurs while updating the image account.
     */
    public void setImageAccount(int imageAccount) throws SQLException {
        this.imageAccount = imageAccount;
        UserQueryDB.setIconUser(this.email, imageAccount);
    }    
}
