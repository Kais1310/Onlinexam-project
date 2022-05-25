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
import Model.Question;

@WebServlet("/List_Questions_banque")
public class List_Questions_banque extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public List_Questions_banque() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		DAO dao = new DAO();
		
		ArrayList<Question> ListQuestions = null;
		 String module = request.getParameter("module");
		
			try {
				ListQuestions = dao.getQuestions(module);
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				
				e.printStackTrace();
			}
		
		
		
		request.setAttribute("ListQuestions", ListQuestions);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Banque.Questions.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
