package com.dailynotes.helper;
import java.sql.*;
public class ConnectionProvider {
public static Connection con;
public static Connection getConnection() {
	try {
		if(con==null) {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/notetaker","root","");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return con;
}
}
