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
import Model.Note;
import Model.Student;


@WebServlet("/Get_Notes")
public class Get_Notes extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Get_Notes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		DAO dao = new DAO();

		ArrayList<Note> ListNotes = null;
		Student student = null;
		
		
			try {
				ListNotes = dao.ShowNotes(studentID);
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				
				e.printStackTrace();
			}
			try {
				student = dao.FindStudent(studentID);
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		request.setAttribute("ListNotes", ListNotes);
		request.setAttribute("student", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student.Notes.jsp");
		dispatcher.forward(request, response);
	}

	

}
