package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Annonce;

@WebServlet("/ShowAnnonce")
public class ShowAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShowAnnonce() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       DAO dao = new DAO();
		
		
        int annonce_id=Integer.parseInt(request.getParameter("annonce_id")); 
		
        Annonce existeannonce = null;
		try {
			existeannonce = dao.FindAnnonce(annonce_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShowAnnonce.jsp");
		request.setAttribute("annonce", existeannonce);
		dispatcher.forward(request, response);
	}

	

}
