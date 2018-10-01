package com.hust.farmproject.model;

public class Config {
	public static String DB_NAME = "FarmProject";
	public static String URL_BASE = "jdbc:mysql://localhost:3306/";
	public static String USER_NAME = "root";
	public static String PASS = "1";
	public static boolean IS_LOCAL = true;
	
	
	public static final int LOGIN_FAILED = -1;
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_EMAIL_NOT_EXIST = 2;
	public static final int LOGIN_WRONG_PASSWORD = 3;

	public static final int ROLE_TYPE_USER = 0;
	public static final int ROLE_TYPE_MANAGER = 1;
	public static final int ROLE_TYPE_ADMIN = 2;
	
}
