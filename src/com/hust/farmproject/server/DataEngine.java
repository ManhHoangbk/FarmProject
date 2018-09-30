package com.hust.farmproject.server;

import java.io.Serializable;

import common.jdbc.JdbcConnectionPool;
import common.jdbc.JdbcParameter;

public class DataEngine implements Serializable {
	/**
	 * 
	 * 
	 */
	private static String DB_NAME = "FarmProject";
	private static final long serialVersionUID = 1L;
	private static DataEngine INSTANCE;
	
	public static boolean IS_LOCAL = true;
	
	// config
	private String dbAddr;
	private String dbPort;
	private String dbUser;
	private String dbPass;
	private String dbName;
	private int maxConn;
	private int clearPeriod;

	/*---------Object Fields-------------*/
	private JdbcConnectionPool pool;
	private JdbcParameter parameter;

	private DAO dao = null;

	public static DataEngine getInstance() {
		System.out.println("isLocal: "+ IS_LOCAL);
		if (INSTANCE == null) {
			INSTANCE = new DataEngine();
		}
		return INSTANCE;
	}
	
	public static DataEngine getInstance(boolean isLocal) {
		IS_LOCAL = isLocal;
		if (INSTANCE == null) {
			INSTANCE = new DataEngine();
		}
		return INSTANCE;
	}

	public DataEngine() {
		start();
	}

	private void start() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			if(IS_LOCAL){
				this.dbAddr = "jdbc:mysql://localhost:3306/" + DB_NAME + "?useUnicode=true&characterEncoding=UTF-8";
				this.dbUser = "root";
				this.dbPass = "1";
			}else{
				this.dbAddr = "jdbc:mysql://202.191.56.160:3306/"+ DB_NAME +"?useUnicode=true&characterEncoding=UTF-8";
				this.dbUser = "root";
				this.dbPass = "123456aA@";
			}
			this.dbPort = "3306";
			this.dbName = DB_NAME;
			this.maxConn = 1000;
			this.clearPeriod = 0;

			this.parameter = new JdbcParameter();
			this.parameter.setUrl(dbAddr);
			// System.out.println("URL : " + dbAddr);
			this.parameter.setUsername(dbUser);
			this.parameter.setPassword(dbPass);
			this.parameter.setMaxConn(maxConn);
			this.parameter.setClearPeriod(clearPeriod);

			this.pool = new JdbcConnectionPool(parameter);
			// -------Khoi tao DAO-------------------------
			dao = new DAO(pool);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static String createDB(){
		try {
			CreateDB createDB = new CreateDB();
			createDB.createDB(IS_LOCAL);
			return "ok";
		} catch (Exception e) {
			return "createDB: "+ e;
		}
	}

	public DAO getDao() {
		return dao;
	}
}
