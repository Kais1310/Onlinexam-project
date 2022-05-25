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


@WebServlet("/Edit_Exam")
public class Edit_Exam extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Edit_Exam() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
       DAO dao = new DAO();
       
        int exam_id=Integer.parseInt(request.getParameter("exam_id")); 
		
        Exam existexam = null;
		try {
			existexam = dao.FindExam(exam_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Exam.Form.Edit.jsp");
		request.setAttribute("exam", existexam);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
