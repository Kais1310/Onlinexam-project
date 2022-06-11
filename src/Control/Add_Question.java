package Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Question;

@WebServlet("/Add_Question")
public class Add_Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Add_Question() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Question.Form.Add.jsp");
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String module = request.getParameter("module");
		String content = request.getParameter("content");
		String choice1 = request.getParameter("choice1");
		String choice2 = request.getParameter("choice2");
		String choice3 = request.getParameter("choice3");
		String choice4 = request.getParameter("choice4");
		String right_answer = request.getParameter("right_answer");
		String type = request.getParameter("type");
		int banque_id = Integer.parseInt(request.getParameter("banque_id"));
		int doctorID = Integer.parseInt(request.getParameter("doctorID"));
		
		
		
		Question question = new Question();
		DAO dao = new DAO();
		
		question = new Question(module,content,choice1,choice2,choice3,choice4,right_answer,type,banque_id,doctorID);
		
		try {
			dao.Doctor_AddQuestion(question);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("QuestionAdded.jsp");
		dispatcher.include(request, response);
	}

}
