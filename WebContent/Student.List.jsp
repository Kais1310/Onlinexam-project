<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Student List</title>
<link href='https://css.gg/trash.css' rel='stylesheet'>
<link href='https://css.gg/edit-exposure.css' rel='stylesheet'>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
<style type="text/css">
	
	.select{
  width: 10%;
  margin:1%;
  outline: none;
  background-color:transparent ;
  color: #000;
  font-size: 15px;
  border: none;
  font-family: 'Quicksand', sans-serif;
  font-weight: 500;

}</style>
	
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #668d9b;">
			<div>
				<h2 style="color: white;"> Account Management page </h2>
			</div>

			<ul class="navbar-nav">
				<li><a href="List_Student" class="nav-link">Students</a></li>
				<li><a href="List_Student" class="nav-link">Teachers</a></li>
				<li><a href="List_Student" class="nav-link">Doctors</a></li>
				
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Students accounts</h3>
			<hr>
			<div class="container text-left">
			
			
			  <form action="List_Student" method="get">
					
                       <input type="text" name="search" placeholder="search here..">
                      
                       
                     <a style="position: left;" href="Create_Student" class="btn btn-success">Add New Student</a>   
                   </form>
                      
			</div>
			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Email</th>
						<th>Level</th>
						<th>Speciality</th>
						<th>Group</th>
						<th>Username</th>
						<th>Password</th>
						
						
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="student" items="${listStudent}">

						<tr>
							<td><c:out value="${student.student_id}" /></td>
							<td><c:out value="${student.firstname}" /></td>
							<td><c:out value="${student.lastname}" /></td>
							<td><c:out value="${student.email}" /></td>
							<td><c:out value="${student.level}" /></td>
							<td><c:out value="${student.speciality}" /></td>
							<td><c:out value="${student.group}" /></td>
							<td><c:out value="${student.username}" /></td>
							<td><c:out value="${student.password}" /></td>
							<td><a href="Edit_Student?student_id=<c:out value='${student.student_id}' /> "> <i class="gg-edit-exposure"></i></a></td>
							  <td><a href="Delete_Student?student_id=<c:out value='${student.student_id}'/> "> <i class="gg-trash"></i></a> </td>
						</tr>
					</c:forEach>
				
				</tbody>

			</table>
		</div>
	</div>
	
	
</body>
</html>
