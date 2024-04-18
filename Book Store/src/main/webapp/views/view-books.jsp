<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>View books.......</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
rel="stylesheet">
</head>
<body>

<div class="container-fluid bg-success text-white text-center">
<h1>Spring Boot Mvc Project.......</h1>
</div>

<div class="container">
<div class="text-center">
<a class="link-primary badge bg-warning" href="/books/addbook">Click Here to add new Book</a>
</div>
<h1><i>List of Books Information....</i></h1>
<div class="text-center text-success">
<c:if test="${savemessage}">
   Data inserted succesfuly......
</c:if>
<c:if test="${deletemessage}">
Data deleted succesfuly.....
</c:if>
</div>
<table class="table table-striped table-bordered table-hover">
<thead class="table table-dark">
<tr>
<th>ISBN</th>
<th>Name</th>
<th>Author</th>
<th>Action</th>
</tr>
</thead>

<tbody>
<c:forEach items="${books}" var="book">
<tr>
<td> ${book.isbn}</td>
<td> ${book.name}</td>
<td> ${book.author}</td>
<td>
    <a href="/books/delete/${book.isbn}">Delete</a>
    <a href="/books/edit/${book.isbn}">Edit</a>
    </td>
 <br>
 
 
 </c:forEach>
 </tbody>
 </table>
 </div>

</body>
</html>