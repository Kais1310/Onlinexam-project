package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;

@WebServlet("/Block_exam")
public class Block_exam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Block_exam() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int exam_id = Integer.parseInt(request.getParameter("exam_id"));
			
			DAO dao = new DAO();
			
			try {
				dao.BlockExam(exam_id);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
			response.getWriter().print("<h2>The exam blocked succesfully.</h2>");
			
			response.sendRedirect("Exam.Blocked.jsp");
	}

	

}
