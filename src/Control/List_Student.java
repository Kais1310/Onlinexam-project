package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Student;

@WebServlet("/List_Student")
public class List_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public List_Student() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		List<Student> listStudent = null;
		String level = request.getParameter("level");
		String speciality = request.getParameter("speciality");
		
		try {
			listStudent = dao.getStudents(level,speciality);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student.List.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
