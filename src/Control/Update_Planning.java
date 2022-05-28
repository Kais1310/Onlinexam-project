package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Planning;


@WebServlet("/Update_Planning")
public class Update_Planning extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Update_Planning() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int planning_id = Integer.parseInt(request.getParameter("planning_id"));
		String module =request.getParameter("module");
		String level =request.getParameter("level");
		String speciality =request.getParameter("speciality");
		String date =request.getParameter("date");
		String duration =request.getParameter("duration");
		int adminID = Integer.parseInt(request.getParameter("adminID"));
		
		Planning planning = new Planning(planning_id, module, level,  speciality, date,  duration,  adminID) ;

			DAO dao = new DAO();					
		 try {
			dao.UpdatePlanning(planning);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
				
		
		response.sendRedirect("List_Plannings");
	}

}
