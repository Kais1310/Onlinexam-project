<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Topic</title>
  <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="style2.css" />
    <link rel="stylesheet" href="question.css" />
   
</head>
<body>
 <div class="d-flex" id="wrapper">
        <!-- Sidebar Exam informations -->
       <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="fas fa-user-secret me-2"></i>Exam informations</div>
            <div class="list-group list-group-flush my-3">
             <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"> Firstname : <c:out value="${student.firstname}" /></a>
             <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"> Lastname : <c:out value="${student.lastname}" /></a>
              <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"> Email : <c:out value="${student.email}" /></a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">Module : <c:out value="${exam.module}" /></a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">Level : <c:out value="${exam.level}" /> <c:out value="${exam.speciality}" /></a>        
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">Duration : <c:out value="${exam.duration}" /></a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold">Nbr questions : <c:out value="${exam.nbr_questions}" /></a>
                
            </div>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                 <div class="d-flex align-items-center">
                    <i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
                     
                </div>
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
                                <i class="fas fa-user me-2"></i> ${student.username} ${student.lastname} 
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
            
           
            <!-- Topic questions -->
            
            <form action="AddAnswers" method="post">
            
                  <c:forEach var="topic" items="${TopicQuestions}">
                     <div class="question">
                         <h2>*Q :  <c:out value="${topic.question}" /></h2> 
                                       <input type="hidden" name="question" value="<c:out value="${topic.question}" />">
                               <p>a)   <input type="checkbox" name="answer" value="<c:out value="${topic.choice1}" />" > <c:out value="${topic.choice1}" /> </p>
                               <p>b)   <input type="checkbox" name="answer" value="<c:out value="${topic.choice2}" />" > <c:out value="${topic.choice2}" /></p>
                               <p>c)   <input type="checkbox" name="answer" value="<c:out value="${topic.choice3}" />" > <c:out value="${topic.choice3}" /> </p>
                               <p>d)   <input type="checkbox" name="answer" value="<c:out value="${topic.choice4}" />" > <c:out value="${topic.choice4}" /> </p>
                     </div>
                     <br>
                 </c:forEach>
                                       <input type="submit" value="Terminer">
            </form>     
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
