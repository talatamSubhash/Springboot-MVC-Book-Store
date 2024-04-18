<%@ page language="java" contentType="text/html"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapodn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>
<div class="container-fluid bg-success test-white text-center">
<h1> Spring Boot MVC Project........</h1>
</div>
<div>
<h1><i>Add the new Book Data</i></h1>
<form method="post" action ="/books/savebook">

<div class="form-group">
<label>Book ISBN:</label>
<div class="Input-group">
<div class="input-group-prepend">
<span class="input-group-text"><i class="fas fa-book"></i></span>
</div>
<input type="text" class="form-control" name="isbn" placeholder="Book number">
</div> 
<c:if test="${not empty errors.getFieldError('isbn')}">
<div class="text-danger">${errors.getFieldError('isbn').defaultMessage}</div>
</c:if>

</div>

<div class="form-group">
<label>Book Name:</label>
<div class="Input-group">
<div class="input-group-prepend">
<span class="input-group-text"><i class="fas fa-book"></i></span>
</div>
<input type="text" class="form-control" name="name" placeholder="Book Name">
</div> 
<c:if test="${not empty errors.getFieldError('name')}">
<div class="text-danger">${errors.getFieldError('name').defaultMessage}</div>
</c:if>
</div>

       <div class="form-group">
     <label>Book Author:</label>
   <div class="Input-group">
   <div class="input-group-prepend">
<span class="input-group-text"><i class="fas fa-user"></i></span>
  </div>
<input type="text" class="form-control" name="author" placeholder="Book Author">
     </div> 
     <c:if test="${not empty errors.getFieldError('author')}">
<div class="text-danger">${errors.getFieldError('author').defaultMessage}</div>
</c:if>
           </div>

<button type="submit" class="btn btn-primary">Save Book</button>
</form>
</div>

</body>
</html>