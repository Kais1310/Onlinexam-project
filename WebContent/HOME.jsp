<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>HOME page</title>
  <link rel="stylesheet" type="text/css" href="HOME.css">

  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Josefin+Sans:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link href="https://fonts.googleapis.com/css?family=Crimson+Text|Work+Sans:400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Quicksand:300,500" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="">


</head>
<body>
  <!----hero Section start---->

  <div class="hero">
    <header id="header">
     <h2 class="logo">e<span>_Exam</span></h2>
      <ul id="menu">
        <li><a href="#">Home</a></li>
        <li><a href="AboutUs.jsp">About Us</a></li>
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
           <h1> Welcome to e<span>_Exam</span> <br> A secure system <br>for online exams</h1>
        <p>Take your secure digital exams online confidence</p><p>  with exam software designed by team of students</p>
        <p>  who know the realities of all the power and</p>  <p> features you need to create exams </p> <p>for your students according to your needs.</p>  

       <a href="Login.Forme.jsp" class="btn">log in</a>
    </div>
  </div>

  <!----About section start---->
  <section class="about">
    <div class="main">
      <img src="pic/securite.jpg">
      <div class="about-text">
        <h2>Securty</h2>
        <h5>in <span>our system</span></h5>
         <p> Our own  software guides candidates through the exam process, ensuring their experience is comfortable, stress-free and reliable.

Applicants are identified by an online proctor through a secure identification process.<br> They are monitored throughout the process to ensure the testing environment meets the highest security standards,<br> while our award-winning security software, ExamShield, locks down their device.<br>

All e-Exam invigilators receive specialist training and are frequently monitored to the highest standards.</p>
       
      </div>
    </div>
    <br>
      <div class="main2">
     <h2>Securty</h2><br>
        <h5>in <span>our system</span></h5><br><br>
         <p> Our own  software guides candidates through the exam process, ensuring their experience is comfortable, stress-free and reliable.

Applicants are identified by an online proctor through a secure identification process.<br> They are monitored throughout the process to ensure the testing environment meets the highest security standards,<br> while our award-winning security software, ExamShield, locks down their device.<br>

All e-Exam invigilators receive specialist training and are frequently monitored to the highest standards.</p>
      <div class="about-text2">
        
        <img src="pic/securite.jpg">
      </div>
    </div>
  </section>

  <div class="service">
    <div class="title">
      
    </div>

    <div class="box">
      <div class="card">
        <i class="fas fa-edit"></i>
        <h5>EVERYTHING YOU NEED.</h5>
        <div class="pra">
          <p>Create comprehensive exams with powerful tools that are easy to use and quick to apply</p>

          <p style="text-align: center;">
           
          </p>
        </div>
      </div>

      <div class="card">
        <i class="fas fa-laptop"></i>
        <h5>KEEP IT SIMPLE</h5>
        <div class="pra">
          <p>Take exams confidently and under control with our intuitive software that makes everything technical easy.</p>

          <p style="text-align: center;">
            
          </p>
        </div>
      </div>

      <div class="card">
        <i class="far fa-user"></i>
        <h5>EMPOWER  STUDENTS</h5>
        <div class="pra">
          <p>Customize exams to meet each student's individual needs and let their knowledge shine.</p>

          <p style="text-align: center;">
            
          </p>
        </div>
      </div>
    </div>
  </div>

  <!------Contact Me------>
  <div class="contact-me">
     <h7>Main advantages</h7>
     <h8>Paper saving</h8>
<div class="text"><p>You never need to print your exam to hand it out to your students. Paper savings = tree savings = everyone is happy.</p><img src="3.jpg"><br>
<span class="moreText">
<h8>Time saving</h8><br><br>
<p>For teachers distributing the exam <br>does not take time.
Also students do not need to gather in a <br>class to take the exam</p><img src="pic/t.jpg">
<br>
<h8>Money saving</h8>
<p>No more need to buy paper: sending emails  is free.<br>Students do not have to travel to a specific location to take the exam;<br> Even students living in isolated places can take it.
   They can do it within the time you</p> <img src="pic/m.jpg"></span></div>
   <button class="read-more-btn">Read More</button>

   <script>
     const readMoreBtn = document.querySelector(".read-more-btn");
const text = document.querySelector(".text");

readMoreBtn.addEventListener("click", (e) => {
  text.classList.toggle("show-more");
  if (readMoreBtn.innerText === "Read More") {
    readMoreBtn.innerText = "Read Less";
  } else {
    readMoreBtn.innerText = "Read More";
  }
});
   </script>
 
</div>
    
 

 
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
</html>