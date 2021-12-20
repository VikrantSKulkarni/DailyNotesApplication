<%@page import="com.dailynotes.entities.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NavBar</title>
</head>
<body>
<%@include file="base.jsp" %>
<% //getting current user session here 
   Users user = (Users) session.getAttribute("currentUser");
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">NoteTaker</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
        <% if(user==null){%>
        <li class="nav-item">
          <a class="nav-link" href="login.jsp">Login/Regsiter</a>
        </li>
        <%}else{ %>
        <li class="nav-item">
          <a class="nav-link" href="logout.jsp">LogOut</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="addnote.jsp">Add Note</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href=""><%= user.getUsername() %></a>
        </li>
        <% }%>
      </ul>
    </div>
  </div>
</nav>

</body>
</html>