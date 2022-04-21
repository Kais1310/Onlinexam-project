<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/css?family=Crimson+Text|Work+Sans:400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Quicksand:300,500" rel="stylesheet">


 
<style><%@include file="login.css"%></style>

</head>
<body>
<div class="head">
   <div class="navbar">
<b><img src="pic/log6.PNG"></b>
    <a href="HOME.jsp"><i><i class="fa fa-fw fa-home"></i></i>Home</a>

    <a href="Home.admin"><i class=" fa fa-fw fa-question"></i>How it works</a>
 <div class="dropdown-content">
      <a href="http://localhost:8080/GestionPresence/Add_Ens_Servlet">Add</a>
      <a href="http://localhost:8080/GestionPresence/Update_Ens_Servlet">Update</a>
      <a href="Delete.User.jsp">Delete</a>
    </div>
  
    <a href="Home.admin"><i class="fa fa-fw fa-users"></i>About</a>
     <div class="dropdown-content">
      <a href="http://localhost:8080/GestionPresence/Add_Ens_Servlet">Add</a>
      <a href="http://localhost:8080/GestionPresence/Update_Ens_Servlet">Update</a>
      <a href="Delete.User.jsp">Delete</a>
   </div> 
 

     <div class="content">
      <h1> Welcome to e_Exam <br> A secure system <br>for online exams</h1>
        <p>Take your secure digital exams online confidence</p><p>  with exam software designed by team of students</p>
        <p>  who know the realities of all the power and</p>  <p> features you need to create exams </p> <p>for your students according to your needs.</p>  
       </div>
       </div>
        <div class="photo">

 <div class="login"> 
<form name="Login" action="LoginServlet" method="post"> 
<h1>Let Get Started</h1> 
  
  
 <input type="text" name="username" placeholder="Username"  required="required"/> 
 <input type=password name="password" placeholder="Password" required="required"/> 

 
      
      <br>
 
 
<button type="submit" class="btn">login </button> 

 
</form> 
 
 
 
 </div> 


          <img src="pic/2.jpg"> 
         
        </div>
      </div>  
        


<div class="comment"> 
  <div class="quotes">

 <div class="card">
  <div class="box1 box">
    <h3><i class=" fa fa-fw fa-edit"></i></h3>
     <h2>EVERYTHING YOU NEED</h2>
   <p>Create comprehensive exams with powerful tools that are easy to use and quick to apply.</p></div>
   
 </div>


  <div class="card">
  <div class="box1 box">
    <h3><i class=" fa fa-fw fa-laptop"></i></h3>
    <h2>KEEP IT SIMPLE</h2>
    <p>Take exams confidently and under control with our intuitive software that makes everything technical easy.</p>
  </div> 

  </div>

<div class="card">
  <div class="box1 box">
    <h3><i class=" fa fa-fw fa-user"></i></h3>
     <h2>EMPOWER  STUDENTS</h2>
    <p>Customize exams to meet each student's individual needs and let their knowledge shine.</p>
  </div> 
 
  </div>
</div>
</div>



<div class="comment2">
  <h2>Security</h2>
  <p> Our own  software guides candidates through the exam process,<br> ensuring their experience is comfortable, stress-free and reliable.<br>

Applicants are identified by an online proctor through a secure identification process.<br> They are monitored throughout the process to ensure the testing environment meets the highest security standards,<br> while our award-winning security software, ExamShield, locks down their device.<br>

All e-Exam invigilators receive specialist training and are frequently monitored to the highest standards.</p>


</div>


<div class="avantage">
  <h4>Main Advantages</h4>
  <div class="paper">
  <h5>Paper saving</h5>
  <p>
You never need to print your exam to hand <br>it out to your students.<br> Paper savings = tree savings = everyone is happy.</p><img src="pic/p5.jpg">
</div>

<div class="time">
  <h5>time saving</h5>
  <img src="pic/t3.jpg">
<p>
For teachers distributing the exam <br>
does not take time.<br>
Also students do not need to gather <br>in a class to take the exam</p>

</div>

<div class="money">
 <h5>Money saving</h5>
<p>No more need to buy paper: sending<br> emails  is free.<br>Students do not have to travel to a specific<br> location to take the exam;<br> Even students living in isolated places can  <br>take it.
   They can do it within the time you <br>specify from their own device.</p><img src="pic/m3.jpg">
</div>
</div>

<div class="fin">
  <div class="logo">
    <img src="pic/log6.PNG">

  </div>

<div class="menu">
  <h6>Menu</h6>
  <p>
  <a href="Home.Admin.jsp">Home</a><br>

    <a href="Home.admin">How it works</a><br>
<a href="Home.admin">About</a></p>


</div>

<div class="links">
     <h6>Related Link</h6>
   <a href="www.univ-constantine2.dz">www.univ-constantine2.dz</a><br>
   <a href="https://elearning.univ-constantine2.dz/">elearning.univ-constantine2.dz</a>
   
</div>

<div class="creators">

  
    <h6>Creators</h6><p>
    kais.khalfa@univ-constantine2.dz  <br>
    hamida.rim@univ-constantine2.dz<br>
    rihab.tsaloub@univ-constantine2.dz
  
  </p>
</div>
</div>

<div class="copyright">
  <h7>©Copyright</h7>
<a href="#"><i class="fa fa-fw fa-angle-double-up"></i></a>

</div>
</body>
</html>