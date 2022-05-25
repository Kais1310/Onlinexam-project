package Control;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Exam;

 


@WebServlet("/Createxam")
public class Createxam extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Createxam() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 
		RequestDispatcher dispatcher = request.getRequestDispatcher("Exam.Form.jsp");
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		String module = request.getParameter("module");
		String level = request.getParameter("level");
		String speciality = request.getParameter("speciality");
		String date = request.getParameter("date");
		String duration = request.getParameter("duration");
		String type = request.getParameter("type");
        int nbr_questions=Integer.parseInt(request.getParameter("nbr_questions"));  
        int doc_id=Integer.parseInt(request.getParameter("doc_id"));  
		
		
		
		 
		 
		Exam exam = new Exam(module,level,speciality,date,duration,type,nbr_questions,doc_id);
		
		DAO dao = new DAO();
		 
			  
				try {
					dao.AddExam(exam);
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			 
				try {
				exam = dao.FindExamId(module, level, speciality, date, duration, type, nbr_questions, doc_id);
				} catch (InstantiationException | IllegalAccessException e) {
					// 
					e.printStackTrace();
				}
		 
		
		request.setAttribute("exam", exam);
		RequestDispatcher dispatcher = request.getRequestDispatcher("List_Questions");
		dispatcher.forward(request, response);
		 
	}

}
