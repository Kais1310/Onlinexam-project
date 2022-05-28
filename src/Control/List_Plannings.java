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
import Model.Planning;
 
@WebServlet("/List_Plannings")
public class List_Plannings extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public List_Plannings() {
        super();
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		
		 ArrayList<Planning> ListPlannings = null;
		
			try {
				ListPlannings = dao.getPlanningExams();
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				
				e.printStackTrace();
			}
		
		
		request.setAttribute("ListPlannings", ListPlannings);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Plannings.List.jsp");
		dispatcher.forward(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
