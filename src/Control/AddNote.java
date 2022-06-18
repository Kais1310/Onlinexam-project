package Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.Note;

@WebServlet("/AddNote")
public class AddNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddNote() {
        super();
     
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String module = request.getParameter("module");
		String note = request.getParameter("note");
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		int doctorID = Integer.parseInt(request.getParameter("doctorID"));
		
		DAO dao = new DAO();
		Note notte = null;
		
		notte = new Note(module,note,studentID,doctorID);
		 
		
		try {
			dao.AddNote(notte);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("NoteAdded.jsp");
	     dispatcher.include(request, response);
		
	}

}
