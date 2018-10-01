package com.hust.farmproject.model.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hust.farmproject.model.SenserData;

import common.jdbc.core.RowMapper;

public class SenserDataMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		SenserData senserData = new SenserData();
		senserData.setId(rs.getLong("id"));
		senserData.setSenserId(rs.getLong("senserId"));
		senserData.setCreateDate(rs.getLong("createDate"));
		senserData.setDeviceId(rs.getLong("deviceId"));
		senserData.setFarmId(rs.getLong("farmId"));
		senserData.setName(rs.getString("name"));
		senserData.setValue(rs.getDouble("value"));
		return senserData;
	}

}
