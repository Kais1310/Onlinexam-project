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
import Model.Reclamation;

@WebServlet("/Get_Reclamations")
public class Get_Reclamations extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Get_Reclamations() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String module = request.getParameter("module");
		DAO dao = new DAO();

		ArrayList<Reclamation> ListReclamations = null;
		
		
			try {
				ListReclamations = dao.ShowReclamations(module);
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				
				e.printStackTrace();
			}
			
		request.setAttribute("ListReclamations", ListReclamations);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Doctor.Reclamations.jsp");
		dispatcher.forward(request, response);
	}

	

}
