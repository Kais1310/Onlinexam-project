package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Teacher;

@WebServlet("/Update_Teacher")
public class Update_Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Update_Teacher() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
		String firstname = request.getParameter("firstname");
		String lastname =request.getParameter("lastname");
		String email =request.getParameter("email");
		String module =request.getParameter("module");
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		
		Teacher teacher = new Teacher(teacher_id, firstname,  lastname,  module, email, username,  password) ;

			DAO dao = new DAO();					
		 try {
			dao.UpdateTeacher(teacher);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
				
		
		response.sendRedirect("List_Teachers");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
