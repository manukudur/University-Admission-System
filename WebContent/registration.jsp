<%@page import="com.university.service.SchPrograms"%>
<%@page import="com.university.dto.ScheduledProgram"%>
<%@page import="com.university.dto.Program"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Registration</title>
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
    <div class="form-group mt-2">
        <a href="./ApplayOnline"><button class="btn btn-danger">Back</button></a>
    </div>
    <div class="container card  mt-2">
        <div class="containercard-body">
            <center>
                <h1 class="mt-2 mb-2">Fill Your Details</h1>
            </center>
            <form method="POST" action="./application">
                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label">Enter Full Name</label>
                    <div class="col-sm-10">
                        <input type="text" name="fullName" class="form-control" id="name" placeholder="eg: Ramuk Jonam" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="email" class="col-sm-2 col-form-label">Your Email ID</label>
                    <div class="col-sm-10">
                        <input type="text" name="emailId" class="form-control" id="email" placeholder="eg: jonam@domain.com" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="highest_qualification" class="col-sm-2 col-form-label">Highest Qualification</label>                
                    <div class="col-sm-10">
                        <input id="highest_qualification" type="text" class="form-control" name="highestQualification" required placeholder="eg: BSC">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="markd" class="col-sm-2 col-form-label">Obtained Marks</label>                
                    <div class="col-sm-10">
                        <input id="markd" class="form-control" name="marksObtained" type="number" step="any" required maxlength="4" placeholder="65.78">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="dob" class="col-sm-2 col-form-label">Date of Birth</label>                
                    <div class="col-sm-10">
                        <input id="dob" type="date" class="form-control" name="dob" required>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="proId" class="col-sm-2 col-form-label">Enter Program ID</label>                
                    <div class="col-sm-10">
						<select class="form-control" name="program" id="proId" required>
                            <option value="null" disabled selected>--select scheduled program--</option>
							<%
								SchPrograms sp = new SchPrograms();
								for (Iterator<ScheduledProgram> iterator = sp.getNames().iterator(); iterator.hasNext();) {
									ScheduledProgram program = (ScheduledProgram) iterator.next();
							%>
							<option value="<%=program.getScheduledProgramId()%>"><%=program.getScheduledProgramId()%> : 
							<%=program.getProgramName()%> - <%= program.getLocation() %></option>
							<%
								}
							%>
						</select>
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