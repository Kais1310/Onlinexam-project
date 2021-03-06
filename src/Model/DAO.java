package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCrypt;


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
			
			requete = "SELECT * FROM Student WHERE username = ?";
			statement = connection.prepareStatement(requete);
			statement.setString(1, username);
			//statement.setString(2, password);
		
			
			ResultSet result = statement.executeQuery();			
			
	        if (result.next()&& BCrypt.checkpw(password, result.getString("password"))) {
	            student = new Student();
	            student.setStudent_id(result.getInt("student_id"));
	            student.setFirstname(result.getString("firstname"));
	            student.setLastname(result.getString("lastname"));
	            student.setEmail(result.getString("email"));
	            student.setLevel(result.getString("level"));
	            student.setSpeciality(result.getString("speciality"));
	            student.setDepartment(result.getString("department"));
	            student.setGroup(result.getInt("group"));
	            student.setUsername(result.getString("username"));
	            student.setPassword(result.getString("password"));
	            

	        }
	        
			statement.close();

			System.out.println("check login --succés !");
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

			System.out.println("check login --succés !");
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
	        	admin.setAdmin_id(result.getInt("admin_id"));
	        	admin.setFirstname(result.getString("firstname"));
	        	admin.setLastname(result.getString("lastname"));
	        	admin.setEmail(result.getString("email"));
	        	admin.setUsername(result.getString("username"));
	        	admin.setPassword(result.getString("password"));
	            

	        }
	        
	        stat.close();

			System.out.println("check login --succés !");
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

		System.out.println("check login --succés !");
	} catch (SQLException e) {
		System.out.println(e);
	}
	
	return monitor;
}


//verify the account of doctor in the DB
public  Doctor checkLoginDoctor(String username, String password) throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement stat;
	
	
	Doctor doctor = null;

	try {
		
		connectDB();
		
		requete = "SELECT * FROM Doctor WHERE username = ? and password = ?";
		stat = connection.prepareStatement(requete);
		stat.setString(1, username);
		stat.setString(2, password);
		
		ResultSet result = stat.executeQuery();			
		
     if (result.next()) {
    	  doctor = new Doctor();
    	  doctor.setDoctor_id(result.getInt("doctor_id"));
    	 doctor.setFirstname(result.getString("firstname"));
    	 doctor.setLastname(result.getString("lastname"));
    	 doctor.setModule(result.getString("module"));
    	 doctor.setEmail(result.getString("email"));
    	 doctor.setUsername(result.getString("username"));
    	 doctor.setPassword(result.getString("password"));
         

     }
     
     stat.close();

		System.out.println("check login --succés !");
	} catch (SQLException e) {
		System.out.println(e);
	}
	
	
	return doctor;
}
	
	
	
public ArrayList<Student> getStudents(String search) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Student> studentList = new ArrayList<Student>();
	try {
		connectDB();
	
		 if(search!=null){
				
				requete ="SELECT * FROM Student where firstname like '%"+search+"%' or lastname like '%\"+search+\"%' ";
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
		        	student.setDepartment(result.getString("department"));
		        	student.setGroup(result.getInt("group"));
		        	student.setUsername(result.getString("username"));
		        	student.setPassword(result.getString("password"));
		        	
		            
		            studentList.add(student);
		        }

				
			}else{
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
		        	student.setDepartment(result.getString("department"));
		        	student.setGroup(result.getInt("group"));
		        	student.setUsername(result.getString("username"));
		        	student.setPassword(result.getString("password"));
		        	
		            
		            studentList.add(student);
		        }
				
			}
	        
			statement.close();

			System.out.println("Get Students -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return studentList;
	
}

