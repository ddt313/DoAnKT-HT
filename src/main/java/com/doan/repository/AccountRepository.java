package com.doan.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.doan.model.Account;

@Repository
public class AccountRepository {

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
	
	public boolean authAccount(Account acc) {
		boolean check = false;
		
		Connection con = this.connectionDatabase();
		String sql = "select *\r\n"
				+ "from Account\r\n"
				+ "where username = '" + acc.getUsername() + "'\r\n"
				+ "	and pass = '" + acc.getPass() + "'";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if (rs.next()) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		
		return check;
	}

}
