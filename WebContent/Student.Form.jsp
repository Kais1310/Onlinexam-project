<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Crimson+Text|Work+Sans:400,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Quicksand:300,500" rel="stylesheet">
<link rel="stylesheet" href="Formule.css">	
	
</head>
<body>


	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #668d9b;">
			<div>
				<h2 style="color: white;">Account Management</h2>
			</div>

			<ul class="navbar-nav">
				<li><a href="List_Student" class="nav-link">Students</a></li>
				<li><a href="List_Student" class="nav-link">Teachers</a></li>
				<li><a href="List_Student" class="nav-link">Doctors</a></li>
			</ul>
		</nav>
	</header>
	<br>
				
<c:if test="${student == null}">
		
		
		 <div class="all">
		     <h1>Create student account</h1>
	        <div class="formule">
                
   
       <form action="Create_Student" method="post">
         <div class="part1">
             
            
                <label>Firstname</label><br>
                 <input type="text"  name="firstname" required="required" />
            <br><br>

                <label>Lastname</label> <br>
                <input type="text"   name="lastname" required="required"/>
            <br><br>
            
                <label>Email</label> <br>
                <input type="text"   name="email" required="required"/>
            <br><br>
             <label>Username</label><br>
                 <input type="text"  name="username" required="required"/>
            <br><br>
                <label>Password</label><br>
                 <input type="text"  name="password" required="required"/>
        </div>
       <div class="part2">
    
                    <strong> Level </strong><br>
                  <select class="role" name="level"  >
                       
                        <option>L1</option>
                        <option>L2</option>
                        <option>L3</option>
                        <option>M1</option>
                        <option>M2</option>
                   </select>
                   <br><br>
                   <strong> Speciality</strong><br>
                    <select class="role" name="speciality" >
                        
                        <option>MI</option>
                        <option>GL</option>
                        <option>TI</option>
                        <option>SI</option>
                        <option>SCI</option>
                        <option>STIW</option>
                   </select>
                   <br><br>
                    <strong> Group </strong><br>
                    <select class="role" name="group">
                       
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                       
                   </select>
                   
                
            

                <br>
            <br>
            <button type="submit" class="btn">Add</button>
        </div>
       
       </form>

 
         </div>
       </div>
 </c:if>
	
	
	<c:if test="${student != null}">
	 
	 <div class="all">
	 <h1>Update Student account</h1>
	    <div class="formule">
                
   
        <form name ="Update_Student" action="Update_Student"  method="post">

             
                <div class="part1">
                
                 <input type="hidden"  name="student_id" value ="<c:out value="${student.student_id}" />" />
            
             
            
                <label>First Name</label><br>
                 <input type="text"  name="firstname" value ="<c:out value="${student.firstname}" />" required="required" />
            <br><br>

                <label>Last Name</label> <br>
                <input type="text"   name="lastname" value ="<c:out value="${student.lastname}"/>" required="required"/>
            <br><br>
            
                <label>Email</label> <br>
                <input type="text"   name="email" value ="<c:out value="${student.email}"/>" required="required"/>
            <br><br>
             <label>Username</label><br>
                 <input type="text"  name="username" value ="<c:out value="${student.username}"/>" required="required"/>
            <br><br>
                <label>Password</label><br>
                 <input type="text"  name="password" value ="<c:out value="${student.password}"/>" required="required"/>

       </div>
     <div class="part2">
                    <strong> Level </strong><br>
                  <select class="role" name="level"  >
                       
                        <option><c:out value="${student.level}"/></option>
                        <option>L1</option>
                        <option>L2</option>
                        <option>L3</option>
                        <option>M1</option>
                        <option>M2</option>
                   </select>
                   <br><br>
                   <strong> Speciality</strong><br>
                    <select class="role" name="speciality" >
                        
                        <option><c:out value="${student.speciality}"/></option>
                        <option>MI</option>
                        <option>GL</option>
                        <option>TI</option>
                        <option>SI</option>
                        <option>SCI</option>
                        <option>STIW</option>
                   </select>
                   <br><br>
                    <strong> Group </strong><br>
                    <select class="role" name="group">
                       
                        <option><c:out value="${student.group}"/></option>
                        <option>1</option>
                        <option>2</option>
                        <option>3</option>
                        <option>4</option>
                        <option>5</option>
                       
                   </select>
                   
                
            

                <br>
            <br>
            <button type="submit" class="btn">Update</button>
        </div>
    </form>

 
         </div>
     </div>
    	   
    </c:if>

</body>

</html>
