package Model;

public class Planning {
	public int planning_id;
	public String module;
	public String level;
	public String speciality;
	public String date;
	public String duration;
	public String salle;
	public int adminID;
	
	public Planning() {
		super();
	}

	public Planning(int planning_id, String module, String level, String speciality, String date, String duration, String salle,
			int adminID) {
		super();
		this.planning_id = planning_id;
		this.module = module;
		this.level = level;
		this.speciality = speciality;
		this.date = date;
		this.duration = duration;
		this.salle = salle;
		this.adminID = adminID;
	}

	public Planning(String module, String level, String speciality, String date, String duration, String salle, int adminID) {
		super();
		this.module = module;
		this.level = level;
		this.speciality = speciality;
		this.date = date;
		this.duration = duration;
		this.salle = salle;
		this.adminID = adminID;
	}

	public int getPlanning_id() {
		return planning_id;
	}

	public void setPlanning_id(int planning_id) {
		this.planning_id = planning_id;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSalle() {
		return salle;
	}

	public void setSalle(String salle) {
		this.salle = salle;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	
	
}
