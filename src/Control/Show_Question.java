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



@WebServlet("/Show_Question")
public class Show_Question extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Show_Question() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       DAO dao = new DAO();
		
		String Question_id=request.getParameter("question_id");  
        int question_id=Integer.parseInt(Question_id); 
		
        Question existequestion = null;
		try {
			existequestion = dao.FindQuestion(question_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Show.Question.jsp");
		request.setAttribute("question", existequestion);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
