package Control;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Model.DAO;
import Model.Justification;

@WebServlet("/AddJustification")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class AddJustification extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddJustification() {
        super();
    }
    

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Justification.jsp");
		dispatcher.include(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
		
        String firstname = request.getParameter("firstname");	
        String lastname = request.getParameter("lastname");	
        String level = request.getParameter("level");	
        String speciality = request.getParameter("speciality");	
        int group = Integer.parseInt(request.getParameter("group"));	
       String module = request.getParameter("module");	
       String date_ajoute = request.getParameter("date_ajoute");	
       String date_absence = request.getParameter("date_absence");	
       String seance = request.getParameter("seance");	
       String justification = request.getParameter("justification");
       int studentID = Integer.parseInt(request.getParameter("studentID"));
       
       Part part = request.getPart("file");//
       String fileName = extractFileName(part);//file name
       
       String savePath = "/Users/macbookair/mywork-eclipse/ExamOnline/WebContent/pic" + File.separator + fileName;
       
       File fileSaveDir = new File(savePath);
      
       part.write(savePath+ File.separator );
      
       
		
       DAO dao = new DAO();
       Justification jstfctn = null;
       jstfctn = new Justification(firstname,lastname,level,speciality,group,module,date_ajoute,date_absence,seance,justification,fileName,savePath,studentID);
       
       try {
		dao.AddJustification(jstfctn);
	} catch (InstantiationException | IllegalAccessException e) {
		e.printStackTrace();
	}
       response.getWriter().print("<h2>The file uploaded sucessfully.</h2>");
       
       RequestDispatcher dispatcher = request.getRequestDispatcher("Justification.jsp");
		dispatcher.include(request, response);
	}
	
	 // file name of the upload file is included in content-disposition header like this:
    //form-data; name="dataFile"; filename="PHOTO.JPG"

    private String extractFileName(Part part) {
    	//This method will print the file name.
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
    

}
