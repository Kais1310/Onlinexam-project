package Model;
 
public class Exam {
	public int exam_id;
	public String module;
	public String level;
	public String speciality;
	public String type;
	public String date;
	public String duration;
	public int nbr_questions;
	public String state;
	public int doc_id;
	
	public Exam() {
		super();
	}
	
	

	public Exam(int exam_id, String module, String level, String speciality, String type, String date, String duration,
			int nbr_questions, String state, int doc_id) {
		super();
		this.exam_id = exam_id;
		this.module = module;
		this.level = level;
		this.speciality = speciality;
		this.type = type;
		this.date = date;
		this.duration = duration;
		this.nbr_questions = nbr_questions;
		this.state = state;
		this.doc_id = doc_id;
	}
	
	public Exam(String module, String level, String speciality, String type, String date, String duration,
			int nbr_questions, String state, int doc_id) {
		super();
		this.module = module;
		this.level = level;
		this.speciality = speciality;
		this.type = type;
		this.date = date;
		this.duration = duration;
		this.nbr_questions = nbr_questions;
		this.state = state;
		this.doc_id = doc_id;
	}



	public int getExam_id() {
		return exam_id;
	}



	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
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



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
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



	public int getNbr_questions() {
		return nbr_questions;
	}



	public void setNbr_questions(int nbr_questions) {
		this.nbr_questions = nbr_questions;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public int getDoc_id() {
		return doc_id;
	}



	public void setDoc_id(int doc_id) {
		this.doc_id = doc_id;
	}

	

}
