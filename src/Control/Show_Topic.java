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

import Model.DAO;
import Model.Exam;
import Model.Question;
import Model.Topic;

@WebServlet("/Show_Topic")
public class Show_Topic extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Show_Topic() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
     DAO dao = new DAO();
		
		ArrayList<Topic> TopicQuestions = null;
		Exam exam = null;
		 
		int exam_id= Integer.parseInt(request.getParameter("exam_id"));
		
			try {
				TopicQuestions = dao.getTopic(exam_id);
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				
				e.printStackTrace();
			}
		
		try {
			 exam = dao.FindExam(exam_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("TopicQuestions", TopicQuestions);
		request.setAttribute("exam", exam);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Topic.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
