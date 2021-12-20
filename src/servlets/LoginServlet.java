package com.dailynotes.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dailynotes.dao.UserDao;
import com.dailynotes.entities.Users;
import com.dailynotes.helper.ConnectionProvider;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String email = req.getParameter("txtEmail");
		String password= req.getParameter("txtPassword");
		
		UserDao dao = new UserDao(ConnectionProvider.getConnection());
		Users u = dao.getUserByEmailPass(email, password);
		if(u==null) {
			
		}else {
			HttpSession s = req.getSession();
			s.setAttribute("currentUser", u);
			res.sendRedirect("index.jsp");
		}
		
	}

}
