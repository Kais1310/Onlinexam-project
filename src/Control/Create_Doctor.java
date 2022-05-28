package Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Doctor;
import Model.Student;

@WebServlet("/Create_Doctor")
public class Create_Doctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Create_Doctor() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("Doctor.Form.Add.jsp");
			dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String firstname = request.getParameter("firstname");	
	        String lastname = request.getParameter("lastname");
	        String email = request.getParameter("email");
	        String module = request.getParameter("module");
	        String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Doctor doctor = new Doctor( firstname,  lastname,  module, email, username,  password) ;
			
				
				
					DAO dao = new DAO();
					
				  try {
					dao.AddDoctor(doctor);
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				
			
			    PrintWriter out = response.getWriter();
			    
			    out.print("<p>Doctor account added successfully!</p>");  
			   		    
	            
			    RequestDispatcher dispatcher = request.getRequestDispatcher("Doctor.Form.Add.jsp");
				dispatcher.include(request, response);

			
			
		

	}

}
