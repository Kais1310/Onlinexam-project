package Model;

public class Doctor {
	private int doctor_id;
	private String firstname;
	private String lastname;
	private String email;
	private String module;
	private String username;
	private String password;
	
	public Doctor() {
		super();
	}
	
	public Doctor(int doctor_id, String firstname, String lastname, String email, String module, String username, String password) {
		super();
		this.doctor_id = doctor_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.module = module;
		this.username = username;
		this.password = password;
	}


	public Doctor(String firstname, String lastname, String email, String module, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.module = module;
		this.username = username;
		this.password = password;
	}


	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
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

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
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
