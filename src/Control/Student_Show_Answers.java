package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Answer;
import Model.DAO;
import Model.Exam;
import Model.Topic;

@WebServlet("/Student_Show_Answers")
public class Student_Show_Answers extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Student_Show_Answers() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    DAO dao = new DAO();
			
			ArrayList<Answer> StudentAnswers = null;
			 
			int examID= Integer.parseInt(request.getParameter("examID"));
			int studentID= Integer.parseInt(request.getParameter("studentID"));
			
				
			try {
				StudentAnswers = dao.ShowAnswers(examID,studentID);
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				e.printStackTrace();
			}
			
			
			request.setAttribute("StudentAnswers", StudentAnswers);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Student.Show.Answers.jsp");
			dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
