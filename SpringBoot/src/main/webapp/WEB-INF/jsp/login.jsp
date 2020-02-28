
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<title>Login page</title>
<style>
h2 {
  text-align: center;
}
</style>
<div class="container">
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<div class="">
				<h2>LOGIN PAGE</h2>
			</div>
			<!-- Tabs Titles -->
			<c:if test="${param.error != null}">
				<div class="fadeIn first">
					<h2>Invalid user name and password</h2>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="fadeIn first">
					<h2>you have been logged out</h2>
				</div>
			</c:if>
			<!-- Login Form -->
			<form:form action="/login" method="POST">
				<div class="form-group">

					*Username: <input type="text" id="username" class="form-control"
						name="username" placeholder="enter username">

				</div>
				<div class="form-group">

					*Password: <input type="password" id="password"
						class="form-control" name="password" placeholder="password">

				</div>
				<div class="form-group">

					<input type="submit" class="btn btn-primary" value="Log In">
				</div>
			</form:form>
			<a href="showRegistration">Create an account</a>
		</div>
	</div>
</div>
</div>
