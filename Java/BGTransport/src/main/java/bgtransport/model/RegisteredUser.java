package bgtransport.model;

import java.sql.SQLException;
import java.util.List;

public class RegisteredUser{

	String name;
	String surname;
	String birthday;
	String email;
	String password;
	String username;
	String address;
	String city;
	String zipCode;
	int imageAccount;
	int role;
	
	private void loadUserDetails() throws SQLException {
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
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) throws SQLException {
		this.name = name;
		UserQueryDB.setNameUser(this.email, name);
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) throws SQLException {
		this.surname = surname;
		UserQueryDB.setSurnameUser(this.email, surname);
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) throws SQLException {
		this.birthday = birthday;
		UserQueryDB.setBirthdayUser(this.email, birthday);
	}

	public int getRole() {
		return this.role;
	}

	public void setRole(int role) throws SQLException {
		this.role = role;
		UserQueryDB.setRoleUser(this.email, role);
	}

	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) throws SQLException {
		this.email = email;
		loadUserDetails();
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) throws SQLException {
		this.username = username;
		UserQueryDB.setUsernameUser(this.email, username);
	}
	
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) throws SQLException {
		this.address = address;
		UserQueryDB.setAddressUser(this.email, address);
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) throws SQLException {
		this.city = city;
		UserQueryDB.setTownUser(this.email, city);
	}

	public String getZIPcode() {
		return this.zipCode;
	}

	public void setZIPcode(String zipCode) throws SQLException {
		this.zipCode = zipCode;
		UserQueryDB.setCAPUser(this.email, zipCode);
	}

	public int getImageAccount() {
		return this.imageAccount;
	}
	public void setImageAccount(int imageAccount) throws SQLException {
		this.imageAccount = imageAccount;
		UserQueryDB.setIconUser(this.email, imageAccount);
	}	
	
	
}
