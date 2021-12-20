package com.dailynotes.helper;
import java.sql.*;
public class ConnectionProvider {
	public static Connection con;
	public static Connection getConnection() {
		try {
			if(con==null) {//if and only if con is null then only creates
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/notetakerapp","root","");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
