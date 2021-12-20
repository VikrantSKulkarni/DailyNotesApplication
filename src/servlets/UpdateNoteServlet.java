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

public class UpdateNoteServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String title = req.getParameter("note_title");
		String desc = req.getParameter("note_desc");
		
		Notes n=new Notes(title, desc);
		NotesDao nd1 = new NotesDao(ConnectionProvider.getConnection());
		if(nd1.UpdateNote(n)) {
			Message m = new Message("Note Updated Succefully !", "update", "success");
			HttpSession s = req.getSession();
			s.setAttribute("msg", m);
			res.sendRedirect("index.jsp");
			
		}
		else {
			Message m = new Message("Note Not Updated !", "update", "danger");
			HttpSession s = req.getSession();
			s.setAttribute("msg", m);
			res.sendRedirect("index.jsp");
			
			
		}
		
	}
}
