package com.hust.farmproject.server;

import java.io.Serializable;

import com.hust.farmproject.model.Config;

import common.jdbc.JdbcConnectionPool;
import common.jdbc.JdbcParameter;

public class DataEngine implements Serializable {
	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DataEngine INSTANCE;
	
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
		if (INSTANCE == null) {
			INSTANCE = new DataEngine();
		}
		return INSTANCE;
	}
	
	public static DataEngine getInstance(boolean isLocal) {
		Config.IS_LOCAL = isLocal;
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
				this.dbAddr = Config.URL_BASE + Config.DB_NAME + "?useUnicode=true&characterEncoding=UTF-8";
				this.dbUser = "root";
				this.dbPass = "1";
			this.dbPort = "3306";
			this.dbName = Config.DB_NAME;
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
			createDB.createDB(Config.IS_LOCAL);
			return "ok";
		} catch (Exception e) {
			return "createDB: "+ e;
		}
	}

	public DAO getDao() {
		return dao;
	}
}
