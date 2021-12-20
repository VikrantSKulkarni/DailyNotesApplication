package com.dailynotes.entities;

public class Users {
	private int userId;
	private String username;
	private String useremail;
	private String password;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Users(int userId, String username, String useremail, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.useremail = useremail;
		this.password = password;
	}
	public Users(String username, String useremail, String password) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
