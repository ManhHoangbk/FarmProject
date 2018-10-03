package com.hust.farmproject.model;

public class UserInfo implements IBasic{
	private String account = "";
	private String email = "";
	private String password = "";
	private int roleType = Config.ROLE_TYPE_USER;
	private int loginCode = Config.LOGIN_SUCCESS;
	private String newPassWord = "";

	public static String createTable() {
		String myTableName = "CREATE TABLE IF NOT EXISTS UserInfo (" 
				+ "account VARCHAR(60) NOT NULL ,"
				+ "email VARCHAR(60) ,"
				+ "roleType INT(15) ,"
				+ "password VARCHAR(60) NOT NULL," 
				+ "PRIMARY KEY(account))";
		return myTableName;
	}

	public UserInfo() {
	}
	
	public UserInfo(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(int loginCode) {
		this.loginCode = loginCode;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}

	public static String getUserInfo(String email) {
		String val = "select * from UserInfo where email='" + email + "'";
		return val;
	}

	public String getNewPassWord() {
		return newPassWord;
	}

	public void setNewPassWord(String newPassWord) {
		this.newPassWord = newPassWord;
	}

	@Override
	public String getColumSQL() {
		String val = "email,password";
		return val;
	}

	@Override
	public String getValueSQL() {
		String val = "'" + this.getEmail() + "','" + this.getPassword() + "'";
		return val;
	}

	@Override
	public String insert() {
		String query = "insert into UserInfo(" + getColumSQL() + ") values (" + getValueSQL() + ")";
		return query;
	}

	@Override
	public String update() {
		return null;
	}

}
