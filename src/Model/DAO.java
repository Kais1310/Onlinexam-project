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
		
		stmt.setString(1,student.getFirstname());
		stmt.setString(2,student.getLastname());
		stmt.setString(3,student.getEmail());
		stmt.setString(4,student.getLevel());
		stmt.setString(5,student.getSpeciality());
		stmt.setString(6,student.getDepartment());
		stmt.setInt(7,student.getGroup());
		stmt.setString(8,student.getUsername());
		stmt.setString(9,student.getPassword());
		
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
		 
	    	requete = "UPDATE `ExamOnline`.`Teacher` set `firstname`=?,`lastname`=?,`email`=?,`module`=?,`username`=?,`password`=? WHERE `doctor_id` = ?";
	    						
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
            doctor =new Doctor(firstname,lastname,module, email,username,password);
      
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
            teacher =new Teacher(firstname,lastname,module, email,username,password);
      
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


public void AddQuestion(Question question) throws InstantiationException, IllegalAccessException {
	
	
	PreparedStatement stmt;
	
	try {
		connectDB();
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`Question` (`module`, `content`, `choice1`, `choice2`, `choice3`, `choice4`, `right_answer`, `type`,`banque_id`,`doctorID`,`teacherID`) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?,?,?);");
		
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
		stmt.setInt(11,question.getTeacherID());		
		  
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
		 
	    	requete = "UPDATE `ExamOnline`.`Question` set `module`=?,`content`=?,`choice1`=?,`choice2`=?,`choice3`=?,`choice4`=?,`right_answer`=?,`type`=?,`banque_id`=?,`doctorID`=?,`teacherID`=?, WHERE `question_id` = ?";
	    						
			stmt = connection.prepareStatement(requete);
			
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
			stmt.setInt(11,question.getTeacherID());		
			stmt.setInt(12,question.getQuestion_id());
			

			
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
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`Exam` (`module`, `level`, `speciality`, `date`, `duration`, `type`, `nbr_questions`, `doc_id`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
		
		 
		stmt.setString(1,exam.getModule());
		stmt.setString(2,exam.getLevel());
		stmt.setString(3,exam.getSpeciality());
		stmt.setString(4,exam.getDate());
		stmt.setString(5,exam.getDuration());
		stmt.setString(6,exam.getType());
		stmt.setInt(7,exam.getNbr_questions());
		stmt.setInt(8,exam.getDoc_id());		
		  
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
		 
	    	requete = "UPDATE `ExamOnline`.`Exam` set `module`=?,`level`=?,`speciality`=?,`type`=?,`date`=?,`duration`=?,`nbr_questions`=? ";
	    						
			stmt = connection.prepareStatement(requete);
			
			
			stmt.setString(1,exam.getModule());
			stmt.setString(2,exam.getLevel());
			stmt.setString(3,exam.getSpeciality());
			stmt.setString(4,exam.getType());
			stmt.setString(5,exam.getDate());
			stmt.setString(6,exam.getDuration());
			stmt.setInt(7,exam.getNbr_questions());
			
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
            String date = result.getString("date");
            String duration = result.getString("duration");
            String type = result.getString("type");
            int nbr_questions = result.getInt("nbr_questions");
            int doc_id = result.getInt("doc_id");
            
             exam = new Exam( exam_id, module,  level,  speciality, date, duration, type, nbr_questions, doc_id) ;
        }
		System.out.println("Find exam byid -- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return exam;
}




public Exam FindExamId(String module,String level, String speciality, String date, String duration, String type, int nbr_questions, int doc_id) throws InstantiationException, IllegalAccessException {
	 
	PreparedStatement statement;
	
	Exam exam = null;
	
	
	try {
		
		connectDB();
		
		 
		statement = connection.prepareStatement("SELECT * FROM Exam where module=? and level=? and speciality =? and date=? and duration=? and type=? and nbr_questions=? and doc_id=?");
		
		
		statement.setString(1, module);
		statement.setString(2, level);
		statement.setString(3, speciality);
		statement.setString(4, date);
		statement.setString(5, duration);
		statement.setString(6, type);
		statement.setInt(7, nbr_questions);
		statement.setInt(8, doc_id);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
        	int exam_id = result.getInt("exam_id");
            module = result.getString("module");
              level = result.getString("level");          
              speciality = result.getString("speciality");
              date = result.getString("date");
              duration = result.getString("duration");
              type = result.getString("type");
              nbr_questions = result.getInt("nbr_questions");
              doc_id = result.getInt("doc_id");
            
             exam = new Exam( exam_id,module,  level,  speciality, date, duration ,type,  nbr_questions,  doc_id) ;
        	    
        	  
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
	
		 
				requete = "SELECT * FROM Exam where level=? and speciality=?";
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

			System.out.println("Get List exam for Student -- succés !");
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
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`Planning` (`module`, `level`, `speciality`, `date`, `duration`, `adminID`) VALUES (?, ?, ?, ?, ?, ?);");
		
		 
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
			stmt.setInt(6, planning.getPlanning_id());
			
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
            
             planning = new Planning( planning_id, module,  level,  speciality, date, duration, adminID) ;
        }
		System.out.println("Find Planning byid -- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return planning;
}


public ArrayList<Planning> getPlannings(String level, String speciality) throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Planning> planninglist = new ArrayList<Planning>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM Planning where level=? and speciality=?";
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
public ArrayList<Planning> getPlanningExams() throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Planning> planninglist = new ArrayList<Planning>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM Planning";
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


	
}

