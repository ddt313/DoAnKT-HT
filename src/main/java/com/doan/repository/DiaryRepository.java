package com.doan.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.stereotype.Repository;

import com.doan.model.Diary;

@Repository
public class DiaryRepository {
	
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

		return con;
	}

	public List<Diary> getAllDiary(String username) {
		List<Diary> listDiary = new ArrayList<>();
		
		Connection con = this.connectionDatabase();
		String sql = "select Diary.id, Diary.username, Music.name_music, Music.src, Diary.d_time, Music.mu_type\r\n"
				+ "from Diary\r\n"
				+ "inner join Music\r\n"
				+ "	on Diary.id_music = Music.id\r\n"
				+ "where Diary.username = '" + username + "'\r\n"
				+ "order by d_time desc";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name_music = rs.getString(3);
				String src = rs.getString(4);
				String d_time = rs.getString(5);
				int mu_type = rs.getInt(6);
				
				listDiary.add(new Diary(id, username, name_music, src, d_time, mu_type));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDiary;
	}

	public boolean postDiary(String username, int mu_type) {
		Connection con = this.connectionDatabase();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
		Date date = new Date();
		String currentDateTime = formatter.format(date).toString();
		
		String sql = "insert into Diary(username, id_music, d_time) values('" + username + "', " + mu_type + ", '" + currentDateTime + "')";
		try {
			Statement st = con.createStatement();
			int rs = st.executeUpdate(sql);
			
			if (rs == 0) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
