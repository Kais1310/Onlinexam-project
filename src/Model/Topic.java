package Model;

public class Topic {
	
	public int topic_id;
	public String module;
	public String question_type;
	public String question;
	public String choice1;
	public String choice2;
	public String choice3;
	public String choice4;
	public int exam_id;
	
	public Topic() {
		super();
	}
	public Topic(int topic_id, String module,String question_type, String question, String choice1, String choice2, String choice3,
			String choice4,int exam_id) {
		super();
		this.topic_id = topic_id;
		this.module = module;
		this.question_type = question_type;
		this.question = question;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.exam_id = exam_id;
	}


	public Topic(String module, String question_type, String question, String choice1, String choice2, String choice3, String choice4, int exam_id) {
		super();
		this.module = module;
		this.question_type = question_type;
		this.question = question;
		this.choice1 = choice1;
		this.choice2 = choice2;
		this.choice3 = choice3;
		this.choice4 = choice4;
		this.exam_id = exam_id;
	}


	public int getTopic_id() {
		return topic_id;
	}


	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}


	public String getModule() {
		return module;
	}


	public void setModule(String module) {
		this.module = module;
	}


	public String getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(String question_type) {
		this.question_type = question_type;
	}
	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
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
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	
	

}
