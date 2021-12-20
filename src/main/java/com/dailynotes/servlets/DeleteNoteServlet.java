package com.dailynotes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailynotes.dao.NoteDao;
import com.dailynotes.entities.Message;
import com.dailynotes.helper.ConnectionProvider;

public class DeleteNoteServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		int noteId =Integer.parseInt(req.getParameter("note_id"));
		//out.println(noteId);
		NoteDao noteDao = new NoteDao(ConnectionProvider.getConnection());
		noteDao.deleteNote(noteId);
		HttpSession s = req.getSession();
		Message m = new Message("Note Deleted !", "error", "danger");
		s.setAttribute("msg", m);
		res.sendRedirect("index.jsp");
		out.println("note Deleted !");
	}

}
