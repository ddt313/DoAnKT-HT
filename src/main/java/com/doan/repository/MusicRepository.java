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
		String url = "jdbc:sqlserver://localhost;databaseName=DOAN";
		String userDB = "sa";
		String passDB = "123456";

		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, userDB, passDB);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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


//String dbURL = "jdbc:sqlserver://DESKTOP-2N4V5K6;databaseName=DOAN";
//Connection conn = DriverManager.getConnection(dbURL);