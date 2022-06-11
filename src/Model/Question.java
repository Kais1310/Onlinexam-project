package Model;

public class Question {
	public int question_id;
	public String module;
	public String content;
	public String choice1;
	public String choice2;
	public String choice3;
	public String choice4;
	public String right_answer;
	public String type;
	public int banque_id;
	public int doctorID;
	public int teacherID;
	
	public Question() {
		super();
	}
	
	public Question(int question_id, String module, String content, String choice1, String choice2, String choice3,
			String choice4, String right_answer, String type,int banque_id, int doctorID, int teacherID) {
		super();
		this.question_id = question_id;
		this.module = module;
		this.content = content;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.right_answer = right_answer;
		this.type = type;
		this.banque_id = banque_id;
		this.doctorID= doctorID;
		this.teacherID = teacherID;
	}


	public Question(String module, String content, String choice1, String choice2, String choice3, String choice4,
			String right_answer, String type,int banque_id,int doctorID, int teacherID) {
		super();
		this.module = module;
		this.content = content;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.right_answer = right_answer;
		this.type = type;
		this.banque_id = banque_id;
		this.doctorID= doctorID;
		this.teacherID = teacherID;
	}


	public Question( String module, String content, String choice1, String choice2, String choice3,
			String choice4, String right_answer, String type, int banque_id, int doctorID) {
		super();
		
		this.module = module;
		this.content = content;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.right_answer = right_answer;
		this.type = type;
		this.banque_id = banque_id;
		this.doctorID = doctorID;
	}

	public Question(int question_id, String module, String content, String choice1, String choice2, String choice3,
			String choice4, String right_answer, String type) {
		super();
		this.question_id = question_id;
		this.module = module;
		this.content = content;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.right_answer = right_answer;
		this.type = type;
	}

	public int getQuestion_id() {
		return question_id;
	}


	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}


	public String getModule() {
		return module;
	}


	public void setModule(String module) {
		this.module = module;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String question) {
		this.content = question;
	}


	public String getChoice1() {
		return choice1;
	}


	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}


	public String getChoice2() {
		return choice2;
	}


	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}


	public String getChoice3() {
		return choice3;
	}


	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}


	public String getChoice4() {
		return choice4;
	}


	public void setChoice4(String choice4) {
		this.choice4 = choice4;
	}


	public String getRight_answer() {
		return right_answer;
	}


	public void setRight_answer(String right_answer) {
		this.right_answer = right_answer;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	public int getBanque_id() {
		return banque_id;
	}

	public void setBanque_id(int banque_id) {
		this.banque_id = banque_id;
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
