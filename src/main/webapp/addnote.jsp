<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Add Notes </title>
</head>
<body>
	<%@include file="base.jsp" %>
	<%@include file="navbar.jsp" %><br><br>
<div class="row justify-content-center">
	<div class="col-md-6">
	  <div class="card">
  	 <div class="card-body">
     <h5 class="card-title text-center">Add Notes Here </h5>
     <p class="card-text">
       <form class="form-group" action="addnote" method="post">
          <label for="noteTitle">Note Title </label>
          <input   name="txtnTitle"  class="form-control" type="text" placeholder="Note Title">
          <label for="noteTitle">Note Description </label>
          <input name="txtnDesc" class="form-control" type="text" placeholder="Note Description">
          <button class="mt-3 btn btn-primary" type="submit">Save</button>
       </form>
     </p>
  </div>
</div>
	</div>
</div>	
</body>
</html>