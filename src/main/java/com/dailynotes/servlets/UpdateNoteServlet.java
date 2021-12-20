package com.dailynotes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailynotes.dao.NoteDao;
import com.dailynotes.entities.Message;
import com.dailynotes.entities.Notes;
import com.dailynotes.helper.ConnectionProvider;

public class UpdateNoteServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		int noteId =Integer.parseInt (req.getParameter("txtnoteId"));
		String noteTitle = req.getParameter("txtnTitle");
		String noteDesc = req.getParameter("txtnDesc");

		Notes note = new Notes(noteId,noteTitle, noteDesc, noteDesc);
		NoteDao ndao = new NoteDao(ConnectionProvider.getConnection());
		ndao.updateNote(note);
		
		HttpSession s = req.getSession();
		Message m = new Message("Note Updated !", "success", "success");
		s.setAttribute("msg", m);
		res.sendRedirect("index.jsp");
		
		
		
		
		
	}

}
