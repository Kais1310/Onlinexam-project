package Model;

public class Professor {
	private int professor_id;
	private String firstname;
	private String lastname;
	private String module;
	private String email;
	private String username;
	private String password;
	
	
	
	public Professor() {
		super();
		
	}


	public Professor(int professor_id, String firstname, String lastname, String module, String email, String username,
			String password) {
		super();
		this.professor_id = professor_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.module = module;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	
	public Professor(String firstname, String lastname, String module, String email, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.module = module;
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public int getProfessor_id() {
		return professor_id;
	}
	public void setProfessor_id(int professor_id) {
		this.professor_id = professor_id;
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
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
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
