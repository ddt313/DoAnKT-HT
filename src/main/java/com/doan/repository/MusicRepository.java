package com.doan.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.doan.model.Music;

@Repository
public class MusicRepository {
	
	private Connection connectionDatabase() {
		String url = "jdbc:postgresql://ec2-3-210-23-22.compute-1.amazonaws.com:5432/d8jdb7pscssrm4";
		String userDB = "rddcbtnessivop";
		String passDB = "94dd879b52e76bc5252ca4438a5967ace5c2eac019145290c0d3a9738fe6aa92";

		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, userDB, passDB);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		
		//5
		return con;
	}

	public List<Music> getAllMusic() {
		List<Music> listMusic = new ArrayList<>();
		
		Connection con = this.connectionDatabase();
		String sql = "select * from Music";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name_music = rs.getString(2);
				String src = rs.getString(3);
				int mu_type = rs.getInt(4);
				
				listMusic.add(new Music(id, name_music, src, mu_type));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMusic;
	}

	public boolean postMusic(Music music) {
		Connection con = this.connectionDatabase();
		String sql = "insert into Music values('" + music.getName_music() +  "', '" + music.getSrc() + "', " + music.getMu_type() + ")";
		
		try {
			Statement st = con.createStatement();
			int rs = st.executeUpdate(sql);
			
			if (rs == 0) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}
		
		return true;
	}

	public String getLastMusic(String username) {
		String url = "";
		
		Connection con = this.connectionDatabase();
		String sql = "select top(1) src\r\n"
				+ "from Diary\r\n"
				+ "inner join Music\r\n"
				+ "	on Diary.id_music = Music.id\r\n"
				+ "where username = '" + username + "'\t\n"
				+ "order by d_time desc";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				url = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return url;
	}

}