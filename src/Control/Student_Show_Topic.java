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
import Model.Student;
import Model.Topic;


@WebServlet("/Student_Show_Topic")
public class Student_Show_Topic extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Student_Show_Topic() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       DAO dao = new DAO();
		
		ArrayList<Topic> TopicQuestions = null;
		Exam exam = null;
		Student student = null;
		 
		int exam_id= Integer.parseInt(request.getParameter("exam_id"));
		int student_id= Integer.parseInt(request.getParameter("student_id"));
		
		
		try {
			student = dao.FindStudent(student_id);
		} catch (InstantiationException | IllegalAccessException e1) {
			e1.printStackTrace();
		}
			
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
		request.setAttribute("student", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student.Topic.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
