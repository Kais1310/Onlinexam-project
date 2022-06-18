package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Session;

@WebServlet("/CreateSession")
public class CreateSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CreateSession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Session.Form.jsp");
		dispatcher.include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		
		String level = request.getParameter("level");
		String speciality = request.getParameter("speciality");
		String date = request.getParameter("date");
		String exam = request.getParameter("exam");
		String meet_link = request.getParameter("meet_link");
		int doctorID = Integer.parseInt(request.getParameter("doctorID"));
		 
		
		Session session = new Session(level,speciality,date,exam,meet_link,doctorID);
		
		try {
			dao.CreateSession(session);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Session.Created.jsp");
		dispatcher.forward(request, response);
		
	}

}
