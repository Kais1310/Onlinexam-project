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

@WebServlet("/Update_Question")
public class Update_Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Update_Question() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int question_id = Integer.parseInt(request.getParameter("question_id"));
		String module = request.getParameter("module");
		String content = request.getParameter("content");
		String choice1 = request.getParameter("choice1");
		String choice2 = request.getParameter("choice2");
		String choice3 = request.getParameter("choice3");
		String choice4 = request.getParameter("choice4");
		String right_answer = request.getParameter("right_answer");
		String type = request.getParameter("type");
		
		Question question = new Question(question_id,module,content,choice1,choice2,choice3,choice4,right_answer,type);
		DAO dao = new DAO();
		try {
			dao.UpdateQuestion(question);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("List_Questions_banque");
		dispatcher.forward(request, response);
		
		
		
	}

}
