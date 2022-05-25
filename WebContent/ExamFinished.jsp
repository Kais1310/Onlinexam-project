<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question</title>
  <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="style2.css" />
    <link rel="stylesheet" href="question.css" />
     <link rel="stylesheet" href="formulaire.css" />
   
</head>
<body>
 <div class="d-flex" id="wrapper">
        <!-- Sidebar -->
     <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="fas fa-check"></i><h1><span>e</span>-Exam</h1> <h3>Université Abd ELHamid Mehri</h3></div>
            <div class="list-group list-group-flush my-3">
                <a href="Home.Student.jsp" class="list-group-item list-group-item-action bg-transparent second-text active"><i class="fas fa-home"></i> Home</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="bi bi-bank2"></i>  Planning exams</a>        
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
                                <i class="bi bi-person-circle"></i> ${student.username} ${student.lastname} 
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
           
           
                  
                     <div class="question">
                         <h2>L´examen est terminé et votre reponses sont enregistré</h2> 
                       <a href="Student_Show_Answers?examID=<c:out value="${exam.exam_id}" />&studentID=<c:out value="${student.student_id}" />">Voir les reponses</a>
                        
                     </div>
              
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
