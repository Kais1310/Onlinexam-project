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
import Model.Session;

@WebServlet("/Student_Session")
public class Student_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Student_Session() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	DAO dao = new DAO();
		
	   	 ArrayList<Session> sessions = null;
		 ArrayList<Exam> ListExams = null;
		 
		 String level = request.getParameter("level");
		 String speciality = request.getParameter("speciality");
		 
		     try {
			   sessions = dao.StudentSession(level, speciality);
		     } catch (InstantiationException | IllegalAccessException | SQLException e1) {
		     	e1.printStackTrace();
		     }
		     
			try {
				ListExams = dao.getStudentExams(level,speciality);
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				
				e.printStackTrace();
			}
		
		request.setAttribute("sessions", sessions);
		request.setAttribute("ListExams", ListExams);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student.Session.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
