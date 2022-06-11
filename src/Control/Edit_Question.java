package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Question;

@WebServlet("/Edit_Question")
public class Edit_Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Edit_Question() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int question_id = Integer.parseInt(request.getParameter("question_id"));
		
		DAO dao = new DAO();
		Question existeQuestion = null;
		try {
			existeQuestion=dao.FindQuestion(question_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Question.Form.Edit.jsp");
		request.setAttribute("question", existeQuestion);
		dispatcher.forward(request, response);
		
	}

	

}