public ArrayList<Doctor> getDoctors(String search) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	try {
		connectDB();
	
		 if(search!=null){
				
				requete ="SELECT * FROM Doctor where firstname like '%"+search+"%' or lastname like '%\"+search+\"%' ";
				statement = connection.prepareStatement(requete);
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Doctor doctor = new Doctor();
		        	doctor.setDoctor_id(result.getInt("doctor_id"));
		        	doctor.setFirstname(result.getString("firstname"));
		        	doctor.setLastname(result.getString("lastname"));
		        	doctor.setEmail(result.getString("email"));
		        	doctor.setModule(result.getString("module"));
		        	doctor.setUsername(result.getString("username"));
		        	doctor.setPassword(result.getString("password"));
		        	
		            
		        	doctorList.add(doctor);
		        }

				
			}else{
				requete = "SELECT * FROM Doctor ";
				statement = connection.prepareStatement(requete);
				
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Doctor doctor = new Doctor();
		        	doctor.setDoctor_id(result.getInt("doctor_id"));
		        	doctor.setFirstname(result.getString("firstname"));
		        	doctor.setLastname(result.getString("lastname"));
		        	doctor.setEmail(result.getString("email"));
		        	doctor.setModule(result.getString("module"));
		        	doctor.setUsername(result.getString("username"));
		        	doctor.setPassword(result.getString("password"));
		        	
		            
		        	doctorList.add(doctor);
		        }
				
			}
	        
			statement.close();

			System.out.println("Get Students -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return doctorList;
	
}
public ArrayList<Teacher> getTeachers(String search) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
	try {
		connectDB();
	
		 if(search!=null){
				
				requete ="SELECT * FROM Teacher where firstname like '%"+search+"%' or lastname like '%\"+search+\"%' ";
				statement = connection.prepareStatement(requete);
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Teacher teacher = new Teacher();
		        	teacher.setTeacher_id(result.getInt("teacher_id"));
		        	teacher.setFirstname(result.getString("firstname"));
		        	teacher.setLastname(result.getString("lastname"));
		        	teacher.setEmail(result.getString("email"));
		        	teacher.setModule(result.getString("module"));
		        	teacher.setUsername(result.getString("username"));
		        	teacher.setPassword(result.getString("password"));
		        	
		            
		        	teacherList.add(teacher);
		        }

				
			}else{
				requete = "SELECT * FROM Teacher ";
				statement = connection.prepareStatement(requete);
				
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Teacher teacher = new Teacher();
		        	teacher.setTeacher_id(result.getInt("teacher_id"));
		        	teacher.setFirstname(result.getString("firstname"));
		        	teacher.setLastname(result.getString("lastname"));
		        	teacher.setEmail(result.getString("email"));
		        	teacher.setModule(result.getString("module"));
		        	teacher.setUsername(result.getString("username"));
		        	teacher.setPassword(result.getString("password"));
		        	
		            
		        	teacherList.add(teacher);
		        }
				
			}
	        
			statement.close();

			System.out.println("Get Students -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return teacherList;
	
}

	
public void AddStudent(Student student) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement stmt;
	 
	
	try {
		connectDB();
		
		requete = "INSERT INTO `ExamOnline`.`Student` (`firstname`, `lastname`, `email`, `level`, `speciality`,`department`, `group`, `username`, `password`) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?);";		
		stmt = connection.prepareStatement(requete);
		
		String pw_hash = BCrypt.hashpw(student.getPassword(), BCrypt.gensalt());

		
		stmt.setString(1,student.getFirstname());
		stmt.setString(2,student.getLastname());
		stmt.setString(3,student.getEmail());
		stmt.setString(4,student.getLevel());
		stmt.setString(5,student.getSpeciality());
		stmt.setString(6,student.getDepartment());
		stmt.setInt(7,student.getGroup());
		stmt.setString(8,student.getUsername());
		stmt.setString(9,pw_hash);
		
		stmt.executeUpdate();
		stmt.close();
		
		System.out.println("Student account Inserted !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	
	
	
}

public void AddDoctor(Doctor doctor) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement stmt;
	 
	
	try {
		connectDB();
		
		requete = "INSERT INTO `ExamOnline`.`Doctor` (`firstname`, `lastname`, `email`, `module`, `username`, `password`) VALUES (?, ?, ?, ?, ?, ?);";		
		stmt = connection.prepareStatement(requete);
		
		stmt.setString(1,doctor.getFirstname());
		stmt.setString(2,doctor.getLastname());
		stmt.setString(3,doctor.getEmail());
		stmt.setString(4,doctor.getModule());
		stmt.setString(5,doctor.getUsername());
		stmt.setString(6,doctor.getPassword());
		
		stmt.executeUpdate();
		stmt.close();
		
		System.out.println("Doctor account Inserted !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	
	
	
}

public void AddTeacher(Teacher teacher) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement stmt;
	 
	
	try {
		connectDB();
		
		requete = "INSERT INTO `ExamOnline`.`Teacher` (`firstname`, `lastname`, `email`, `module`, `username`, `password`) VALUES (?, ?, ?, ?, ?, ?);";		
		stmt = connection.prepareStatement(requete);
		
		stmt.setString(1,teacher.getFirstname());
		stmt.setString(2,teacher.getLastname());
		stmt.setString(3,teacher.getEmail());
		stmt.setString(4,teacher.getModule());
		stmt.setString(5,teacher.getUsername());
		stmt.setString(6,teacher.getPassword());
		
		stmt.executeUpdate();
		stmt.close();
		
		System.out.println("teacher account Inserted !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	
	
	
}


public Student UpdateStudent(Student student) throws InstantiationException, IllegalAccessException{ 

	String requete;
	PreparedStatement stmt;
	
	
	
	 try{  
		 connectDB();
		 
	    	requete = "UPDATE `ExamOnline`.`Student` set `firstname`=?,`lastname`=?,`email`=?,`level`=?,`speciality`=?,`department`=?,`group`=?,`username`=?,`password`=? WHERE `student_id` = ?";
	    						
			stmt = connection.prepareStatement(requete);
			
			
			stmt.setString(1,student.getFirstname());
			stmt.setString(2,student.getLastname());
			stmt.setString(3,student.getEmail());
			stmt.setString(4,student.getLevel());
			stmt.setString(5,student.getSpeciality());
			stmt.setString(6,student.getDepartment());
			stmt.setInt(7,student.getGroup());
			stmt.setString(8,student.getUsername());
			stmt.setString(9,student.getPassword());
			stmt.setInt(10,student.getStudent_id());
			

			
			 stmt.executeUpdate();
			 
			   
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	
	return student;
}

public Doctor UpdateDoctor(Doctor doctor) throws InstantiationException, IllegalAccessException{ 

	String requete;
	PreparedStatement stmt;
	
	
	
	 try{  
		 connectDB();
		 
	    	requete = "UPDATE `ExamOnline`.`Doctor` set `firstname`=?,`lastname`=?,`email`=?,`module`=?,`username`=?,`password`=? WHERE `doctor_id` = ?";
	    						
			stmt = connection.prepareStatement(requete);
			
			
			stmt.setString(1,doctor.getFirstname());
			stmt.setString(2,doctor.getLastname());
			stmt.setString(3,doctor.getEmail());
			stmt.setString(4,doctor.getModule());
			stmt.setString(5,doctor.getUsername());
			stmt.setString(6,doctor.getPassword());
			stmt.setInt(7,doctor.getDoctor_id());
			

			
			 stmt.executeUpdate();
			 
			   
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	
	return doctor;
}

public Teacher UpdateTeacher(Teacher teacher) throws InstantiationException, IllegalAccessException{ 

	String requete;
	PreparedStatement stmt;
	
	
	
	 try{  
		 connectDB();
		 
	    	requete = "UPDATE `ExamOnline`.`Teacher` set `firstname`=?,`lastname`=?,`email`=?,`module`=?,`username`=?,`password`=? WHERE `teacher_id` = ?";
	    						
			stmt = connection.prepareStatement(requete);
			
			
			stmt.setString(1,teacher.getFirstname());
			stmt.setString(2,teacher.getLastname());
			stmt.setString(3,teacher.getEmail());
			stmt.setString(4,teacher.getModule());
			stmt.setString(5,teacher.getUsername());
			stmt.setString(6,teacher.getPassword());
			stmt.setInt(7,teacher.getTeacher_id());
			

			
			 stmt.executeUpdate();
			 
			   
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	
	return teacher;
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
            String department = result.getString("department");
            Integer group = result.getInt("group");
            String username = result.getString("username");
            String password = result.getString("password");
            student =new Student(student_id,firstname,lastname,level,speciality,department,group, email,username,password);
      
        }
		System.out.println("Find student --- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return student;
}
public Doctor FindDoctor(int doctor_id) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement statement;
	
	Doctor doctor = null;
	
	
	try {
		
		connectDB();
		
		requete = "SELECT * FROM Doctor where doctor_id=?";
		statement = connection.prepareStatement(requete);
		
		statement.setInt(1, doctor_id);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String email = result.getString("email");
            String module = result.getString("module");
            String username = result.getString("username");
            String password = result.getString("password");
            doctor =new Doctor(doctor_id, firstname,lastname,module, email,username,password);
      
        }
		System.out.println("Find Doctor --- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return doctor;
}

public Teacher Findteacher(int teacher_id) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement statement;
	
	Teacher teacher = null;
	
	
	try {
		
		connectDB();
		
		requete = "SELECT * FROM Teacher where teacher_id=?";
		statement = connection.prepareStatement(requete);
		
		statement.setInt(1, teacher_id);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	 
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String email = result.getString("email");
            String module = result.getString("module");
            String username = result.getString("username");
            String password = result.getString("password");
            teacher =new Teacher(teacher_id,firstname,lastname,module, email,username,password);
      
        }
		System.out.println("Find teacher --- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return teacher;
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
	        System.out.println("Delete student --succés !");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	return rowDelete;
		
}
public boolean DeleteDoctor(int doctor_id) throws InstantiationException, IllegalAccessException{ 
	
	boolean rowDelete = false;
	String requete;
	PreparedStatement stmt;
	connectDB();
	
	 try{  
		   
	    	requete = "delete from Doctor where doctor_id=?";			
			stmt = connection.prepareStatement(requete);
			 stmt.setInt(1,doctor_id);
			
			rowDelete= stmt.executeUpdate()>0;
			stmt.close(); 
			
	        connection.close();   
	        System.out.println("Delete doctor --succés !");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	return rowDelete;
		
}

public boolean DeleteTeacher(int teacher_id) throws InstantiationException, IllegalAccessException{ 
	
	boolean rowDelete = false;
	String requete;
	PreparedStatement stmt;
	connectDB();
	
	 try{  
		   
	    	requete = "delete from Teacher where teacher_id=?";			
			stmt = connection.prepareStatement(requete);
			 stmt.setInt(1,teacher_id);
			
			rowDelete= stmt.executeUpdate()>0;
			stmt.close(); 
			
	        connection.close();   
	        System.out.println("Delete teacher --succés !");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	return rowDelete;
		
}


public void Doctor_AddQuestion(Question question) throws InstantiationException, IllegalAccessException {
	
	
	PreparedStatement stmt;
	
	try {
		connectDB();
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`Question` (`module`, `content`, `choice1`, `choice2`, `choice3`, `choice4`, `right_answer`, `type`,`banque_id`,`doctorID`) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,);");
		
		stmt.setString(1,question.getModule());
		stmt.setString(2,question.getContent());
		stmt.setString(3,question.getChoice1());
		stmt.setString(4,question.getChoice2());
		stmt.setString(5,question.getChoice3());
		stmt.setString(6,question.getChoice4());
		stmt.setString(7,question.getRight_answer());
		stmt.setString(8,question.getType());	
		stmt.setInt(9,question.getBanque_id());
		stmt.setInt(10,question.getDoctorID());
				
		  
		 stmt.executeUpdate();
		 
		stmt.close();
		 
		
		System.out.println("question added --succés !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	 
	
}

public ArrayList<Question> getQuestions(String module) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Question> questionlist = new ArrayList<Question>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM Question where module=?";
				statement = connection.prepareStatement(requete);
				statement.setString(1, module);
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Question question = new Question();
		        	question.setQuestion_id(result.getInt("question_id"));
		        	question.setContent(result.getString("content"));
		        	question.setChoice1(result.getString("choice1"));
		        	question.setChoice2(result.getString("choice2"));
		        	question.setChoice3(result.getString("choice3"));
		        	question.setChoice4(result.getString("choice4"));
		        	question.setRight_answer(result.getString("right_answer"));
		        	question.setType(result.getString("type"));
		        	question.setModule(result.getString("module"));
		        	question.setDoctorID(result.getInt("doctorID"));
		        	question.setTeacherID(result.getInt("teacherID"));
		        	question.setBanque_id(result.getInt("banque_id"));
		        	
		            
		           questionlist.add(question);
		        }
				
			
	        
			statement.close();

			System.out.println("Get Questions -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return questionlist;
	
}


public Question FindQuestion(int question_id) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement statement;
	
	Question question = null;
	
	
	try {
		
		connectDB();
		
		requete = "SELECT * FROM Question where question_id=?";
		statement = connection.prepareStatement(requete);
		
		statement.setInt(1, question_id);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
            String content = result.getString("content");
            String module = result.getString("module");
            String choice1 = result.getString("choice1");
            String choice2 = result.getString("choice2");
            String choice3 = result.getString("choice3");
            String choice4 = result.getString("choice4");
            String type = result.getString("type");
            String right_answer = result.getString("right_answer");
            int banque_id = result.getInt("banque_id");
            int doctorID = result.getInt("doctorID");
            int teacherID = result.getInt("teacherID");
            
            question =new Question(question_id,module,content,choice1,choice2,choice3, choice4,right_answer,type,banque_id,doctorID,teacherID);
      
        }
		System.out.println("Find question byid -- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return question;
}


public Question UpdateQuestion(Question question) throws InstantiationException, IllegalAccessException{ 

	String requete;
	PreparedStatement stmt;
	
	
	
	 try{  
		 connectDB();
		 
	    	requete = "UPDATE `ExamOnline`.`Question` set `module`=?,`content`=?,`choice1`=?,`choice2`=?,`choice3`=?,`choice4`=?,`right_answer`=?,`type`=? WHERE `question_id` = ?";
	    						
			stmt = connection.prepareStatement(requete);
			
			stmt.setString(1,question.getModule());
			stmt.setString(2,question.getContent());
			stmt.setString(3,question.getChoice1());
			stmt.setString(4,question.getChoice2());
			stmt.setString(5,question.getChoice3());
			stmt.setString(6,question.getChoice4());
			stmt.setString(7,question.getRight_answer());
			stmt.setString(8,question.getType());			
			stmt.setInt(9,question.getQuestion_id());
			

			
			 stmt.executeUpdate();
			 
			 System.out.println("question updated --succés !");  
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	
	return question;
}



public boolean DeleteQuestion(int question_id) throws InstantiationException, IllegalAccessException{ 
	
	boolean rowDelete = false;
	String requete;
	PreparedStatement stmt;
	connectDB();
	
	 try{  
		   
	    	requete = "delete from Question where question_id=?";			
			stmt = connection.prepareStatement(requete);
			 stmt.setInt(1,question_id);
			
			rowDelete= stmt.executeUpdate()>0;
			stmt.close(); 
			
	        connection.close();   
	        System.out.println("Delete question --succés !");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	return rowDelete;
		
}


 // this method used to create new exam in the data base

public void AddExam(Exam exam) throws InstantiationException, IllegalAccessException {
	
	
	PreparedStatement stmt;
	try {
		connectDB();
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`Exam` (`module`, `level`, `speciality`, `type`, `date`, `duration`, `nbr_questions`, `state` ,`doc_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
		
		 
		stmt.setString(1,exam.getModule());
		stmt.setString(2,exam.getLevel());
		stmt.setString(3,exam.getSpeciality());
		stmt.setString(4,exam.getType());
		stmt.setString(5,exam.getDate());
		stmt.setString(6,exam.getDuration());
		stmt.setInt(7,exam.getNbr_questions());
		stmt.setString(8,exam.getState());
		stmt.setInt(9,exam.getDoc_id());		
		  
		 stmt.executeUpdate();
		 
		stmt.close();
		 
		
		System.out.println("exam added --succés !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	 
	
}

public Exam UpdateExam(Exam exam) throws InstantiationException, IllegalAccessException{ 

	String requete;
	PreparedStatement stmt;
	
	
	
	 try{  
		 connectDB();
		 
	    	requete = "UPDATE `ExamOnline`.`Exam` set `module`=?,`level`=?,`speciality`=?,`type`=?,`date`=?,`duration`=?,`nbr_questions`=? where (`exam_id` = ?)";
	    						
			stmt = connection.prepareStatement(requete);
			
			
			stmt.setString(1,exam.getModule());
			stmt.setString(2,exam.getLevel());
			stmt.setString(3,exam.getSpeciality());
			stmt.setString(4,exam.getType());
			stmt.setString(5,exam.getDate());
			stmt.setString(6,exam.getDuration());
			stmt.setInt(7,exam.getNbr_questions());
			stmt.setInt(8,exam.getExam_id());
			
			 stmt.executeUpdate();
			 System.out.println("exam updated --succés !"); 
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	
	return exam;
}

public boolean DeleteExam(int exam_id) throws InstantiationException, IllegalAccessException{ 
	
	boolean rowDelete = false;
	String requete;
	PreparedStatement stmt;
	connectDB();
	
	 try{  
		   
	    	requete = "delete from Exam where exam_id=?";			
			stmt = connection.prepareStatement(requete);
			 stmt.setInt(1,exam_id);
			
			rowDelete= stmt.executeUpdate()>0;
			stmt.close(); 
			
	        connection.close();   
	        System.out.println("Delete exam --succés !");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	return rowDelete;
		
}




public Exam FindExam(int exam_id) throws InstantiationException, IllegalAccessException {
	 
	PreparedStatement statement;
	
	Exam exam = null;
	
	
	try {
		
		connectDB();
		
		 
		statement = connection.prepareStatement("SELECT * FROM Exam where exam_id=?");
		
		
		statement.setInt(1, exam_id);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
        	  exam_id = result.getInt("exam_id");
            String module = result.getString("module");
            String level = result.getString("level");          
            String speciality = result.getString("speciality");
            String type = result.getString("type");
            String date = result.getString("date");
            String duration = result.getString("duration");
            String state = result.getString("state");
            int nbr_questions = result.getInt("nbr_questions");
            int doc_id = result.getInt("doc_id");
            
             exam = new Exam( exam_id, module,  level,  speciality, type, date, duration, nbr_questions,state, doc_id);
        }
		System.out.println("Find exam byid -- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return exam;
}




public Exam FindExamId(String module,String level, String speciality, String type, String date, String duration, int nbr_questions, String state, int doc_id) throws InstantiationException, IllegalAccessException {
	 
	PreparedStatement statement;
	
	Exam exam = null;
	
	
	try {
		
		connectDB();
		
		 
		statement = connection.prepareStatement("SELECT * FROM Exam where module=? and level=? and speciality =? and type=? and date=? and duration=? and nbr_questions=? and state=? and doc_id=?");
		
		
		statement.setString(1, module);
		statement.setString(2, level);
		statement.setString(3, speciality);
		statement.setString(4, type);
		statement.setString(5, date);
		statement.setString(6, duration);
		statement.setInt(7, nbr_questions);
		statement.setString(8, state);
		statement.setInt(9, doc_id);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
        	int exam_id = result.getInt("exam_id");
            module = result.getString("module");
              level = result.getString("level");          
              speciality = result.getString("speciality");
              type = result.getString("type");
              date = result.getString("date");
              duration = result.getString("duration");
              nbr_questions = result.getInt("nbr_questions");
              state = result.getString("state");
              doc_id = result.getInt("doc_id");
            
             exam = new Exam( exam_id,module,  level, speciality, type, date, duration, nbr_questions, state, doc_id) ;
        	    
        	  
        }
		System.out.println("Find exam_id from object exam -- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	
	return exam;
}

// this method insert the object question in the Topic with the foreign key exam_id 

public void AddTopic_Qsts(Question question, int exam_id) throws InstantiationException, IllegalAccessException {
	
	
	PreparedStatement stmt;
	
	try {
		connectDB();
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`Topic` (`module`, `question_type`,`question`, `choice1`, `choice2`, `choice3`, `choice4`, `exam_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
		
		stmt.setString(1,question.getModule());
		stmt.setString(2,question.getType());
		stmt.setString(3,question.getContent());
		stmt.setString(4,question.getChoice1());
		stmt.setString(5,question.getChoice2());
		stmt.setString(6,question.getChoice3());
		stmt.setString(7,question.getChoice4());
		stmt.setInt(8,exam_id);		
		
		stmt.executeUpdate();
		stmt.close();
		
		System.out.println("question added to topic --succés !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	
	
	
}

public ArrayList<Topic> getTopic(int exam_id) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Topic> TopicQuestions = new ArrayList<Topic>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM Topic where exam_id = ?";
				statement = connection.prepareStatement(requete);
				
				statement.setInt(1, exam_id);
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Topic topic = new Topic();
		        	topic.setTopic_id(result.getInt("topic_id"));
		        	topic.setQuestion_type(result.getString("question_type"));
		        	topic.setQuestion(result.getString("question"));
		        	topic.setChoice1(result.getString("choice1"));
		        	topic.setChoice2(result.getString("choice2"));
		        	topic.setChoice3(result.getString("choice3"));
		        	topic.setChoice4(result.getString("choice4"));
		        	topic.setModule(result.getString("module"));
		        	topic.setExam_id(result.getInt("exam_id"));
		        	
		            
		        	TopicQuestions.add(topic);
		        }
				
			
	        
			statement.close();

			System.out.println("Get Topic Questions -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return TopicQuestions;
	
}

// method getExams return list of the exam created by doctor using doc_id

public ArrayList<Exam> getExams(int doc_id) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Exam> examlist = new ArrayList<Exam>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM Exam where doc_id=?";
				statement = connection.prepareStatement(requete);
				statement.setInt(1, doc_id);
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Exam exam = new Exam();
		        	exam.setExam_id(result.getInt("exam_id"));
		        	exam.setModule(result.getString("module"));
		        	exam.setLevel(result.getString("level"));
		        	exam.setSpeciality(result.getString("speciality"));
		        	exam.setType(result.getString("type"));
		        	exam.setDate(result.getString("date"));
		        	exam.setDuration(result.getString("duration"));
		        	exam.setNbr_questions(result.getInt("nbr_questions"));
		        	exam.setState(result.getString("state"));
		        	exam.setDoc_id(result.getInt("doc_id"));
		        	
		           examlist.add(exam);
		        }
				
			
	        
			statement.close();

			System.out.println("Get List exams -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return examlist;
	
}


public ArrayList<Exam> getStudentExams(String level, String speciality) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Exam> examlist = new ArrayList<Exam>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM Exam where level=? and speciality=? and `state` = 'on' ";
				statement = connection.prepareStatement(requete);
				statement.setString(1, level);
				statement.setString(2, speciality);
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Exam exam = new Exam();
		        	exam.setExam_id(result.getInt("exam_id"));
		        	exam.setModule(result.getString("module"));
		        	exam.setLevel(result.getString("level"));
		        	exam.setSpeciality(result.getString("speciality"));
		        	exam.setType(result.getString("type"));
		        	exam.setDate(result.getString("date"));
		        	exam.setDuration(result.getString("duration"));
		        	exam.setNbr_questions(result.getInt("nbr_questions"));
		        	exam.setDoc_id(result.getInt("doc_id"));
		        	
		           examlist.add(exam);
		        }
				
			
	        
			statement.close();

			System.out.println("Get exam for Student -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return examlist;
	
}

public void AddAnswers(Answer answer) throws InstantiationException, IllegalAccessException {
	
	
	PreparedStatement stmt;
	
	try {
		connectDB();
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`Answer` (`question`, `answer`,`examID`, `studentID`) VALUES (?, ?, ?, ?);");
		
		stmt.setString(1,answer.getQuestion());
		stmt.setString(2,answer.getAnswer());
		stmt.setInt(3,answer.getExamID());
		stmt.setInt(4,answer.getStudentID());
		
		
		stmt.executeUpdate();
		stmt.close();
		
		System.out.println("Answer added to table answer --succés !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	
	
	
}

public ArrayList<Answer> ShowAnswers(int examID, int studentID) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Answer> StudentAnswers = new ArrayList<Answer>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM Answer where examID = ? and studentID=?";
				statement = connection.prepareStatement(requete);
				
				statement.setInt(1, examID);
				statement.setInt(2, studentID);
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Answer answer = new Answer();
		        	
		        	answer.setQuestion(result.getString("question"));
		        	answer.setAnswer(result.getString("answer"));
		        	answer.setExamID(result.getInt("examID"));
		        	answer.setStudentID(result.getInt("studentID"));
		        	
		            
		        	StudentAnswers.add(answer);
		        }
				
			
	        
			statement.close();

			System.out.println("Show Student Answers -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return StudentAnswers;
	
}

public void AddPlanning(Planning planning) throws InstantiationException, IllegalAccessException {
	
	
	PreparedStatement stmt;
	try {
		connectDB();
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`Planning` (`module`, `level`, `speciality`, `date`, `duration`,`adminID`) VALUES (?, ?, ?, ?, ?, ?);");
		
		 
		stmt.setString(1,planning.getModule());
		stmt.setString(2,planning.getLevel());
		stmt.setString(3,planning.getSpeciality());
		stmt.setString(4,planning.getDate());
		stmt.setString(5,planning.getDuration());
		stmt.setInt(6,planning.getAdminID());
			
		  
		 stmt.executeUpdate();
		 
		stmt.close();
		 
		
		System.out.println("Planning added --succés !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	 
	
}

public boolean DeletePlanning(int planning_id) throws InstantiationException, IllegalAccessException{ 
	
	boolean rowDelete = false;
	String requete;
	PreparedStatement stmt;
	connectDB();
	
	 try{  
		   
	    	requete = "delete from Planning where planning_id=?";			
			stmt = connection.prepareStatement(requete);
			 stmt.setInt(1,planning_id);
			
			rowDelete= stmt.executeUpdate()>0;
			stmt.close(); 
			
	        connection.close();   
	        System.out.println("Delete planning exam --succés !");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	return rowDelete;
		
}


public Planning UpdatePlanning(Planning planning) throws InstantiationException, IllegalAccessException{ 

	String requete;
	PreparedStatement stmt;
	
	
	
	 try{  
		 connectDB();
		 
	    	requete = "UPDATE `ExamOnline`.`Planning` set `module`=?,`level`=?,`speciality`=?,`date`=?,`duration`=? where planning_id=?";
	    						
			stmt = connection.prepareStatement(requete);
			
			stmt.setString(1,planning.getModule());
			stmt.setString(2,planning.getLevel());
			stmt.setString(3,planning.getSpeciality());
			stmt.setString(4,planning.getDate());
			stmt.setString(5,planning.getDuration());
			stmt.setInt(6,planning.getPlanning_id());
			
			 stmt.executeUpdate();
			 System.out.println("Planning updated --succés !"); 
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	
	return planning;
}

public Planning FindPlanning(int planning_id) throws InstantiationException, IllegalAccessException {
	 
	PreparedStatement statement;
	
	Planning planning = null;
	
	
	try {
		
		connectDB();
		
		 
		statement = connection.prepareStatement("SELECT * FROM Planning where planning_id=?");
		
		
		statement.setInt(1, planning_id);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
        	  planning_id = result.getInt("planning_id");
            String module = result.getString("module");
            String level = result.getString("level");          
            String speciality = result.getString("speciality");
            String date = result.getString("date");
            String duration = result.getString("duration");
            int adminID = result.getInt("adminID");
            
             planning = new Planning( planning_id, module,  level,  speciality, date, duration,adminID) ;
        }
		System.out.println("Find Planning byid -- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return planning;
}


// this method show the planning to the students

public ArrayList<Planning> getPlannings(String level, String speciality) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Planning> planninglist = new ArrayList<Planning>();
	try {
		connectDB();
	
		 
				requete = "SELECT planning_id, module, level, speciality, DATE_FORMAT(date,'%d-%m-%Y    /    %a,  : %H:%i') AS Date, duration, adminID FROM Planning where level=? and speciality=? ORDER BY date";
				statement = connection.prepareStatement(requete);
				statement.setString(1, level);
				statement.setString(2, speciality);
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Planning planning = new Planning();
		        	
		        	planning.setPlanning_id(result.getInt("planning_id"));
		        	planning.setModule(result.getString("module"));
		        	planning.setLevel(result.getString("level"));
		        	planning.setSpeciality(result.getString("speciality"));
		        	planning.setDate(result.getString("date"));
		        	planning.setDuration(result.getString("duration"));
		        	planning.setAdminID(result.getInt("adminID"));
		        	
		            
		        	planninglist.add(planning);
		        }
				
			
	        
			statement.close();

			System.out.println("Get Plannings -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return planninglist;
	
}


// This method show the plannings created to the admin

public ArrayList<Planning> getPlanningExams() throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Planning> planninglist = new ArrayList<Planning>();
	try {
		connectDB();
	
		 
				requete = "SELECT  planning_id, module, level, speciality, DATE_FORMAT(date, '%d-%m-%Y  %H:%i') AS Date, duration, adminID FROM Planning";
				statement = connection.prepareStatement(requete);
				
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Planning planning = new Planning();
		        	
		        	planning.setPlanning_id(result.getInt("planning_id"));
		        	planning.setModule(result.getString("module"));
		        	planning.setLevel(result.getString("level"));
		        	planning.setSpeciality(result.getString("speciality"));
		        	planning.setDate(result.getString("date"));
		        	planning.setDuration(result.getString("duration"));
		        	planning.setAdminID(result.getInt("adminID"));
		        	
		            
		        	planninglist.add(planning);
		        }
				
			
	        
			statement.close();

			System.out.println("Get Plannings -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return planninglist;
	
}


public void AddJustification(Justification justification) throws InstantiationException, IllegalAccessException {
	
	
	PreparedStatement stmt;
	try {
		connectDB();
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`Justification` (`firstname`,`lastname`,`level`,`speciality`,`group`,`module`, `date_absence`, `seance`, `justification`,`fileName`,`savePath`, `studentID`) VALUES (?,?,?,?,?,?, ?, ?, ?, ?, ?, ?);");
		
		stmt.setString(1,justification.getFirstname());
		stmt.setString(2,justification.getLastname());
		stmt.setString(3,justification.getLevel());
		stmt.setString(4,justification.getSpeciality());
		stmt.setInt(5,justification.getGroup());
		stmt.setString(6,justification.getModule());
		stmt.setString(7,justification.getDate_absence());
		stmt.setString(8,justification.getSeance());
		stmt.setString(9,justification.getJustification());
		stmt.setString(10,justification.getFileName());
		stmt.setString(11,justification.getSavePath());
		stmt.setInt(12,justification.getStudentID());
		
		 stmt.executeUpdate();
		 
		stmt.close();
		 
		
		System.out.println("Justification added --succés !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	 
	
}

public ArrayList<Justification> getJustifications() throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Justification> JustificationList = new ArrayList<Justification>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM `ExamOnline`.`Justification`;";
				statement = connection.prepareStatement(requete);
				
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Justification justification = new Justification();
		        	 
		        	justification.setJustification_id(result.getInt("Justification_id"));
		        	justification.setFirstname(result.getString("firstname"));
		        	justification.setLastname(result.getString("lastname"));
		        	justification.setLevel(result.getString("level"));
		        	justification.setSpeciality(result.getString("speciality"));
		        	justification.setGroup(result.getInt("group"));
		        	justification.setModule(result.getString("module"));
		        	justification.setDate_ajoute(result.getString("date_ajoute"));
		        	justification.setDate_absence(result.getString("date_absence"));
		        	justification.setSeance(result.getString("seance"));
		        	justification.setJustification(result.getString("justification"));
		        	justification.setFileName(result.getString("fileName"));
		        	justification.setSavePath(result.getString("savePath"));
		        	justification.setStudentID(result.getInt("studentID"));
		        	
		            
		        	JustificationList.add(justification);
		        	 
		        	
		        }
				
			
	        
			statement.close();

			System.out.println("Get Justifications -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return JustificationList;
	
}

public Justification FindJustification(int justification_id) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement statement;
	
	Justification justificationInfo = null;
	
	
	try {
		
		connectDB();
		requete = "SELECT * FROM Justification where justification_id=?";
		statement = connection.prepareStatement(requete);
		
		statement.setInt(1, justification_id);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	 
            String firstname = result.getString("firstname");
            String lastname = result.getString("lastname");
            String level = result.getString("level");
            String speciality = result.getString("speciality");
            int group = result.getInt("group");
            String module = result.getString("module");
            String date_ajoute = result.getString("date_ajoute");
            String date_absence = result.getString("date_absence");
            String seance = result.getString("seance");
            String justification = result.getString("justification");
            String fileName = result.getString("fileName");
            String savePath = result.getString("savePath");
            int studentID = result.getInt("studentID");
            justificationInfo =new Justification(justification_id,firstname,lastname,level,speciality,group,module,date_ajoute,date_absence,seance,justification,fileName,savePath,studentID);
      
        }
		System.out.println("Find justificationInfo --- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return justificationInfo;
}


public boolean DeleteJustification(int justification_id) throws InstantiationException, IllegalAccessException{ 
	
	boolean rowDelete = false;
	String requete;
	PreparedStatement stmt;
	connectDB();
	
	 try{  
		   
	    	requete = "delete from Justification where justification_id=?";			
			stmt = connection.prepareStatement(requete);
			 stmt.setInt(1,justification_id);
			
			rowDelete= stmt.executeUpdate()>0;
			stmt.close(); 
			
	        connection.close();   
	        System.out.println("Delete justification  --succés !");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	return rowDelete;
		
}
public void AddAnnonce(Annonce annonce) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement stmt;
	
	connectDB();

	try {

		requete = "INSERT INTO `ExamOnline`.`Annonces` (titre,content,adminID) VALUES(?,?,?)";			
		stmt = connection.prepareStatement(requete);
		
		
		stmt.setString(1,annonce.getTitre());
		stmt.setString(2,annonce.getContent());
		stmt.setInt(3, annonce.adminID);

		
		
		stmt.executeUpdate();
		stmt.close();

		System.out.println("Annonce Inserted !");
	} catch (SQLException e) {
		System.out.println(e);
	}
}
public ArrayList<Annonce> getAnnonce() throws InstantiationException, IllegalAccessException {
	
	String requete;
	PreparedStatement statement;
	
	Annonce annonce = null;
	ArrayList<Annonce> ListAnnonces = new ArrayList<Annonce>();
	
	try {
		
		connectDB();
		
		requete = "SELECT * FROM Annonces";
		statement = connection.prepareStatement(requete);
		
		
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
        	annonce = new Annonce();
        	annonce.setAnnonce_id(result.getInt("annonce_id"));
        	annonce.setContent(result.getString("content"));
        	annonce.setTitre(result.getString("titre"));
        	annonce.setDate_ajoute(result.getString("date_ajoute"));
        	annonce.setAdminID(result.getInt("adminID"));
            
            
            
        	ListAnnonces.add(annonce);
        }
        
		statement.close();

		System.out.println("Get List Annonces --- succed !");
	} catch (SQLException e) {
		System.out.println(e);
	}
	
	return ListAnnonces;
}

public Annonce FindAnnonce(int annonce_id) throws InstantiationException, IllegalAccessException {
	String requete;
	PreparedStatement statement;
	
	Annonce annonce = null;
	
	
	try {
		
		connectDB();
		
		requete = "SELECT * FROM `ExamOnline`.`Annonces` where annonce_id=?";
		statement = connection.prepareStatement(requete);
		
		statement.setInt(1,annonce_id);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
        	 
        	String titre = result.getString("titre");
            String content = result.getString("content");
            String date_ajoute = result.getString("date_ajoute");
            int adminID = result.getInt("adminID");
            
            annonce =new Annonce(titre,content,date_ajoute,adminID);
      
        }
		System.out.println("Find Annonce byid -- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return annonce;
}


public void CreateSession(Session session) throws InstantiationException, IllegalAccessException {
	
	
	PreparedStatement stmt;
	try {
		connectDB();
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`session` (`level`, `speciality`, `date`, `exam`,`meet_link`, `doctorID`) VALUES (?, ?, ?, ?, ?, ?);");
		
		stmt.setString(1,session.getLevel());
		stmt.setString(2,session.getSpeciality());
		stmt.setString(3,session.getDate());
		stmt.setString(4,session.getExam());
		stmt.setString(5,session.getMeet_link());
		stmt.setInt(6,session.getDoctorID());
			
		  
		 stmt.executeUpdate();
		 
		stmt.close();
		 
		
		System.out.println("Session Created -- succesfuly !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	 
	
}

// cette method permet de aaficher au enseignant la session quelle deja crée et permet au enseignant acces a ca session

public ArrayList<Session> getSession(int doctorID) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Session> sessions = new ArrayList<Session>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM session where doctorID=?";
				statement = connection.prepareStatement(requete);
				statement.setInt(1, doctorID);
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Session session = new Session();
		        	session.setSession_id(result.getInt("session_id"));
		        	session.setLevel(result.getString("level"));
		        	session.setSpeciality(result.getString("speciality"));
		        	session.setDate(result.getString("date"));
		        	session.setExam(result.getString("exam"));
		        	session.setMeet_link(result.getString("meet_link"));
		        	session.setDoctorID(result.getInt("doctorID"));
		        	 
		        	
		           sessions.add(session);
		        }
				
			
	        
			statement.close();

			System.out.println("Get Session -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return sessions;
	
}

// cette method permet de trouver la session aux etudiants concerner 
public ArrayList<Session> StudentSession(String level,String speciality) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Session> sessions = new ArrayList<Session>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM session where level=? and speciality=?";
				statement = connection.prepareStatement(requete);
				statement.setString(1, level);
				statement.setString(2, speciality);
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Session session = new Session();
		        	session.setSession_id(result.getInt("session_id"));
		        	session.setLevel(result.getString("level"));
		        	session.setSpeciality(result.getString("speciality"));
		        	session.setDate(result.getString("date"));
		        	session.setExam(result.getString("exam"));
		        	session.setMeet_link(result.getString("meet_link"));
		        	session.setDoctorID(result.getInt("doctorID"));
		        	
		           sessions.add(session);
		        }
				
			
	        
			statement.close();

			System.out.println("Get Student Session -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return sessions;
	
}

public void ReleasExam(int exam_id) throws InstantiationException, IllegalAccessException{ 

	String requete;
	PreparedStatement stmt;
	
	
	
	 try{  
		 connectDB();
		 
	    	requete = "UPDATE `ExamOnline`.`Exam` set `state` = 'on' where (`exam_id` = ?)";
	    						
			stmt = connection.prepareStatement(requete);
			
			stmt.setInt(1,exam_id);
			
			 stmt.executeUpdate();
			 System.out.println("Release exam --succés !"); 
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	
}

public void BlockExam(int exam_id) throws InstantiationException, IllegalAccessException{ 

	String requete;
	PreparedStatement stmt;
	
	
	
	 try{  
		 connectDB();
		 
	    	requete = "UPDATE `ExamOnline`.`Exam` set `state` = 'off' where (`exam_id` = ?)";
	    						
			stmt = connection.prepareStatement(requete);
			
			stmt.setInt(1,exam_id);
			
			 stmt.executeUpdate();
			 System.out.println("block exam --succés !"); 
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	
}


public boolean DeleteSession(int doctorID) throws InstantiationException, IllegalAccessException{ 

	boolean rowDelete = false;
	String requete;
	PreparedStatement stmt;
	connectDB();
	
	 try{  
		   
	    	requete = "delete from session where doctorID=?";			
			stmt = connection.prepareStatement(requete);
			 stmt.setInt(1,doctorID);
			
			rowDelete= stmt.executeUpdate()>0;
			stmt.close(); 
			
	        connection.close();   
	        System.out.println("Delete session exam --succés !");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	return rowDelete;
	
}

public ArrayList<Answer> ShowStudentAnswers(int examID, int studentID) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Answer> StudentAnswers = new ArrayList<Answer>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM Answer where examID = ? and studentID=?";
				statement = connection.prepareStatement(requete);
				
				statement.setInt(1, examID);
				statement.setInt(2, studentID);
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Answer answer = new Answer();
		        	
		        	answer.setQuestion(result.getString("question"));
		        	answer.setAnswer(result.getString("answer"));
		        	answer.setExamID(result.getInt("examID"));
		        	answer.setStudentID(result.getInt("studentID"));
		        	
		            
		        	StudentAnswers.add(answer);
		        }
				
			
	        
			statement.close();

			System.out.println("Show Student Answers -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return StudentAnswers;
	
}

// afficher les examen par module aux enseigants qui enseignie le mm module pour corriger le.
public ArrayList<Exam> ShowExams(String module) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Exam> ListExams = new ArrayList<Exam>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM Exam where module=?";
				statement = connection.prepareStatement(requete);
				
				statement.setString(1, module);
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Exam exam = new Exam();
		        	
		        	exam.setExam_id(result.getInt("exam_id"));
		        	exam.setModule(result.getString("module"));
		        	exam.setDate(result.getString("date"));
		        	ListExams.add(exam);
		        }
				
			
	        
			statement.close();

			System.out.println("Afficher la list des examens pour noté -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return ListExams;
	
}
// afficher la list des etudiants qui participer dans lexamen 
public ArrayList<Student> ShowStudentsParticipated(int examID) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Student> ListStudents = new ArrayList<Student>();
	try {
		connectDB();
	
		 
				requete = "SELECT distinct student_id,firstname,lastname,level,speciality FROM ExamOnline.Student join Answer where Student.student_id=Answer.studentID and examID = ?";
				statement = connection.prepareStatement(requete);
				
				statement.setInt(1, examID);
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Student student = new Student();
		        	
		        	student.setStudent_id(result.getInt("student_id"));
		        	student.setFirstname(result.getString("firstname"));
		        	student.setLastname(result.getString("lastname"));
		        	student.setLevel(result.getString("level"));
		        	student.setSpeciality(result.getString("speciality"));
		        	
		        	ListStudents.add(student);
		        }
				
		         
	        
			statement.close();

			System.out.println("Afficher la list des etudiants qui sont participer dans lexamen -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return ListStudents;
	
}

public void AddNote(Note note) throws InstantiationException, IllegalAccessException {
	
	
	PreparedStatement stmt;
	try {
		connectDB();
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`Notes` (`module`, `note`, `studentID`, `doctorID`) VALUES (?, ?, ?, ?);");
		
		stmt.setString(1,note.getModule());
		stmt.setString(2,note.getNote());
		stmt.setInt(3,note.getStudentID());
		stmt.setInt(4,note.getDoctorID());
		
			
		  
		 stmt.executeUpdate();
		 
		stmt.close();
		 
		
		System.out.println("Note Added -- succesfuly !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	 
	
}
public ArrayList<Note> ShowNotes(int studentID) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Note> ListNotes = new ArrayList<Note>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM Notes where studentID=?";
				statement = connection.prepareStatement(requete);
				
				statement.setInt(1, studentID);
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Note note = new Note();
		        	
		        	note.setNote_id(result.getInt("note_id"));
		        	note.setModule(result.getString("module"));
		        	note.setNote(result.getString("note"));
		        	note.setDoctorID(result.getInt("doctorID"));
		        	ListNotes.add(note);
		        }
				
			
	        
			statement.close();

			System.out.println("Afficher la list des notes pour chaque etudiant -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return ListNotes;
	
}
public void AddReclamation(Reclamation reclamation) throws InstantiationException, IllegalAccessException {
	
	
	PreparedStatement stmt;
	try {
		connectDB();
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`reclamation` ( `module`, `note`,`studentID`) VALUES (?, ?, ?);");
		
		stmt.setString(1,reclamation.getModule());
		stmt.setString(2,reclamation.getNote());
		stmt.setInt(3,reclamation.getStudentID());
		
		
			
		  
		 stmt.executeUpdate();
		 
		stmt.close();
		 
		
		System.out.println("reclamation Added -- succesfuly !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	 
	
}
public ArrayList<Reclamation> ShowReclamations(String module) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Reclamation> ListReclamations = new ArrayList<Reclamation>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM reclamation where module=?";
				statement = connection.prepareStatement(requete);
				
				statement.setString(1, module);
				
				ResultSet result = statement.executeQuery();			
				
		        while (result.next()) {
		        	
		        	Reclamation reclamation = new Reclamation();
		        	
		        	reclamation.setReclamation_id(result.getInt("reclamation_id"));
		        	reclamation.setFirstname(result.getString("firstname"));
		        	reclamation.setLastname(result.getString("lastname"));
		        	reclamation.setModule(result.getString("module"));
		        	reclamation.setNote(result.getString("note"));
		        	reclamation.setDate(result.getString("date"));
		        	reclamation.setStudentID(result.getInt("studentID"));
		        	ListReclamations.add(reclamation);
		        }
				
			
	        
			statement.close();

			System.out.println("Afficher la list des Reclamations aux doctor -- succés !");
	  }catch(Exception e){
	    	e.printStackTrace();
	    }

	return ListReclamations;
	
}

public boolean DeleteReclamation(int reclamation_id) throws InstantiationException, IllegalAccessException{ 
	
	boolean rowDelete = false;
	String requete;
	PreparedStatement stmt;
	connectDB();
	
	 try{  
		   
	    	requete = "delete from reclamation where reclamation_id=?";			
			stmt = connection.prepareStatement(requete);
			 stmt.setInt(1,reclamation_id);
			
			rowDelete= stmt.executeUpdate()>0;
			stmt.close(); 
			
	        connection.close();   
	        System.out.println("Delete reclamation  --succés !");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	return rowDelete;
		
}


	
}



