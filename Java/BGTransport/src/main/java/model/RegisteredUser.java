package model;

import java.sql.SQLException;
import java.util.List;

import org.jooq.DSLContext;

import controller.LoginController;

public class RegisteredUser extends User{

	String name;
	String surname;
	String birthday;
	String email;
	String password;
	String username;
	String address;
	String city;
	String ZIPcode;
	int imageAccount;
	int role;
	
	 public RegisteredUser() {
	        this.email = LoginController.FinalEmail;
	    }
	
	private void loadUserDetails() throws SQLException {
        List<String> userDetails = QueryDB.getUserDetailsByEmail(this.email);

        if (!userDetails.isEmpty()) {
            this.name = userDetails.get(0);
            this.surname = userDetails.get(1);
            this.username = userDetails.get(2);
            this.birthday = userDetails.get(3);
            this.address = userDetails.get(4);
            this.city = userDetails.get(5);
            this.ZIPcode = userDetails.get(6);
            this.password = userDetails.get(7);  // Se desideri includere la password
            this.role = Integer.parseInt(userDetails.get(8));  // Converte il ruolo in intero
            this.imageAccount = Integer.parseInt(userDetails.get(9));
        }
    }
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getRole() {
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
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

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZIPcode() {
		return this.ZIPcode;
	}

	public void setZIPcode(String ZIPcode) {
		this.ZIPcode = ZIPcode;
	}

	public void setImageAccount(int imageAccount) {
		this.imageAccount = imageAccount;
	}	
	
	public int getImageAccount() {
		return this.imageAccount;
	}
}
