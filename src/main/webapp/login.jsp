<%@page import="com.dailynotes.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login / Register </title>
</head>
<body>
	<%@include file="base.jsp" %><br><br>
	<div class="row justify-content-center" >
	  <div class="col-md-4">
	  	<div class="card">
	  	<%Message msg = (Message) session.getAttribute("msg"); 
	  	 if(msg!=null){
	  	%>
	  	<div class="alert alert-<%= msg.getCssClass() %>" role="alert">
  			<%= msg.getContent()%>
		</div>
		<% } %>
	  	<% session.removeAttribute("msg");%>
		   <div class="card-body">
		   <h5 class="card-title text-center">Login Here </h5>
		   <p class="card-text">
		   <form class="form-group" action="login" method="post">
		   <label for="email" class="form-label">Email address</label>
  		   <input type="email" name="txtemail" class="form-control" placeholder="name@example.com">
		   <label for="password" class="form-label">Password</label>
  		   <input type="password" name="txtpass" class="form-control" placeholder="password">
		   <button type="submit" class="btn btn-primary mt-3">Login</button>
		   </form>
		   </p>
		   </div>
		  </div>
		</div>
		 <div class="col-md-4">
	  	<div class="card">
		   <div class="card-body">
		   <h5 class="card-title text-center">Register Here </h5>
		   <p class="card-text">
		   <form class="form-group" action="register" method="post">
		   <label for="name" class="form-label">Name</label>
  		   <input type="text" name="txtname" class="form-control" placeholder="John Doe ">
		   <label for="email" class="form-label">Email address</label>
  		   <input type="email" name="txtemail" class="form-control" placeholder="name@example.com">
		   <label for="password" class="form-label">Password</label>
  		   <input type="password" name="txtpass" class="form-control" placeholder="password">
		   <button type="submit" class="btn btn-primary mt-3">Register</button>
		   </form>
		   </div>
		   </p>
		  </div>
		</div>
	  </div>
	  </div>
</body>
</html>