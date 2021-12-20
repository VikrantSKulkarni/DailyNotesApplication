package com.dailynotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dailynotes.entities.Notes;
public class NotesDao {
	private Connection con;
	public NotesDao(Connection con) {
		super();
		this.con = con;
	}
	public boolean saveNotes(Notes note) {
		boolean f1=false;
		try {
			String query = "insert into Notes(n_title,n_desc) values(?,?)";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, note.getN_title());
			psmt.setString(2, note.getN_desc());
			psmt.executeUpdate();
			f1=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f1;
	}
	public boolean deleteNote(int noteId) {
		boolean f2=false;
		try {
			String q= "delete from notes where note_id=?";
			PreparedStatement p1 =con.prepareStatement(q);
			p1.setInt(1, noteId);
			p1.execute();
			f2=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f2;
		
	}
	
	public Notes getNoteById(int nId) {
		Notes n =null;
		try {
			String q2 = "select * from notes where note_id=?";
			PreparedStatement p2 = con.prepareStatement(q2);
			p2.setInt(1, nId);
			ResultSet s=  p2.executeQuery();
			if(s.next()) {
				n = new Notes();
				n.setN_title(s.getString("n_title"));
				n.setN_desc(s.getString("n_desc"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return n;
	}
	public boolean UpdateNote(Notes note) {
		boolean flag=false;
		try {
			String q3 = "UPDATE notes SET n_title=?,n_desc=? WHERE note_id=?";
			PreparedStatement p3= con.prepareStatement(q3);
			p3.setString(1, note.getN_title());
			p3.setString(2, note.getN_desc());
			p3.setInt(3, note.getNote_id());
			p3.executeUpdate(q3);
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	return flag;
	}	

}
