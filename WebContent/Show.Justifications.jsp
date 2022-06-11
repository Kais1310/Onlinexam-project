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


    <link rel="stylesheet" href="Style.Justi.css" />
    <link rel="stylesheet" href="Justi.css" />

    <title>Justification</title>
    
    
</head>

<body>
    <div class="d-flex" id="wrapper">
        <!-- Sidebar -->
        <div class="bg-white" id="sidebar-wrapper">
            <div class="sidebar-heading text-center py-4 primary-text fs-4 fw-bold text-uppercase border-bottom"><i
                    class="fas fa-check"></i><h1><span>e</span>-Exam</h1> <h3>Université Abd ELHamid Mehri</h3></div>
            <div class="list-group list-group-flush my-3">
                <a href="Home.Admin.jsp" class="list-group-item list-group-item-action bg-transparent second-text active"><i class="fas fa-home"></i> Home</a>
                <a href="List_Student" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="bi bi-person-fill"></i> Accounts</a>        
                <a href="List_Plannings" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="bi bi-calendar2-date-fill"></i> Planning Exam</a>
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="bi bi-file-text-fill"></i> Justifications</a> 
                <a href="#" class="list-group-item list-group-item-action bg-transparent second-text fw-bold"><i class="fas fa-exclamation"></i> Annonces</a>        
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
            
                       <div class="question3">
                        <div class="first5">

                               <p>Firstname : <c:out value="${justification.firstname}" /></p>
                               <p>Lastname : <c:out value="${justification.lastname}" /></p>
                               <p>Level :  <c:out value="${justification.level}" />  <c:out value="${justification.speciality}" /></p>
                               <p>Groupe :  <c:out value="${justification.group}" /></p>
                               
                              
                               <p>Module :  <c:out value="${justification.module}" /></p>
                               <p> Absence date :  <c:out value="${justification.date_absence}" /></p>
                               <p>Reason  :  <c:out value="${justification.justification}" /></p></div> 
                               <div class="second5">
                               <p>Justifications :  <br>
                                <div class="image-container">
                                <div class="image">
                                <img src="pic/<c:out value="${justification.fileName}"/>" alt="">
                                </div>
                               </div>
                       <br>
                               <br>
                    <div class="popup-image">
                              <span>&times;</span>
                        <img src="pic/<c:out value="${justification.fileName}"/>" alt="">
                    </div>  
                </div>
                    <script >
                         document.querySelector('.popup-image').style.display='none';
                        document.querySelector('.image-container img').onclick=()=>{
                                document.querySelector('.popup-image').style.display='block';
                                document.querySelector('.popup-image img').src=image.getAttribute('src');
                            };
                        
                           document.querySelector('.popup-image span').onclick=()=>{
                            document.querySelector('.popup-image').style.display='none';
                             }
                    </script>
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