package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Justification;

@WebServlet("/Show_Justification")
public class Show_Justification extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Show_Justification() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       DAO dao = new DAO();
		
		
        int justification_id=Integer.parseInt(request.getParameter("justification_id")); 
		
        Justification existejustification = null;
		try {
			existejustification = dao.FindJustification(justification_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Show.Justifications.jsp");
		request.setAttribute("justification", existejustification);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
