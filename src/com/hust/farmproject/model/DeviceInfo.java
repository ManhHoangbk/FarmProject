package com.hust.farmproject.model;

public class DeviceInfo implements IBasic{

	private Long id;
	private String name;
	
	public static String createTable() {
		String myTableName = "CREATE TABLE IF NOT EXISTS DeviceInfo (" 
				+ "id BIGINT(20) NOT NULL AUTO_INCREMENT," 
				+ "name VARCHAR(60) ,"
				+ "PRIMARY KEY(id))";
		return myTableName;
	}
	
	public DeviceInfo() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getColumSQL() {
		return "id,name";
	}

	@Override
	public String getValueSQL() {
		String val = "'" + this.getId() + "','" + this.getName() + "'";
		return val;
	}

	@Override
	public String insert() {
		String query = "insert into DeviceInfo(" + getColumSQL() + ") values (" + getValueSQL() + ")";
		return query;
	}

	@Override
	public String update() {
		return "name='" + this.getName()  + "'";
	}
	
	
}
