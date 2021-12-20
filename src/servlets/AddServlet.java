package com.dailynotes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailynotes.dao.UserDao;
import com.dailynotes.entities.Message;
import com.dailynotes.entities.Users;
import com.dailynotes.helper.ConnectionProvider;

public class AddServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String name = req.getParameter("txtName");
		String email = req.getParameter("txtEmail");
		String password= req.getParameter("txtPassword");
		
		Users u = new Users(name, email, password);
		UserDao dao = new UserDao(ConnectionProvider.getConnection());
		dao.saveUser(u);
		Message m = new Message("Registered Succefully ! Please Login Here", "success", "success");
		HttpSession s = req.getSession();
		s.setAttribute("msg", m);
		res.sendRedirect("Login.jsp");
		out.println("Data Saved Succefully !! ");
		out.println(name);
		out.println(email);
		out.println(password);
		
		out.println("Servlet Works Properly !");
	}
}
