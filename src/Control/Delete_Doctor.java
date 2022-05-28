package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;

@WebServlet("/Delete_Doctor")
public class Delete_Doctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Delete_Doctor() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		int doctor_id = Integer.parseInt(request.getParameter("doctor_id"));
		try {
			dao.DeleteDoctor(doctor_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		response.sendRedirect("List_Doctor");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
