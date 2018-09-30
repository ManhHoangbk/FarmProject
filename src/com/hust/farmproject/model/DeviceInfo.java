package com.hust.farmproject.model;

public class DeviceInfo {

	private Long id;
	private String name;
	
	public DeviceInfo() {
		
	}
	
	public static String createTable(){
		 String myTableName = "CREATE TABLE DeviceInfo (" 
	              + "id BIGINT(20) NOT NULL ,"  
	              + "name VARCHAR(60) ," 
	              + "PRIMARY KEY(id))";  
		 return myTableName;
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
	
	
}
