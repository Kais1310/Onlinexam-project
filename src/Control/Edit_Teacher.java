package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Teacher;

@WebServlet("/Edit_Teacher")
public class Edit_Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Edit_Teacher() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		 
        int teacher_id=Integer.parseInt(request.getParameter("teacher_id")); 
		
        Teacher existeteacher = null;
		try {
			existeteacher = dao.Findteacher(teacher_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Teacher.Form.Edit.jsp");
		request.setAttribute("teacher", existeteacher);
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
