package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Exam;
import Model.Answer;

@WebServlet("/AddAnswers")
public class AddAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddAnswers() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();
		Exam exam = null;
		
		 int examID = Integer.parseInt(request.getParameter("examID"));
		 int studentID = Integer.parseInt(request.getParameter("studentID"));
		String[] questions = request.getParameterValues("question");
		String[] answers = request.getParameterValues("answer");
		
		
		 
			for(int i=0;i<questions.length;i++) {
				
				String question = questions[i];
				String answer = answers[i];
				
				Answer answerS = new Answer(question,answer,examID,studentID);
				
				try {
					dao.AddAnswers(answerS);
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
			
			
			 try {
					exam = dao.FindExam(examID);
				} catch (InstantiationException | IllegalAccessException e1) {
					e1.printStackTrace();
				}
			 
			 
		request.setAttribute("exam", exam);	 
		RequestDispatcher dispatcher = request.getRequestDispatcher("ExamFinished.jsp");
		dispatcher.forward(request, response);
	}

}
