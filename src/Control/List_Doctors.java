package Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Doctor;
 

@WebServlet("/List_Doctors")
public class List_Doctors extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public List_Doctors() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao = new DAO();
		List<Doctor> listDoctor = null;
		
		String search = request.getParameter("search");
		
		try {
			listDoctor = dao.getDoctors(search);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listDoctor", listDoctor);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Doctor.List.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
