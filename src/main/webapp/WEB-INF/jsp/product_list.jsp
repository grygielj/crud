
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Car list</title>
    <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Product List</h2>
    <table class="table table-striped">
        <thead>
        <th scope="row">#ID</th>
        <th scope="row">Name</th>
        <th scope="row">Category</th>
        <th scope="row">Update</th>
        <th scope="row">Delete</th>
        </thead>
        <tbody>
        <c:forEach items="${productList }" var="product">
            <tr>
                <td>${product.id }</td>
                <td>${product.name }</td>
                <td>${product.category }</td>
                <td>
                    <spring:url value="/product//updateProduct/${product.id }" var="updateURL"/>
                    <a class ="btn btn-primary" href="${updateURL }" role="button">Update</a>
                </td>
                <td>
                    <spring:url value="/product/deleteProduct/${product.id }" var="deleteURL"/>
                    <a class ="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    <spring:url value="/product/addProduct/" var="addURL" />
    <a class="btn btn-primary" href="${addURL }" role="button" >CREATE New Product</a>
    <div></div>


</div>
</body>
</html>