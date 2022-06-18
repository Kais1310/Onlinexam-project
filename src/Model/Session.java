package Model;

public class Session {
	
public int session_id;
public String level;
public String speciality;
public String date;
public String exam;
public String meet_link;
public int doctorID;
public int teacherID;

public Session() {
	super();
}

public Session(int session_id, String level, String speciality, String date, String exam, String meet_link,
		int doctorID, int teacherID) {
	super();
	this.session_id = session_id;
	this.level = level;
	this.speciality = speciality;
	this.date = date;
	this.exam = exam;
	this.meet_link = meet_link;
	this.doctorID = doctorID;
	this.teacherID = teacherID;
}

public Session(String level, String speciality, String date, String exam, String meet_link, int doctorID,
		int teacherID) {
	super();
	this.level = level;
	this.speciality = speciality;
	this.date = date;
	this.exam = exam;
	this.meet_link = meet_link;
	this.doctorID = doctorID;
	this.teacherID = teacherID;
}


public Session(String level, String speciality, String date, String exam, String meet_link, int doctorID) {
	super();
	this.level = level;
	this.speciality = speciality;
	this.date = date;
	this.exam = exam;
	this.meet_link = meet_link;
	this.doctorID = doctorID;
}


public int getSession_id() {
	return session_id;
}

public void setSession_id(int session_id) {
	this.session_id = session_id;
}

public String getLevel() {
	return level;
}

public void setLevel(String level) {
	this.level = level;
}

public String getSpeciality() {
	return speciality;
}

public void setSpeciality(String speciality) {
	this.speciality = speciality;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getExam() {
	return exam;
}

public void setExam(String exam) {
	this.exam = exam;
}

public String getMeet_link() {
	return meet_link;
}

public void setMeet_link(String meet_link) {
	this.meet_link = meet_link;
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



