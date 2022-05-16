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




@WebServlet("/List_Questions")
public class List_Questions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public List_Questions() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();
		
		ArrayList<Question> ListQuestions = null;
		 
		
			try {
				ListQuestions = dao.getQuestions();
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				
				e.printStackTrace();
			}
		
		
		
		request.setAttribute("ListQuestions", ListQuestions);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Createxam.Listquestions.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
