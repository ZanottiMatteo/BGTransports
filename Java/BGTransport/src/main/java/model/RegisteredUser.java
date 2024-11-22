package model;

public class RegisteredUser extends User{

	String email = "ciao@gmail.com";
	String password = "1234";
	String username = "Ciao";
	String address;
	String city;
	String ZIPcode;
	
	public RegisteredUser(String name, String surname, String birthday, int role) {
		super(name, surname, birthday, role);
		
	}	

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setZIPcode(String zIPcode) {
		this.ZIPcode = zIPcode;
	}	
}
