package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
 
@WebServlet("/delete_Planning")
public class delete_Planning extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public delete_Planning() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int plannig_id=Integer.parseInt(request.getParameter("planning_id"));
		DAO dao = new DAO();
		try {
			dao.DeletePlanning(plannig_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("List_Plannings");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
