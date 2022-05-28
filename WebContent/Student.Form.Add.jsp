<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Student form</title>
   <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="style2.css" />
    <link rel="stylesheet" href="formulaire.css" />
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
                <a href="Home.Admin.jsp" class="list-group-item list-group-item-action bg-transparent second-text active"><i class="fas fa-home"></i> Home</a>
                <a href="List_Student" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="bi bi-bank2"></i> Management Account</a>        
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-edit"></i> Planning Exam</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-check"></i> Justifications</a> 
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-exclamation"></i> Annonces</a>        
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-comment-dots me-2"></i>Chat</a>
               
                 
            </div>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
 <div id="page-content-wrapper">
	 		        
       
           <div class="Formule"> 
                   <form name ="Create_Student" action="Create_Student"  method="post">
                        <h2>Add Student account</h2>
                <p>you need to enter the information of the student to create the account</p>
                
            <div class="first">
                      <label>Firstname</label><br>
                 <input type="text"  name="firstname" required="required"/>
            <br>

                <label>Lastname</label> <br>
                <input type="text"   name="lastname" required="required"/>
            <br>
            
                <label>Email</label> <br>
                <input type="text"   name="email" required="required"/>
            <br>
             <label>Username</label> <br> 
                 <input type="text"  name="username" required="required"/>
            <br>
                <label>Password</label> <br>
                 <input type="text"  name="password" required="required"/>
           </div>
           
           <div class="second">
                 <strong> Level </strong><br><br>
                  <select class="role" name="level"  >
                       
                        <option>L1</option>
                        <option>L2</option>
                        <option>L3</option>
                        <option>M1</option>
                        <option>M2</option>
                   </select>
                   
                   <br><br>
                   <strong> Speciality</strong><br><br>
                    <select class="role" name="speciality" >
                        
                        <option>MI</option>
                        <option>GL</option>
                        <option>TI</option>
                        <option>SI</option>
                        <option>SCI</option>
                        <option>STIW</option>
                   </select>
                   <br><br>
                   
                    <strong> Department</strong><br><br>
                    <select class="role" name="department" >
                        
                        <option>MI</option>
                        <option>TLSI</option>
                        <option>IFA</option>
                        
                   </select>
                   <br><br>
                   
                    <strong> Group </strong><br><br>
                    <select class="role" name="group">
                       
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                       
                   </select>
            

            </div>
                      <br>
                 <button type="submit" class="btn">Add account</button>
        
                </form>
             </div>
    
  </div>
</div>


      
   
</body>

</html>
