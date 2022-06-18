package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;

@WebServlet("/Delete_Session")
public class Delete_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Delete_Session() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();
		int doctorID = Integer.parseInt(request.getParameter("doctorID"));
		try {
			dao.DeleteSession(doctorID);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("Session.Deleted.jsp");
	}

	
}
