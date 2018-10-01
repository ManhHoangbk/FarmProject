package com.hust.farmproject.model;

public class SenserData {

	private Long id;
	private Long sensor_id;// phần_cứng_có_Id
	private String sensor_name;
	private double sensor_value;
	private Long device_id;
	private Long farm_id;
	private Long createDate;
	
	public static String createTable() {
		String myTableName = "CREATE TABLE IF NOT EXISTS SenserData (" 
				+ "id BIGINT(15) NOT NULL ,"
				+ "sensor_id BIGINT(15) NOT NULL ,"
				+ "sensor_name VARCHAR(60) ,"
				+ "sensor_value DOUBLE ,"
				+ "device_id BIGINT(15) NOT NULL ," 
				+ "farm_id BIGINT(15) NOT NULL ," 
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

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public Long getSensor_id() {
		return sensor_id;
	}

	public void setSensor_id(Long sensor_id) {
		this.sensor_id = sensor_id;
	}

	public String getSensor_name() {
		return sensor_name;
	}

	public void setSensor_name(String sensor_name) {
		this.sensor_name = sensor_name;
	}

	public double getSensor_value() {
		return sensor_value;
	}

	public void setSensor_value(double sensor_value) {
		this.sensor_value = sensor_value;
	}

	public Long getDevice_id() {
		return device_id;
	}

	public void setDevice_id(Long device_id) {
		this.device_id = device_id;
	}

	public Long getFarm_id() {
		return farm_id;
	}

	public void setFarm_id(Long farm_id) {
		this.farm_id = farm_id;
	}
	
	
}
