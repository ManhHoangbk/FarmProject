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
		senserData.setSensor_id(rs.getLong("senserId"));
		senserData.setCreateDate(rs.getLong("createDate"));
		senserData.setDevice_id(rs.getLong("deviceId"));
		senserData.setFarm_id(rs.getLong("farmId"));
		senserData.setSensor_name(rs.getString("name"));
		senserData.setSensor_value(rs.getDouble("value"));
		return senserData;
	}

}
