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
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="style2.css" />
	
	
	
</head>
<body>


<div class="d-flex" id="wrapper">
        <!-- Sidebar -->
        <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="fas fa-user-secret me-2"></i>e-Exam</div>
            <div class="list-group list-group-flush my-3">
                <a href="Home.Admin.jsp" class="list-group-item list-group-item-action bg-transparent second-text active"><i
                        class="fas fa-tachometer-alt me-2"></i>Home</a>
                <a href="List_Student" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-project-diagram me-2"></i>Account Management</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-chart-line me-2"></i>Modules</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-paperclip me-2"></i>Reports</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-shopping-cart me-2"></i>Store Mng</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-gift me-2"></i>Products</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-comment-dots me-2"></i>Chat</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-map-marker-alt me-2"></i>Outlet</a>
                <a href="LogoutStudentServlet" class="list-group-item list-group-item-action bg-transparent text-danger fw-bold"><i
                        class="fas fa-power-off me-2"></i>Logout</a>
            </div>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
 <div id="page-content-wrapper">
	 		 <c:if test="${student != null}">
           <div class="Formule"> 
                   <form name ="Update_Student" action="Update_Student"  method="post">
                        <h2>Update Student account</h2>
        <div class="first">
                     <label>Firstname</label><br>
                 <input type="text"  name="firstname" value="<c:out value="${student.firstname}"/>" required="required"/>
            <br><br>

                <label>Lastname</label> <br>
                <input type="text"   name="lastname"  value="<c:out value="${student.lastname}"/>" required="required"/>
            <br><br>
            
                <label>Email</label> <br>
                <input type="text"   name="email" value="<c:out value="${student.email}"/>" required="required"/>
            <br><br>
             <label>Username</label><br>
                 <input type="text"  name="username" value="<c:out value="${student.username}"/>" required="required"/>
            <br><br>
                <label>Password</label><br>
                 <input type="text"  name="password"  value="<c:out value="${student.password}"/>" required="required"/>
         </div>        
                 
                 
      <div class="second">
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

          </div>
                      <br>
                 <button type="submit" class="btn">update</button>
        
                </form>
             </div>
             
             
         </c:if>   
         
            
       <c:if test="${student = null}">
           <div class="Formule"> 
                   <form name ="Create_Student" action="Create_Student"  method="post">
                        <h2>Update Student account</h2>
                
                 <div class="first">
                      <label>Firstname</label><br>
                 <input type="text"  name="firstname" required="required"/>
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
                       <div class="second">
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
                   
                    <strong> Department</strong><br>
                    <select class="role" name="department" >
                        
                        <option>MI</option>
                        <option>TLSI</option>
                        <option>IFA</option>
                        
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
            

                      </div>
                      <br>
                 <button type="submit" class="btn">Add account</button>
        
                </form>
             </div>
             
             
         </c:if> 	
    
  </div>
</div>


      
   
</body>

</html>
