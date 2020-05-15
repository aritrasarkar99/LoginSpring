package com.login.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

	public boolean check(String uname, String pass) {

		// jdbc:mysql://localhost:3306/iot?useLegacyDatetimeCode=false&serverTimezone=UTC

		String user = "Oi1MmsKaw1";
		String password = "SwikGVUTTj";
		String url = "jdbc:mysql://remotemysql.com/Oi1MmsKaw1";
		String sql = "SELECT * FROM `usertable` WHERE `username`=? AND `password`=?";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, uname);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
