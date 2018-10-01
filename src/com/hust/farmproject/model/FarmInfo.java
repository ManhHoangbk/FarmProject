package com.hust.farmproject.model;

public class FarmInfo {

	private Long id;
	private String name = "";
	private String addr = "";
	private long lastUpdate;

	public FarmInfo() {
	}

	public static String createTable() {
		String myTableName = "CREATE TABLE IF NOT EXISTS FarmInfo (" 
				+ "id BIGINT(20) NOT NULL ," + "name VARCHAR(60) ,"
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

}
