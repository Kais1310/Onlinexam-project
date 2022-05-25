package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;


@WebServlet("/Delete_Exam")
public class Delete_Exam extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Delete_Exam() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int exam_id=Integer.parseInt(request.getParameter("exam_id"));
		DAO dao = new DAO();
		try {
			dao.DeleteExam(exam_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("Exam.Deleted.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
