package com.dailynotes.dao;

import java.sql.*;

import com.dailynotes.entities.Users;
public class UserDao {
	private Connection con;

	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	public boolean saveUser(Users user) {
		boolean f1=false;
		try {
			String query = "insert into users(u_name,u_email,u_password) values(?,?,?)";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, user.getU_name());
			psmt.setString(2, user.getU_email());
			psmt.setString(3, user.getU_password());
			psmt.executeUpdate();
			f1=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f1;
	}

	public Users getUserByEmailPass(String email,String password) {
		Users user=null;
		try {
			String query = "select * from users where u_email=? and u_password=?";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1,email);
			psmt.setString(2,password);
			ResultSet rs =psmt.executeQuery();
			if(rs.next()) {
				user = new Users();
				user.setU_name(rs.getString("u_name"));
				user.setU_email(rs.getString("u_email"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
