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

public class AddNoteServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String nTitle = req.getParameter("txtnTitle");
		String nDesc = req.getParameter("txtnDesc");
		
		//Let Print Taken Data 
		out.println(nTitle);
		out.println(nDesc);
		//Let Save this to database
		
		Notes note = new Notes(nTitle, nDesc);
		NoteDao noteDao = new NoteDao(ConnectionProvider.getConnection());
		
		noteDao.saveNote(note);
		//Data Saved 
		HttpSession s = req.getSession();
		Message m = new Message("Note Saved Succefully !","success", "success");
		s.setAttribute("msg", m);
		res.sendRedirect("index.jsp");
		out.println("Data Saved !!!");
		
		
	}

}
