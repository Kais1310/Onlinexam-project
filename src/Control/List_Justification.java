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
import Model.Justification;
 

@WebServlet("/List_Justification")
public class List_Justification extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public List_Justification() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		DAO dao = new DAO();
		
		ArrayList<Justification> JustificationList = null;
		
			try {
				JustificationList = dao.getJustifications();
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				
				e.printStackTrace();
			}
		
		  
		
		request.setAttribute("JustificationList", JustificationList);
		 
		RequestDispatcher dispatcher = request.getRequestDispatcher("Justifications.List.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
