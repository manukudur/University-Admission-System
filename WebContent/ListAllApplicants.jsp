<%@page import="java.util.List"%>
<%@page import="com.university.service.ProgramService"%>
<%@page import="com.university.dto.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Applicant Lists</title>
</head>
<body>
	<%
	HttpSession session = request.getSession(false);
	if(session == null){
		response.sendRedirect("./LoginPage");
	}
	%>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="./admin">Super University</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item">
					<a class="nav-link" href="./logout">Logout</a>
				</li>
			</ul>
		</div>
		</nav>
	</div>
	<div class="container">
		<ul class="nav justify-content-center" style="border: 2px solid rgb(75, 204, 243)">
			<li class="nav-item">
				<a class="nav-link" href="./programs">Programs</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="./ScheduledPrograms">Scheduled Programs</a>
			</li>
			<li class="nav-item">
				<a class="nav-link disabled" href="./Applicants">Applicants</a>
			</li>
		</ul>
    </div>
    <div class="container form-group mt-2">
        <a href="./programs"><button class="btn btn-danger">Back</button></a>
    </div>
	<%
		ProgramService p = new ProgramService();
		List<Program> proLists = p.getPrograms();
	%>
    <div class="mt-2">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Application ID</th>
					<th scope="col">Full Name</th>
					<th scope="col">DOB</th>
					<th scope="col">Highest Qualification</th>
					<th scope="col">Marks Obtained</th>
					<th scope="col">Email Id</th>
					<th scope="col">Scheduled Program ID</th>
					<th scope="col">Status</th>
					<th scope="col">Interview Date</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
                <% for (Program proList : proLists) { %>
                    <form action="./UdateApplicant" method="post">
                        <tr>
                            <th scope="col"><input readonly type="number" name="proName" value="<%= proList.getProgramName() %>"></input></th>
                            <td scope="col"><input readonly name="fullName"><%= proList.getDescription() %></input></td>
                            <td scope="col"><input readonly type="text" name="dob" value="<%= proList.getApplicantEligibility() %>"></input></td>
                            <td scope="col"><input readonly type="number" name="HighestQualification" value="<%= proList.getDurationInMonths() %>"></input></td>
                            <td scope="col"><input readonly type="text" name="marksObtained" value="<%= proList.getDegreeCertificateOffered() %>"></input></td>
                            <td scope="col"><input readonly type="text" name="emailId"><%= proList.getImgUrl() %></input></td>
                            <td scope="col"><input readonly type="text" name="scheduledProgramId"><%= proList.getImgUrl() %></input></td>
                            <td scope="col"><input type="text" name="status"><%= proList.getImgUrl() %></input></td>
                            <td scope="col"><input type="date" name="DateOfInterview"><%= proList.getImgUrl() %></input></td>
                            <td scope="col"><button type="submit" class="btn btn-success">Update</button></td>
                        </tr>
                    </form>
				<% }%>
			</tbody>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>