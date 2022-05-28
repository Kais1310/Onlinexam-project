package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Doctor;

@WebServlet("/Edit_Doctor")
public class Edit_Doctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Edit_Doctor() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		 
        int doctor_id=Integer.parseInt(request.getParameter("doctor_id")); 
		
        Doctor existedoctor = null;
		try {
			existedoctor = dao.FindDoctor(doctor_id);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("Doctor.Form.Edit.jsp");
		request.setAttribute("doctor", existedoctor);
		dispatcher.include(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
