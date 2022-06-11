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

import Model.Annonce;
import Model.DAO;


@WebServlet("/List_Annonces")
public class List_Annonces extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public List_Annonces() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		
		 ArrayList<Annonce> ListAnnonces = null;
		    	try {
					ListAnnonces = dao.getAnnonce();
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			
		
		
		request.setAttribute("ListAnnonces", ListAnnonces);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Annonce.jsp");
		dispatcher.forward(request, response);
	}


}
