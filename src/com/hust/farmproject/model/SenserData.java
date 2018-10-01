package com.hust.farmproject.model;

public class SenserData {

	private Long id;
	private Long senserId;// phần_cứng_có_Id
	private String name;
	private double value;
	private Long deviceId;
	private Long farmId;
	private Long createDate;
	
	public static String createTable() {
		String myTableName = "CREATE TABLE IF NOT EXISTS SenserData (" 
				+ "id BIGINT(15) NOT NULL ,"
				+ "senserId BIGINT(15) NOT NULL ,"
				+ "name VARCHAR(60) ,"
				+ "value DOUBLE ,"
				+ "deviceId BIGINT(15) NOT NULL ," 
				+ "farmId BIGINT(15) NOT NULL ," 
				+ "createDate BIGINT(15) NOT NULL ," 
				+ "PRIMARY KEY(id))";
		return myTableName;
	}

	public SenserData() {
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public Long getFarmId() {
		return farmId;
	}

	public void setFarmId(Long farmId) {
		this.farmId = farmId;
	}

	public Long getSenserId() {
		return senserId;
	}

	public void setSenserId(Long senserId) {
		this.senserId = senserId;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}
}
