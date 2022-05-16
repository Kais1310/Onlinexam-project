package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAO {
	private static final int Exm_id = 0;
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
		stmt.setString(5,student.getDepartment());
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

 // this method used to create new exam in the data base

public void AddExam(Exam exam) throws InstantiationException, IllegalAccessException {
	
	
	PreparedStatement stmt;
	
	try {
		connectDB();
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`Exam` (`module`, `level`, `speciality`, `type`, `nbr_questions`, `doc_id`) VALUES (?, ?, ?, ?, ?, ?);");
		
		stmt.setString(1,exam.getModule());
		stmt.setString(2,exam.getLevel());
		stmt.setString(3,exam.getSpeciality());
		stmt.setString(4,exam.getType());
		stmt.setInt(5,exam.getNbr_questions());
		stmt.setInt(6,exam.getDoc_id());		
		  
		 stmt.executeUpdate();
		 
		stmt.close();
		 
		
		System.out.println("exam added --succés !");
		} catch (SQLException e) {
			System.out.println(e);
		   }
	 
	
}
public ArrayList<Question> getQuestions() throws InstantiationException, IllegalAccessException, SQLException {

	
	String requete;
	PreparedStatement statement;
	
	
	ArrayList<Question> questionlist = new ArrayList<Question>();
	try {
		connectDB();
	
		 
				requete = "SELECT * FROM Question ";
				statement = connection.prepareStatement(requete);
				
				
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
            String type = result.getString("type");
            String choice1 = result.getString("choice1");
            String choice2 = result.getString("choice2");
            String choice3 = result.getString("choice3");
            String choice4 = result.getString("choice4");
            String right_answer = result.getString("right_answer");
            int banque_id = result.getInt("banque_id");
            
            question =new Question(question_id,module,content,choice1,choice2,choice3, choice4,right_answer,type,banque_id);
      
        }
		System.out.println("Find question byid -- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return question;
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
            int nbr_questions = result.getInt("nbr_questions");
            int doc_id = result.getInt("doc_id");
            
             exam = new Exam( exam_id, module,  level,  speciality,  type,  nbr_questions,  doc_id) ;
        }
		System.out.println("Find question byid -- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	return exam;
}

public Exam FindExamId(String module,String level, String speciality, String type, int nbr_questions, int doc_id) throws InstantiationException, IllegalAccessException {
	 
	PreparedStatement statement;
	
	Exam exam = null;
	
	
	try {
		
		connectDB();
		
		 
		statement = connection.prepareStatement("SELECT * FROM Exam where module=? and level=? and speciality =? and type=? and nbr_questions=? and doc_id=?");
		
		statement.setString(1, module);
		statement.setString(2, level);
		statement.setString(3, speciality);
		statement.setString(4, type);
		statement.setInt(5, nbr_questions);
		statement.setInt(6, doc_id);
		ResultSet result = statement.executeQuery();			
		
        while (result.next()) {
        	
        	int exam_id = result.getInt("exam_id");
            module = result.getString("module");
              level = result.getString("level");          
              speciality = result.getString("speciality");
              type = result.getString("type");
              nbr_questions = result.getInt("nbr_questions");
              doc_id = result.getInt("doc_id");
            
             exam = new Exam( exam_id,module,  level,  speciality,  type,  nbr_questions,  doc_id) ;
        	    
        	  
        }
		System.out.println("Find exam_id from object exam -- succés !");
	}catch (SQLException e) {
		System.out.println(e);
	}
	
	
	return exam;
}


public void AddTopic_Qsts(Question question, int exam_id) throws InstantiationException, IllegalAccessException {
	
	
	PreparedStatement stmt;
	
	try {
		connectDB();
				
		stmt = connection.prepareStatement( "INSERT INTO `ExamOnline`.`Topic` (`module`, `question`, `choice1`, `choice2`, `choice3`, `choice4`, `exam_id`) VALUES (?, ?, ?, ?, ?, ?, ?);");
		
		stmt.setString(1,question.getModule());
		stmt.setString(2,question.getContent());
		stmt.setString(3,question.getChoice1());
		stmt.setString(4,question.getChoice2());
		stmt.setString(5,question.getChoice3());
		stmt.setString(6,question.getChoice4());
		stmt.setInt(7,exam_id);		
		
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








	
}

