package com.dailynotes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailynotes.dao.NotesDao;
import com.dailynotes.entities.Message;
import com.dailynotes.helper.ConnectionProvider;

public class DeleteNoteServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		int noteId  = Integer.parseInt(req.getParameter("note_id"));
		NotesDao ndao = new NotesDao(ConnectionProvider.getConnection());
		if(ndao.deleteNote(noteId)) {
			HttpSession s = req.getSession();
			Message m = new Message("Note Deleted Succefully!","delete","danger");
			s.setAttribute("msg", m);
			res.sendRedirect("index.jsp");
		}else {
			
		}
		
		
		
	}

}
