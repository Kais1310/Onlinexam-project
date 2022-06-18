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
import Model.Teacher;

@WebServlet("/Create_Teacher")
public class Create_Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Create_Teacher() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher dispatcher = request.getRequestDispatcher("Teacher.Form.Add.jsp");
			dispatcher.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");	
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String module = request.getParameter("module");
        String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Teacher teacher = new Teacher( firstname,  lastname,  module, email, username,  password) ;
		
			
			
				DAO dao = new DAO();
				
			  try {
				dao.AddTeacher(teacher);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		
		    PrintWriter out = response.getWriter();
		    
		    out.print("<p>Teacher account added successfully!</p>");  
		   		    
            
		    RequestDispatcher dispatcher = request.getRequestDispatcher("Teacher.Form.Add.jsp");
			dispatcher.include(request, response);
	}

}
