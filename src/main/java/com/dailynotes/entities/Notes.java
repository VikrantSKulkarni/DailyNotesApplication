package com.dailynotes.entities;

public class Notes {
	private int noteId;
	private String note_title;
	private String note_desc;
	private String note_date;
	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notes(int noteId, String note_title, String note_desc, String note_date) {
		super();
		this.noteId = noteId;
		this.note_title = note_title;
		this.note_desc = note_desc;
		this.note_date = note_date;
	}
	public Notes(String note_title, String note_desc, String note_date) {
		super();
		this.note_title = note_title;
		this.note_desc = note_desc;
		this.note_date = note_date;
	}
	
	public Notes(String note_title, String note_desc) {
		super();
		this.note_title = note_title;
		this.note_desc = note_desc;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public String getNote_title() {
		return note_title;
	}
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	public String getNote_desc() {
		return note_desc;
	}
	public void setNote_desc(String note_desc) {
		this.note_desc = note_desc;
	}
	public String getNote_date() {
		return note_date;
	}
	public void setNote_date(String note_date) {
		this.note_date = note_date;
	}
}
