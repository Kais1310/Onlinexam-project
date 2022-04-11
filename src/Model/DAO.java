package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAO {
	private  Connection connection;

	public DAO() {
		this.connection = null;
	}

	// connection to database
	public  void connectDB() throws InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ExamOnline", "root", "KAIS1310kh");
			System.out.println("Connection avec succes a la base de donnees !");
		} catch (ClassNotFoundException cnf) {
			System.out.print("Driver non chargé...");
		} catch (SQLException sqlex) {
			System.out.println("Incapable de connecter a la base de donnees...");
		}

	}
	// verify the account of student in the DB
	public  Student checkLoginStudent(String username, String password)
			throws InstantiationException, IllegalAccessException {
		
		String requete;
		PreparedStatement statement;
		
		
       Student student = null;

		try {
			
			connectDB();
			
			requete = "SELECT * FROM Student WHERE username = ? and password = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, username);
			statement.setString(2, password);
		
			
			ResultSet result = statement.executeQuery();			
			
	        if (result.next()) {
	            student = new Student();
	            student.setFirstname(result.getString("firstname"));
	            student.setLastname(result.getString("lastname"));
	            student.setEmail(result.getString("email"));
	            student.setLevel(result.getString("level"));
	            student.setSpeciality(result.getString("speciality"));
	            student.setGroup(result.getInt("group"));
	            student.setUsername(result.getString("username"));
	            student.setPassword(result.getString("password"));
	            

	        }
	        
			statement.close();

			System.out.println("succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return student;
	}
	
	// verify the account of teacher in the DB
	public  Teacher checkLoginTeacher(String username, String password) throws InstantiationException, IllegalAccessException {
		
		String requete;
		PreparedStatement stat;
		
		
		Teacher teacher = null;

		try {
			
			connectDB();
			
			requete = "SELECT * FROM Teacher WHERE username = ? and password = ?";
			stat = connection.prepareStatement(requete);
			stat.setString(1, username);
			stat.setString(2, password);
			
			ResultSet result = stat.executeQuery();			
			
	        if (result.next()) {
	        	teacher = new Teacher();
	        	teacher.setFirstname(result.getString("firstname"));
	        	teacher.setLastname(result.getString("lastname"));
	        	teacher.setModule(result.getString("module"));
	        	teacher.setEmail(result.getString("email"));
	        	teacher.setUsername(result.getString("username"));
	        	teacher.setPassword(result.getString("password"));
	            

	        }
	        
	        stat.close();

			System.out.println("succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return teacher;
	}
	
	
	// verify the account of admin in the DB
public  Admin checkLoginAdmin(String username, String password) throws InstantiationException, IllegalAccessException {
		
		String requete;
		PreparedStatement stat;
		
		
		Admin admin = null;

		try {
			
			connectDB();
			
			requete = "SELECT * FROM Admin WHERE username = ? and password = ?";
			stat = connection.prepareStatement(requete);
			stat.setString(1, username);
			stat.setString(2, password);
			
			ResultSet result = stat.executeQuery();			
			
	        if (result.next()) {
	        	admin =new Admin();
	        	admin.setUsername(result.getString("username"));
	        	admin.setPassword(result.getString("password"));
	            

	        }
	        
	        stat.close();

			System.out.println("succés !");
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return admin;
	}
	
	
// verify the account of monito in the DB
public  Monitor checkLoginMonitor(String username, String password) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement stat;
	
	
	Monitor monitor = null;

	try {
		
		connectDB();
		
		requete = "SELECT * FROM Monitor WHERE username = ? and password = ?";
		stat = connection.prepareStatement(requete);
		stat.setString(1, username);
		stat.setString(2, password);
		
		ResultSet result = stat.executeQuery();			
		
        if (result.next()) {
        	monitor =new Monitor();
        	monitor.setFirstname(result.getString("firstname"));
        	monitor.setLastname(result.getString("lastname"));
        	monitor.setEmail(result.getString("email"));
        	monitor.setUsername(result.getString("username"));
        	monitor.setPassword(result.getString("password"));
            

        }
        
        stat.close();

		System.out.println("succés !");
	} catch (SQLException e) {
		System.out.println(e);
	}
	
	return monitor;
}


//verify the account of professor in the DB
public  Professor checkLoginProfessor(String username, String password) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement stat;
	
	
	Professor professor = null;

	try {
		
		connectDB();
		
		requete = "SELECT * FROM Professor WHERE username = ? and password = ?";
		stat = connection.prepareStatement(requete);
		stat.setString(1, username);
		stat.setString(2, password);
		
		ResultSet result = stat.executeQuery();			
		
     if (result.next()) {
    	 professor =new Professor();
    	 professor.setFirstname(result.getString("firstname"));
    	 professor.setLastname(result.getString("lastname"));
    	 professor.setModule(result.getString("module"));
    	 professor.setEmail(result.getString("email"));
    	 professor.setUsername(result.getString("username"));
    	 professor.setPassword(result.getString("password"));
         

     }
     
     stat.close();

		System.out.println("succés !");
	} catch (SQLException e) {
		System.out.println(e);
	}
	
	return professor;
}
	
	
	
public ArrayList<Student> getStudents(String level, String speciality) throws InstantiationException, IllegalAccessException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Student> studentList = new ArrayList<Student>();
	
	
		try {
			
			connectDB();

			if (level != null || speciality != null) {
			
			requete = "SELECT * FROM Student where level= ? and speciality= ?";
			
			statement = connection.prepareStatement(requete);
			
			statement.setString(1, level);
			statement.setString(2, speciality);
			
			ResultSet result = statement.executeQuery();			
			
	        while (result.next()) {
	        	
	        	Student student = new Student();
	        	student.setStudent_id(result.getInt("student_id"));
	        	student.setFirstname(result.getString("firstname"));
	        	student.setLastname(result.getString("lastname"));
	        	student.setEmail(result.getString("email"));
	        	student.setLevel(result.getString("level"));
	        	student.setSpeciality(result.getString("speciality"));
	        	student.setGroup(result.getInt("group"));
	        	student.setUsername(result.getString("username"));
	        	student.setPassword(result.getString("password"));
	        	
	            
	            studentList.add(student);
	        }
	        
			}else {
				requete = "SELECT * FROM Student ";
				statement = connection.prepareStatement(requete);
				
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Student student = new Student();
		        	student.setStudent_id(result.getInt("student_id"));
		        	student.setFirstname(result.getString("firstname"));
		        	student.setLastname(result.getString("lastname"));
		        	student.setEmail(result.getString("email"));
		        	student.setLevel(result.getString("level"));
		        	student.setSpeciality(result.getString("speciality"));
		        	student.setGroup(result.getInt("group"));
		        	student.setUsername(result.getString("username"));
		        	student.setPassword(result.getString("password"));
		        	
		            
		            studentList.add(student);
		        }
				
			}
	        
			statement.close();

			System.out.println("Users --- succés !");
		}catch (SQLException e) {
			System.out.println(e);
		}
		

	return studentList;
}

	
public void AddStudent(Student student) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement stmt;
	 
	
	try {
		connectDB();
		
		requete = "INSERT INTO `ExamOnline`.`Student` (`firstname`, `lastname`, `email`, `level`, `speciality`, `group`, `username`, `password`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";		
		stmt = connection.prepareStatement(requete);
		
		stmt.setString(1,student.getFirstname());
		stmt.setString(2,student.getLastname());
		stmt.setString(3,student.getEmail());
		stmt.setString(4,student.getLevel());
		stmt.setString(5,student.getSpeciality());
		stmt.setInt(6,student.getGroup());
		stmt.setString(7,student.getUsername());
		stmt.setString(8,student.getPassword());
		
		stmt.executeUpdate();
		stmt.close();
		
		System.out.println("Inserted !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	
	
	
}


public Student UpdateStudent(Student student) throws InstantiationException, IllegalAccessException{ 

	String requete;
	PreparedStatement stmt;
	
	
	
	 try{  
		 connectDB();
		 
	    	requete = "UPDATE `ExamOnline`.`Student` set `firstname`=?,`lastname`=?,`email`=?,`level`=?,`speciality`=?,`group`=?,`username`=?,`password`=? WHERE `student_id` = ?";
	    						
			stmt = connection.prepareStatement(requete);
			
			
			stmt.setString(1,student.getFirstname());
			stmt.setString(2,student.getLastname());
			stmt.setString(3,student.getEmail());
			stmt.setString(4,student.getLevel());
			stmt.setString(5,student.getSpeciality());
			stmt.setInt(6,student.getGroup());
			stmt.setString(7,student.getUsername());
			stmt.setString(8,student.getPassword());
			stmt.setInt(9,student.getStudent_id());
			

			
			 stmt.executeUpdate();
			 
			   
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	
	return student;
}

public Student FindStudent(int student_id) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement statement;
	
	Student student = null;
	
	
	try {
		
		connectDB();
		
		requete = "SELECT * FROM Student where student_id=?";
		statement = connection.prepareStatement(requete);
		
		statement.setInt(1, student_id);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String email = result.getString("email");
            String level = result.getString("level");
            String speciality = result.getString("speciality");
            Integer group = result.getInt("group");
            String username = result.getString("username");
            String password = result.getString("password");
            student =new Student(student_id,firstname,lastname,level,speciality,group, email,username,password);
      
        }
		System.out.println("Users --- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return student;
}

	
public boolean DeleteStudent(int student_id) throws InstantiationException, IllegalAccessException{ 
	
	boolean rowDelete = false;
	String requete;
	PreparedStatement stmt;
	connectDB();
	
	 try{  
		   
	    	requete = "delete from Student where student_id=?";			
			stmt = connection.prepareStatement(requete);
			 stmt.setInt(1,student_id);
			
			rowDelete= stmt.executeUpdate()>0;
			stmt.close(); 
			
	        connection.close();   
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	return rowDelete;
		
}




	
}

