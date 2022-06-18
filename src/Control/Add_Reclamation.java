package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Reclamation;

/**
 * Servlet implementation class Add_Reclamation
 */
@WebServlet("/Add_Reclamation")
public class Add_Reclamation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Reclamation() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String firstname = request.getParameter("firstname");
    	String lastname = request.getParameter("lastname");
		String module = request.getParameter("module");
		String note = request.getParameter("note");
		String date = request.getParameter("date");
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		
		DAO dao = new DAO();
		Reclamation reclamation = null;
		reclamation = new Reclamation(firstname,lastname,module,note,date,studentID);
		
		try {
			dao.AddReclamation(reclamation);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("ReclamationAdded.jsp");
	     dispatcher.include(request, response);
	}

}
