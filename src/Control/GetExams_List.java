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

@WebServlet("/GetExams_List")
public class GetExams_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GetExams_List() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String module = request.getParameter("module");
		ArrayList<Exam> ListExams = null;
		DAO dao = new DAO();
		
		try {
			ListExams = dao.ShowExams(module);
		} catch (InstantiationException | IllegalAccessException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("ListExams", ListExams);
		RequestDispatcher dispatcher = request.getRequestDispatcher("List.Exams.Answers.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
