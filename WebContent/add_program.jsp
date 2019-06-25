<%@page import="com.university.dto.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Add Program</title>
</head>
<body class="container">
	<%
	HttpSession session = request.getSession(false);
	if(session == null){
		response.sendRedirect("./LoginPage");		
	} else {
		User u = (User) session.getAttribute("admin");
		if(u.equals("admin") != false){
			response.sendRedirect("./LoginPage");
		}
	}
	%>
	<div>
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
	<div>
		<ul class="nav justify-content-center" style="border: 2px solid rgb(75, 204, 243)">
			<li class="nav-item">
				<a class="nav-link disabled" href="./programs">Programs</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="./ScheduledPrograms">Scheduled Programs</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="./Applicants">Applicants</a>
			</li>
		</ul>
    </div>
    <div class="form-group mt-2">
        <a href="./programs"><button class="btn btn-danger">Back</button></a>
    </div>
    <div class="container card mt-2">
        <div class="containercard-body">
            <center>
                <h1 class="mt-2 mb-2">Fill Program Details</h1>
            </center>
            <form method="POST" action="./addPro">
                <div class="form-group row">
                    <label for="pname" class="col-sm-2 col-form-label">Enter Program Name</label>
                    <div class="col-sm-10">
                        <input type="text" name="pname" class="form-control" id="pname"required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="pdesc" class="col-sm-2 col-form-label">Program Description</label>                
                    <div class="col-sm-10">
                        <textarea name="pdesc" id="pdesc" class="form-control" required></textarea>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="appele" class="col-sm-2 col-form-label">Applicant Eligibility</label>                
                    <div class="col-sm-10">
                        <input id="appele" type="text" class="form-control" name="appele" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="dinmonth" class="col-sm-2 col-form-label">Duration In Months</label>                
                    <div class="col-sm-10">
                        <input id="dinmonth" class="form-control" name="dinmonth" type="number" required maxlength="4">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="dco" class="col-sm-2 col-form-label">Degree Certificate Offered</label>                
                    <div class="col-sm-10">
                        <input id="dco" type="text" class="form-control" name="dco" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="imgurl" class="col-sm-2 col-form-label">Image Url</label>                
                    <div class="col-sm-10">
                        <textarea name="imgurl" id="imgurl" class="form-control" required></textarea>
                    </div>
                </div>
                <div class="form-group float-right">
                    <button type="submit" class="btn btn-success">Submit</button>
                </div>
            </form>                   
        </div>
    </div>	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>