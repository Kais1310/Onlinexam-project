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
import Model.Student;


@WebServlet("/Create_Student")
public class Create_Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Create_Student() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher = request.getRequestDispatcher("Student.Form.jsp");
			dispatcher.include(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        String firstname = request.getParameter("firstname");	
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String level = request.getParameter("level");
        String speciality = request.getParameter("speciality");

        int group = Integer.parseInt(request.getParameter("group"));
		
        String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Student student = new Student( firstname,  lastname,  level,  speciality,  group,  email, username,  password) ;
		
			
			
				DAO dao = new DAO();
				
			  try {
				dao.AddStudent(student);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		
		    PrintWriter out = response.getWriter();
		    
		    out.print("<p>Student account added successfully!</p>");  
		   		    
            
		    RequestDispatcher dispatcher = request.getRequestDispatcher("Student.Form.jsp");
			dispatcher.include(request, response);

		
		
	

	}
}


