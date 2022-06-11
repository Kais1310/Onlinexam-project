<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
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
    
  <link rel="stylesheet" href="Management.Account.Style.css" />
   
     
    <title>Students List</title>
    
    
</head>

<body>
    <div class="d-flex" id="wrapper">
        <!-- Sidebar -->
       <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="fas fa-check"></i><h1><span>e</span>-Exam</h1> <h3>Université Abd ELHamid Mehri</h3></div>
            <div class="list-group list-group-flush my-3">
                <a href="Home.Admin.jsp" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-home"></i> Home</a>
                <a href="List_Student" class="list-group-item list-group-item-action bg-transparent second-text active"><i class="bi bi-bank2"></i> Management Account</a>        
                <a href="List_Plannings" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-edit"></i> Planning Exam</a>
                <a href="List_Justification" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-check"></i> Justifications</a> 
                <a href="AddAnnonce" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-exclamation"></i> Annonces</a>        
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-comment-dots me-2"></i>Chat</a>
               
                 
            </div>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <nav class="navbar navbar-expand-lg navbar-light bg-transparent py-4 px-4">
                <div class="d-flex align-items-center">
                    <i class="fas fa-align-left primary-text fs-4 me-3" id="menu-toggle"></i>
                    <h2 class="fs-2 m-0"></h2>
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
                                <i class="fas fa-user me-2"></i>${admin.firstname} ${admin.lastname}
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Profile</a></li>
                                <li><a class="dropdown-item" href="#">Settings</a></li>
                                <li><a class="dropdown-item" href="LogoutAdminServlet">Logout</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
            

            <div class="container-fluid px-4">
                <div class="row g-3 my-2">
                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                <h3 class="fs-2">1000</h3>
                                <p class="fs-5"><a href="List_Student">Student</a></p>
                            </div>
                            
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                <h3 class="fs-2">24</h3>
                                <p class="fs-5"><a href="List_Doctors">Doctors</a></p>
                            </div>
                             
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                <h3 class="fs-2">60</h3>
                                <p class="fs-5"><a href="List_Teachers">Teachers</a></p>
                            </div>
                            
                        </div>
                    </div>

                    <div class="col-md-3">
                        <div class="p-3 bg-white shadow-sm d-flex justify-content-around align-items-center rounded">
                            <div>
                                <h3 class="fs-2">3</h3>
                                <p class="fs-5">surveilant</p>
                            </div>
                             
                        </div>
                    </div>
                </div>
           
          
           
                <div class="row my-5">
                   
           
                    <div class="col">
 <h2>Student list</h2> 
                    <form action="List_Student" method="get"> <input type="search" placeholder="search.." name="search" class="search"></form>
<button><a href ="Create_Student"><i class="bi bi-plus-circle"></i>  Add Student</a></button>
                        <table class="table bg-white rounded shadow-sm  table-hover">
                            <thead>
                                <tr>
                                     <th scope="col">action</th>
                                     <th scope="col" width="50">id</th>
                                     <th scope="col">Firstname</th>
                                     <th scope="col">Lastname</th>
                                     <th scope="col">Email</th>
                                     <th scope="col">level</th>
                                     <th scope="col">speciality</th>
                                     <th scope="col">department</th>
                                     <th scope="col">Group</th>
                                     <th scope="col">username</th>
                                    
                                     
                                </tr>
                            </thead>
                            <tbody>
                                 <c:forEach var="student" items="${listStudent}">
						             <tr>
						                <td><a href="Edit_Student?student_id=<c:out value='${student.student_id}' /> "><i class="bi bi-gear"></i></a> / <a href="Delete_Student?student_id=<c:out value='${student.student_id}'/> "> <i class="bi bi-trash3"></i></a></td>
						              	<th scope="row"><c:out value="${student.student_id}" /></th>
							            <td><c:out value="${student.firstname}" /></td>
						             	<td><c:out value="${student.lastname}" /></td>
						             	<td><c:out value="${student.email}" /></td>
					             		<td><c:out value="${student.level}" /></td>
						            	<td><c:out value="${student.speciality}" /></td>
						            	<td><c:out value="${student.department}" /></td>
						            	<td><c:out value="${student.group}" /></td>
						            	<td><c:out value="${student.username}" /></td>
						            	
						            	
						           	   
						            </tr>
				            	</c:forEach>
                                  
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->
    
 
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