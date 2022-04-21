package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Student;


@WebServlet("/Update_Student")
public class Update_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Update_Student() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
      
		int student_id = Integer.parseInt(request.getParameter("student_id"));
		String firstname = request.getParameter("firstname");
		String lastname =request.getParameter("lastname");
		String email =request.getParameter("email");
		String level =request.getParameter("level");
		String speciality =request.getParameter("speciality");
		int group = Integer.parseInt(request.getParameter("group"));
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		
		Student student = new Student(student_id, firstname,  lastname,  level,  speciality,  group,  email, username,  password) ;

			DAO dao = new DAO();					
		 try {
			dao.UpdateStudent(student);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
				
		
		response.sendRedirect("List_Student");
	}

}
