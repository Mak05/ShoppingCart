<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.error {
	color: red;
	font-style: italic;
}
</style>
<script>
		function valid() {
		if (document.getElementById("name").value == "") {
			document.getElementById("error1").innerHTML = "<center>name required</center>";
			return false;
		} else {

			document.getElementById("error1").innerHTML = "";

		}
		if (document.getElementById("quantity").value == "") {
			document.getElementById("error3").innerHTML = "<center> quantity required</center>";
			return false;
		} else {

			document.getElementById("error3").innerHTML = "";
		}
		if (document.getElementById("price").value == "") {
			document.getElementById("error4").innerHTML = "<center>price required</center>";
			return false;
		} else {
			return true;
		}
	}
</script>
<form:form method="POST" action="success" modelAttribute="product">
	<h2 class="jumbotron" height=100 align="center">Edit Product</h2>
	<div align="center">
		<table>
			<tr>
				<form:hidden path="id"></form:hidden>
				<td>Product Name * :</td>
				<td><div class="form-group"><form:input path="name" id="name" value="${product.name}" class="form-control"
						size="35" maxlength="30" /> <form:errors path="name"
						cssClass="error" /></div></td>
						<td><p id="error1"></p></td>
			</tr>

			<tr>
				<td>Product Description :</td>
				<td><div class="form-group"><form:input path="description" id="description" class="form-control"
						value="${product.description}" size="35" maxlength="30" /> <form:errors
						path="description" cssClass="error" /></div></td>
			</tr>
			<tr>
				<td>Quantity *:</td>
				<td><div class="form-group"><input type="number" name="quantity" id="quantity" class="form-control"
						value="${product.quantity}" size="6" maxlength="5" /> <form:errors
						path="quantity" cssClass="error" /></div></td>
						<td><p id="error3"></p></td>
			</tr>
			<tr>
				<td>Price *:</td>
				<td><div class="form-group"><input type="number" name="price" id="price" size="8" class="form-control"
						value="${product.price}" maxlength="6" /> <form:errors
						path="price" cssClass="error" /></div></td>
						<td><p id="error4"></p></td>
			</tr>
			<tr>
				<td><br /></td>
				<td><input type="submit" class="btn btn-primary"
					value="Update Product" onclick="return valid()" /></td>
				<td><input type="reset" class="btn btn-primary"
					value="reset" /></td>
			</tr>
		</table>

	</div>
</form:form>
<center>
	<a href="/logout">logout</a>
</center>
<p align="center">${message}</p>