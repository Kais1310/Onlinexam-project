package Model;

public class Teacher {
	private int teacher_id;
	private String firstname;
	private String lastname;
	private String module;
	private String email;
	private String username;
	private String password;
	
	
	public Teacher() {
		super();
	}
	
	
	public Teacher(int teacher_id, String firstname, String lastname, String module, String email, String username,
			String password) {
		super();
		this.teacher_id = teacher_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.module = module;
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public Teacher(String firstname, String lastname, String module, String email, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.module = module;
		this.email = email;
		this.username = username;
		this.password = password;
	}


	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
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
