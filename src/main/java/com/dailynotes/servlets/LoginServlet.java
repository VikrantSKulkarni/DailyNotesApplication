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

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String useremail = req.getParameter("txtemail");
		String userpass = req.getParameter("txtpass");
		
		UserDao udao = new UserDao(ConnectionProvider.getConnection());
		Users user =  udao.getUSerByEmailPass(useremail, userpass);
		if(user!=null) {
			HttpSession s = req.getSession();
			s.setAttribute("currentUser", user);
			res.sendRedirect("index.jsp");
		}else {
			HttpSession s = req.getSession();
			Message msg = new Message("User Not Found !","error", "danger");
			s.setAttribute("msg", msg);
			res.sendRedirect("login.jsp");
			out.println("User Not Found !");
		}
		
	}

}
