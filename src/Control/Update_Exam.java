package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Exam;


@WebServlet("/Update_Exam")
public class Update_Exam extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Update_Exam() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int exam_id = Integer.parseInt(request.getParameter("exam_id"));
		String module = request.getParameter("module");
		String level =request.getParameter("level");
		String speciality =request.getParameter("speciality");
		String type =request.getParameter("type");
		String date =request.getParameter("date");
		String duration = request.getParameter("duration");
		int nbr_questions = Integer.parseInt(request.getParameter("nbr_questions"));
		int doc_id = Integer.parseInt(request.getParameter("doc_id"));
		 
		Exam exam = new Exam(exam_id,module,level,speciality,type,date,duration,nbr_questions,doc_id);
		
			DAO dao = new DAO();					
		 try {
			dao.UpdateExam(exam);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
				
		
		response.sendRedirect("List_Exams");
	}

}
