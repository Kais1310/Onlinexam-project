package Model;

public class Admin {
	private int admin_id;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	
	
	
	public Admin() {
		super();
		
	}



	public Admin(int admin_id, String firstname, String lastname, String email, String username, String password) {
		super();
		this.admin_id = admin_id;
		this.username = username;
		this.password = password;
	}
	


	public Admin(String firstname, String lastname, String email ,String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
