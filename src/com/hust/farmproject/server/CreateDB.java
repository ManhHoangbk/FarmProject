package com.hust.farmproject.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.hust.farmproject.model.Config;
import com.hust.farmproject.model.DeviceInfo;
import com.hust.farmproject.model.FarmInfo;
import com.hust.farmproject.model.SenserData;
import com.hust.farmproject.model.UserInfo;


public class CreateDB {
	
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
		try {
			Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			String url = Config.URL_BASE;
			connection = DriverManager.getConnection(url, Config.USER_NAME, Config.PASS);
			statement = connection.createStatement();
			
			String createDB = "CREATE DATABASE IF NOT EXISTS " + Config.DB_NAME
					+ " DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_unicode_ci ";
			int status = statement.executeUpdate(createDB);
			System.out.println("createDB: "+ status);
			
			url = Config.URL_BASE + Config.DB_NAME;
			connection = DriverManager.getConnection(url, Config.USER_NAME, Config.PASS);
			statement = connection.createStatement();
			
			String tableDevice = DeviceInfo.createTable();
			status = statement.executeUpdate(tableDevice);
			System.out.println("tableDevice: "+ status);
			
			String tableFarm = FarmInfo.createTable();
			status = statement.executeUpdate(tableFarm);
			System.out.println("tableFarm: "+ status);
			
			String senserTalbe = SenserData.createTable();
			status = statement.executeUpdate(senserTalbe);
			System.out.println("senserTalbe: "+ status);
			
			String userTable = UserInfo.createTable();
			status = statement.executeUpdate(userTable);
			System.out.println("userTable: "+ status);
			
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
	
}
