package com.connection;

import java.security.SecureRandom;
import java.sql.*;
import java.util.Random;

public class DatabaseConnection {
	static Connection con;

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/elearningsystem?useSSL=false", "root", "root");
	}

	public static ResultSet getResultFromSqlQuery(String SqlQueryString) {
		ResultSet rs = null;
		try {
			con = getConnection();
			rs = con.createStatement().executeQuery(SqlQueryString);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public static int insertUpdateFromSqlQuery(String SqlQueryString) {
		int i = 2;
		try {
			if (con == null) {
				getConnection();
			}
			i = con.createStatement().executeUpdate(SqlQueryString);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return i;
	}
	
	/*
	 * public static void main(String[] args) { DatabaseConnection d=new
	 * DatabaseConnection(); try { d.getConnection();
	 * System.out.println("Connection established"); ResultSet
	 * resultset=d.getResultFromSqlQuery("select * from tblcaptcha");
	 * while(resultset.next()) { String kkk=resultset.getString(1);
	 * System.out.println(kkk); }
	 * 
	 * int i = d.insertUpdateFromSqlQuery(
	 * "insert into user(user_id,name) values('10',' Javed ')");
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
}