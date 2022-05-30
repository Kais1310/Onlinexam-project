<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exams</title>
  <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
 
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="style2.css" />
     <link rel="stylesheet" href="question.css" />

 
    <link rel="preconnect" href="https://fonts.gstatic.com">
  
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://fonts.googleapis.com/css?family=Crimson+Text|Work+Sans:400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Quicksand:300,500" rel="stylesheet">
   
</head>
<body>
 <div class="d-flex" id="wrapper">
       
         <!-- Sidebar -->
        <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="fas fa-check"></i><h1><span>e</span>-Exam</h1> <h3>Université Abd ELHamid Mehri</h3></div>
            <div class="list-group list-group-flush my-3">
                <a href="Home.Student.jsp" class="list-group-item list-group-item-action bg-transparent second-text active"><i class="fas fa-home"></i> Home</a>
                <a href="Student_ShowPlannings?level=<c:out value="${student.level}" />&speciality=<c:out value="${student.speciality}" />" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="bi bi-bank2"></i>  Planning exams</a>        
                <a href="Student_List_Exams?level=<c:out value="${student.level}" />&speciality=<c:out value="${student.speciality}" />" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">
                    <i class="fas fa-list"></i> Session</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-edit"></i> Annonces</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-check"></i> Notes</a> 
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-exclamation"></i> Justification</a>        
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-comment-dots me-2"></i>Chat</a>
               
                 
            </div>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
               

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle second-text fw-bold" href="#" id="navbarDropdown"
                                role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="bi bi-person-circle"></i> ${student.firstname} ${student.lastname} 
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Profile</a></li>
                                <li><a class="dropdown-item" href="#">Settings</a></li>
                                <li><a class="dropdown-item" href="LogoutStudentServlet">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
  
              <c:if test="${ListExams.size() == 0}">
                 <div class="question">
                   <h2 style="text-align: center;">There is no exam yet </h2><br>
                   <p>wait untile the date of the exam came</p>
                 </div>
              </c:if>    
           
              <c:if test="${ListExams.size() != 0}">         
              <div class="table">
                    <h2>Exams list</h2> 
                    
                    <div class="col">
                        <table class="table bg-white rounded shadow-sm  table-hover">
                            <thead>
                                <tr>
                                    <th scope="col" width="50">id</th>
                                    <th scope="col">Module</th>
                                    <th scope="col">Level</th>
                                    <th scope="col">Speciality</th>
                                    <th scope="col">Date</th>
                                     <th scope="col">Duration</th>
                                     <th scope="col">Type</th>
                                     <th scope="col" width="20">nbrQ</th>
                                    
                                     <th scope="col"></th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                            
                                 <c:forEach var="exam" items="${ListExams}">
						             <tr>
						                <th scope="row"><c:out value="${exam.exam_id}" /></th>
						              	<td><c:out value="${exam.module}" /></td>			              	
							            <td><c:out value="${exam.level}" /></td>	
							            <td><c:out value="${exam.speciality}" /></td>
							            <td><c:out value="${exam.date}" /></td>	
							            <td><c:out value="${exam.duration}" /></td>
							            <td><c:out value="${exam.type}" /></td>	
							            <td><c:out value="${exam.nbr_questions}" /></td>
							            <td><a href="Student_Show_Topic?exam_id=<c:out value="${exam.exam_id}" />&student_id=<c:out value="${student.student_id}" />"><i class="bi bi-eye"></i></a></td>		
							            
							        </tr>
				            	</c:forEach>
                             
                            </tbody>
                        </table>
                      
                    </div>
                </div>
               </c:if>
            
        </div>
       
             
   </div>
    
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        var el = document.getElementById("wrapper");
        var toggleButton = document.getElementById("menu-toggle");

        toggleButton.onclick = function () {
            el.classList.toggle("toggled");
        };
    </script>
</body>
</html>
