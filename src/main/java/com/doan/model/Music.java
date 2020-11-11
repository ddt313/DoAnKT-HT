package com.doan.model;

public class Music {
	private int id;
	private String name_music;
	private String src;
	private int mu_type;

	public Music() {

	}

	public Music(int id, String name_music, String src, int mu_type) {
		super();
		this.id = id;
		this.name_music = name_music;
		this.src = src;
		this.mu_type = mu_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getMu_type() {
		return mu_type;
	}

	public void setMu_type(int mu_type) {
		this.mu_type = mu_type;
	}

}
