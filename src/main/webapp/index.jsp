<%@page import="com.dailynotes.entities.Message"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.dailynotes.helper.ConnectionProvider"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<%@include file="base.jsp" %>
<body>
<!--   Navigation Bar -->
<%@include file="navbar.jsp"%><br><br>

		<!-- <h1 class="text-primary">Hello This is NoteTaker Application  : </h1> 
		<p>connection to Database</p>-->
		<% Connection con =ConnectionProvider.getConnection();
		   String query="select * from notes";
		   Statement stmt = con.createStatement();
		   ResultSet rs = stmt.executeQuery(query); 
		   while(rs.next()) {%>
		

<div class="row justify-content-center">
		
<div class="col-md-6">
<%  Message m = (Message) session.getAttribute("msg"); 
	if(m!=null){
%>
<div class="alert alert-<%= m.getCssClass() %>" role="alert">
<%= m.getContent()%>
</div>
<% } %>
<% session.removeAttribute("msg");%>

     <div class="card">
     <div class="card-body">
     <h5 class="card-title"><%=  rs.getString("note_title") %></h5>
     <p class="card-text"><%=  rs.getString("note_desc") %> </p>
     <p class="card-text">Date Added :-<%=  rs.getString("note_date") %> </p>
     
     <a  href="edit.jsp?note_id=<%= rs.getInt("note_id") %>" class="btn btn-success">Edit</a>
     <a href="delete?note_id=<%= rs.getInt("note_id") %>" class="btn btn-danger">Delete</a>
     
     
   </div>
     
    </div>
    
</div>
   <% }%>
   
</div>

</body>
</html>