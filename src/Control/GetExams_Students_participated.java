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

@WebServlet("/GetExams_Students_participated")
public class GetExams_Students_participated extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GetExams_Students_participated() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int examID = Integer.parseInt(request.getParameter("examID"));
		ArrayList<Student> ListStudents = null;
		Exam exam = null;
		
		DAO dao = new DAO();
		
		try {
			exam = dao.FindExam(examID);
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			ListStudents = dao.ShowStudentsParticipated(examID);
		} catch (InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("ListStudents", ListStudents);
		request.setAttribute("exam", exam);
		RequestDispatcher dispatcher = request.getRequestDispatcher("List.Students.Participated.jsp");
		dispatcher.forward(request, response);
	}

	

}
