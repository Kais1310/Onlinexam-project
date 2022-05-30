package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Planning;

@WebServlet("/AddPlanning")
public class AddPlanning extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddPlanning() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Planning.Form.Add.jsp");
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		String module = request.getParameter("module");
		String level = request.getParameter("level");
		String speciality = request.getParameter("speciality");
		String date = request.getParameter("date");
		String duration = request.getParameter("duration");
		String salle =request.getParameter("salle");
        int adminID=Integer.parseInt(request.getParameter("adminID"));  
		
		
		
		 
		 
		Planning planning = new Planning(module,level,speciality,date,duration,salle,adminID);
		
		DAO dao = new DAO();
		 
			  
				try {
					dao.AddPlanning(planning);
				} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
				}
			 
		 
		
		request.setAttribute("planning", planning);
		RequestDispatcher dispatcher = request.getRequestDispatcher("List_Plannings");
		dispatcher.forward(request, response);
	}

}
