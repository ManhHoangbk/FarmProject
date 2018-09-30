package com.hust.farmproject.model;

import java.util.ArrayList;
import java.util.List;

public class FarmInfo {
	
	private Long id;
	private String name = "";
	private String addr = "";
	private List<Long> deviceIds = new ArrayList<>();
	private long lastUpdate;
	
	public FarmInfo() {
	}
	
	public static String createTable(){
		 String myTableName = "CREATE TABLE FarmInfo (" 
	              + "id BIGINT(20) NOT NULL ,"  
	              + "name VARCHAR(60) ," 
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
	public List<Long> getDeviceIds() {
		return deviceIds;
	}
	public void setDeviceIds(List<Long> deviceIds) {
		this.deviceIds = deviceIds;
	}
	public long getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(long lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
}
