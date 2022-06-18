package Model;

public class Note {
	
	public int note_id;
	public String module;
	public String note;
	public int studentID;
	public int doctorID;
	public int teacherID;
	
	
	public Note() {
		super();
	}


	public Note(int note_id, String module, String note, int studentID, int doctorID, int teacherID) {
		super();
		this.note_id = note_id;
		this.module = module;
		this.note = note;
		this.studentID = studentID;
		this.doctorID = doctorID;
		this.teacherID = teacherID;
	}


	public Note(String module, String note, int studentID, int doctorID) {
		super();
		this.module = module;
		this.note = note;
		this.studentID = studentID;
		this.doctorID = doctorID;
	}
	
	

	public Note(String module, String note, int studentID) {
		super();
		this.module = module;
		this.note = note;
		this.studentID = studentID;
	}


	public int getNote_id() {
		return note_id;
	}


	public void setNote_id(int note_id) {
		this.note_id = note_id;
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


	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	public int getDoctorID() {
		return doctorID;
	}


	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}


	public int getTeacherID() {
		return teacherID;
	}


	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	
	

}
