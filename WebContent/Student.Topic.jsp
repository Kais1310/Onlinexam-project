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
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
   
    <link rel="preconnect" href="https://fonts.gstatic.com">
  
<link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://fonts.googleapis.com/css?family=Crimson+Text|Work+Sans:400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Quicksand:300,500" rel="stylesheet">

    <link rel="stylesheet" href="style2.css" />
    <link rel="stylesheet" href="question.css" />
   
</head>
<body>
 <div class="d-flex" id="wrapper">
        <!-- Sidebar Exam informations -->
       <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="fas fa-check"></i><h5><span>e</span>-Exam</h5> <h7>Universite Abd ELHamid Mehri</h7>
                    <br>
  <span style="color: white;">
<div id="on" class="hours">12:</div> 
<div id="on" class="minutes">12:</div> 
<div id="on" class="seconds">12</div> 

   <script>
   
//const me = "30 apr 16:50:00 2022";
const me =   document.getElementById("one").innerHTML;
var deadline = new Date(me).getTime();
setInterval(function(){
    
    var now = new Date().getTime();
    var t =  now - deadline ;
    if(t < 0){
    document.location.href="http://localhost:8080/TP1/loginServlet"
    }
    if (t >= 0){
 
    
    var days = Math.floor(t/(1000*60*60*24));
    var hours = Math.floor((t % (1000*60*60*24))/(1000*60*60));
    var minutes = Math.floor((t % (1000*60*60))/(1000*60));
    var seconds = Math.floor((t % (1000*60))/1000);
    document.getElementsByClassName("hours")[0].innerHTML = hours;
    document.getElementsByClassName("minutes")[0].innerHTML = minutes;
    document.getElementsByClassName("seconds")[0].innerHTML = seconds;
 if (days ==0 & hours >= 1){
    document.location.href="http://localhost:8080/TP1/loginServlet"
}else 
    if (    days < 0 & hours < 0 & minutes < 0 & seconds < 0) {
    document.location.href="http://localhost:8080/TP1/consulterplanning"

}if (days > 0){
    document.location.href="http://localhost:8080/TP1/loginServlet"
}}
},1000);


</script></span></div>


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
                                       <input type="submit" value="Terminer" id="btn" >
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
