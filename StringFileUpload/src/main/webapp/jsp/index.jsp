<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<title>SpringFileUpload</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">Student Registration</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">All students</a></li>
				<li><a href="new">new Student</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">

		<c:choose>
			<c:when test="${mode == 'STUDENT_VIEW'}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Age</th>
							<th>Photo</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="student" items="${students}">
							<tr>
								<td>${student.id}</td>
								<td>${student.firstName}</td>
								<td>${student.lastName}</td>
								<td>${student.age}</td>
								<td></td>
								<td><a href="update?id= ${student.id}">edit</a></td>
								<td><a href="delete?id= ${student.id}">delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>

			<c:when test="${mode == 'STUDENT_EDIT' || mode == 'STUDENT_CREATE'}">
				<form action="save" method="POST">
				
				<input type="hidden" value="${student.id}" class="form-control" id="id" name="id">
				
					<div class="form-group">
						<label for="studentFirstName">First Name:</label> <input type="text"
							class="form-control" id="firstName" name="firstName"
							value="${student.firstName}">
					</div>

					<div class="form-group">
						<label for="lastName">Last Name:</label> <input type="text"
							class="form-control" id="lastName" name="lastName"
							value="${student.lastName}">
					</div>
					
					<div class="form-group">
						<label for="age">Age:</label> <input type="text"
							class="form-control" id="age" name="age"
							value="${student.age}">
					</div>
					
					<div>
						<h3>Upload Single File</h3>
						<form id="singleUploadForm" name="singleUploadForm">
							<input id="singleFileUploadInput" type="file" name="file" required />
							<button type="submit">Submit</button>
						</form>

						<div>
							<div id="singleFileUploadError"></div>
							<div id="singleFileUploadSuccess"></div>
						</div>

					</div>
					
					
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</c:when>

		</c:choose>
	</div>
	
	<script src="/js/main.js"></script>
</body>
</html>
