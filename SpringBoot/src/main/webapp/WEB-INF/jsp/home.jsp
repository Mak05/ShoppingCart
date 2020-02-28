<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Inventory</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
	<style>
	h2{
	text-align: center;}
	</style>
</head>
<body>

	<h2>PRODUCT SEARCH</h2>

	<div class="container">
		<form:form method="post" action="/products" commandName="Search">
			<input type="text" style="display:inline" name="searchItem" class="form-control"
				placeholder="Search the products">
			<button type="submit" name="save" class="btn btn-primary">Search</button>
		</form:form>
	</div>
<c:if test="${message==null}">
	<table class="table">

		<tr>
			<th scope="col">Product Name</th>
			<th scope="col">Description</th>
			<th scope="col">Price</th>
			<th scope="col">Quantity</th>
		</tr>
		<%-- <c:choose>
			<c:when test="${fn:length(productList) > 0}">
 --%>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.name}</td>
						<td>${product.description}</td>
						<td>${product.price}</td>
						<td>${product.quantity}</td>

					</tr>
				</c:forEach>
		<%-- 	</c:when>
			<c:otherwise>
				<tr>
					<td colspan="8">No Products Found</td>
				</tr>
			</c:otherwise>
		</c:choose> --%>
	</table>
	</c:if>
	<c:out value="${message}"/>
	<center>
		<a href="/logout" style="display: block">logout</a>
	</center>
</body>
</html>