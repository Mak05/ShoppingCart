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
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
</head>
<body>

	<h2>Product Search</h2>

	<div class="container">
		<form:form method="post" action="/products" commandName="Search">
			<input type="text" name="searchItem" class="form-control"
				placeholder="Search the products">
			<button type="submit" name="save" class="btn btn-primary">Search</button>
		</form:form>
	</div>

	<table class="customerTable">

		<tr>
			<th width="130">Product Name</th>
			<th width="130">Description</th>
			<th width="130">Price</th>
			<th width="130">Quantity</th>
		</tr>
		<c:choose>
			<c:when test="${fn:length(productList) > 0}">

				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.name}</td>
						<td>${product.description}</td>
						<td>${product.price}</td>
						<td>${product.quantity}</td>

					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="8">No Products Found</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	<center>
		<a href="/logout" style="display: block">logout</a>
	</center>
</body>
</html>