package Model;

public class Monitor {
	private int monitor_id;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String password;
	
	public Monitor() {
		super();
	}

	public Monitor(int monitor_id, String firstname, String lastname, String email, String username, String password) {
		super();
		this.monitor_id = monitor_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public Monitor(String firstname, String lastname, String email, String username, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getMonitor_id() {
		return monitor_id;
	}

	public void setMonitor_id(int monitor_id) {
		this.monitor_id = monitor_id;
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
