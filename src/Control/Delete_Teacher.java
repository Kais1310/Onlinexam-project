package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;

@WebServlet("/Delete_Teacher")
public class Delete_Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Delete_Teacher() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DAO dao = new DAO();
		int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
		try {
			dao.DeleteTeacher(teacher_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		response.sendRedirect("List_Teachers");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
