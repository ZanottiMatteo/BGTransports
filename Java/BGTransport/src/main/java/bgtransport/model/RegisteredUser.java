package bgtransport.model;

import java.sql.SQLException;
import java.util.List;

/**
 * Represents a registered user in the system. This class contains user details such as name, surname, email,
 * password, and other related information. It provides methods to get and set these details, with changes being
 * persisted in the database.
 */
public class RegisteredUser extends User {

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
    private int role = 1;

    /**
     * Loads user details from the database based on the user's email. This method retrieves user information from
     * the database and populates the user's attributes.
     * 
     * @throws SQLException if a database error occurs while fetching user details.
     */
    @Override
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
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Sets the user's name and updates it in the database.
     * 
     * @param name the new name to be set.
     * @throws SQLException if a database error occurs while updating the name.
     */
    @Override
    public void setName(String name) {
        this.name = name;
        try {
            UserQueryDB.setNameUser(this.email, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the user's surname.
     * 
     * @return the user's surname.
     */
    @Override
    public String getSurname() {
        return this.surname;
    }

    /**
     * Sets the user's surname and updates it in the database.
     * 
     * @param surname the new surname to be set.
     */
    @Override
    public void setSurname(String surname) {
        this.surname = surname;
        try {
            UserQueryDB.setSurnameUser(this.email, surname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the user's birthday.
     * 
     * @return the user's birthday.
     */
    @Override
    public String getBirthday() {
        return this.birthday;
    }

    /**
     * Sets the user's birthday and updates it in the database.
     * 
     * @param birthday the new birthday to be set.
     */
    @Override
    public void setBirthday(String birthday) {
        this.birthday = birthday;
        try {
            UserQueryDB.setBirthdayUser(this.email, birthday);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the user's role.
     * 
     * @return the user's role.
     */
    @Override
    public int getRole() {
        return this.role;
    }

    /**
     * Gets the user's email address.
     * 
     * @return the user's email address.
     */
    @Override
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the user's email address and reloads the user details from the database.
     * 
     * @param email the new email address to be set.
     */
    @Override
    public void setEmail(String email) {
        this.email = email;
        try {
            loadUserDetails();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the user's password.
     * 
     * @return the user's password.
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the user's password.
     * 
     * @param password the new password to be set.
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the user's username.
     * 
     * @return the user's username.
     */
    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the user's username and updates it in the database.
     * 
     * @param username the new username to be set.
     */
    @Override
    public void setUsername(String username) {
        this.username = username;
        try {
            UserQueryDB.setUsernameUser(this.email, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the user's address.
     * 
     * @return the user's address.
     */
    @Override
    public String getAddress() {
        return this.address;
    }

    /**
     * Sets the user's address and updates it in the database.
     * 
     * @param address the new address to be set.
     */
    @Override
    public void setAddress(String address) {
        this.address = address;
        try {
            UserQueryDB.setAddressUser(this.email, address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the user's city.
     * 
     * @return the user's city.
     */
    @Override
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the user's city and updates it in the database.
     * 
     * @param city the new city to be set.
     */
    @Override
    public void setCity(String city) {
        this.city = city;
        try {
            UserQueryDB.setTownUser(this.email, city);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the user's ZIP code.
     * 
     * @return the user's ZIP code.
     */
    @Override
    public String getZipCode() {
        return this.zipCode;
    }

    /**
     * Sets the user's ZIP code and updates it in the database.
     * 
     * @param zipCode the new ZIP code to be set.
     */
    @Override
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
        try {
            UserQueryDB.setCAPUser(this.email, zipCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the user's account image ID.
     * 
     * @return the user's account image ID.
     */
    @Override
    public int getImageAccount() {
        return this.imageAccount;
    }

    /**
     * Sets the user's account image ID and updates it in the database.
     * 
     * @param imageAccount the new image account ID to be set.
     */
    @Override
    public void setImageAccount(int imageAccount) {
        this.imageAccount = imageAccount;
        try {
            UserQueryDB.setIconUser(this.email, imageAccount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
