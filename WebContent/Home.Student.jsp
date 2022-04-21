<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title> HOME Student </title>
    <link rel="stylesheet" href="etudiant.css">
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css" integrity="sha384-ejwKkLla8gPP8t2u0eQyL0Q/4ItcnyveF505U0NIobD/SMsNyXrLti6CWaD0L52l" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/b99e675b6e.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Quicksand:300,500" rel="stylesheet">
</head>
<body>

<div class="wrapper">
    <div class="sidebar">
        <h2>Univ-Test</h2>
        <ul>
            <li><a href="#"><i class="fas fa-home"></i>Home</a></li>
            <li><a href="#"><i class="fas fa-user"></i>Profile</a></li>
            <li><a href="#"><i class="bi bi-megaphone"></i> announcement</a></li>
            <li><a href="#"><i class="bi bi-clipboard-check"></i> Exam</a>
            </li><li><a href="#"><i class="bi bi-mortarboard"></i>  exam score</a></li>
            <li><a href="#"><i class="bi bi-calendar-date"></i> planing</a></li>
            <li><a href="#"><i class="fas fa-address-book"></i>Contact</a></li>
            <li><a href="LogoutStudentServlet"><i class="fas fa-user"></i>logout</a></li>
            
        </ul> 
        <div class="social_media">
          <a href="#"><i class="bi bi-envelope"></i></a>
          <a href="#"><i class="fab fa-twitter"></i></a>
          <a href="#"><i class="bi bi-github"></i></a>
      </div>
    </div>
    <div class="main_content">
      <div class="container">
<div class="header">  

  <div class="nav" class="user-wrapper">

                <div class="search">
                  
                    <input type="text" placeholder="Search..">
                    <button type="submit"><img src="search.png" alt=""></button>
                </div>
                <div class="user">
                 <i class="bi bi-plus-square-fill"></i> <a href="#" class="btn">add justification </a> <br>  
                   
                </div>
              <div class="user-wrapper" id="dropdown">
        <div>
        </div>
        
        <img src="images.jpg" width="30" height="30" class="logo-admin">
        <div class="dropdown-content">
        <p>My Profile</p>
        <p>Log Out</p>
        </div>
        
      </div>
                </div>
                </div>
                 <div class="content">
            <div class="cards">
                <div class="card">
                    <div class="box">
                        <h3>Mon Cursus</h3>
                        <button class="button button2"><a href=""><i class="fa fa-th-list fa-fw mr-1"></i> Click</a></button>
                    </div>
                </div>
                <div class="card">
                    <div class="box">        
                      <h3>Annoncement</h3>
                        <button class="button button2"><a href=""><i class="fa fa-th-list fa-fw mr-1"></i> Click</a></button>
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <h3>My messages</h3>
                        <button class="button button2"><a href=""><i class="fa fa-th-list fa-fw mr-1"></i> Click</a></button>
                    </div>
                </div>
                <div class="card">
                    <div class="box">
                        <h3>Mes Notes</h3>
                       <button class="button button2"><a href=""><i class="fa fa-th-list fa-fw mr-1"></i> Click</a></button>
                    </div>
                </div>
                                <div class="card">
                    <div class="box">
                        <h3>Emplois du Temps</h3>
                         <button class="button button2"><a href=""><i class="fa fa-th-list fa-fw mr-1"></i>Click</a></button>
                    </div>
                </div>

                <div class="card">
                    <div class="box">
                        <h3> Educational Documentation</h3>
                       <button class="button button2"><a href=""><i class="fa fa-th-list fa-fw mr-1"></i> Click</a></button>
                    </div>
                </div>

            </div>
            <div class="content-2">
                <div class="recent-payments">
                    <div class="title">
                        <h2>Planing Exam</h2>
                        <a href="#" class="btn">View All</a>
                    </div>
                    <table>
                        <tr>
                            <th>Name Module</th>
                            <th>Teacher Name </th>
                            <th>Date </th>
                            <th>Time </th>
                            <th>Option</th>
                        </tr>
                        <tr>
                            <td>Daaw</td>
                            <td>Mr . Main Main</td>
                            <td>12/12/2001</td>
                            <td>8:00 AM</td>
                            <td><a href="#" class="btn">View</a></td>
                        </tr>
                        <tr>
                           <td>Daaw</td>
                            <td>Mr . Main Main</td>
                            <td>12/12/2001</td>
                             <td>8:00 AM</td>
                            <td><a href="#" class="btn">View</a></td>
                        </tr>
                        <tr>
                           <td>Daaw</td>
                            <td>Mr . Main Main</td>
                            <td>12/12/2001</td>
                             <td>8:00 AM</td>
                            <td><a href="#" class="btn">View</a></td>
                        </tr>
                        <tr>
                            <td>Daaw</td>
                            <td>Mr . Main Main</td>
                            <td>12/12/2001</td>
                             <td>8:00 AM</td>
                            <td><a href="#" class="btn">View</a></td>
                        </tr>
                        <tr>
                           <td>Daaw</td>
                            <td>Mr . Main Main</td>
                            <td>12/12/2001</td>
                             <td>8:00 AM</td>
                            <td><a href="#" class="btn">View</a></td>
                        </tr>
                       
                    </table>
                </div>
            </div>
        </div>
    </div>a
                
                </div>

</body>
</html>