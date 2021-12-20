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

public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String username = req.getParameter("txtname");
		String useremail = req.getParameter("txtemail");
		String userpass = req.getParameter("txtpass");
		
		UserDao udao = new UserDao(ConnectionProvider.getConnection());
		Users user = new Users(username, useremail, userpass);
		udao.saveUser(user);
		HttpSession s = req.getSession();
		Message m =new Message("User Saved Succefully ! Now You Can Log In !", "success", "success");
		s.setAttribute("msg", m);
		res.sendRedirect("login.jsp");
		out.println("User Saved Succefully !");
		}

}
