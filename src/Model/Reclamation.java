package Model;

public class Reclamation {
	public int reclamation_id;
	public String firstname;
	public String lastname;
	public String module;
	public String note;
	public String date;
	public int studentID;
	
	public Reclamation() {
		super();
	}

	public Reclamation(String firstname, String lastname, String module, String note, String date, int studentID) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.module = module;
		this.note = note;
		this.date = date;
		this.studentID = studentID;
	}

	public int getReclamation_id() {
		return reclamation_id;
	}

	public void setReclamation_id(int reclamation_id) {
		this.reclamation_id = reclamation_id;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	
	
}
