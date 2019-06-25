<%@page import="java.util.Iterator"%>
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
<title>Schedule Program</title>
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
				<a class="nav-link" href="./programs">Programs</a>
			</li>
			<li class="nav-item">
				<a class="nav-link disabled" href="./ScheduledPrograms">Scheduled Programs</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="./Applicants">Applicants</a>
			</li>
		</ul>
    </div>
    <div class="form-group mt-2">
        <a href="./ScheduledPrograms"><button class="btn btn-danger">Back</button></a>
    </div>
    <div class="container card mt-2">
        <div class="containercard-body">
            <center>
                <h1 class="mt-2 mb-2">Fill Scheduled Program Details</h1>
            </center>
            <form method="POST" action="./AddSchePro">
                <div class="form-group row">
                    <label for="scheduledProgramId" class="col-sm-2 col-form-label">Enter Scheduled Program ID</label>
                    <div class="col-sm-10">
                        <input type="text" name="scheduledProgramId" class="form-control" id="scheduledProgramId"required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="pname" class="col-sm-2 col-form-label">Select Program</label>                
                    <div class="col-sm-10">
                        <select class="form-control" name="pname" id="pname" required>
                            <option value="null" disabled selected>--select scheduled program--</option>
							<%
								ProgramService sp = new ProgramService();
								for (Iterator<Program> iterator = sp.listAllPrograms().iterator(); iterator.hasNext();) {
									Program program = (Program) iterator.next();
							%>
							<option value="<%=program.getProgramName()%>"><%=program.getProgramName()%></option>
							<%
								}
							%>
						</select>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="location" class="col-sm-2 col-form-label">Enter Location</label>                
                    <div class="col-sm-10">
                        <input id="location" type="text" class="form-control" name="location" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="sdate" class="col-sm-2 col-form-label">Start Date</label>                
                    <div class="col-sm-10">
                        <input id="sdate" class="form-control" name="sdate" type="date" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="edate" class="col-sm-2 col-form-label">End Date</label>                
                    <div class="col-sm-10">
                        <input id="edate" type="date" class="form-control" name="edate" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="spw" class="col-sm-2 col-form-label">Sessions Per Week</label>                
                    <div class="col-sm-10">
                        <input id="spw" type="number" class="form-control" name="spw" required>
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