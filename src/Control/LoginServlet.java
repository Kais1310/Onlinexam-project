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
import Model.Professor;
import Model.Monitor;
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
			}else if (request.getSession().getAttribute("teacher") != null) {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Home.Teacher.jsp");
				dispatcher.include(request, response);
				}else if (request.getSession().getAttribute("Admin") != null) {
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("Home.Admin.jsp");
					dispatcher.include(request, response);
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("Login.Forme.jsp");
						dispatcher.include(request, response);
					}
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		
        String Role = request.getParameter("Role");
        
        String username = request.getParameter("username");
		String password = request.getParameter("password");
		

		DAO dao = new DAO();
		
       switch (Role) {
       
       case "Student":
    	   
   		try {

   			Student student = dao.checkLoginStudent(username, password);
   			

   			if (student != null) {
   				
   				
   				HttpSession session = request.getSession();
   				session.setAttribute("student", student);

   				dispatcher = request.getRequestDispatcher("Home.Student.jsp");
   				dispatcher.forward(request, response);

   			} 
   			else {

   				PrintWriter out = response.getWriter();

   				dispatcher = request.getRequestDispatcher("Login.Forme.jsp");
   				dispatcher.include(request, response);

   				out.print("<center><h2> Incorect user or password !!<h2>");
   			}

   		} catch (InstantiationException | IllegalAccessException e) {
   			e.printStackTrace();
   		}
   		break;
		
       case "Teacher":
    	   
   		try {

   			Teacher teacher = dao.checkLoginTeacher(username, password);
   			

   			if (teacher != null) {
   				
   				
   				HttpSession session = request.getSession();
   				session.setAttribute("teacher", teacher);

   				dispatcher = request.getRequestDispatcher("Home.Teacher.jsp");
   				dispatcher.forward(request, response);

   			} 
   			else {

   				PrintWriter out = response.getWriter();

   				dispatcher = request.getRequestDispatcher("Login.Forme.jsp");
   				dispatcher.include(request, response);

   				out.print("<center><h2> Incorect user or password !!<h2>");
   			}

   		} catch (InstantiationException | IllegalAccessException e) {
   			e.printStackTrace();
   		}
   		break;
   		
       case "Admin":
    	   
      		try {

      			Admin admin = dao.checkLoginAdmin(username, password);
      			

      			if (admin != null) {
      				
      				
      				HttpSession session = request.getSession();
      				session.setAttribute("admin", admin);

      				dispatcher = request.getRequestDispatcher("Home.Admin.jsp");
      				dispatcher.forward(request, response);

      			} 
      			else {

      				PrintWriter out = response.getWriter();

      				dispatcher = request.getRequestDispatcher("Login.Forme.jsp");
      				dispatcher.include(request, response);

      				out.print("<center><h2> Incorect user or password !!<h2>");
      			}

      		} catch (InstantiationException | IllegalAccessException e) {
      			e.printStackTrace();
      		}
      		break;
      		
       case "Professor":
    	   
     		try {

     			Professor professor = dao.checkLoginProfessor(username, password);
     			

     			if (professor != null) {
     				
     				
     				HttpSession session = request.getSession();
     				session.setAttribute("professor", professor);

     				dispatcher = request.getRequestDispatcher("Home.Professor.jsp");
     				dispatcher.forward(request, response);

     			} 
     			else {

     				PrintWriter out = response.getWriter();

     				dispatcher = request.getRequestDispatcher("Login.Forme.jsp");
     				dispatcher.include(request, response);

     				out.print("<center><h2> Incorect user or password !!<h2>");
     			}

     		} catch (InstantiationException | IllegalAccessException e) {
     			e.printStackTrace();
     		}
     		break;

       case "Supervisor":
    	   
    		try {

    			Monitor monitor = dao.checkLoginMonitor(username, password);
    			

    			if (monitor != null) {
    				
    				
    				HttpSession session = request.getSession();
    				session.setAttribute("monitor", monitor);

    				dispatcher = request.getRequestDispatcher("Home.Monitor.jsp");
    				dispatcher.forward(request, response);

    			} 
    			else {

    				PrintWriter out = response.getWriter();

    				dispatcher = request.getRequestDispatcher("Login.Forme.jsp");
    				dispatcher.include(request, response);

    				out.print("<center><h2> Incorect user or password !!<h2>");
    			}

    		} catch (InstantiationException | IllegalAccessException e) {
    			e.printStackTrace();
    		}
    		break;

	}
       
	}
	
}
	



