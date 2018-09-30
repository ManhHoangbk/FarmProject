package com.hust.farmproject.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.hust.farmproject.model.FarmInfo;


public class CreateDB {
	private static String DB_NAME = "FarmProject";
	private static String URL_BASE = "jdbc:mysql://202.191.56.160:3306/";
	private static String USER_NAME = "root";
	private static String PASS = "123456aA@";
	public static String statusCreateDB = "1";
	public static String statusCreateTB = "1";
	
	Connection connection = null;
	Statement statement = null;
	
	public void createTableUserRequest() {
		try {
		} catch (Exception e) {
			System.out.println("e: " + e);
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				} // nothing we can do
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				} // nothing we can do
			}
		}
	}
	
	public void createDB(boolean isLocal) {
		if(isLocal){
			URL_BASE = "jdbc:mysql://localhost:3306/";
			USER_NAME = "root";
			PASS = "1";
		}else{
			URL_BASE = "jdbc:mysql://202.191.56.160:3306/";
			USER_NAME = "root";
			PASS = "123456aA@";
		}
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			String url = URL_BASE;
			connection = DriverManager.getConnection(url, USER_NAME, PASS);
			statement = connection.createStatement();
			String hrappSQL = "CREATE DATABASE IF NOT EXISTS " + DB_NAME
					+ " DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_unicode_ci ";
			int b = statement.executeUpdate(hrappSQL);
			url = URL_BASE + DB_NAME;
			connection = DriverManager.getConnection(url, USER_NAME, PASS);
			statement = connection.createStatement();
			
			String myTableName = FarmInfo.createTable();
			int c = statement.executeUpdate(myTableName);
			
			
			System.out.println("b: " + b +" c: "+ c);
		} catch (Exception e) {
			statusCreateDB = "e: "+ e;
			System.out.println("e: " + e);
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
				} // nothing we can do
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				} // nothing we can do
			}
		}
	}
	
}
