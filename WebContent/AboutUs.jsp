<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>About Us</title>
  <link rel="stylesheet" type="text/css" href="about.css">

  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://fonts.googleapis.com/css?family=Crimson+Text|Work+Sans:400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Quicksand:300,500" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



</head>
<body>
  <!----hero Section start---->

  <div class="hero">
    <header id="header">
     <h2 class="logo">e<span>_Exam</span></h2>
      <ul id="menu">
        <li><a href="HOME.jsp">Home</a></li>
        <li><a href="#">About Us</a></li>
        <li><a href="#">Services</a></li>
        <li><a href="#">Skills</a></li>
        <li><a href="#">Contact Us</a></li>
      </ul>
   
</header>
<script> 
 var header=document.getElementById("header");
 var menu=document.getElementById("menu");
  window.onscroll=function(){
    if (window.pageYOffset >=menu.offsetTop) {
      header.classList.add("sticky");
    }else
    {
     header.classList.remove("sticky");
    }
  }
   
  </script>
<div class="content">
           <h1>Who are</h1><span> we?</span><br>
       <a href="AboutUs.html" class="btn">Contact Us</a>
    </div>
  </div>
  <section class="about">
  <div class="main">
     <img src="pic/ab2.jpg">
    <div class="about-text">
      <h2>About Us</h2>
<h5>e<span>_exam</span> App Develepement team</h5>
<p>It all started when our university offered workshops for students for a bachelor's degree project.<br>
We are a team of students from <span>University Abd ELHamid Mehri</span>.
 Our work is based on developng a simple system
 designed to teachers and students in order to facilitate the exams process.  </p>




    </div>
  </div>
</section>
 <footer>
    <p>Univerité Abd Elhamid Mehri</p>
    <p>For more informations click here</p>
    <div class="social">
      <a href="https://www.facebook.com/univCns2"><i class="fab fa-facebook-f"></i></a>
      <a href="https://www.univ-constantine2.dz/"><i class="fab fa-dribbble"></i></a>
    <p class="end">CopyRight &copy</p>
    </div>
  </footer>
</body>
</html></html>