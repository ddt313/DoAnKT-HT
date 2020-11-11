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
