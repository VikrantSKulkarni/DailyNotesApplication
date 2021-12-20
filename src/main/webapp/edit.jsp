<%@page import="com.dailynotes.entities.Notes"%>
<%@page import="com.dailynotes.helper.ConnectionProvider"%>
<%@page import="com.dailynotes.dao.NoteDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Note </title>
</head>
<body>
	<%@include file="base.jsp" %>
	<%@include file="navbar.jsp" %><br><br>

	<% int noteId =Integer.parseInt( request.getParameter("note_id"));
	   NoteDao nDao = new NoteDao(ConnectionProvider.getConnection());
	   Notes note = nDao.getNoteById(noteId);//here we got all data of that note 
	   //now I am going to print that data to form
	%>
<div class="row justify-content-center">
	<div class="col-md-6">
	  <div class="card">
  	 <div class="card-body">
     <h5 class="card-title text-center">Update Notes Here </h5>
     <p class="card-text">
       <form class="form-group" action="update" method="post">
          <input  type="hidden" name="txtnoteId" value="<%= note.getNoteId()%>">
          <label for="noteTitle">Note Title </label>
          <input   name="txtnTitle"  class="form-control" value="<%= note.getNote_title() %>" type="text" placeholder="Note Title">
          <label for="noteTitle">Note Description </label>
          <input name="txtnDesc" class="form-control" value="<%= note.getNote_desc() %>" type="text" placeholder="Note Description">
          <button class="mt-3 btn btn-primary" type="submit">Save</button>
       </form>
     </p>
  </div>
</div>
	</div>
</div>	
	

</body>
</html>