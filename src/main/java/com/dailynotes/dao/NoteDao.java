package com.dailynotes.dao;

import java.sql.*;

import com.dailynotes.entities.Notes;

public class NoteDao {
	public Connection con;

	public NoteDao(Connection con) {
		super();
		this.con = con;
	}
		public boolean saveNote(Notes note) {
		boolean flag=false;
		try {
			String query="insert into notes(note_title,note_desc) values (?,?)";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, note.getNote_title());
			psmt.setString(2, note.getNote_desc());
			psmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	} 
		
	public boolean deleteNote(int noteId) {
		boolean flag=false;
		try {
			String query="delete from notes where note_id=?";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1,noteId);
			psmt.executeUpdate();
			flag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return flag;
	}	
	
	public Notes getNoteById(int note_id) {
		Notes note=null;
		try {
			String query = "select * from notes where note_id= ?";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setInt(1, note_id);
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				//set the values to note object from resultset
				note = new Notes();
				note.setNoteId(Integer.parseInt(rs.getString("note_id")));
				note.setNote_title(rs.getString("note_title"));
				note.setNote_desc(rs.getString("note_desc"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}	
		return note;
		
	}
	
	public boolean updateNote(Notes note) {
		boolean flag=false;
		try {
			String query="update notes set note_title=?,note_desc=? where note_id=?";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, note.getNote_title());
			psmt.setString(2, note.getNote_desc());
			psmt.setInt(3, note.getNoteId());
			
			psmt.executeUpdate();
			flag = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
		
		
		
		
		
		
		
		
		
		
		
		
}
