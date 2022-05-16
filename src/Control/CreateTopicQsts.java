package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import Model.DAO;
import Model.Exam;
import Model.Question;
 


@WebServlet("/CreateTopicQsts")
public class CreateTopicQsts extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CreateTopicQsts() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("List_Questions");
		dispatcher.forward(request, response);
		 
		 
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();
		 
		Exam exam = null;
		 
		int exam_id = Integer.parseInt(request.getParameter("Exm_id"));
		String[] values = request.getParameterValues("qst_id");
		
		
		 
			for(int i=0;i<values.length;i++) {
				
				int question_id = Integer.parseInt(values[i]);
				Question question = null;
				try {
					question = dao.FindQuestion(question_id);
					 
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				try {
					dao.AddTopic_Qsts(question,exam_id);
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
			try {
				exam =dao.FindExam(exam_id);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
			
		 request.setAttribute("exam",exam);
			 
		RequestDispatcher dispatcher = request.getRequestDispatcher("Topic_Created.jsp");
		dispatcher.forward(request, response);
	}
	 

}
