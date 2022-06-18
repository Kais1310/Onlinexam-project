package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;

@WebServlet("/Delete_Reclamation")
public class Delete_Reclamation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Delete_Reclamation() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reclamation_id=Integer.parseInt(request.getParameter("reclamation_id"));
		DAO dao = new DAO();
		try {
			dao.DeleteReclamation(reclamation_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("Reclamation.Deleted.jsp");
	}

	

}
