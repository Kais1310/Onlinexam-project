package Model;

public class Student {
	private int student_id;
	private String firstname;
	private String lastname;
	private String level;
	private String speciality;
	private int group;
	private String email;
	private String username;
	private String password;
	
	public Student() {
		super();
	}

	public Student(int student_id, String firstname, String lastname, String level, String speciality, int group,
			String email, String username, String password) {
		super();
		this.student_id = student_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.level = level;
		this.speciality = speciality;
		this.group = group;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Student(String firstname, String lastname, String level, String speciality, int group, String email,
			String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.level = level;
		this.speciality = speciality;
		this.group = group;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String lever) {
		this.level = lever;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
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
