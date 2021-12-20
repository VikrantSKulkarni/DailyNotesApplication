package com.dailynotes.entities;

import java.sql.Timestamp;

public class Notes {
	private int note_id;
	private String n_title;
	private String n_desc;
	private Timestamp note_date;
	public Notes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notes(int note_id, String n_title, String n_desc, Timestamp note_date) {
		super();
		this.note_id = note_id;
		this.n_title = n_title;
		this.n_desc = n_desc;
		this.note_date = note_date;
	}
	public Notes(String n_title, String n_desc) {
		super();
		this.n_title = n_title;
		this.n_desc = n_desc;
	}
	public Notes(String n_title, String n_desc, Timestamp note_date) {
		super();
		this.n_title = n_title;
		this.n_desc = n_desc;
		this.note_date = note_date;
	}
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public String getN_title() {
		return n_title;
	}
	public void setN_title(String n_title) {
		this.n_title = n_title;
	}
	public String getN_desc() {
		return n_desc;
	}
	public void setN_desc(String n_desc) {
		this.n_desc = n_desc;
	}
	public Timestamp getNote_date() {
		return note_date;
	}
	public void setNote_date(Timestamp note_date) {
		this.note_date = note_date;
	}
}
