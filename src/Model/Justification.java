package Model;

public class Justification {
	
	public int justification_id;
	public String firstname;
	public String lastname;
	public String level;
	public String speciality;
	public int group;
	public String module;
	public String Date_ajoute;
	public String Date_absence;
	public String seance;
	public String justification;
	public String fileName;
	public String savePath;
	public int studentID;
	 
	public Justification() {
		super();
	}

	public Justification(int justification_id,String firstname, String lastname,String level, String speciality, int group, String module, String date_ajoute, String date_absence, String seance,
			String justification, String fileName,String savePath, int studentID) {
		super();
		this.justification_id = justification_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.level = level;
		this.speciality = speciality;
		this.group = group;
		this.module = module;
		Date_ajoute = date_ajoute;
		Date_absence = date_absence;
		this.seance = seance;
		this.justification = justification;
		this.fileName = fileName;
		this.savePath = savePath;
		this.studentID = studentID;
	}

	public Justification(String firstname, String lastname,String level, String speciality, int group,String module, String date_ajoute, String date_absence, String seance, String justification,String fileName,String savePath, int studentID) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.level = level;
		this.speciality = speciality;
		this.group = group;
		this.module = module;
		Date_ajoute = date_ajoute;
		Date_absence = date_absence;
		this.seance = seance;
		this.justification = justification;
		this.fileName = fileName;
		this.savePath = savePath;
		this.studentID = studentID;
	}

	public int getJustification_id() {
		return justification_id;
	}

	public void setJustification_id(int justification_id) {
		this.justification_id = justification_id;
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

	public void setLevel(String level) {
		this.level = level;
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

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getDate_ajoute() {
		return Date_ajoute;
	}

	public void setDate_ajoute(String date_ajoute) {
		Date_ajoute = date_ajoute;
	}

	public String getDate_absence() {
		return Date_absence;
	}

	public void setDate_absence(String date_absence) {
		Date_absence = date_absence;
	}

	public String getSeance() {
		return seance;
	}

	public void setSeance(String seance) {
		this.seance = seance;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	
}
