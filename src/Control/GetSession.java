package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Exam;
import Model.Session;

@WebServlet("/GetSession")
public class GetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public GetSession() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		ArrayList<Session> sessions = null;
		ArrayList<Exam> ListExams = null;
		int doctorID = Integer.parseInt(request.getParameter("doctorID"));
		int doc_id = Integer.parseInt(request.getParameter("doctorID"));
		
		
		try {
			sessions = dao.getSession(doctorID);
		} catch (InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
		}
		try {
			ListExams = dao.getExams(doc_id);
		} catch (InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("ListExams", ListExams);
		request.setAttribute("sessions", sessions);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Session.jsp");
		dispatcher.forward(request, response);
		
	}


}
