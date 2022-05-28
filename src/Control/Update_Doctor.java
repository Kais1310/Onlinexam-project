package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Doctor;
import Model.Student;

@WebServlet("/Update_Doctor")
public class Update_Doctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Update_Doctor() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
		String firstname = request.getParameter("firstname");
		String lastname =request.getParameter("lastname");
		String email =request.getParameter("email");
		String module =request.getParameter("module");
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		
		Doctor doctor = new Doctor(doctor_id, firstname,  lastname,  module, email, username,  password) ;

			DAO dao = new DAO();					
		 try {
			dao.UpdateDoctor(doctor);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
				
		
		response.sendRedirect("List_Doctors");
	}

}
