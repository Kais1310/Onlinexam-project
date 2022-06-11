package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;


@WebServlet("/Delete_Question")
public class Delete_Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Delete_Question() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int question_id = Integer.parseInt(request.getParameter("question_id"));
		DAO dao = new DAO();
		try {
			dao.DeleteQuestion(question_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("QuestionDeleted.jsp");
		dispatcher.forward(request, response);
	}

	

}
