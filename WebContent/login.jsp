<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
    .form-container {
        border: 2px solid rgb(204, 198, 198);
        height: 400px;
        border-radius: 5px;
    }
</style>
<title>Login</title>
</head>
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
    <div class="col-lg-6 form-container mt-4 float-right">
        <div class="card-body">
            <div class="form-group">
                <form action="./login" method="post">
                    <center>
                        <h1>Login</h1>
                    </center>
                    <label for="username">Username</label>
                    <input type="text" name="username" id="username" class="form-control" required>
                    <br>
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" class="form-control" required>
                    <br>
                        <select class="form-control" name="role" required>
                            <option disabled selected>Choose your role</option>
                            <option value="admin">Admin</option>
                            <option value="member">Member</option>
                        </select>
                    <br>
                    <button type="submit" class="btn btn-primary pull-right">Submit</button>
                </form>
            </div>
        </div>
    </div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>