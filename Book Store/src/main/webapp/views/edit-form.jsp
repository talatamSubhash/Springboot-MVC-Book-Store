<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapodn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">

<title>Insert title here</title>
</head>
<body>
<form method="post" action="/books/editsavebook">
<div class="form-group">
<label>Book ISBN:</label>
<div class="Input-group">
<div class="input-group-prepend">
<span class="input-group-text"><i class="fas fa-book"></i></span>
</div>
<input type="text" class="form-control" name="isbn" readonly="readonly" value="${book.isbn}" placeholder="Book number">
</div>
</div> 

<div class="form-group">
<label>Book Name:</label>
<div class="Input-group">
<div class="input-group-prepend">
<span class="input-group-text"><i class="fas fa-book"></i></span>
</div>
<input type="text" class="form-control" name="name" value="${book.name}" placeholder="Book name">
</div> 


</div>


<div class="form-group">
     <label>Book Author:</label>
   <div class="Input-group">
   <div class="input-group-prepend">
<span class="input-group-text"><i class="fas fa-user"></i></span>
  </div>
<input type="text" class="form-control" name="author" value="${book.author}" placeholder="Book Author">
     </div> 
     
           </div>

<button type="submit" class="btn btn-primary">Save Book</button>
</form>

</body>
</html>