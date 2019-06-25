<%@page import="com.university.service.ProgramService"%>
<%@page import="com.university.dto.Program"%>
<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Courses</title>
</head>
<body class="container">
    <div>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="./">Super University</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="./Courses">Courses</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./ApplayOnline">Apply Online</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./LoginPage">Login</a>
                </li>
            </ul>
        </div>
        </nav>
    </div>
	<div class="row mb-4">
	<%
		ProgramService p = new ProgramService();
		for (Iterator<Program> iterator = p.getPrograms().iterator(); iterator.hasNext();) {
			Program program = (Program) iterator.next();
	%>
		<div class="col-sm-6">
			<div class="card mt-4">
				<div class="card-body">
					<h3 class="card-title"><%=program.getProgramName()%></h3>
					<h6 class="card-subtitle mb-2 text-muted"><%=program.getDurationInMonths()%> Month Course</h6>
					<hr>
					<img src="<%=program.getImgUrl() %>" class="card-img-top" alt="<%=program.getProgramName()%>">
					<hr>
					<p class="card-text"><%=program.getDescription()%></p>
				</div>
			</div>
		</div>
	<%
		}
	%>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
				integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
				crossorigin="anonymous"></script>
			<script
				src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
				integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
				crossorigin="anonymous"></script>
			<script
				src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
				integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
				crossorigin="anonymous"></script>
</body>
</html>