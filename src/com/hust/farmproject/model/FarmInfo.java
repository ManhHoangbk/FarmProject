package com.hust.farmproject.model;

public class FarmInfo implements IBasic{

	private Long id;
	private String name = "";
	private String addr = "";
	private long lastUpdate;

	public FarmInfo() {
	}

	public static String createTable() {
		String myTableName = "CREATE TABLE IF NOT EXISTS FarmInfo (" 
				+ "id BIGINT(20) NOT NULL AUTO_INCREMENT," + "name VARCHAR(60) ,"
				+ "addr VARCHAR(100) ," 
				+ "lastUpdate BIGINT(20)," 
				+ "PRIMARY KEY(id))";
		return myTableName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public long getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(long lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String getColumSQL() {
		return "id,name,addr,lastUpdate";
	}

	@Override
	public String getValueSQL() {
		String val = "'" + getId() + "','" + getName() + "','" + getAddr() + "','"
				+ getLastUpdate() + "'";
		return val;
	}

	@Override
	public String insert() {
		String query = "insert into FarmInfo(" + getColumSQL() + ") values (" + getValueSQL() + ")";
		return query;
	}

	@Override
	public String update() {
		return "name='" + getName() + "',addr='" + getAddr() + "',lastUpdate='" + getLastUpdate() + "'";
	}

}
