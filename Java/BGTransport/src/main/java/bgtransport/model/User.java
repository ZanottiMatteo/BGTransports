package bgtransport.model;

import java.sql.SQLException;
import java.util.List;

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
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
        this.email = email;
        try {
			loadUserDetails();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public int getRole() {
        return this.role;
    }
    
    public void setRole(int role) {
		this.role = role;
	}

	public int getImageAccount() {
		return imageAccount;
	}

	public void setImageAccount(int imageAccount) {
		this.imageAccount = imageAccount;
	}

}
