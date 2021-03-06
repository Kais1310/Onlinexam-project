package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Student;


@WebServlet("/Edit_Student")
public class Edit_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Edit_Student() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();
 
        int student_id=Integer.parseInt(request.getParameter("student_id")); 
		
        Student existestudent = null;
		try {
			existestudent = dao.FindStudent(student_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student.Form.Edit.jsp");
		request.setAttribute("student", existestudent);
		dispatcher.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
