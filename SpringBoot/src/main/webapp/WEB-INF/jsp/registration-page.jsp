<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script>
	function valid() {
		if (document.getElementById("userName").value == "") {
			document.getElementById("error1").innerHTML = "<center>Username required</center>";
			return false;
		} else {

			document.getElementById("error1").innerHTML = "";

		}
		if (document.getElementById("email").value == "") {
			document.getElementById("error2").innerHTML = "<center>Email Id required</center>";
			return false;
		} else {

			document.getElementById("error2").innerHTML = "";

		}
		if (document.getElementById("password").value == "") {
			document.getElementById("error3").innerHTML = "<center> password required</center>";
			return false;
		} else {

			document.getElementById("error3").innerHTML = "";

		}
		if (document.getElementById("address").value != "") {
			document.getElementById("error4").innerHTML = "<center>Passwords don't match</center>";
			return false;
		} else {
			return true;
		}

	}
</script>
<style type="text/css">
.formError, #error1, #error2, #error3 {
	color: red;
}

.home {
	margin-left: auto;
	margin-right: auto;
}

body {
	background-repeat: no-repeat;
	height: 100%;
	background-size: cover;
	background-attachment: fixed;
	background-position: center;
	/* background-color:#4ac7ed; */
}
</style>
</head>
<body>
	<div class="container">
		<h1 align="center">REGISTRATION FORM</h1>
		<br />

		<form:form action="saveRegistrationForm" method="post"
			modelAttribute="users">
			<table align="center">
				<tr>
					<td><form:input path="userId" type="hidden" /></td>
				</tr>
				<tr>
					<td>User Name*</td>
					
					<td>
					<div class="form-group"><form:input path="userName"  class="form-control"
							placeholder="Enter User Name" /></div></td>
					<td><p id="error1"></p></td>
					
					
				</tr>
				<tr></tr>
				<tr>
					<td>Email*</td>
					<td><div class="form-group"><input type="email" name="email" class="form-control"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$"
						placeholder="xyz@something.com" required /></div></td>
					<td><p id="error2"></p></td>
				</tr>
				<tr></tr>
				<tr>
					<td>Password*</td>
					<td><div class="form-group"><form:password path="password" class="form-control"
							placeholder="Enter password" /></div></td>
					<td><p id="error3"></p></td>
				</tr>
				<tr>
					<td>Address*</td>
					<td><div class="form-group"><form:input path="address" class="form-control"
							placeholder="Enter Address" /></div></td>
					<td><p id="error4"></p></td>
				</tr>
				<tr>
					<td>Role*</td>
					<td><div class="form-group"><form:radiobutton path="role" value="A" />Admin <form:radiobutton
							path="role" value="U" />User</div></td>
					<td></td>
				</tr>

				<tr>
					<td align="right"><input type="submit" value="Submit" class="btn btn-primary"
						onclick="return valid()" /></td>
					<td align="left"><input type="reset" value="Reset" class="btn btn-primary"/></td>
				</tr>
			</table>
			<center>
		<a href="/login" style="display: block">Back to Login</a>
	</center>
		</form:form>
	</div>
</body>
</html>