package Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Annonce;
import Model.DAO;

@WebServlet("/AddAnnonce")
public class AddAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddAnnonce() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("AnnonceAdd.jsp");
	     dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titre = request.getParameter("titre");
		String content = request.getParameter("content");
		String date_ajoute = request.getParameter("date_ajoute");
		int adminID = Integer.parseInt(request.getParameter("adminID"));
		
		Annonce annonce = null;
		annonce = new Annonce(titre,content,date_ajoute,adminID);
		DAO dao = new DAO();
		
		try {
			dao.AddAnnonce(annonce);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
              
		     
		     RequestDispatcher dispatcher = request.getRequestDispatcher("AnnonceAdded.jsp");
		     dispatcher.forward(request, response);
		}

	}
}
