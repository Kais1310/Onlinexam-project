package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Planning;

@WebServlet("/Edit_Planning")
public class Edit_Planning extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Edit_Planning() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
	       
        int planning_id=Integer.parseInt(request.getParameter("planning_id")); 
		
        Planning existeplanning = null;
		try {
			existeplanning = dao.FindPlanning(planning_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Planning.Form.Edit.jsp");
		request.setAttribute("planning", existeplanning);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
