package com.dailynotes.dao;
import java.sql.*;

import com.dailynotes.entities.Users;
public class UserDao {
	public Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	public boolean saveUser(Users user) {
		boolean flag=false;
		try {
			String query="insert into users(username,useremail,password) values (?,?,?)";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, user.getUsername());
			psmt.setString(2, user.getUseremail());
			psmt.setString(3, user.getPassword());
			psmt.executeUpdate();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
	return flag;
	}
	
	public Users getUSerByEmailPass(String email,String password) {
		Users user = null;
		try {
			String query="select * from users where useremail=? and password=?";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, email);
			psmt.setString(2, password);
			 ResultSet rs= psmt.executeQuery();
			 if(rs.next()) {
				 user = new Users();
				 user.setUsername(rs.getString("username"));
				 user.setUseremail(rs.getString("useremail"));
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
