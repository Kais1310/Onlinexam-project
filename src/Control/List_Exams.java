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
import Model.Exam;

 
@WebServlet("/List_Exams")
public class List_Exams extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public List_Exams() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       DAO dao = new DAO();
		
		 ArrayList<Exam> ListExams = null;
		 int doc_id = Integer.parseInt(request.getParameter("doc_id"));
		
			try {
				ListExams = dao.getExams(doc_id);
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				
				e.printStackTrace();
			}
		
		
		request.setAttribute("ListExams", ListExams);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Exams.List.jsp");
		dispatcher.forward(request, response);
			
		
	}
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
