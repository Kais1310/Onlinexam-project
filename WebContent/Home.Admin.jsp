<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>HOME Admin </title>
	  <link rel="stylesheet" href="admin.css">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" integrity="sha384-ejwKkLla8gPP8t2u0eQyL0Q/4ItcnyveF505U0NIobD/SMsNyXrLti6CWaD0L52l" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Quicksand:300,500" rel="stylesheet">
</head>
<body>
<div class="admin">
    <div class="sidebar">
        <h2>e-Exam</h2>
        <ul>

            <li><a href="Home.Admin.jsp"><i class="fas fa-home"></i>Home</a></li>
            <li><a href="List_Student"><i class="bi bi-person-workspace"></i>   Management Account </a></li>
            <li><a href="#"><i class="bi bi-book"></i>  Modules</a></li>
            <li><a href="#"><i class="bi bi-calendar-date"></i>  Planing Exams</a></li>
            <li><a href="#"><i class="bi bi-question-circle"></i>  Help</a></li>
            <li><a href="#"><i class="bi bi-gear"></i>  Settings</a></li>
            <li><a href="#"><i class="bi bi-plus-square-fill"></i> Add justification</a></li>
              <li><a href="#"><i class="fas fa-user"></i> Profile</a></li>
            <li><a href="LogoutAdminServlet"><i class="bi bi-gear"></i>  logout</a></li>
            
        </ul> 
        <div class="social_media">
          <a href="#"><i class="bi bi-envelope"></i></a>
          <a href="#"><i class="fab fa-twitter"></i></a>
          <a href="#"><i class="bi bi-github"></i></a>
      </div>
    </div>
    <div class="nav" class="user-wrapper">

                <div class="search">
                  
                    <input type="text" placeholder="Search..">
                    <button type="submit"><img src="pic/search.png" alt=""></button>
                </div>
               
              
        
        </div>
        
        <img src="images.jpg" width="30" height="30" class="logo-admin">
        <div class="dropdown-content">
        <p>My Profile</p>
        <p>Log Out</p>
        </div>
        
      </div>
       
</body>
</html>