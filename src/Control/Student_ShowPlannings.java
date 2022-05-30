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
import Model.Planning;

@WebServlet("/Student_ShowPlannings")
public class Student_ShowPlannings extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Student_ShowPlannings() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		
		 ArrayList<Planning> ListPlannings = null;
		 
		 String level = request.getParameter("level");
		 String speciality = request.getParameter("speciality");
		
			try {
				ListPlannings = dao.getPlannings(level,speciality);
			} catch (InstantiationException | IllegalAccessException | SQLException e) {
				
				e.printStackTrace();
			}
		
		
		request.setAttribute("ListPlannings", ListPlannings);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Student.ShowPlannings.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
