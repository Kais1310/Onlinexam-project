package Model;

public class Answer {
	public String question;
	public String answer;
	public int examID;
	public int studentID;
	
	
	public Answer() {
		super();
	}
	
	public Answer(String question, String answer, int examID, int studentID) {
		super();
		this.question = question;
		this.answer = answer;
		this.examID = examID;
		this.studentID = studentID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getExamID() {
		return examID;
	}

	public void setExamID(int examID) {
		this.examID = examID;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	

}
