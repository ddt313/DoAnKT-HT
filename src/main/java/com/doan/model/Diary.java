package com.doan.model;

public class Diary {
	private int id;
	private String username;
	private String name_music;
	private String src;
	private String d_time;
	private int mu_type;

	public Diary() {

	}

	public Diary(int id, String username, String name_music, String src, String d_time, int mu_type) {
		super();
		this.id = id;
		this.username = username;
		this.name_music = name_music;
		this.src = src;
		this.d_time = d_time;
		this.mu_type = mu_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName_music() {
		return name_music;
	}

	public void setName_music(String name_music) {
		this.name_music = name_music;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getD_time() {
		return d_time;
	}

	public void setD_time(String d_time) {
		this.d_time = d_time;
	}

	public int getMu_type() {
		return mu_type;
	}

	public void setMu_type(int mu_type) {
		this.mu_type = mu_type;
	}

}
