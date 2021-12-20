package com.dailynotes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailynotes.dao.NotesDao;
import com.dailynotes.entities.Message;
import com.dailynotes.entities.Notes;
import com.dailynotes.helper.ConnectionProvider;

public class AddNoteServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String title = req.getParameter("note_title");
		String desc = req.getParameter("note_desc");
		
		Notes note = new Notes(title, desc);
		NotesDao ndao = new NotesDao(ConnectionProvider.getConnection());
		ndao.saveNotes(note);
		Message m = new Message("Note Saved Succefully !","success","success");
		HttpSession s = req.getSession();
		s.setAttribute("msg", m);
		res.sendRedirect("index.jsp");
		out.println("Data Saved Succefully !! ");
		out.println(title);
		out.println(desc);
		
		
		}

}
