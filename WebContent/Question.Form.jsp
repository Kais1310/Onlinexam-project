<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Question form</title>
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
                    class="fas fa-check"></i><h1><span>e</span>-Exam</h1> <h3>Université Abd ELHamid Mehri</h3></div>
            <div class="list-group list-group-flush my-3">
                <a href="Home.Doctor.jsp" class="list-group-item list-group-item-action bg-transparent second-text active"><i
                        class="fas fa-home"></i> Home</a>
                <a href="List_Questions_banque?module=<c:out value="${doctor.module}" />" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="bi bi-bank2"></i>  Bank</a>        
                <a href="List_Exams?doc_id=<c:out value="${doctor.doctor_id}" />" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-list"></i> Exams</a>
                 <a href="Createxam?doctor_id=<c:out value="${doctor.doctor_id}" />" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-edit"></i> Create exam</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-check"></i> Notes</a> 
                        <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-exclamation"></i> Reclamations</a>        
                
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i
                        class="fas fa-comment-dots me-2"></i>Chat</a>   
            </div>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
 <div id="page-content-wrapper">
	 		 <c:if test="${student != null}">
           <div class="Formule"> 
                   <form name ="Update_Question" action="Update_Question"  method="post">
                        <h2>Update question</h2>
        <div class="first">
        
                <label>Content</label> <br>
                <input type="text"   name="content"  value="<c:out value="${question.content}"/>" required="required"/>
            <br><br>
                 <label>Choice1</label><br>
                 <input type="text"  name="choice1" value="<c:out value="${question.choice1}"/>" required="required"/>
            <br><br>
                 <label>Choice2</label><br>
                 <input type="text"  name="choice2" value="<c:out value="${question.choice2}"/>" required="required"/>
            <br><br>
                 <label>Choice3</label><br>
                 <input type="text"  name="choice3" value="<c:out value="${question.choice3}"/>" required="required"/>
            <br><br>
                 <label>Choice4</label><br>
                 <input type="text"  name="choice4" value="<c:out value="${question.choice4}"/>" required="required"/>
            <br><br>
            
                <label>Right answer</label> <br>
                <input type="text"   name="right_answer" value="<c:out value="${student.right_answer}"/>" required="required"/>
            <br><br>
         </div>        
                 
                 
      <div class="second">
                   <strong> Module </strong><br>
                  <select class="role" name="module"  >
                        <option><c:out value="${question.module}"/></option>
                   </select>
                   <br><br>
                   <strong> Type</strong><br>
                    <select class="role" name="type" >
                        
                        <option><c:out value="${question.type}"/></option>
                        <option>QCM</option>
                        <option>Subjenctif questions</option>
                        <option>both</option>
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
                   <form name ="Add_Question" action="Add_Question"  method="post">
                        <h2>Add question</h2>
        <div class="first">
        
                <label>Content</label> <br>
                <input type="text"   name="content"   required="required"/>
            <br><br>
                 <label>Choice1</label><br>
                 <input type="text"  name="choice1"  required="required"/>
            <br><br>
                 <label>Choice2</label><br>
                 <input type="text"  name="choice2"  required="required"/>
            <br><br>
                 <label>Choice3</label><br>
                 <input type="text"  name="choice3"  required="required"/>
            <br><br>
                 <label>Choice4</label><br>
                 <input type="text"  name="choice4" required="required"/>
            <br><br>
            
                <label>Right answer</label> <br>
                <input type="text"   name="right_answer" required="required"/>
            <br><br>
         </div>        
                 
                 
      <div class="second">
                   <strong> Module </strong><br>
                  <select class="role" name="module"  >
                        <option><c:out value="${doctor.module}"/></option>
                   </select>
                   <br><br>
                   <strong> Type</strong><br>
                    <select class="role" name="type" >
                        
                        <option></option>
                        <option>QCM</option>
                        <option>Subjenctif questions</option>
                        <option>both</option>
                   </select>
                <br>
            <br>

          </div>
                      <br>
                 <button type="submit" class="btn">Add</button>
        
                </form>
             </div>
             
             
             
             
         </c:if> 	
    
  </div>
</div>


      
   
</body>

</html>
