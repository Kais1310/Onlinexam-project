package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutProfessorServlet")
public class LogoutProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LogoutProfessorServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
HttpSession session= request.getSession(false);
		
		session.removeAttribute("doctor");
		session.invalidate();
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("HOME.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}