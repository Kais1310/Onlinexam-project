package Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Admin;
import Model.Student;
import Model.Teacher;
import Model.Doctor;
import Model.DAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			if (request.getSession().getAttribute("student") != null) {
		
			 RequestDispatcher dispatcher = request.getRequestDispatcher("Home.Student.jsp");
		     dispatcher.include(request, response);
		     
			   }else if(request.getSession().getAttribute("doctor")!=null) {
					  
				   RequestDispatcher dispatcher =request.getRequestDispatcher("Home.Doctor.jsp");
				   dispatcher.include(request, response);
			       
			       }else if (request.getSession().getAttribute("teacher") != null) {
				
				    RequestDispatcher dispatcher = request.getRequestDispatcher("Home.Teacher.jsp");
				    dispatcher.include(request, response);
				    
				   }else if(request.getSession().getAttribute("admin")!=null) {
					  
					   RequestDispatcher dispatcher =request.getRequestDispatcher("List_Student");
					   dispatcher.include(request, response);
				       
				       }else {
					     
				    	   RequestDispatcher dispatcher = request.getRequestDispatcher("HOME.jsp");
					       dispatcher.include(request, response);
				       }
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
        String username = request.getParameter("username");
		String password = request.getParameter("password");
		

		DAO dao = new DAO();
		
       // you need to check username and password in account of all your actors 
    	   
   	try {
          // verify if username and password are for Student account
   		
   			Student student = dao.checkLoginStudent(username, password);
   			

   			if (student != null) {
   				
   				HttpSession session = request.getSession();
   				session.setAttribute("student", student);

   				RequestDispatcher dispatcher = request.getRequestDispatcher("Home.Student.jsp");
   				dispatcher.forward(request, response);

   			
   			}else {
   				
   			// verify if username and password are for doctor account
   				
   				Doctor doctor = dao.checkLoginDoctor(username, password);
   				
   				if (doctor != null) {
   	   				
   	   				
   	   				HttpSession session = request.getSession();
   	   				session.setAttribute("doctor", doctor);

   	   			RequestDispatcher dispatcher = request.getRequestDispatcher("Home.Doctor.jsp");
   	   				dispatcher.forward(request, response);
   				

   	   			} else {
   	   				
   	   		      // verify if username and password are for teacher account
   	   				
   	   				Teacher teacher = dao.checkLoginTeacher(username, password);
   	   				
   	   				    if (teacher != null) {
   	   	   				
   	   	   				
   	   	   				     HttpSession session = request.getSession();
   	   	   				     session.setAttribute("teacher", teacher);

   	   	   			         RequestDispatcher dispatcher = request.getRequestDispatcher("Home.Teacher.jsp");
   	   	   				     dispatcher.forward(request, response);
   	   				

   	   	   			     } else {
   	   				
   	   	   		         	// verify if username and password are for admin account
   	    			
   	   			            	Admin admin = dao.checkLoginAdmin(username, password);
   	   				
   	   				           if (admin != null) {
   	   	   				
   	   	   				
   	   	   			        	HttpSession session = request.getSession();
   	   	   			        	session.setAttribute("admin", admin);

   	   	   			            RequestDispatcher dispatcher = request.getRequestDispatcher("List_Student");
   	   	   				        dispatcher.forward(request, response);

   	   	   			           } else {
   	   			
   	   	   			        	   // username and password not in any table of actors in the database.
   	   	   			        	   
   	   	   			               RequestDispatcher dispatcher = request.getRequestDispatcher("HOME2.jsp");
   				                   dispatcher.include(request, response);
   				                   
   				                   PrintWriter out = response.getWriter();   
   				                   out.print("<center><h2> Incorect username or password !!<h2>");
   				                
   				               }

   		                }
   		     }
   	     }
   	  }catch (InstantiationException | IllegalAccessException e) {
   			e.printStackTrace();
   	  }
   		
		
      
  } 	
}
   		