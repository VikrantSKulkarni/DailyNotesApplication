<%@page import="com.dailynotes.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% //Remover Current User From Session 
	session.removeAttribute("currentUser");
	Message m = new Message("Logout Succefully !","success","success");
	session.setAttribute("msg", m);
	response.sendRedirect("login.jsp");
%>
</body>
</html>